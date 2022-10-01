package acme.jungleware.jungle.module.move;

import org.lwjgl.glfw.GLFW;
import acme.jungleware.jungle.module.Mod;
import acme.jungleware.jungle.module.settings.ModeSetting;
import acme.jungleware.jungle.ui.screens.clickgui.setting.ModeBox;
import acme.jungleware.jungle.module.settings.NumberSetting;
import acme.jungleware.jungle.ui.screens.clickgui.setting.Slider;

public class fly extends Mod {
    public NumberSetting speed = new NumberSetting("Speed", 0.00, 10.00, 0.10, 0.01);
    public ModeSetting mode = new ModeSetting("Mode", "Flight", "Flight", "Saki", "Velocity");

    public fly() {
        super("Climb", "Monkeys can do it!", Category.MONKEYDO);
        //this.setKey(GLFW.GLFW_KEY_G);
        addSettings(speed, mode);
    }


    @Override
    public void onTick() {
        switch (mode.getMode()) {
            case "Flight":
                mc.player.getAbilities().flying = true;
                mc.player.getAbilities().setFlySpeed(speed.getValueFloat());
            break;

            case "Saki":
                if(mc.options.jumpKey.isPressed()) mc.player.jump();
            break;

            case "Velocity":
                mc.player.setVelocity(0, 0, 0);
                mc.player.airStrafingSpeed = speed.getValueFloat();
                if (mc.options.jumpKey.isPressed()) mc.player.setVelocity(0, speed.getValueFloat(), 0);
                if (mc.options.sneakKey.isPressed()) mc.player.setVelocity(0, speed.getValueFloat()*-1, 0);
            break;
        }
        super.onTick();
    }

    @Override
    public void onDisable() {
        mc.player.getAbilities().flying = false;
        super.onDisable();
    }
}
