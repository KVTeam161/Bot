package net.rick.utils;

import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.managers.GuildController;

public final class Util {

    private Util() {}

    public static GuildController getController(MessageReceivedEvent event) {
        return event.getJDA().getGuildById(event.getGuild().getId()).getController();
    }

    public static User getUser(Message message) {
        return message.getMentionedUsers().get(0);
    }
}
