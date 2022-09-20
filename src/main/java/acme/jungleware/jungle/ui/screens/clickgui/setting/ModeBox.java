package acme.jungleware.jungle.ui.screens.clickgui.setting;

import java.awt.Color;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;
import acme.jungleware.jungle.module.settings.Setting;
import acme.jungleware.jungle.module.settings.ModeSetting;
import acme.jungleware.jungle.ui.screens.clickgui.ModuleButton;

public class ModeBox extends Component{
    private ModeSetting modeSet = (ModeSetting)setting;

    public ModeBox(Setting setting, ModuleButton parent, int offset) {
        super(setting, parent, offset);
        this.modeSet = (ModeSetting)setting;
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        DrawableHelper.fill(matrices, parent.parent.x, parent.parent.y + parent.offset + offset, parent.parent.x + parent.parent.width, parent.parent.y + parent.offset + offset + parent.parent.height, new Color(0, 0, 0, 160).getRGB());
        int textOffset = ((parent.parent.height/2)-mc.textRenderer.fontHeight/2);
        mc.textRenderer.drawWithShadow(matrices, modeSet.getName() + ": " + modeSet.getMode(), parent.parent.x + 2, parent.parent.y + parent.offset + offset + textOffset, new Color(0, 190, 0, 180).getRGB());
        super.render(matrices, mouseX, mouseY, delta);
    }

    @Override
    public void mouseClicked(double mouseX, double mouseY, int button) {
        if (isHovered(mouseX, mouseY) && button == 0) modeSet.cycle();
        super.mouseClicked(mouseX, mouseY, button);
    }
}