package acme.jungleware.jungle.module.move;

import acme.jungleware.jungle.module.Mod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.AbstractHorseEntity;
import acme.jungleware.jungle.module.settings.BooleanSetting;
import acme.jungleware.jungle.mixininterface.IHorseBaseEntity;
import acme.jungleware.jungle.mixin.ClientPlayerEntityAccessor;
import acme.jungleware.jungle.ui.screens.clickgui.setting.CheckBox;

public class jockey extends Mod {
    public BooleanSetting maxJump = new BooleanSetting("MaxJump", true);

    public jockey() {
        super("Jockey", "Horseless horseman!", Category.MONKEYDO);
        addSetting(maxJump);
    }

    @Override
    public void onDisable() {
        if (mc.world.getEntities() == null) return;

        for (Entity entity : mc.world.getEntities()) {
            if (entity instanceof AbstractHorseEntity) ((IHorseBaseEntity) entity).setSaddled(false);
        }
    }

    @Override
    public void onTick() {
        for (Entity entity : mc.world.getEntities()) {
            if (entity instanceof AbstractHorseEntity) ((IHorseBaseEntity) entity).setSaddled(true);
        }

        if (maxJump.isEnabled()) ((ClientPlayerEntityAccessor) mc.player).setMountJumpStrength(1);

    super.onTick();
    }
}
