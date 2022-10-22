package acme.jungleware.jungle.module.move;

import acme.jungleware.jungle.module.Mod;

public class jesus extends Mod {

    public jesus() {
        super("Jesus", "Stay afloat!", Category.MONKEYDO);
    }

    @Override
    public void onTick() {
        if (mc.player.isTouchingWater()) mc.player.addVelocity(0, 0.1, 0);
    super.onTick();
    }
}
