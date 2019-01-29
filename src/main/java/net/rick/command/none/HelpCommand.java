package net.rick.command.none;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.MessageEmbed;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.rick.command.basic.Command;
import net.rick.command.basic.CommandCategory;
import net.rick.command.basic.CommandInfo;
import net.rick.command.basic.CommandManager;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.List;


@CommandInfo(
        name="help",
        usage="help",
        category=CommandCategory.NONE,
        permissions={Permission.UNKNOWN}
)
public class HelpCommand extends Command {
    private final MessageEmbed embed;

    public HelpCommand(CommandManager manager) {
        super(manager);
        final EmbedBuilder embed = new EmbedBuilder();
        embed.setAuthor("Jestem Rick!")
                .setDescription("Poniżej znajdziesz listę z dostepnymi komendami.")
                .setColor(Color.green);

        for (CommandCategory category : CommandCategory.values()) {
            if (category != CommandCategory.NONE) {
                final List<Command> cmds = manager.getCommandsByCategory(category);
                if (cmds.size() != 0) {
                    embed.addField(category.getName() + " - (" + cmds.size() + ")", this.getCommands(manager, category), false);
                }
            }
        }

        this.embed = embed.build();
    }

    @Override
    public boolean onCommand(MessageReceivedEvent event, String... args) {
        event.getTextChannel().sendMessage(this.embed).queue();
        return true;
    }

    @NotNull
    private String getCommands(CommandManager manager, CommandCategory category) {
        final StringBuilder sb = new StringBuilder();
        for (Command c : manager.getCommandsByCategory(category)) {
            sb.append("``"+c.getNameNoPrefix()+"``, ");
        }
        final String s = sb.toString();
        sb.replace(s.lastIndexOf(","),s.lastIndexOf(",") + 1, ".");
        return sb.toString();
    }
}