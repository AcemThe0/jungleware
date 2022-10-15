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
import acme.jungleware.jungle.utils.chatUtils;
import acme.jungleware.jungle.utils.mathUtils;
import acme.jungleware.jungle.module.settings.NumberSetting;
import acme.jungleware.jungle.module.settings.BooleanSetting;
import acme.jungleware.jungle.ui.screens.clickgui.setting.Slider;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import acme.jungleware.jungle.ui.screens.clickgui.setting.CheckBox;

public class killaura extends Mod {
    public static NumberSetting range = new NumberSetting("Range", 1.00, 10.00, 4.00, 1.00);
    public static NumberSetting maxOffset = new NumberSetting("MaxOffset", 2.00, 30.00, 30.00, 1.00);
    public BooleanSetting offset = new BooleanSetting("Offset", false);
    public BooleanSetting attack = new BooleanSetting("Attack", true);
    public BooleanSetting players = new BooleanSetting("PlayersOnly", true);
    public BooleanSetting name = new BooleanSetting("EntityName", true);
    public BooleanSetting rotate = new BooleanSetting("Rotate", true);
    public BooleanSetting lock = new BooleanSetting("Lock", false);

    public killaura() {
        super("Gorilla", "CHIMPOUT!", Category.CHIMP);
        addSettings(range, maxOffset, offset, attack, players, name, rotate, lock);
    }

    @Override
    public void onTick() {
        if (this.isEnabled() && mc.world != null && mc.world.getEntities() != null) {
            List<Entity> targets = new ArrayList<>();
            Entity target;

            for (Entity entity : mc.world.getEntities()) {
                if (entity instanceof LivingEntity && entity != mc.player && mc.player.distanceTo(entity) <= range.getValueInt()) {
                    if (players.isEnabled() && entity.isPlayer()) {targets.add(entity);}
                    else if (!players.isEnabled()) {targets.add(entity);}
                } else {
                    targets.remove(entity);
                }
                targets.sort(Comparator.comparingDouble(ent -> mc.player.distanceTo(entity)));
            }

            if (targets.size() >= 1) {
                target = targets.get(0);
                if (rotate.isEnabled()) {
                    float yaw = rotUtils.getYawToEnt(target);
                    float pitch = rotUtils.getPitchToEnt(target);
                    mc.player.networkHandler.sendPacket(new PlayerMoveC2SPacket.LookAndOnGround(yaw, pitch, mc.player.isOnGround()));

                    if (offset.isEnabled()) {
                        yaw   += mathUtils.roundToPlace(Math.random() * maxOffset.getValueFloat() + 1, 2);
                        pitch += mathUtils.roundToPlace(Math.random() * maxOffset.getValueFloat() + 1, 2);
                    }

                    if (lock.isEnabled()) {
                        mc.player.setPitch(pitch);
                        mc.player.setYaw(yaw);
                    }

                    mc.player.setHeadYaw(yaw);
                    mc.player.setBodyYaw(yaw);
                }

                if (mc.player.getAttackCooldownProgress(0.5f) == 1 && attack.isEnabled()) {
                    mc.interactionManager.attackEntity(mc.player, target); //Attack
                    mc.player.swingHand(Hand.MAIN_HAND); //Visually swing hand
                    if (name.isEnabled() && target.isPlayer()) {chatUtils.warn("target: " + target.getEntityName());}
                }
            }
        }
    super.onTick();
    }

}
