package acme.jungleware.jungle.module.fight;

import acme.jungleware.jungle.module.Mod;
import acme.jungleware.jungle.module.settings.NumberSetting;
import acme.jungleware.jungle.ui.screens.clickgui.setting.Slider;

public class timer extends Mod {
    public static NumberSetting multiplier = new NumberSetting("Multiplier", 0.10, 20.00, 1.00, 0.10);

    public timer() {
        super("Timer", "Limitless.", Category.CHIMP);
        addSetting(multiplier);
    }

    public static double getMultiplier() {
        return multiplier.getValueFloat();

    }

}
