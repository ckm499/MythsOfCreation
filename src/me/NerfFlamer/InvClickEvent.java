package me.NerfFlamer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InvClickEvent implements Listener {
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		Player player = (Player) e.getWhoClicked();
		
		if(e.getCurrentItem() == null) {
			return;
		}
		
		if(!e.getCurrentItem().hasItemMeta()) {
			return;
		}
		
		if(e.getInventory().getName().contains("Shop")) {
			Integer pointamount = YamlConfiguration.loadConfiguration(
					new File("plugins" + File.separator + "NyxPoints"
							+ File.separator + "PlayerData" + File.separator + player.getUniqueId() + ".yml"))
					.getInt("NyxPoints");
			Integer price = Integer.parseInt(e.getCurrentItem().getItemMeta().getLore().get(1).substring(2));
			if(pointamount >= price) {
				ItemStack commonKey = new ItemStack(Material.TRIPWIRE_HOOK);
				ItemMeta commonKeyMeta = commonKey.getItemMeta();
				commonKeyMeta.setDisplayName("" + ChatColor.BOLD
						+ ChatColor.WHITE + "Common Dungeon Key");
				commonKey.setItemMeta(commonKeyMeta);
				if (player.getInventory().firstEmpty() != -1)
				{
					YamlConfiguration temp = new YamlConfiguration();
					try {
						temp.load(new File("plugins" + File.separator + "NyxPoints"
										+ File.separator + "PlayerData" + File.separator + player.getUniqueId() + ".yml"));
					} catch (FileNotFoundException e2) {
						e2.printStackTrace();
					} catch (IOException e2) {
						e2.printStackTrace();
					} catch (InvalidConfigurationException e2) {
						e2.printStackTrace();
					}
					temp.set("NyxPoints", (pointamount-price));
					try {
						temp.save("plugins" + File.separator + "NyxPoints"
										+ File.separator + "PlayerData" + File.separator + player.getUniqueId() + ".yml");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					player.sendMessage(ChatColor.GREEN + "You have successfully purchased a Common Dungeon Key!");
					player.sendMessage(ChatColor.AQUA + "New Point Balance : " + (pointamount-price));
					player.closeInventory();
					player.getInventory().addItem(commonKey);
					return;
				}
				player.closeInventory();
				player.sendMessage(ChatColor.GOLD + "You don't have room for that item!");
				return;
			}
			player.sendMessage(ChatColor.RED + "You don't have enough Nyx Points to buy that!");
			return;
		}
		return;
	}
}