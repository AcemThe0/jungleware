package acme.jungleware.jungle.mixin;

import net.minecraft.client.option.SimpleOption;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(SimpleOption.class)
public interface SimpleOptionMixin {
    @Accessor("value")
    <T> void forceSetValue(T value);
}
