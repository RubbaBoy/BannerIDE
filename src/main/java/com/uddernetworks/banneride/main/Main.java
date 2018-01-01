package com.uddernetworks.banneride.main;

import com.uddernetworks.banneride.commands.BannerCommand;
import com.uddernetworks.banneride.commands.ChangeCaseCommand;
import com.uddernetworks.banneride.parser.LetterManager;
import com.uddernetworks.command.CommandManager;
import com.uddernetworks.config.Config;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private LetterManager letterManager;

    @Override
    public void onEnable() {
        letterManager = new LetterManager();

        CommandManager manager = new CommandManager();
        manager.registerCommand(this, new ChangeCaseCommand());
        manager.registerCommand(this, new BannerCommand(this));

        Config.getDefaultOptions()
                .enableAutoReload(true)
                .enableAutoSave(true)
                .setDefaultLocation(getDataFolder());
    }

    @Override
    public void onDisable() {

    }

    public LetterManager getLetterManager() {
        return letterManager;
    }
}
