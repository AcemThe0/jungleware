package acme.jungleware.jungle.module.view;

import acme.jungleware.jungle.module.Mod;
import acme.jungleware.jungle.module.settings.NumberSetting;
import acme.jungleware.jungle.ui.screens.clickgui.setting.Slider;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;

public class spinbot extends Mod {
    public NumberSetting speed = new NumberSetting("Speed", 0.00, 180.00, 1.00, 0.01);
    float rotation = 0;

    public spinbot() {
        super("Monkespin", "TF2", Category.MONKEYSEE);
        addSetting(speed);
    }

    @Override
    public void onTick() {
        if (rotation < 360) {rotation += speed.getValueFloat()*0.5;}
        else {rotation = 90;};

        mc.player.networkHandler.sendPacket(new PlayerMoveC2SPacket.LookAndOnGround(rotation, 0, mc.player.isOnGround()));
    super.onTick();
    }
}
