package acme.jungleware.jungle.module.fight;

import acme.jungleware.jungle.module.Mod;
import acme.jungleware.jungle.module.settings.NumberSetting;
import acme.jungleware.jungle.ui.screens.clickgui.setting.Slider;
import acme.jungleware.jungle.module.settings.BooleanSetting;
import acme.jungleware.jungle.ui.screens.clickgui.setting.CheckBox;

public class timer extends Mod {
    public static NumberSetting multiplier = new NumberSetting("Multiplier", 0.10, 5.00, 1.00, 0.10);
    public static BooleanSetting enabled = new BooleanSetting("Enabled", false);


    public timer() {
        super("Timer", "Limitless.", Category.CHIMP);
        addSettings(multiplier, enabled);
    }

    public static double getMultiplier() {
        return enabled.isEnabled() ? multiplier.getValueFloat() : 1;
    }

}
