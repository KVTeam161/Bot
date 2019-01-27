package net.rick.basic;

public class RickInitializer {

    public static void main(String... args) {
        final String token = "paste your token";
        final Rick rick = new RickImpl(token);
        rick.onEnable();
    }
}