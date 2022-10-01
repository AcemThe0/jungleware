package acme.jungleware.jungle.module.fight;

import org.lwjgl.glfw.GLFW;
import net.minecraft.item.Items;
import acme.jungleware.jungle.module.Mod;
import acme.jungleware.jungle.utils.invUtils;

public class totem extends Mod {
    int tikis;

    public totem() {
        super("TikiReplace", "Replaces your tiki.", Category.CHIMP);
        //this.setKey(GLFW.GLFW_KEY_O);
    }

    @Override
    public void onTick() {
        if (mc.player.getInventory().contains(Items.TOTEM_OF_UNDYING.getDefaultStack())) {
        }
        super.onTick();
    }

}
