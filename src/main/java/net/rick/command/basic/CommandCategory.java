package net.rick.command.basic;

public enum CommandCategory {
    NONE("Brak", -1),
    INFORMATIVE("Informacyjne", 0),
    FUN("Zabawne", 1),
    USEFULL("Uzyteczne", 2),
    MODERATION("Moderacyjne", 3);

    private final String name;
    private final int id;

    CommandCategory(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }
}