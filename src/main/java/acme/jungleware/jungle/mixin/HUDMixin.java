package acme.jungleware.jungle.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import acme.jungleware.jungle.ui.HUD;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;

@Mixin(InGameHud.class)
public class HUDMixin {

    @Inject(method = "render", at = @At("RETURN"), cancellable = true)
    public void renderHUD(MatrixStack matrices, float tickDelta, CallbackInfo ci) {
        HUD.render(matrices, tickDelta);
    }
}
