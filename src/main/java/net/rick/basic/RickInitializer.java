package net.rick.basic;

public class RickInitializer {

    public static void main(String... args) {
        final String token = "NTM4NDk5NDQzMjcyNzEyMTky.Dy0vwg.aYMqOwygPMsiFFsQdlokLhmihDo";
        final Rick rick = new RickImpl(token);
        rick.onEnable();
    }
}