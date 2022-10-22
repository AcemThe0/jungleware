package acme.jungleware.jungle.module.misc;

import acme.jungleware.jungle.module.Mod;
import acme.jungleware.jungle.utils.mathUtils;
import acme.jungleware.jungle.module.settings.NumberSetting;
import acme.jungleware.jungle.ui.screens.clickgui.setting.Slider;

public class coordinates extends Mod {
    public static NumberSetting red = new NumberSetting("Red", 0.00, 255.00, 255.00, 1.00);
    public static NumberSetting green = new NumberSetting("Green", 0.00, 255.00, 255.00, 1.00);
    public static NumberSetting blue = new NumberSetting("Blue", 0.00, 255.00, 138.00, 1.00);
    public static NumberSetting alpha = new NumberSetting("Alpha", 25.00, 255.00, 255.00, 1.00);

    public coordinates() {
        super("Homing", "Find your location!", Category.CHIMPHUD);
        addSettings(red, green, blue, alpha);
    }

    @Override
    public void onTick() {
        super.onTick();
    }

    public static String getCoords() {
        return "XYZ " + mathUtils.roundToPlace(mc.player.getX(), 1) + ", " + mathUtils.roundToPlace(mc.player.getY(), 1) + ", " + mathUtils.roundToPlace(mc.player.getZ(), 1);
    }
}
