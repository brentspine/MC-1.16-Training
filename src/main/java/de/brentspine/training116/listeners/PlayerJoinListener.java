package de.brentspine.training116.listeners;

import de.brentspine.training116.Main;
import de.brentspine.training116.util.ItemBuilder;
import de.brentspine.training116.util.LocationUtil;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerJoinListener implements Listener {

    public static final String GAME_SELECTOR_NAME = "§aGame-Selector";

    private ItemStack gameSelector;

    public PlayerJoinListener() {
        this.gameSelector = new ItemBuilder(Material.CLOCK).setDisplayName(GAME_SELECTOR_NAME).setLore("§7Select a training mode").build();
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.setJoinMessage("");
        Player player = event.getPlayer();
        player.teleport(new LocationUtil(Main.getInstance(),  player.getLocation(), "main.spawn").getLocation());
        player.sendMessage(Main.PREFIX + "Welcome, select a mode");
        player.getInventory().setItem(4, gameSelector);
    }

}
