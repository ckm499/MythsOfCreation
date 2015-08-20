package me.NyxCraft.Listeners;

import java.io.File;

import me.NyxCraft.MOCUtils;

import org.bukkit.ChatColor;
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
			if (!(e.getEntity() instanceof Player)) {
				Player p = e.getEntity().getKiller();
				int tier = YamlConfiguration.loadConfiguration(
						new File("plugins" + File.separator + "MythsOfCreation"
								+ File.separator + "PlayerData"
								+ File.separator + p.getUniqueId() + ".yml"))
						.getInt("tier");
				if (e.getEntity().getType().getName().equals("Zombie")) {
					p.sendMessage(ChatColor.GRAY
							+ "You earned 1 nxp for killing a Zombie!");
					MOCUtils.addNxp(p, 1);
					MOCUtils.checkAcheivement(p, "First Mob Kill", 4);
				}
				if (e.getEntity().getType().getName().equals("Skeleton")) {
					p.sendMessage(ChatColor.GRAY
							+ "You earned 1 nxp for killing a Skeleton!");
					MOCUtils.addNxp(p, 1);
				}
				if (e.getEntity().getType().getName().equals("Spider")) {
					p.sendMessage(ChatColor.GRAY
							+ "You earned 1 nxp for killing a Spider!");
					MOCUtils.addNxp(p, 1);
				}
				if (e.getEntity().getType().getName().equals("Creeper")) {
					p.sendMessage(ChatColor.GRAY
							+ "You earned 1 nxp for killing a Creeper!");
					MOCUtils.addNxp(p, 1);
				}
				if (e.getEntity().getType().getName().equals("Witch")) {
					p.sendMessage(ChatColor.GRAY
							+ "You earned 1 nxp for killing a Witch!");
					MOCUtils.addNxp(p, 1);
				}
				if (e.getEntity().getType().getName().equals("Blaze")) {
					p.sendMessage(ChatColor.GRAY
							+ "You earned 1 nxp for killing a Blaze!");
					MOCUtils.addNxp(p, 1);
				}
				if (e.getEntity().getType().getName().equals("Ghast")) {
					p.sendMessage(ChatColor.GRAY
							+ "You earned 1 nxp for killing a Ghast!");
					MOCUtils.addNxp(p, 1);
				}
				if (e.getEntity().getType().getName()
						.equalsIgnoreCase("Enderman")) {
					p.sendMessage(ChatColor.GRAY
							+ "You earned 1 nxp for killing an Enderman!");
					MOCUtils.addNxp(p, 1);
				}
				if (e.getEntity().getType().getName().equals("PigZombie")) {
					p.sendMessage(ChatColor.GRAY
							+ "You earned 1 nxp for killing a PigZombie!");
					MOCUtils.addNxp(p, 1);
				}
				if (e.getEntity().getType().getName().equals("Wither")) {
					if (tier == 1) {
						p.sendMessage(ChatColor.GRAY
								+ "You earned 25 nxp for killing a Wither!");
						MOCUtils.addNxp(p, 25);
					}
					if (tier == 2) {
						p.sendMessage(ChatColor.GRAY
								+ "You earned 50 nxp for killing a Wither!");
						MOCUtils.addNxp(p, 50);
					}
					if (tier == 3) {
						p.sendMessage(ChatColor.GRAY
								+ "You earned 100 nxp for killing a Wither!");
						MOCUtils.addNxp(p, 100);
					}
					if (tier >= 4) {
						p.sendMessage(ChatColor.GRAY
								+ "You earned 150 nxp for killing a Wither!");
						MOCUtils.addNxp(p, 150);
					}
				}
				if (e.getEntity().getType().getName()
						.equalsIgnoreCase("Enderdragon")) {
					if (tier == 1) {
						p.sendMessage(ChatColor.GRAY
								+ "You earned 50 nxp for killing a Wither!");
						MOCUtils.addNxp(p, 50);
					}
					if (tier == 2) {
						p.sendMessage(ChatColor.GRAY
								+ "You earned 100 nxp for killing a Wither!");
						MOCUtils.addNxp(p, 100);
					}
					if (tier == 3) {
						p.sendMessage(ChatColor.GRAY
								+ "You earned 175 nxp for killing a Wither!");
						MOCUtils.addNxp(p, 175);
					}
					if (tier >= 4) {
						p.sendMessage(ChatColor.GRAY
								+ "You earned 250 nxp for killing a Wither!");
						MOCUtils.addNxp(p, 250);
					}
				}
			}
		}
	}
}
