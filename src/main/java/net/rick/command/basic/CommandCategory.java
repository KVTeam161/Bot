package net.rick.command.basic;

import net.rick.utils.Emojibet;

public enum CommandCategory {
    NONE(Emojibet.NO_ENTRY+" Brak", -1),
    INFORMATIVE(Emojibet.BOOK_OPEN +" Informacyjne", 0),
    FUN(Emojibet.GAME_DICE +" Zabawne", 1),
    USEFULL(Emojibet.NOTEPAD+" Uzyteczne", 2),
    MODERATION(Emojibet.WRENCH+" Moderacyjne", 3);

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