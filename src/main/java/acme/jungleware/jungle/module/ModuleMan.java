package acme.jungleware.jungle.module;

import java.util.List;
import java.util.ArrayList;
import acme.jungleware.jungle.module.move.*;
import acme.jungleware.jungle.module.view.*;
import acme.jungleware.jungle.module.fight.*;
import acme.jungleware.jungle.module.misc.*;
import acme.jungleware.jungle.module.Mod.Category;

public class ModuleMan {

    public static final ModuleMan INSTANCE = new ModuleMan();
    private List<Mod> modules = new ArrayList<>();

    public ModuleMan() {
        addModules();
    }

    public List<Mod> getModules() {
        return modules;
    }

    public List<Mod> getEnabledModules() {
        List<Mod> enabledModules = new ArrayList<>();
        for (Mod module : modules) {
            if (module.isEnabled()) enabledModules.add(module);
        }
        return enabledModules;
    }

    private Category category;
    public List<Mod> getModulesInCategory(Category category) {
        List<Mod> categoryModules = new ArrayList();

        for (Mod mod : modules) {
            if (mod.getCategory() == category) {
                categoryModules.add(mod);
            }
        }
        return categoryModules;
    }

    private void addModules() {
        modules.add(new fly());
        modules.add(new sprint());

        modules.add(new bright());
        //modules.add(new time());

        modules.add(new totem());

        modules.add(new testmodule());
    }
}
