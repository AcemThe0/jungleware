package acme.jungleware.jungle.module.move;

import java.lang.Math;
import org.lwjgl.glfw.GLFW;
import acme.jungleware.jungle.module.Mod;
import acme.jungleware.jungle.module.settings.NumberSetting;
import acme.jungleware.jungle.module.settings.BooleanSetting;
import acme.jungleware.jungle.ui.screens.clickgui.setting.Slider;
import acme.jungleware.jungle.ui.screens.clickgui.setting.CheckBox;

public class sprint extends Mod {
    public NumberSetting speed = new NumberSetting("Speed", 0.00, 10.00, 0.10, 0.10);
    public NumberSetting height = new NumberSetting("Height", 0.00, 5.00, 0.50, 0.10);
    public BooleanSetting jump = new BooleanSetting("AutoJump", true);

    public sprint() {
        super("Quadrupedalism", "Get on all fours!", Category.MONKEYDO);
        //this.setKey(GLFW.GLFW_KEY_V);
        addSettings(speed, height, jump);
    }
    
    @Override
    public void onTick() {
        mc.player.airStrafingSpeed = speed.getValueFloat(); 
        if (jump.isEnabled()) {
            if (mc.player.forwardSpeed != 0 && mc.player.isOnGround() || mc.player.sidewaysSpeed != 0 && mc.player.isOnGround()) mc.player.addVelocity(0, height.getValueFloat(), 0);
        }
        super.onTick();
    }
}
