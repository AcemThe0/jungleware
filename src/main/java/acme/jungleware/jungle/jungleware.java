package acme.jungleware.jungle;

import org.slf4j.Logger;
import org.lwjgl.glfw.GLFW;
import org.slf4j.LoggerFactory;
import net.fabricmc.api.ModInitializer;
import acme.jungleware.jungle.module.Mod;
import net.minecraft.client.MinecraftClient;
import acme.jungleware.jungle.module.ModuleMan;
import acme.jungleware.jungle.ui.screens.clickgui.ClickGUI;
import net.minecraft.client.gui.screen.ingame.HandledScreen;

public class jungleware implements ModInitializer {

	public static final jungleware INSTANCE = new jungleware();
	public static final Logger LOGGER = LoggerFactory.getLogger("jungleware");
	
	private MinecraftClient mc = MinecraftClient.getInstance();
	
	@Override
	public void onInitialize() {
		//   No longer /V/craft approved!
	
		LOGGER.info("OOK!");
	}
	
	public void onKeyPress(int key, int action) {
		if (action == GLFW.GLFW_PRESS && mc.player != null && mc.currentScreen == null) {
			for (Mod module : ModuleMan.INSTANCE.getModules()) {
				if (key == GLFW.GLFW_KEY_RIGHT_SHIFT) mc.setScreen(ClickGUI.INSTANCE);
				if (key == module.getKey()) module.toggle();
			}
		}
	}
	
	public void onTick() {
		if (mc.player != null) {
			for (Mod module : ModuleMan.INSTANCE.getEnabledModules()) {
					module.onTick();
			}
		}
	}
}
