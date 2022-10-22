package acme.jungleware.jungle.module.fight;

import java.util.List;
import java.util.ArrayList;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import acme.jungleware.jungle.module.Mod;
import net.minecraft.screen.slot.SlotActionType;

public class totem extends Mod {
    int tikis;

    public totem() {
        super("TikiReplace", "Replaces your tiki.", Category.CHIMPING);
    }

    @Override
    public void onTick() {
        int i;
        Boolean found = false;
        Item itm = Items.TOTEM_OF_UNDYING;

        if (!mc.player.getOffHandStack().getItem().equals(itm)) {
            for (i=0; i<=36; i++) {
                if (mc.player.getInventory().getStack(i).getItem().equals(itm)) {
                    found = true;
                    break;
                }
            }

            if (!(mc.player.getOffHandStack().getItem().equals(itm)) && found) {
                mc.interactionManager.clickSlot(mc.player.currentScreenHandler.syncId, i, 0, SlotActionType.PICKUP, mc.player);
                mc.interactionManager.clickSlot(mc.player.currentScreenHandler.syncId, 45, 0, SlotActionType.PICKUP, mc.player);
            }
        }
        super.onTick();
    }
}
