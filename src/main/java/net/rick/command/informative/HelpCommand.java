package net.rick.command.informative;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.MessageEmbed;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.rick.command.basic.Command;
import net.rick.command.basic.CommandCategory;
import net.rick.command.basic.CommandInfo;
import net.rick.command.basic.CommandManager;
import net.rick.utils.Emojibet;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.List;


@CommandInfo(
        name="help",
        usage="help",
        category=CommandCategory.INFORMATIVE,
        permissions={Permission.UNKNOWN}
)
public class HelpCommand extends Command {

    private final CommandManager manager;
    private final MessageEmbed embed;

    public HelpCommand(CommandManager manager) {
        super(manager);
        this.manager = manager;
        final EmbedBuilder embed = new EmbedBuilder();
        embed.setAuthor("Jestem Rick!")
                .setDescription("Poniżej znajdziesz listę z dostepnymi komendami.")
                .setColor(Color.green);

        for (CommandCategory category : CommandCategory.values()) {
            if (category != CommandCategory.NONE) {
                final List<Command> cmds = this.manager.getCommandsByCategory(category);
                if (cmds.size() != 0) {
                    embed.addField(category.getName() + " - (" + cmds.size() + ")", this.getCommands(category), false);
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
    private String getCommands(CommandCategory category) {
        String s = "";
        for (Command c : this.manager.getCommandsByCategory(category)) {
            s +="``"+c.getNameNoPrefix()+"``, ";
        }
        return s;
    }
}