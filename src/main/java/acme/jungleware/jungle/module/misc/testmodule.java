package acme.jungleware.jungle.module.misc;

import acme.jungleware.jungle.module.Mod;
import acme.jungleware.jungle.ui.screens.clickgui.setting.Slider;
import acme.jungleware.jungle.ui.screens.clickgui.setting.ModeBox;
import acme.jungleware.jungle.ui.screens.clickgui.setting.CheckBox;
import acme.jungleware.jungle.module.settings.ModeSetting;
import acme.jungleware.jungle.module.settings.NumberSetting;
import acme.jungleware.jungle.module.settings.BooleanSetting;

public class testmodule extends Mod {
    public NumberSetting slide = new NumberSetting("slider", 0, 10, 3, 1);
    public BooleanSetting check = new BooleanSetting("check", true);
    public ModeSetting mode = new ModeSetting("Mode", "Test1","Test1","Test 2","Test 3");
    
    public testmodule() {
        super("TestModule", "codemonkey", Category.CHIMPSEE);
        addSettings(slide, check, mode);
    }

    @Override
    public void onEnable() {
        //do thing
        super.onTick();
    }
}
