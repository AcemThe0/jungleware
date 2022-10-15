package acme.jungleware.jungle.module.view;

import java.util.List;
import java.util.ArrayList;
import net.minecraft.entity.Entity;
import acme.jungleware.jungle.module.Mod;
import acme.jungleware.jungle.module.settings.ModeSetting;
import acme.jungleware.jungle.module.settings.BooleanSetting;
import acme.jungleware.jungle.ui.screens.clickgui.setting.ModeBox;
import acme.jungleware.jungle.ui.screens.clickgui.setting.CheckBox;

public class esp extends Mod {
    public BooleanSetting players = new BooleanSetting("JustPlayers", true);

    private List<Entity> targetEntities = new ArrayList<>();

    public esp() {
        super("Smell", "Sense the nearby's!", Category.MONKEYSEE);
        addSetting(players);
    }

    @Override
    public void onTick() {
        mc.world.getEntities().forEach(entity -> {
            if (entity.isInvisible() && !targetEntities.contains(entity)) {
                targetEntities.add(entity);
                entity.setInvisible(false);
            }
        });
    super.onTick();
    }

    @Override
    public void onDisable() {
        targetEntities.forEach(entity -> {entity.setInvisible(true);});
        targetEntities.clear();
    super.onDisable();
    }
}
