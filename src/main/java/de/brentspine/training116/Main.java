package de.brentspine.training116;

import de.brentspine.training116.commands.SetupCommand;
import de.brentspine.training116.listeners.PlayerJoinListener;
import de.brentspine.training116.listeners.items.GameSelector;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main instance;

    public static final String PREFIX = "§4§lTraining §8» §7";
    public static final String NOPERM = PREFIX + "§cIm sorry, but you dont have enough permissions to do that";

    @Override
    public void onEnable() {
        instance = this;
        init(Bukkit.getPluginManager());
        Bukkit.broadcastMessage(Main.PREFIX + "§aHello World");
    }

    public void init(PluginManager pluginManager) {
        getCommand("setup").setExecutor(new SetupCommand(this));
        pluginManager.registerEvents(new PlayerJoinListener(), this);
        pluginManager.registerEvents(new GameSelector(), this);
    }

    @Override
    public void onDisable() {

    }

    public static Main getInstance() {
        return instance;
    }

}
