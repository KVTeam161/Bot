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
    public void onMessageReceived(MessageReceivedEvent event) { //TODO change to java 11
        final String message = event.getMessage().getContentDisplay();
        if (message.startsWith("ri!")) {
            final String[] args = message.split(" ");
            final Optional<Command> command = this.commandManager.getCommand(args[0]);
            if (command.isPresent()) {
                command.ifPresent(c -> c.onCommand(event, args));
            } else event.getTextChannel().sendMessage("Unknown command!").queue();
        }
    }
}