package net.rick.command.informative;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.rick.basic.Rick;
import net.rick.basic.RickImpl;
import net.rick.basic.RickInitializer;
import net.rick.command.basic.Command;
import net.rick.command.basic.CommandCategory;
import net.rick.command.basic.CommandInfo;
import net.rick.command.basic.CommandManager;
import net.rick.utils.Emojibet;

import java.awt.*;

@CommandInfo(
        name="info",
        usage="info",
        category=CommandCategory.INFORMATIVE,
        permissions={Permission.UNKNOWN}
)
public class InfoCommand extends Command {

    public InfoCommand(CommandManager manager) {
        super(manager);
    }

    @Override
    public boolean onCommand(MessageReceivedEvent event, String... args) {
        final EmbedBuilder embed = new EmbedBuilder();
        embed.setAuthor("O Rick'u")
                .addField(Emojibet.BOOK_OPEN+" Biblioteka", "JDA 3.8.1_437", true)
                .addField(Emojibet.CALENDAR+" Data utworzenia", "2019-01-25", true)
                .addField(Emojibet.GUILD_JOIN+" Serwery", Integer.toString(event.getJDA().getGuilds().size()), true)
                .addField(Emojibet.USER+" Użytkownicy", Integer.toString(event.getJDA().getUsers().size()), true)
                .addField(Emojibet.GEAR+" Wersja", "v0.2", true)
                .addField(Emojibet.WRENCH+" GitHub: ", "github.com/Rick616", true)
                .setColor(Color.green);
        event.getTextChannel().sendMessage(embed.build()).queue();
        return true;
    }
}