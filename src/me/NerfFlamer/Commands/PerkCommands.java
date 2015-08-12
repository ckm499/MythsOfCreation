package me.NerfFlamer.Commands;

import java.io.File;
import java.util.List;

import me.NerfFlamer.Main;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PerkCommands implements CommandExecutor {

	public PerkCommands() {
		Main.getInstance().getCommand("invis").setExecutor(this);
		Main.getInstance().getCommand("fury").setExecutor(this);
		Main.getInstance().getCommand("sheild").setExecutor(this);
		Main.getInstance().getCommand("sprint").setExecutor(this);
		Main.getInstance().getCommand("regen").setExecutor(this);
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		long time = 0;
		Player p = (Player) sender;
		List<String> perks = YamlConfiguration.loadConfiguration(
				new File("plugins" + File.separator + "MythsOfCreation"
						+ File.separator + "PlayerData" + File.separator
						+ p.getUniqueId() + ".yml")).getStringList("perks");
		if (cmd.getName().equalsIgnoreCase("invis")) {
			if (perks.contains("INVIS:1") || perks.contains("INVIS:2")
					|| perks.contains("INVIS:3") || perks.contains("ALL")) {
				if (perks.contains("INVIS:1")) {
					PotionEffect pe = new PotionEffect(
							PotionEffectType.INVISIBILITY, 60, 0);
					p.addPotionEffect(pe);
					time = 3000;
				} else if (perks.contains("INVIS:2")) {
					PotionEffect pe = new PotionEffect(
							PotionEffectType.INVISIBILITY, 80, 0);
					p.addPotionEffect(pe);
					time = 4000;
				} else if (perks.contains("INVIS:3") || perks.contains("ALL")) {
					PotionEffect pe = new PotionEffect(
							PotionEffectType.INVISIBILITY, 100, 0);
					p.addPotionEffect(pe);
					time = 5000;
				}
				p.sendMessage(ChatColor.GRAY + "You are now invisible!");
				try {
					Thread.sleep(time);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				p.sendMessage(ChatColor.GRAY + "You are no longer invisible!");
				return true;
			} else {
				p.sendMessage(ChatColor.DARK_RED
						+ "You must purchase this perk before using it!");
				return true;
			}
		}
		if (cmd.getName().equalsIgnoreCase("fury")) {
			if (perks.contains("FURY:1") || perks.contains("FURY:2")
					|| perks.contains("FURY:3") || perks.contains("FURY:4")
					|| perks.contains("ALL")) {
				if (perks.contains("FURY:1")) {
					PotionEffect pe = new PotionEffect(PotionEffectType.HARM,
							60, 0);
					p.addPotionEffect(pe);
					time = 3000;
				}
				if (perks.contains("FURY:2")) {
					PotionEffect pe = new PotionEffect(PotionEffectType.HARM,
							60, 1);
					p.addPotionEffect(pe);
					time = 3000;
				}
				if (perks.contains("FURY:3")) {
					PotionEffect pe = new PotionEffect(PotionEffectType.HARM,
							80, 1);
					p.addPotionEffect(pe);
					time = 4000;
				}
				if (perks.contains("FURY:4") || perks.contains("ALL")) {
					PotionEffect pe = new PotionEffect(PotionEffectType.HARM,
							100, 1);
					p.addPotionEffect(pe);
					time = 5000;
				}
				p.sendMessage(ChatColor.GRAY + "Your fury has been unleashed!");
				try {
					Thread.sleep(time);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				p.sendMessage(ChatColor.GRAY + "Your fury has faded!");
				return true;
			} else {
				p.sendMessage(ChatColor.DARK_RED
						+ "You must purchase this perk before using it!");
				return true;
			}
		}
		if (cmd.getName().equalsIgnoreCase("sheild")) {
			if (perks.contains("SHEILD:1") || perks.contains("SHEILD:2")
					|| perks.contains("SHEILD:3") || perks.contains("SHEILD:4")
					|| perks.contains("ALL")) {
				if (perks.contains("SHEILD:1")) {
					PotionEffect pe = new PotionEffect(
							PotionEffectType.DAMAGE_RESISTANCE, 60, 0);
					p.addPotionEffect(pe);
					time = 3000;
				}
				if (perks.contains("SHEILD:2")) {
					PotionEffect pe = new PotionEffect(
							PotionEffectType.DAMAGE_RESISTANCE, 60, 1);
					p.addPotionEffect(pe);
					time = 3000;
				}
				if (perks.contains("SHEILD:3")) {
					PotionEffect pe = new PotionEffect(
							PotionEffectType.DAMAGE_RESISTANCE, 80, 1);
					p.addPotionEffect(pe);
					time = 4000;
				}
				if (perks.contains("SHEILD:4") || perks.contains("ALL")) {
					PotionEffect pe = new PotionEffect(
							PotionEffectType.DAMAGE_RESISTANCE, 100, 1);
					p.addPotionEffect(pe);
					time = 5000;
				}
				p.sendMessage(ChatColor.GRAY
						+ "You have activated your sheild!");
				try {
					Thread.sleep(time);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				p.sendMessage(ChatColor.GRAY + "Your sheild has worn off!");
				return true;
			} else {
				p.sendMessage(ChatColor.DARK_RED
						+ "You must purchase this perk before using it!");
				return true;
			}
		}
		if (cmd.getName().equalsIgnoreCase("sprint")) {
			if (perks.contains("SPRINT:1") || perks.contains("SPRINT:2")
					|| perks.contains("SPRINT:3") || perks.contains("SPRINT:4")
					|| perks.contains("ALL")) {
				if (perks.contains("SPRINT:1")) {
					PotionEffect pe = new PotionEffect(PotionEffectType.SPEED,
							60, 0);
					p.addPotionEffect(pe);
					time = 3000;
				}
				if (perks.contains("SPRINT:2")) {
					PotionEffect pe = new PotionEffect(PotionEffectType.SPEED,
							60, 1);
					p.addPotionEffect(pe);
					time = 3000;
				}
				if (perks.contains("SPRINT:3")) {
					PotionEffect pe = new PotionEffect(PotionEffectType.SPEED,
							80, 1);
					p.addPotionEffect(pe);
					time = 4000;
				}
				if (perks.contains("SPRINT:4") || perks.contains("ALL")) {
					PotionEffect pe = new PotionEffect(PotionEffectType.SPEED,
							100, 1);
					p.addPotionEffect(pe);
					time = 5000;
				}
				p.sendMessage(ChatColor.GRAY + "You have activated sprint!");
				try {
					Thread.sleep(time);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				p.sendMessage(ChatColor.GRAY + "Sprint has worn off!");
				return true;
			} else {
				p.sendMessage(ChatColor.DARK_RED
						+ "You must purchase this perk before using it!");
				return true;
			}
		}
		if (cmd.getName().equalsIgnoreCase("regen")) {
			if (perks.contains("REGEN:1") || perks.contains("REGEN:2")
					|| perks.contains("REGEN:3") || perks.contains("REGEN:4")
					|| perks.contains("ALL")) {
				if (perks.contains("REGEN:1")) {
					PotionEffect pe = new PotionEffect(
							PotionEffectType.REGENERATION, 100, 0);
					p.addPotionEffect(pe);
					time = 5000;
				}
				if (perks.contains("REGEN:2")) {
					PotionEffect pe = new PotionEffect(
							PotionEffectType.REGENERATION, 150, 0);
					p.addPotionEffect(pe);
					time = 7500;
				}
				if (perks.contains("REGEN:3")) {
					PotionEffect pe = new PotionEffect(
							PotionEffectType.REGENERATION, 100, 1);
					p.addPotionEffect(pe);
					time = 5000;
				}
				if (perks.contains("REGEN:4") || perks.contains("ALL")) {
					PotionEffect pe = new PotionEffect(
							PotionEffectType.REGENERATION, 150, 1);
					p.addPotionEffect(pe);
					time = 7500;
				}
				p.sendMessage(ChatColor.GRAY + "You have begun to gain health!");
				try {
					Thread.sleep(time);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				p.sendMessage(ChatColor.GRAY
						+ "You have stopped gaining health!");
				return true;
			} else {
				p.sendMessage(ChatColor.DARK_RED
						+ "You must purchase this perk before using it!");
				return true;
			}
		}
		return false;
	}
}
