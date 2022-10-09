package acme.jungleware.jungle.mixin;

import org.spongepowered.asm.mixin.Mixin;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.injection.At;
import acme.jungleware.jungle.module.fight.reach;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ClientPlayerInteractionManager.class)
public abstract class ClientPlayerInteractionManagerMixin {
    @Inject(method = "getReachDistance()F", at = @At("HEAD"), cancellable = true)
    private void onGetReachDistance(CallbackInfoReturnable<Float> ci)
    {
        if(!reach.enabled) return;
        ci.setReturnValue(reach.getRange());
    }

    @Inject(method = "hasExtendedReach()Z",at = @At("HEAD") , cancellable = true)
    private void hasExtendedReach(CallbackInfoReturnable<Boolean> cir)
    {
        if(!reach.enabled) return;
        cir.setReturnValue(true);
    }
}