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
			Inventory shop = Bukkit.createInventory(null, 9, "Shop");
			Integer pointamount = plugin.pointData.get(player.getUniqueId());
			
			if(args.length == 1) {
				if(args[0].equalsIgnoreCase("balance") || args[0].equalsIgnoreCase("bal")) {
					player.sendMessage(ChatColor.GOLD + "NyxPoints: " + ChatColor.YELLOW + pointamount);
				}
			}
			if(args.length == 1) {
				if(args[0].equalsIgnoreCase("shop") || args[0].equalsIgnoreCase("s")) {
					player.openInventory(shop);
					
					//Items
					//common key
					ItemStack commonKey = new ItemStack(Material.TRIPWIRE_HOOK);
					ItemMeta commonKeyMeta = commonKey.getItemMeta();
					commonKeyMeta.setDisplayName("" + ChatColor.BOLD + ChatColor.WHITE + "Common Dungeon Key");
					commonKeyMeta.setLore(Arrays.asList(ChatColor.GRAY + "Price: ", ChatColor.GRAY + "2"));
					commonKey.setItemMeta(commonKeyMeta);
					shop.setItem(0, commonKey);
					//uncommon key
					ItemStack uncommonKey = new ItemStack(Material.TRIPWIRE_HOOK);
					ItemMeta uncommonKeyMeta = uncommonKey.getItemMeta();
					uncommonKeyMeta.setDisplayName("" + ChatColor.BOLD + ChatColor.GREEN + "Uncommon Dungeon Key");
					uncommonKeyMeta.setLore(Arrays.asList(ChatColor.GRAY + "Price: ", ChatColor.GRAY + "2"));
					uncommonKey.setItemMeta(uncommonKeyMeta);
					shop.setItem(1, uncommonKey);
					//rare key
					ItemStack rareKey = new ItemStack(Material.TRIPWIRE_HOOK);
					ItemMeta rareKeyMeta = rareKey.getItemMeta();
					rareKeyMeta.setDisplayName("" + ChatColor.BOLD + ChatColor.BLUE + "Rare Dungeon Key");
					rareKeyMeta.setLore(Arrays.asList(ChatColor.GRAY + "Price: ", ChatColor.GRAY + "2"));
					rareKey.setItemMeta(rareKeyMeta);
					shop.setItem(1, rareKey);
					
					return true;
				}
			}
			}
			
		return false;	
		
	}
	
	
	

}
