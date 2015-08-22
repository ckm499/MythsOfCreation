package me.NyxCraft;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MOCUtils {
	public static Main plugin = Main.getInstance();

	public static void checkAcheivement(Player p, String acheivement, int reward) {
		YamlConfiguration temp = new YamlConfiguration();
		try {
			temp.load(new File("plugins" + File.separator + "MythsOfCreation"
					+ File.separator + "Acheivements.yml"));
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		} catch (InvalidConfigurationException e2) {
			e2.printStackTrace();
		}
		if (!temp.getStringList(acheivement).contains(p.getUniqueId())) {
			List<String> a = new ArrayList<String>();
			a = temp.getStringList(acheivement);
			a.add("" + p.getUniqueId());
			temp.set(acheivement, a);
			try {
				temp.save(new File("plugins" + File.separator
						+ "MythsOfCreation" + File.separator
						+ "Acheivements.yml"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			p.sendMessage(ChatColor.GRAY + "You have earned the acheivement "
					+ ChatColor.GOLD + acheivement + " " + ChatColor.GRAY
					+ "and " + reward + " np!");
			addNp(p, reward);
		}
	}

	public static void addNxp(Player p, int amount) {
		YamlConfiguration temp = new YamlConfiguration();
		int firstAmount = YamlConfiguration.loadConfiguration(
				new File("plugins" + File.separator + "MythsOfCreation"
						+ File.separator + "PlayerData" + File.separator
						+ p.getUniqueId() + ".yml")).getInt("nxp");
		try {
			temp.load(new File("plugins" + File.separator + "MythsOfCreation"
					+ File.separator + "PlayerData" + File.separator
					+ p.getUniqueId() + ".yml"));
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		} catch (InvalidConfigurationException e2) {
			e2.printStackTrace();
		}
		temp.set("nxp", firstAmount + amount);
		if (temp.getInt("tier") == 1) {
			if ((firstAmount + amount) >= 100) {
				temp.set("nxp", firstAmount + amount - 100);
				temp.set("tier", 2);
				p.sendMessage(ChatColor.GOLD
						+ "You have ascended to the second tier!");
			}
		}
		if (temp.getInt("tier") == 2) {
			if ((firstAmount + amount) >= 500) {
				temp.set("nxp", firstAmount + amount - 500);
				temp.set("tier", 3);
				p.sendMessage(ChatColor.GOLD
						+ "You have ascended to the third tier!");
			}
		}
		if (temp.getInt("tier") == 3) {
			if ((firstAmount + amount) >= 1500) {
				temp.set("nxp", firstAmount + amount - 1500);
				temp.set("tier", 4);
				p.sendMessage(ChatColor.GOLD
						+ "You have ascended to the fourth tier!");
			}
		}
		if (temp.getInt("tier") == 4) {
			if ((firstAmount + amount) >= 4000) {
				temp.set("nxp", firstAmount + amount - 4000);
				temp.set("tier", 5);
				p.sendMessage(ChatColor.GOLD
						+ "You have ascended to the fifth tier!");
			}
		}
		if (temp.getInt("tier") == 5) {
			if ((firstAmount + amount) >= 7500) {
				temp.set("nxp", firstAmount + amount - 7500);
				temp.set("tier", 6);
				p.sendMessage(ChatColor.GOLD
						+ "You have ascended to the sixth tier!");
			}
		}
		if (temp.getInt("tier") == 6) {
			if ((firstAmount + amount) >= 12000) {
				temp.set("nxp", firstAmount + amount - 12000);
				temp.set("tier", 7);
				p.sendMessage(ChatColor.GOLD
						+ "You have ascended to the seventh tier!");
			}
		}
		if (temp.getInt("tier") == 7) {
			if ((firstAmount + amount) >= 18000) {
				temp.set("nxp", firstAmount + amount - 18000);
				temp.set("tier", 8);
				p.sendMessage(ChatColor.GOLD
						+ "You have ascended to the eighth and final tier!");
			}
		}
		try {
			temp.save("plugins" + File.separator + "MythsOfCreation"
					+ File.separator + "PlayerData" + File.separator
					+ p.getUniqueId() + ".yml");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	// returns a player's class by looking at their yaml
	public static Classes getClass(Player p) {
		String name = YamlConfiguration.loadConfiguration(
				new File("plugins" + File.separator + "MythsOfCreation"
						+ File.separator + "PlayerData" + File.separator
						+ p.getUniqueId() + ".yml")).getString("class");
		for (Classes c : plugin.classes) {
			if (c.getName().equalsIgnoreCase(name)) {
				return c;
			}
		}
		return plugin.classes.get(0);
	}

	// checks to see if a class with the name String c exists
	public static boolean checkForClass(String c) {
		for (Classes cl : plugin.classes) {
			if (cl.getName().equalsIgnoreCase(c)) {
				return true;
			}
		}
		return false;
	}

	public static void addNp(Player p, int amount) {
		YamlConfiguration temp = new YamlConfiguration();
		int firstAmount = YamlConfiguration.loadConfiguration(
				new File("plugins" + File.separator + "MythsOfCreation"
						+ File.separator + "PlayerData" + File.separator
						+ p.getUniqueId() + ".yml")).getInt("NyxPoints");
		try {
			temp.load(new File("plugins" + File.separator + "MythsOfCreation"
					+ File.separator + "PlayerData" + File.separator
					+ p.getUniqueId() + ".yml"));
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		} catch (InvalidConfigurationException e2) {
			e2.printStackTrace();
		}
		temp.set("NyxPoints", firstAmount + amount);
		try {
			temp.save("plugins" + File.separator + "MythsOfCreation"
					+ File.separator + "PlayerData" + File.separator
					+ p.getUniqueId() + ".yml");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public static void openShop(Player p) {
		Inventory shop = Bukkit.createInventory(null, 9, "Perk Shop");
		List<String> perks = YamlConfiguration.loadConfiguration(
				new File("plugins" + File.separator + "MythsOfCreation"
						+ File.separator + "PlayerData" + File.separator
						+ p.getUniqueId() + ".yml")).getStringList("perks");
		int tier = YamlConfiguration.loadConfiguration(
				new File("plugins" + File.separator + "MythsOfCreation"
						+ File.separator + "PlayerData" + File.separator
						+ p.getUniqueId() + ".yml")).getInt("tier");
		String cl = YamlConfiguration.loadConfiguration(
				new File("plugins" + File.separator + "MythsOfCreation"
						+ File.separator + "PlayerData" + File.separator
						+ p.getUniqueId() + ".yml")).getString("class");
		if (cl.equals("Hephaestus")) {
			if (tier == 1) {
				if (!(perks.contains("SHEILD:1") || perks.contains("SHEILD:2")
						|| perks.contains("SHEILD:3")
						|| perks.contains("SHEILD:4") || perks.contains("ALL"))) {
					shop.setItem(
							shop.firstEmpty(),
							createItem("Sheild 1", "IRON_FENCE",
									"Raise a sheild for 3 seconds", 2));
				}
				if (!(perks.contains("RESIST:1") || perks.contains("RESIST:2")
						|| perks.contains("RESIST:3")
						|| perks.contains("RESIST:4") || perks.contains("ALL"))) {
					shop.setItem(
							shop.firstEmpty(),
							createItem("Resist 1", "LEATHER_CHESTPLATE",
									"Resist Player Damage by 2%", 2));
				}
				if (perks.contains("RESIST:1")) {
					shop.setItem(
							shop.firstEmpty(),
							createItem(
									ChatColor.RED + "Resist 2",
									"IRON_CHESTPLATE",
									ChatColor.RED
											+ "2nd tier required to purchase this perk",
									4));
				}
				if (perks.contains("SHEILD:1")) {
					shop.setItem(
							shop.firstEmpty(),
							createItem(
									ChatColor.RED + "Sheild 2",
									"IRON_FENCE",
									ChatColor.RED
											+ "2nd tier required to purchase this perk",
									4));
				}
			}
		}
		p.openInventory(shop);
	}

	public static ItemStack createItem(String name, String material,
			String desc, int price) {
		ItemStack temp = new ItemStack(Material.getMaterial(material));
		ItemMeta meta = temp.getItemMeta();
		meta.setDisplayName(name);
		List<String> lore = new ArrayList<String>();
		lore.add(desc);
		lore.add("Price: " + price);
		meta.setLore(lore);
		temp.setItemMeta(meta);
		return temp;
	}
}
