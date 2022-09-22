package acme.jungleware.jungle.module.fight;

import org.lwjgl.glfw.GLFW;
import acme.jungleware.jungle.module.Mod;;

public class totem extends Mod {
    public totem() {
        super("TikiReplace", "Replaces your tiki.", Category.CHIMP);
        //this.setKey(GLFW.GLFW_KEY_O);
    }

    @Override
    public void onEnable() {

        super.onTick();
    }

}
