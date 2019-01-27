package net.rick.command.basic;

public enum CommandCategory {
    NONE(-1),
    USUALLY(0),
    FUN(1),
    USEFULL(2),
    MODERATION(3);

    private final int id;

    CommandCategory(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
}