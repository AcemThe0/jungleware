package acme.jungleware.jungle.mixin;

import net.minecraft.block.Block;
import net.minecraft.world.BlockView;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.spongepowered.asm.mixin.Mixin;
import acme.jungleware.jungle.module.view.xray;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Block.class)
public class BlockRender {
    
    @Inject(method = "shouldDrawSide", at = @At("HEAD"), cancellable = true)
    private static void shouldDrawSide(BlockState state, BlockView world, BlockPos pos, Direction side, BlockPos blockPos, CallbackInfoReturnable<Boolean> cir) {
        if (xray.xrayEnabled) {
            cir.setReturnValue(xray.blocks.contains(state.getBlock()));
            }
        }

        @Inject(method = "isTranslucent", at = @At("HEAD"), cancellable = true)
        public void isTranslucent(BlockState state, BlockView world, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
            if (xray.xrayEnabled) {
                cir.setReturnValue(!xray.blocks.contains(state.getBlock()));
            }
        }
}