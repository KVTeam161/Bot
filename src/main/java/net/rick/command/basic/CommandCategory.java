package net.rick.command.basic;

import net.rick.utils.Emojibet;

public enum CommandCategory {
<<<<<<< HEAD
    NONE(Emojibet.NO_ENTRY+" Brak", -1),
    INFORMATIVE(Emojibet.BOOK_OPEN +" Informacyjne", 0),
    FUN(Emojibet.GAME_DICE +" Zabawne", 1),
    USEFULL(Emojibet.NOTEPAD+" Uzyteczne", 2),
    MODERATION(Emojibet.WRENCH+" Moderacyjne", 3);
=======
    NONE("Brak", -1),
    INFORMATIVE("Informacyjne", 0),
    FUN("Zabawne", 1),
    USEFULL("Uzyteczne", 2),
    MODERATION("Moderacyjne", 3);
>>>>>>> ba63aacd120ccc90d3423ef59d6faf5a03f529c2

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