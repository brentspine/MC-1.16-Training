package de.brentspine.training116.commands;

import de.brentspine.training116.Main;
import de.brentspine.training116.util.LocationUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetupCommand implements CommandExecutor {

    private Main plugin;

    public SetupCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(Main.PREFIX + "Dieser Befehl ist nur für InGame");
            return true;
        }
        Player player = (Player) sender;
        if(!player.hasPermission("lobby.setup")) {
            player.sendMessage(Main.NOPERM);
            return true;
        }
        if(args.length <= 0) {
            player.sendMessage(Main.PREFIX + "Verwendung: /" + label + " [spawn]");
            return true;
        }
        new LocationUtil(Main.getInstance(),  player.getLocation(), "main." + args[0].toLowerCase()).saveLocation();
        player.sendMessage(Main.PREFIX + "Du hast die Location für §c" + args[0] + "§7 gesetzt");


        return true;
    }

}
