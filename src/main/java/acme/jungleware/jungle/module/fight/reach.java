package acme.jungleware.jungle.module.fight;

import acme.jungleware.jungle.module.Mod;
import acme.jungleware.jungle.module.settings.NumberSetting;
import acme.jungleware.jungle.ui.screens.clickgui.setting.Slider;

public class reach extends Mod {
    public static NumberSetting range = new NumberSetting("Range", 1.00, 7.00, 4.00, 0.10);
    public static boolean enabled = false;


    public reach() {
        super("Reach", "Orangutan hands!", Category.CHIMPING);
        addSetting(range);
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


    public static float getRange() {
        return enabled ? range.getValueFloat() : 3;
    }

}
