package acme.jungleware.jungle.module.misc;

import acme.jungleware.jungle.utils.chatUtils;
import acme.jungleware.jungle.module.Mod;
import acme.jungleware.jungle.ui.screens.clickgui.setting.Slider;
import acme.jungleware.jungle.ui.screens.clickgui.setting.ModeBox;
import acme.jungleware.jungle.ui.screens.clickgui.setting.CheckBox;
import acme.jungleware.jungle.module.settings.ModeSetting;
import acme.jungleware.jungle.module.settings.NumberSetting;
import acme.jungleware.jungle.module.settings.BooleanSetting;

public class testmodule extends Mod {
    public NumberSetting slide = new NumberSetting("slider", 0, 10, 3, 1);
    public BooleanSetting check = new BooleanSetting("check", false);
    public ModeSetting mode = new ModeSetting("Mode", "Test1","Test1","Test2","Test3");
    
    public testmodule() {
        super("TestModule", "codemonkey", Category.CHIMPGUI);
        addSettings(slide, check, mode);
    }

    @Override
    public void onEnable() {
        if (check.isEnabled()) {
            switch (mode.getMode()) {
                case "Test1":
                chatUtils.message("EEK!");
                break;
                case "Test2":
                chatUtils.warn("EEK!");
                break;
                case "Test3":
                chatUtils.error("EEK!");
                break;
            }
        }
    }

    @Override
    public void onDisable() {
        if (!check.isEnabled()) {
            switch (mode.getMode()) {
                case "Test1":
                chatUtils.sendMsg("Hello!");
                break;
                case "Test2":
                chatUtils.sendMsg("/w " + mc.player.getEntityName() + " Hello!");
                break;
            }
        }
    }
}
