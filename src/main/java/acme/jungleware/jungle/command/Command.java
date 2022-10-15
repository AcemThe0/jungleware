package acme.jungleware.jungle.command;

import acme.jungleware.jungle.utils.chatUtils;

public class Command {
    private String name;
    private String desc;
    private String[] syntax;

    public Command(String name, String desc, String[] syntax) {
        this.name = name;
        this.desc = desc;
        this.syntax = syntax;
    }

    public String getName() {
        return "." + name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String[] getSyntax() {
        return syntax;
    }

    public void setSyntax(String[] syntax) {
        this.syntax = syntax;
    }


}
