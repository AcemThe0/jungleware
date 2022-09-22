/*package acme.jungleware.jungle.module.view;

import org.lwjgl.glfw.GLFW;
import acme.jungleware.jungle.module.Mod;
import acme.jungleware.jungle.mixin.SimpleOptionMixin;
import acme.jungleware.jungle.module.settings.NumberSetting;
import acme.jungleware.jungle.ui.screens.clickgui.setting.Slider;

public class time extends Mod {
    long oldTime;
    public NumberSetting time = new NumberSetting("Time", -20000, 20000, 12800, 0.01);

    public time() {
        super("Time", "Cronos", Category.MONKEYSEE);
        addSettings(time);
    }

    @Override
    public void onEnable() {
        long oldTime = mc.world.getTime();
        super.onEnable();
    }

    @Override
    public void onDisable() {
        mc.world.setTimeOfDay(oldTime);
        super.onDisable();
    }

    @Override
    public void onTick() {
        mc.world.setTimeOfDay(time.getValueLong());
        super.onTick();
    }
    //Commented due to flickering
}*/
