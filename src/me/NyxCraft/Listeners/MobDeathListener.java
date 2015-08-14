package me.NyxCraft.Listeners;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class MobDeathListener implements Listener {

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onMobDeath(EntityDeathEvent e) {
		if (e.getEntity().getKiller() instanceof Player) {
			Player p = e.getEntity().getKiller();
			int tier = YamlConfiguration.loadConfiguration(
					new File("plugins" + File.separator + "MythsOfCreation"
							+ File.separator + "PlayerData" + File.separator
							+ p.getUniqueId() + ".yml")).getInt("tier");
			if (e.getEntity().getType().getName().equals("Zombie")) {
				p.sendMessage(ChatColor.GRAY
						+ "You earned 1 nxp for killing a Zombie!");
				addNxp(p, 1);
			}
			if (e.getEntity().getType().getName().equals("Skeleton")) {
				p.sendMessage(ChatColor.GRAY
						+ "You earned 1 nxp for killing a Skeleton!");
				addNxp(p, 1);
			}
			if (e.getEntity().getType().getName().equals("Spider")) {
				p.sendMessage(ChatColor.GRAY
						+ "You earned 1 nxp for killing a Spider!");
				addNxp(p, 1);
			}
			if (e.getEntity().getType().getName().equals("Creeper")) {
				p.sendMessage(ChatColor.GRAY
						+ "You earned 1 nxp for killing a Creeper!");
				addNxp(p, 1);
			}
			if (e.getEntity().getType().getName().equals("Witch")) {
				p.sendMessage(ChatColor.GRAY
						+ "You earned 1 nxp for killing a Witch!");
				addNxp(p, 1);
			}
			if (e.getEntity().getType().getName().equals("Blaze")) {
				p.sendMessage(ChatColor.GRAY
						+ "You earned 1 nxp for killing a Blaze!");
				addNxp(p, 1);
			}
			if (e.getEntity().getType().getName().equals("Ghast")) {
				p.sendMessage(ChatColor.GRAY
						+ "You earned 1 nxp for killing a Ghast!");
				addNxp(p, 1);
			}
			if (e.getEntity().getType().getName().equalsIgnoreCase("Enderman")) {
				p.sendMessage(ChatColor.GRAY
						+ "You earned 1 nxp for killing an Enderman!");
				addNxp(p, 1);
			}
			if (e.getEntity().getType().getName().equals("PigZombie")) {
				p.sendMessage(ChatColor.GRAY
						+ "You earned 1 nxp for killing a PigZombie!");
				addNxp(p, 1);
			}
			if (e.getEntity().getType().getName().equals("Wither")) {
				if (tier == 1) {
					p.sendMessage(ChatColor.GRAY
							+ "You earned 25 nxp for killing a Wither!");
					addNxp(p, 25);
				}
				if (tier == 2) {
					p.sendMessage(ChatColor.GRAY
							+ "You earned 50 nxp for killing a Wither!");
					addNxp(p, 50);
				}
				if (tier == 3) {
					p.sendMessage(ChatColor.GRAY
							+ "You earned 100 nxp for killing a Wither!");
					addNxp(p, 100);
				}
				if (tier >= 4) {
					p.sendMessage(ChatColor.GRAY
							+ "You earned 150 nxp for killing a Wither!");
					addNxp(p, 150);
				}
			}
			if (e.getEntity().getType().getName()
					.equalsIgnoreCase("Enderdragon")) {
				if (tier == 1) {
					p.sendMessage(ChatColor.GRAY
							+ "You earned 50 nxp for killing a Wither!");
					addNxp(p, 50);
				}
				if (tier == 2) {
					p.sendMessage(ChatColor.GRAY
							+ "You earned 100 nxp for killing a Wither!");
					addNxp(p, 100);
				}
				if (tier == 3) {
					p.sendMessage(ChatColor.GRAY
							+ "You earned 175 nxp for killing a Wither!");
					addNxp(p, 175);
				}
				if (tier >= 4) {
					p.sendMessage(ChatColor.GRAY
							+ "You earned 250 nxp for killing a Wither!");
					addNxp(p, 250);
				}
			}
		}
	}

	public void addNxp(Player p, int amount) {
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
}
