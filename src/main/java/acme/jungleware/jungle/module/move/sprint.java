package acme.jungleware.jungle.module.move;

import org.lwjgl.glfw.GLFW;
import acme.jungleware.jungle.module.Mod;
import acme.jungleware.jungle.module.settings.ModeSetting;
import acme.jungleware.jungle.module.settings.NumberSetting;
import acme.jungleware.jungle.ui.screens.clickgui.setting.Slider;
import acme.jungleware.jungle.ui.screens.clickgui.setting.CheckBox;

public class sprint extends Mod {

    public sprint() {
        super("Quadrupedalism", "Get on all fours.", Category.MONKEYDO);
        this.setKey(GLFW.GLFW_KEY_V);
    }
    
    @Override
    public void onTick() {
        mc.player.setSprinting(true);
        super.onTick();
    }
}
