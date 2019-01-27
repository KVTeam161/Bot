package net.rick.basic;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;
import net.rick.command.basic.CommandManager;
import net.rick.command.usually.ExampleCommand;
import net.rick.impl.CommandManagerImpl;
import net.rick.listener.CommandListener;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.security.auth.login.LoginException;

public class RickImpl implements Rick {

    private final String token;
    private JDA jda;
    private final Logger logger;
    private final CommandManager commandManager;

    public RickImpl(String token) {
        this.token = token;
        this.logger = LoggerFactory.getLogger(RickImpl.class);
        this.commandManager = new CommandManagerImpl();
    }

    @Override
    public void onEnable() {
        this.logger.info("# Bot connecting...");
        try {
            this.jda = new JDABuilder(AccountType.BOT)
                    .setToken(this.token)
                    .setAutoReconnect(true)
                    .setStatus(OnlineStatus.ONLINE)
                    .setGame(Game.playing("Cute bot"))
                    .build();
            this.initCommands();
            this.initListeners();
            this.logger.info("# Bot connected!");
        } catch (LoginException e) {
            this.logger.error("# Bot could not connect!", e.getMessage());
        }
    }

    @NotNull
    private void initListeners() {
        this.jda.addEventListener(new CommandListener(this.commandManager));
    }

    @NotNull
    private void initCommands() {
        this.logger.info("# Loading commands...");
        new ExampleCommand(this.commandManager);
        this.logger.info("# Loaded ("+this.commandManager.getCommands().size()+") commands!");
    }

    @Override
    public JDA getJDA() {
        return this.jda;
    }
}