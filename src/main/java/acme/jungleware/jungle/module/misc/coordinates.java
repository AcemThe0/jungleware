package acme.jungleware.jungle.module.misc;

import java.math.BigDecimal;
import java.math.RoundingMode;
import acme.jungleware.jungle.ui.HUD;
import acme.jungleware.jungle.module.Mod;
import acme.jungleware.jungle.utils.mathUtils;
import acme.jungleware.jungle.module.settings.BooleanSetting;
import acme.jungleware.jungle.ui.screens.clickgui.setting.CheckBox;

public class coordinates extends Mod {
    public static BooleanSetting on = new BooleanSetting("Enabled", true);

    public coordinates() {
        super("Homing", "Find your way!", Category.CHIMPSEE);
        addSetting(on);
    }

    @Override
    public void onTick() {
        super.onTick();
    }

    public static String getCoords() {
        return "XYZ " + mathUtils.roundToPlace(mc.player.getX(), 1) + ", " + mathUtils.roundToPlace(mc.player.getY(), 1) + ", " + mathUtils.roundToPlace(mc.player.getZ(), 1);
    }
}
