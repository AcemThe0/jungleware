package acme.jungleware.jungle.ui;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.awt.Color;

import java.math.BigDecimal;
import java.math.RoundingMode;
import acme.jungleware.jungle.module.Mod;
import net.minecraft.client.MinecraftClient;
import acme.jungleware.jungle.utils.mathUtils;
import acme.jungleware.jungle.module.ModuleMan;
import net.minecraft.client.util.math.MatrixStack;
import acme.jungleware.jungle.module.misc.arraylist;
import acme.jungleware.jungle.module.misc.coordinates;

public class HUD {
    private static MinecraftClient mc = MinecraftClient.getInstance();

    public static void render(MatrixStack matrices, float tickDelta) {
       renderArrayList(matrices);
    }

    public static void renderArrayList(MatrixStack matrices) {
        int index = 0;
        int sWidth = mc.getWindow().getScaledWidth();
        int sHeight = mc.getWindow().getScaledHeight();

        List<Mod> enabled = ModuleMan.INSTANCE.getEnabledModules();
        enabled.sort(Comparator.comparingInt(m -> (int)mc.textRenderer.getWidth(((Mod)m).getName())).reversed());

            String coords = coordinates.getCoords();
            mc.textRenderer.drawWithShadow(matrices, coords, (sWidth - 4) - mc.textRenderer.getWidth(coords), sHeight-15, new Color(coordinates.red.getValueInt(), coordinates.green.getValueInt(), coordinates.blue.getValueInt(), coordinates.alpha.getValueInt()).getRGB());

            for (Mod module : ModuleMan.INSTANCE.getEnabledModules()) {
                mc.textRenderer.drawWithShadow(matrices, module.getName(), (sWidth - 4) - mc.textRenderer.getWidth(module.getName()), 20 + (index * mc.textRenderer.fontHeight), new Color(arraylist.red.getValueInt(), arraylist.green.getValueInt(), arraylist.blue.getValueInt(), arraylist.alpha.getValueInt()).getRGB());
                index++;
            }
    }
}
