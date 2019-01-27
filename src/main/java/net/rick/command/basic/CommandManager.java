package net.rick.command.basic;

import com.google.common.collect.ImmutableList;

import java.util.Optional;

public interface CommandManager {
    void registerCommand(Command command);

    void registerCommands(Command... commands);

    Optional<Command> getCommand(String name);

    ImmutableList<Command> getCommands();

    ImmutableList<Command> getCommandsByCategory(CommandCategory category);
}