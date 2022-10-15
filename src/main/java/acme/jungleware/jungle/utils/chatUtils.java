package acme.jungleware.jungle.utils;

import net.minecraft.text.Text;
import net.minecraft.text.MutableText;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.ChatHud;
import net.minecraft.client.MinecraftClient;

public class chatUtils {
    public static String jwprefix = "\u00a7e[\u00a72Jungle\u00a7aware\u00a7e]\u00a7r ";
    public static String warnprefix = "\u00a76!\u00a7r ";
    public static String errprefix = "\u00a7c!!!\u00a7r ";

    public static void component(Text component)
    {
        ChatHud chatHud = MinecraftClient.getInstance().inGameHud.getChatHud();
        MutableText prefix = Text.literal(jwprefix);
        chatHud.addMessage(prefix.append(component));
    }


    public static void message(String message)
    {
        component(Text.literal(message));
    }

    public static void warn(String message)
    {
        message(warnprefix + message);
    }

    public static void error(String message)
    {
        message(warnprefix + message);
    }
}
