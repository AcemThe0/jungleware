package acme.jungleware.jungle.utils;

import net.minecraft.text.Text;
import net.minecraft.text.MutableText;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.ChatHud;

public class chatUtils {
    public static String jwprefix = "\u00a7e[\u00a72Jungle\u00a7aware\u00a7e]\u00a7r ";
    public static String warnprefix = "\u00a7e[\u00a76WARN\u00a7e]\u00a7r ";
    public static String errprefix = "\u00a7e[\u00a74ERR\u00a7e]\u00a7r ";

    static MinecraftClient mc = MinecraftClient.getInstance();

    public static void component(Text component)
    {
        ChatHud chatHud = MinecraftClient.getInstance().inGameHud.getChatHud();
        MutableText prefix = Text.literal(jwprefix);
        chatHud.addMessage(prefix.append(component));
    }

    char chatPrefix = '.';

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
        message(errprefix + message);
    }

    public static void sendMsg(String message) {
        mc.inGameHud.getChatHud().addToMessageHistory(message);

        if (message.startsWith("/")) mc.player.sendCommand(message.substring(1), null);
        else mc.player.sendChatMessage(message, null);
    }
}
