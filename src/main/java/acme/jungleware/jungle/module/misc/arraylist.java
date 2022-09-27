package acme.jungleware.jungle.module.misc;

import acme.jungleware.jungle.module.Mod;
import acme.jungleware.jungle.module.settings.NumberSetting;
import acme.jungleware.jungle.module.settings.BooleanSetting;
import acme.jungleware.jungle.ui.screens.clickgui.setting.Slider;
import acme.jungleware.jungle.ui.screens.clickgui.setting.CheckBox;

public class arraylist extends Mod {
    public static NumberSetting red = new NumberSetting("Red", 0.00, 255.00, 255.00, 1.00);
    public static NumberSetting green = new NumberSetting("Green", 0.00, 255.00, 255.00, 1.00);
    public static NumberSetting blue = new NumberSetting("Blue", 0.00, 255.00, 255.00, 1.00);
    public static NumberSetting alpha = new NumberSetting("Alpha", 25.00, 255.00, 255.00, 1.00);
    public static BooleanSetting on = new BooleanSetting("Enabled", true);

    public arraylist() {
        super("Arraylist", "Modules!", Category.CHIMPSEE);
        addSettings(red, green, blue, alpha, on);
    }

}
