package net.rick.command.fun;

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
        name="wubba",
        usage="wubba",
        category=CommandCategory.FUN,
        permissions={Permission.UNKNOWN}
)
public class WubbaCommand extends Command {

    public WubbaCommand(CommandManager manager) {
        super(manager);
    }

    @Override
    public boolean onCommand(MessageReceivedEvent event, String... args) {
        final EmbedBuilder embed = new EmbedBuilder();
        embed.setAuthor("Wubba lubba dub dub!")
                .setImage("https://media.giphy.com/media/l41lI4bYmcsPJX9Go/giphy.gif")
                .setColor(Color.green);
        event.getTextChannel().sendMessage(embed.build()).queue();
        return true;
    }
}