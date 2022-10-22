package acme.jungleware.jungle.module.view;

import java.util.ArrayList;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.OreBlock;
import acme.jungleware.jungle.module.Mod;
import acme.jungleware.jungle.module.view.bright;
import net.minecraft.block.RedstoneOreBlock;
import net.minecraft.util.registry.Registry;
import acme.jungleware.jungle.module.settings.ModeSetting;
import acme.jungleware.jungle.module.settings.BooleanSetting;
import acme.jungleware.jungle.ui.screens.clickgui.setting.ModeBox;
import acme.jungleware.jungle.ui.screens.clickgui.setting.CheckBox;

public class xray extends Mod {
    public static ArrayList<Block> blocks = new ArrayList<>();
    public static boolean xrayEnabled = false;
    
    public BooleanSetting ores = new BooleanSetting("Ores", false);

    public xray() {
        super("Sniff", "See blocks!", Category.MONKEYSEE);
        addSetting(ores);

        /*Registry.BLOCK.forEach(block -> {
            if (targetBlock(block)) blocks.add(block);
        });*/
    }

    @Override
    public void onEnable() {
        mc.worldRenderer.reload();
        xrayEnabled = true;

        Registry.BLOCK.forEach(block -> {
            if (targetBlock(block)) {blocks.add(block);}
        });

        bright.setGamma(255.0);
        super.onTick();
    }

    @Override
    public void onDisable() {
        mc.worldRenderer.reload();
        xrayEnabled = false;
        bright.setGamma(1.0);
    }

    boolean targetBlock(Block block) {
        boolean c1;
        if (ores.isEnabled()) {c1 = block instanceof OreBlock || block instanceof RedstoneOreBlock;} else {c1 = false;}

        return c1;
    }

}
