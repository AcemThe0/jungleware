package acme.jungleware.jungle.module.move;

import org.lwjgl.glfw.GLFW;
import acme.jungleware.jungle.module.Mod;
import acme.jungleware.jungle.ui.screens.clickgui.setting.Slider;
import acme.jungleware.jungle.ui.screens.clickgui.setting.ModeBox;
import acme.jungleware.jungle.ui.screens.clickgui.setting.CheckBox;
import acme.jungleware.jungle.module.settings.ModeSetting;
import acme.jungleware.jungle.module.settings.NumberSetting;
import acme.jungleware.jungle.module.settings.BooleanSetting;

public class fly extends Mod {
    public NumberSetting speed = new NumberSetting("Speed", 0, 10, 0.01, 0.001);

    public fly() {
        super("Climb", "Monkeys can do it!", Category.MONKEYDO);
        this.setKey(GLFW.GLFW_KEY_G);
        addSetting(speed);
    }


    @Override
    public void onTick() {
        mc.player.getAbilities().flying = true;
        mc.player.getAbilities().setFlySpeed(speed.getValueFloat());
        super.onTick();
    }

    @Override
    public void onDisable() {
        mc.player.getAbilities().flying = false;
        super.onDisable();
    }
}
