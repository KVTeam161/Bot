package net.rick.command.moderation;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.rick.command.basic.Command;
import net.rick.command.basic.CommandCategory;
import net.rick.command.basic.CommandInfo;
import net.rick.command.basic.CommandManager;
import net.rick.utils.Emojibet;
import net.rick.utils.Util;

import java.awt.*;

@CommandInfo(
        name="kick",
        usage="kick <użytkownik>",
        category=CommandCategory.MODERATION,
        permissions={Permission.KICK_MEMBERS}
)
public class KickCommand extends Command {

    public KickCommand(CommandManager manager) {
        super(manager);
    }

    @Override
    public boolean onCommand(MessageReceivedEvent event, String... args) {
        if (args.length < 2) { return this.sendUsage(event); }

        if (event.getMessage().getMentionedUsers().isEmpty()) {
            event.getTextChannel().sendMessage(event.getAuthor().getAsMention()+", nie oznaczyłeś żadnego użytkownika!").queue();
            return true;
        }
        try {
            final User u = Util.getUser(event.getMessage());
            final EmbedBuilder embed = new EmbedBuilder();
            Util.getController(event).kick(u.getId()).queue();
            event.getTextChannel().sendMessage(embed.setDescription(Emojibet.KICKED+" Użytkownik "+u.getAsMention()+ " został wyrzucony z serwera!").setColor(Color.green).build()).queue();
        } catch (Exception e) {
            event.getTextChannel().sendMessage(event.getAuthor().getAsMention()+", nie moge wyrzucić kogoś, kto ma wyższą rangę niż ja!").queue();
        }

        return true;
    }
}