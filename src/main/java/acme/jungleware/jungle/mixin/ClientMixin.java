package acme.jungleware.jungle.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import acme.jungleware.jungle.jungleware;
import net.minecraft.client.MinecraftClient;

@Mixin(MinecraftClient.class)
public class ClientMixin {

	@Inject(method = "tick", at = @At("HEAD"), cancellable = true)
	public void onTick(CallbackInfo ci) {
		jungleware.INSTANCE.onTick();
	}
}
