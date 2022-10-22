package acme.jungleware.jungle.command;

import net.minecraft.client.MinecraftClient;
import acme.jungleware.jungle.utils.chatUtils;

public abstract class Command {
    private String name;
    private String desc;
    private String[] syntax;

    protected static MinecraftClient mc;
    public Command(String name, String desc, String[] syntax) {

        this.name = name;
        this.desc = desc;
        this.syntax = syntax;
        mc = MinecraftClient.getInstance();
    }

    public String getName() {
        return "." + name;
    }


    public String getDesc() {
        return desc;
    }

    public String[] getSyntax() {
        return syntax;
    }

}
