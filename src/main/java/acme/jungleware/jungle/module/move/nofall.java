package acme.jungleware.jungle.module.move;

import acme.jungleware.jungle.module.Mod;
import acme.jungleware.jungle.module.settings.ModeSetting;
import acme.jungleware.jungle.ui.screens.clickgui.setting.ModeBox;
import acme.jungleware.jungle.module.settings.NumberSetting;
import acme.jungleware.jungle.ui.screens.clickgui.setting.Slider;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket.OnGroundOnly;

public class nofall extends Mod {
    public NumberSetting threshold = new NumberSetting("Velocity", -2.9, -0.5, -0.7, 0.01);
    public ModeSetting mode = new ModeSetting("Mode", "Packet", "Steps", "Packet");

    public nofall() {
        super("NoFall", "You fell off the tree again, didn't you?", Category.MONKEYDO);
        addSettings(threshold, mode);
    }

    @Override
    public void onTick() {
        if (mc.player.getVelocity().y < threshold.getValueFloat()) {

            switch(mode.getMode()) {
                case "Steps":
                    mc.player.setVelocity(0, 0.1, 0);
                break;

                case "Packet":
                    mc.player.networkHandler.sendPacket(new OnGroundOnly(true));
                break;
            }
        }
    super.onTick();
    }
}
