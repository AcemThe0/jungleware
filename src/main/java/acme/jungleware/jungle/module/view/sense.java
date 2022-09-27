package acme.jungleware.jungle.module.view;

import java.util.List;
import java.util.ArrayList;
import net.minecraft.entity.Entity;
import acme.jungleware.jungle.module.Mod;

public class sense extends Mod {
    private List<Entity> invisPlayers = new ArrayList<>();

    public sense() {
        super("Sense", "See the invisible!", Category.MONKEYSEE);
    }

    @Override
    public void onTick() {
        mc.world.getEntities().forEach(entity -> {
            if (entity.isInvisible() && !invisPlayers.contains(entity)) {
                invisPlayers.add(entity);
                entity.setInvisible(false);
            }
        });
    super.onTick();
    }

    @Override
    public void onDisable() {
        invisPlayers.forEach(entity -> {entity.setInvisible(true);});
        invisPlayers.clear();
    super.onDisable();
    }
}
