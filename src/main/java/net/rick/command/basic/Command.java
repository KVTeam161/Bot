package net.rick.command.basic;

import lombok.Data;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import org.apache.commons.lang3.Validate;

import java.util.Arrays;
import java.util.List;

@Data
public abstract class Command {

    private final String name, usage, description;
    private final List<String> aliases;
    private final CommandCategory category;
    private final List<Permission> permissions;

    public Command(CommandManager manager) {
        final CommandInfo info = this.getClass().getDeclaredAnnotation(CommandInfo.class);
        Validate.notNull(info, "CommandInfo cannot be null!");
        this.name = "ri!"+info.name();
        this.usage = "ri!"+info.usage();
        this.description = info.description();
        this.category = info.category();
        this.permissions = Arrays.asList(info.permissions());
        this.aliases = Arrays.asList(info.aliases());
        manager.registerCommand(this);
    }

    public abstract boolean onCommand(MessageReceivedEvent event, String... args);

    public String getFullUsage() {
<<<<<<< HEAD
        return "prawidłowe użycie komendy: " + this.usage;
=======
        return "prawidlowe uzycie komendy: " + this.usage;
>>>>>>> ba63aacd120ccc90d3423ef59d6faf5a03f529c2
    }

    public String getNameNoPrefix() {
        return this.name.substring(3);
    }

    public boolean sendUsage(MessageReceivedEvent event) {
        event.getTextChannel().sendMessage(event.getAuthor().getAsMention()+", "+this.getFullUsage()).queue();
        return true;
    }
}