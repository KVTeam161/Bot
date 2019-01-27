package net.rick.command.usually;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.rick.command.basic.Command;
import net.rick.command.basic.CommandInfo;
import net.rick.command.basic.CommandManager;

@CommandInfo(
        name="example",
        usage="example",
        permissions={Permission.UNKNOWN}
)
public class ExampleCommand extends Command {

    public ExampleCommand(CommandManager manager) {
        super(manager);
    }

    @Override
    public boolean onCommand(MessageReceivedEvent event, String... args) {
        event.getTextChannel().sendMessage("hello world!").queue();
        return true;
    }
}