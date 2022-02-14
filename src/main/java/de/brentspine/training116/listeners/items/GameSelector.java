package de.brentspine.training116.listeners.items;

import de.brentspine.training116.listeners.PlayerJoinListener;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

public class GameSelector implements Listener {



    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if(event.getAction() != Action.RIGHT_CLICK_BLOCK && event.getAction() != Action.RIGHT_CLICK_AIR) return;
        if(event.getItem() == null) return;
        if(!event.getItem().getItemMeta().getDisplayName().equalsIgnoreCase(PlayerJoinListener.GAME_SELECTOR_NAME)) return;

    }

    private void openGameSelectorMain(Player player) {
        Inventory inventory = Bukkit.createInventory(null, 3*9, "Select a training");
        player.openInventory(inventory);
    }

}
