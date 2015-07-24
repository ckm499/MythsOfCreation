package me.NerfFlamer;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.command.CommandExecutor;;

public class NyxPointsCommand implements CommandExecutor{
	
	Main plugin = Main.hook();

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (cmd.getName().equalsIgnoreCase("nyxpoints") || 
				cmd.getName().equalsIgnoreCase("np") || 
				cmd.getName().equalsIgnoreCase("nyxpoint") && 
				sender instanceof Player) {
			
			Player player = (Player) sender;
			Integer pointamount = plugin.pointData.get(player.getUniqueId());
			
			if(args.length == 1) {
				if(args[0].equalsIgnoreCase("balance") || args[0].equalsIgnoreCase("bal")) {
					player.sendMessage(ChatColor.GOLD + "NyxPoints: " + ChatColor.YELLOW + pointamount);
				}
			}
			if(args.length == 1) {
				if(args[0].equalsIgnoreCase("shop") || args[0].equalsIgnoreCase("s")) {
					
				}
			}
			
			ItemStack commonKey = new ItemStack(Material.TRIPWIRE_HOOK);
			ItemMeta commonKeyMeta = commonKey.getItemMeta();
			commonKeyMeta.setDisplayName("" + ChatColor.BOLD + ChatColor.WHITE + "Common Dungeon Key");
			commonKeyMeta.setLore(Arrays.asList(ChatColor.GRAY + "Price: ", ChatColor.GRAY + "2"));
			commonKey.setItemMeta(commonKeyMeta);
			Inventory shop = Bukkit.createInventory(null, 9, "Shop");
			shop.setItem(1, commonKey);
			}
			
		return false;	
		
	}
	
	
	

}
