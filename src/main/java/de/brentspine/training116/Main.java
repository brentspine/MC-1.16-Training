package de.brentspine.training116;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main instance;

    public static final String PREFIX = "§4§lTraining §8» §7";
    public static final String NOPERM = PREFIX + "§cIm sorry, but you dont have enough permissions to do that";

    @Override
    public void onEnable() {
        instance = this;
        Bukkit.broadcastMessage(Main.PREFIX + "§aHello World");
    }

    @Override
    public void onDisable() {

    }

    public static Main getInstance() {
        return instance;
    }

}
