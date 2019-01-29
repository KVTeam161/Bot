package net.rick.listener;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import net.rick.command.basic.Command;
import net.rick.command.basic.CommandManager;

import java.util.Optional;

public class CommandListener extends ListenerAdapter {

    private final CommandManager commandManager;

    public CommandListener(CommandManager commandManager) {
        this.commandManager = commandManager;
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        final String message = event.getMessage().getContentDisplay();
        if (message.startsWith("ri!")) {
            final String[] args = message.split(" ");
            final Optional<Command> command = this.commandManager.getCommand(args[0]);
            command.ifPresentOrElse(c -> c.onCommand(event, args), () -> event.getTextChannel().sendMessage("Unknown command!"));
        }
    }
}