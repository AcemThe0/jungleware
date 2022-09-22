package acme.jungleware.jungle.module.view;

import org.lwjgl.glfw.GLFW;
import acme.jungleware.jungle.module.Mod;
import acme.jungleware.jungle.mixin.SimpleOptionMixin;
import acme.jungleware.jungle.module.settings.NumberSetting;
import acme.jungleware.jungle.ui.screens.clickgui.setting.Slider;

public class bright extends Mod {
    public NumberSetting gamma = new NumberSetting("Gamma", 0, 255, 255, 0.1);

    public bright() {
        super("Nightvision", "Lurk.", Category.MONKEYSEE);
        //this.setKey(GLFW.GLFW_KEY_N);
        addSettings(gamma);
    }

    private static void setGamma(double gamma) {
    ((SimpleOptionMixin) (Object) mc.options.getGamma()).forceSetValue(gamma);
    }

    @Override
    public void onEnable() {
        setGamma(gamma.getValueFloat());
        super.onTick();
    }

    @Override
    public void onDisable() {
        mc.options.getGamma().setValue(1.0);
        super.onDisable();
    }
}

