package me.NyxCraft.Listeners;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InvClickListener implements Listener {

	/*
	 * handles purchases in the shop will have to make more abstract later
	 */
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		Player player = (Player) e.getWhoClicked();

		if (e.getCurrentItem() == null) {
			return;
		}

		if (!e.getCurrentItem().hasItemMeta()) {
			return;
		}

		if (e.getInventory().getName().contains("Shop")) {
			Integer pointamount = YamlConfiguration.loadConfiguration(
					new File("plugins" + File.separator + "MythsOfCreation"
							+ File.separator + "PlayerData" + File.separator
							+ player.getUniqueId() + ".yml")).getInt(
					"NyxPoints");
			Integer price = Integer.parseInt(e.getCurrentItem().getItemMeta()
					.getLore().get(1).substring(7));
			if (pointamount >= price) {
				/*
				 * ItemStack item = e.getCurrentItem(); List<String> lore = new
				 * ArrayList<String>(); //lore to prevent fakes
				 * lore.add(ChatColor.GRAY + "Use this key to");
				 * lore.add(ChatColor.GRAY + "unlock a dungeon"); ItemMeta iMeta
				 * = e.getCurrentItem().getItemMeta(); iMeta.setLore(lore);
				 * item.setItemMeta(iMeta);
				 * 
				 * if (player.getInventory().firstEmpty() != -1) {
				 */
				YamlConfiguration temp = new YamlConfiguration();
				try {
					temp.load(new File("plugins" + File.separator
							+ "MythsOfCreation" + File.separator + "PlayerData"
							+ File.separator + player.getUniqueId() + ".yml"));
				} catch (FileNotFoundException e2) {
					e2.printStackTrace();
				} catch (IOException e2) {
					e2.printStackTrace();
				} catch (InvalidConfigurationException e2) {
					e2.printStackTrace();
				}
				temp.set("NyxPoints", (pointamount - price));
				String name = e.getCurrentItem().getItemMeta().getDisplayName();
				name = name.toUpperCase();
				List<String> perks = temp.getStringList("perks");
				if (Integer.parseInt(name.substring(name.indexOf(" ") + 1)) == 1)
				{
					perks.add(name.substring(0, name.indexOf(" ")) + ":1");
				}
				if (Integer.parseInt(name.substring(name.indexOf(" ") + 1)) > 1)
				{
					perks.remove(perks.indexOf(name.substring(0, name.indexOf(" ")) + "1"));
					perks.add(name.substring(0, name.indexOf(" ")) + ":" + name.substring(name.indexOf(" ") + 1));
				}
				temp.set("perks", perks);
				player.sendMessage(ChatColor.GOLD + "(!) " + ChatColor.GREEN
						+ "You have successfully purchased: " + ChatColor.GOLD
						+ name);
				player.sendMessage(ChatColor.GOLD + "(!)" + ChatColor.YELLOW
						+ "New Point Balance: " + ChatColor.GOLD
						+ (pointamount - price));
				player.closeInventory();
				// player.getInventory().addItem(item);
				try {
					temp.save("plugins" + File.separator + "MythsOfCreation"
							+ File.separator + "PlayerData" + File.separator
							+ player.getUniqueId() + ".yml");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				return;
				/* }

				player.closeInventory();
				player.sendMessage(ChatColor.GOLD
						+ "You don't have room for that item!");
				return;
				*/
			}
			player.sendMessage(ChatColor.RED
					+ "You don't have enough Nyx Points to buy that!");
			return;
		}
		return;
	}
}
