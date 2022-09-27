package acme.jungleware.jungle.module.move;

import org.lwjgl.glfw.GLFW;
import acme.jungleware.jungle.module.Mod;
import acme.jungleware.jungle.module.settings.ModeSetting;
import acme.jungleware.jungle.ui.screens.clickgui.setting.ModeBox;
import acme.jungleware.jungle.module.settings.NumberSetting;
import acme.jungleware.jungle.ui.screens.clickgui.setting.Slider;


public class sprint extends Mod {
    public NumberSetting speed = new NumberSetting("Speed", 0.00, 10.00, 0.01, 0.01);
    public ModeSetting mode = new ModeSetting("Mode", "Sprint", "Sprint", "MonkeyHop");

    public sprint() {
        super("Quadrupedalism", "Get on all fours!", Category.MONKEYDO);
        //this.setKey(GLFW.GLFW_KEY_V);
        addSettings(speed, mode);
    }
    
    @Override
    public void onTick() {
        switch (mode.getMode()) {
            case "Sprint":
            mc.player.setSprinting(true);
            break;

            case "MonkeyHop":
            mc.player.airStrafingSpeed = speed.getValueFloat();
            if (mc.player.isOnGround() && mc.player.isSprinting()) mc.player.jump();
            break;
        }
        super.onTick();
    }

}
