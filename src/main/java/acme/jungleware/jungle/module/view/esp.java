package acme.jungleware.jungle.module.view;

import java.util.List;
import java.util.ArrayList;
import net.minecraft.entity.Entity;
import acme.jungleware.jungle.module.Mod;
import net.minecraft.entity.player.PlayerEntity;
import acme.jungleware.jungle.module.settings.BooleanSetting;
import acme.jungleware.jungle.ui.screens.clickgui.setting.CheckBox;

public class esp extends Mod {
    private List<Entity> targetEntities = new ArrayList<>();
    public BooleanSetting invisibles = new BooleanSetting("invisibles", true);

    public esp() {
        super("Smell", "Sense nearby users!", Category.MONKEYSEE);
        addSetting(invisibles);
        get = this;
    }

    @Override
    public void onTick() {
        if (invisibles.isEnabled()) {
            mc.world.getEntities().forEach(entity -> {
                if (entity.isInvisible() && !targetEntities.contains(entity)) {
                    targetEntities.add(entity);
                    entity.setInvisible(false);
                }
            });
        }
    super.onTick();
    }

    @Override
    public void onDisable() {
        if (invisibles.isEnabled()) {
            targetEntities.forEach(entity -> {entity.setInvisible(true);});
            targetEntities.clear();
        }
    super.onDisable();
    }

    
    public boolean shouldRenderEntity(Entity entity) {
        if (!isEnabled()) return false;
        if (entity == null) return false;
        
        return true;
    }

    public static esp get;
}
