package acme.jungleware.jungle.module.misc;

import acme.jungleware.jungle.module.Mod;
import acme.jungleware.jungle.module.settings.NumberSetting;
import acme.jungleware.jungle.ui.screens.clickgui.setting.Slider;

public class arraylist extends Mod {
    public static NumberSetting red = new NumberSetting("Red", 0.00, 255.00, 145.00, 1.00);
    public static NumberSetting green = new NumberSetting("Green", 0.00, 255.00, 100.00, 1.00);
    public static NumberSetting blue = new NumberSetting("Blue", 0.00, 255.00, 82.00, 1.00);
    public static NumberSetting alpha = new NumberSetting("Alpha", 25.00, 255.00, 255.00, 1.00);

    public arraylist() {
        super("Arraylist", "Modules!", Category.CHIMPHUD);
        addSettings(red, green, blue, alpha);
    }

}
