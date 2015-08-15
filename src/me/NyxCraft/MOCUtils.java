package me.NyxCraft;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class MOCUtils {
	public static Main plugin = Main.getInstance();

	public static void checkAcheivement(Player p, String acheivement, int reward)
	{
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
			p.sendMessage(ChatColor.GRAY
					+ "You have earned the acheivement " + ChatColor.GOLD
					+ acheivement + " " + ChatColor.GRAY
					+ "and " + reward + " nxp!");
			addNxp(p, reward);
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
	//returns a player's class by looking at their yaml
		public static Classes getClass(Player p)
		{
			String name = YamlConfiguration.loadConfiguration(
					new File("plugins" + File.separator + "MythsOfCreation"
							+ File.separator + "PlayerData" + File.separator + p.getUniqueId() + ".yml"))
					.getString("class");
			for (Classes c : plugin.classes)
			{
				if (c.getName().equalsIgnoreCase(name))
				{
					return c;
				}
			}
			return plugin.classes.get(0);
		}
		
		//checks to see if a class with the name String c exists
		public static boolean checkForClass(String c)
		{
			for (Classes cl : plugin.classes)
			{
				if (cl.getName().equalsIgnoreCase(c))
				{
					return true;
				}
			}
			return false;
		}
}
