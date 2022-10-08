package acme.jungleware.jungle.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import net.minecraft.entity.passive.AbstractHorseEntity;
import acme.jungleware.jungle.mixininterface.IHorseBaseEntity;

@Mixin(AbstractHorseEntity.class)
public abstract class HorseBaseEntityMixin implements IHorseBaseEntity {
    @Shadow protected abstract void setHorseFlag(int bitmask, boolean flag);

    @Override
    public void setSaddled(boolean saddled) {
        setHorseFlag(4, saddled);
    }
}
