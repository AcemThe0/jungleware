package acme.jungleware.jungle.ui.screens.clickgui;

import java.awt.Color;
import java.util.List;
import java.util.ArrayList;
import acme.jungleware.jungle.module.Mod;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import acme.jungleware.jungle.module.settings.Setting;
import acme.jungleware.jungle.module.settings.ModeSetting;
import acme.jungleware.jungle.module.settings.NumberSetting;
import acme.jungleware.jungle.module.settings.BooleanSetting;
import acme.jungleware.jungle.ui.screens.clickgui.setting.Slider;
import acme.jungleware.jungle.ui.screens.clickgui.setting.ModeBox;
import acme.jungleware.jungle.ui.screens.clickgui.setting.CheckBox;
import acme.jungleware.jungle.ui.screens.clickgui.setting.Component;

public class ModuleButton {
    public Mod module;
    public Frame parent;
    public int offset;
    public List<Component> components;
    public boolean extended;

    public ModuleButton(Mod module, Frame parent, int offset) {
        this.module = module;
        this.parent = parent;
        this.offset = offset;
        this.components = new ArrayList<>();
        this.extended = false;

        int setOffset = parent.height;
        for (Setting setting : module.getSettings()) {
            if (setting instanceof BooleanSetting) {
                components.add(new CheckBox(setting, this, setOffset));
            } else if (setting instanceof ModeSetting) {
                components.add(new ModeBox(setting, this, setOffset));
            } else if (setting instanceof NumberSetting) {
                components.add(new Slider(setting, this, setOffset));
            }
            setOffset += parent.height;
        }
    }

    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        DrawableHelper.fill(matrices, parent.x, parent.y + offset, parent.x + parent.width, parent.y + offset + parent.height, new Color(0, 0, 0, 160).getRGB());
        if (isHovered(mouseX, mouseY)) {
            int wWidth  = MinecraftClient.getInstance().getWindow().getScaledWidth();
            int wHeight = MinecraftClient.getInstance().getWindow().getScaledHeight();
            DrawableHelper.fill(matrices, parent.x, parent.y + offset, parent.x + parent.width, parent.y + offset + parent.height, new Color(0, 0, 0, 20).getRGB());
            parent.mc.textRenderer.drawWithShadow(matrices, module.getDesc(), 5, wHeight-20, new Color(255, 255, 255, 255).getRGB());
        }

        int textOffset = ((parent.height/2)-parent.mc.textRenderer.fontHeight/2);
        parent.mc.textRenderer.drawWithShadow(matrices, module.getName(), parent.x + 2, parent.y + offset + textOffset, module.isEnabled() ? new Color(255, 255, 0, 255).getRGB() : new Color(190, 190, 0, 255).getRGB());

        if (extended) {
            for (Component component : components) {
                component.render(matrices, mouseX, mouseY, delta);
                }
        }
    }

    public void mouseClicked(double mouseX, double mouseY, int button) {
        if (isHovered(mouseX, mouseY)) {
            if (button == 0) {
                module.toggle();
            } else if (button == 1) {
                extended = !extended;
                parent.updateButtons();
            }
        }

        for (Component component : components) {
            if (extended) component.mouseClicked(mouseX, mouseY, button);
        }
    }

    public void mouseReleased(double mouseX, double mouseY, int button) {
        for (Component component : components) {
            component.mouseReleased(mouseX, mouseY, button);
        }
    }

    public boolean isHovered(double mouseX, double mouseY) {
        return mouseX > parent.x && mouseX < parent.x + parent.width && mouseY > parent.y + offset && mouseY < parent.y + offset + parent.height;
    }
}
