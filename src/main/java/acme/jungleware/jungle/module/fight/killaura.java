package acme.jungleware.jungle.module.fight;

import java.lang.Math;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import net.minecraft.util.Hand;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import acme.jungleware.jungle.module.Mod;
import acme.jungleware.jungle.utils.rotUtils;
import acme.jungleware.jungle.utils.mathUtils;
import acme.jungleware.jungle.module.settings.NumberSetting;
import acme.jungleware.jungle.module.settings.BooleanSetting;
import acme.jungleware.jungle.ui.screens.clickgui.setting.Slider;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import acme.jungleware.jungle.ui.screens.clickgui.setting.CheckBox;

public class killaura extends Mod {
    public static NumberSetting range = new NumberSetting("Range", 1.00, 10.00, 3.00, 1.00);
    public static NumberSetting maxOffset = new NumberSetting("MaxOffset", 2.00, 30.00, 5.00, 1.00);
    public BooleanSetting offset = new BooleanSetting("Offset", false);
    public BooleanSetting attack = new BooleanSetting("Attack", true);
    public BooleanSetting lock = new BooleanSetting("Lock", false);

    public killaura() {
        super("Gorilla", "CHIMPOUT!", Category.CHIMP);
        addSettings(range, maxOffset, offset, attack, lock);
    }

    @Override
    public void onTick() {
        if (this.isEnabled() && mc.world != null && mc.world.getEntities() != null) {
            List<Entity> targets = new ArrayList<>();

            for (Entity ent : mc.world.getEntities()) {
                if (ent instanceof LivingEntity && ent != mc.player && mc.player.distanceTo(ent) <= range.getValueInt()) {
                    targets.add((LivingEntity) ent);
                } else {
                    targets.remove(ent);
                }
                targets.sort(Comparator.comparingDouble(entity -> mc.player.distanceTo(ent)));
            }
            if(targets.size() -1 >= 0) {
                float yaw = rotUtils.getYawToEnt(targets.get(0));
                float pitch = rotUtils.getPitchToEnt(targets.get(0));
                if (offset.isEnabled()) {
                    yaw += mathUtils.roundToPlace(Math.random() * maxOffset.getValueFloat() + 1, 2);
                    pitch += mathUtils.roundToPlace(Math.random() * maxOffset.getValueFloat() + 1, 2);
                }

                mc.player.networkHandler.sendPacket(new PlayerMoveC2SPacket.LookAndOnGround(yaw, pitch, mc.player.isOnGround()));
                if (lock.isEnabled()) {
                    mc.player.setPitch(pitch);
                    mc.player.setYaw(yaw);
                }
                mc.player.setHeadYaw(yaw);
                mc.player.setBodyYaw(yaw);

                if (mc.player.getAttackCooldownProgress(0.5f) == 1 && attack.isEnabled()) {
                    mc.interactionManager.attackEntity(mc.player, targets.get(0)); //Attack
                    mc.player.swingHand(Hand.MAIN_HAND); //Visually swing hand
                }
            }
        }
    super.onTick();
    }

}
