package acme.jungleware.jungle.module.fight;

import acme.jungleware.jungle.module.Mod;
import acme.jungleware.jungle.module.settings.NumberSetting;
import acme.jungleware.jungle.ui.screens.clickgui.setting.Slider;

public class timer extends Mod {
    public static NumberSetting multiplier = new NumberSetting("Multiplier", 0.10, 5.00, 1.00, 0.10);
    public static boolean enabled = false;


    public timer() {
        super("Timer", "Limitless.", Category.CHIMPING);
        addSetting(multiplier);
    }

    @Override
    public void onEnable() {
        enabled = true;
    super.onEnable();
    }

    @Override
    public void onDisable() {
        enabled = false;
    super.onDisable();
    }


    public static double getMultiplier() {
        return enabled ? multiplier.getValueFloat() : 1;
    }

}
