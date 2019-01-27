package net.rick.impl;

import com.google.common.collect.ImmutableList;
import net.rick.command.basic.Command;
import net.rick.command.basic.CommandCategory;
import net.rick.command.basic.CommandManager;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class CommandManagerImpl implements CommandManager {

    private final Set<Command> commands = new HashSet<>();

    @Override
    public void registerCommand(Command command) {
        this.commands.add(command);
    }

    @Override
    public void registerCommands(Command... commands) {
        Arrays.stream(commands).forEach(this::registerCommand);
    }

    @Override
    public Optional<Command> getCommand(String name) {
        return this.commands.stream()
                .filter(c -> c.getName().equals(name) || c.getAliases().contains(name))
                .findFirst();
    }

    @Override
    public ImmutableList<Command> getCommands() {
        return ImmutableList.copyOf(this.commands);
    }

    @Override
    public ImmutableList<Command> getCommandsByCategory(CommandCategory category) {
        return this.commands.stream()
                .filter(c -> c.getCategory() == category)
                .collect(Collectors.collectingAndThen(Collectors.toList(), ImmutableList::copyOf));
    }
}