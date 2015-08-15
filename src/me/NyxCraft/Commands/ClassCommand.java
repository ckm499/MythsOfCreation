package me.NyxCraft.Commands;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import me.NyxCraft.Classes;
import me.NyxCraft.MOCUtils;
import me.NyxCraft.Main;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

public class ClassCommand implements CommandExecutor {

	// sets this class as executor for the class commands
	public ClassCommand() {
		Main.getInstance().getCommand("class").setExecutor(this);
		Main.getInstance().getCommand("c").setExecutor(this);
		Main.getInstance().getCommand("ckit").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		Player player = (Player) sender;
		if ((cmd.getName().equalsIgnoreCase("class") || cmd.getName()
				.equalsIgnoreCase("c")) && sender instanceof Player) {

			if (args.length == 0) {
				player.sendMessage(ChatColor.DARK_RED
						+ "Not enough arguments! Usage: /class (args)");
				return true;
			}
			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("kit")
						|| args[0].equalsIgnoreCase("k")) {
					kit(player);
					return true;
				}
				if (args[0].equalsIgnoreCase("test")) {
					ItemStack i = new ItemStack(Material.IRON_FENCE);
					ItemMeta im = i.getItemMeta();
					List<String> l = new ArrayList<String>();
					l.add("Fury");
					im.setLore(l);
					i.setItemMeta(im);
					player.getInventory().addItem(i);
					return true;
				}
				if (args[0].equalsIgnoreCase("test")) {
					player.sendMessage(Main.instance.getConfig()
							.getStringList("Classes.Hephaestus.Kit").get(0)
							+ Main.instance.getConfig()
									.getStringList("Classes.Hephaestus.Kit")
									.get(1));
					return true;
				}
				if (args[0].equalsIgnoreCase("info")
						|| args[0].equalsIgnoreCase("i")) {
					player.sendMessage(ChatColor.GOLD + "Class: "
							+ ChatColor.YELLOW
							+ MOCUtils.getClass(player).getName());
					return true;
				}
				if (args[0].equalsIgnoreCase("list")) {
					player.sendMessage(ChatColor.GOLD + "Classes:");
					for (Classes c : Main.getInstance().classes) {
						player.sendMessage(ChatColor.YELLOW + c.getName());
					}
					return true;
				}
				// sets players class to "none" in yaml file and removes perks
				// from file
				if (args[0].equalsIgnoreCase("leave")) {
					YamlConfiguration temp = new YamlConfiguration();
					try {
						temp.load(new File("plugins" + File.separator
								+ "MythsOfCreation" + File.separator
								+ "PlayerData" + File.separator
								+ player.getUniqueId() + ".yml"));
					} catch (FileNotFoundException e2) {
						e2.printStackTrace();
					} catch (IOException e2) {
						e2.printStackTrace();
					} catch (InvalidConfigurationException e2) {
						e2.printStackTrace();
					}
					temp.set("class", "none");
					List<String> p = new ArrayList<String>();
					temp.set("perks", p);
					try {
						temp.save("plugins" + File.separator
								+ "MythsOfCreation" + File.separator
								+ "PlayerData" + File.separator
								+ player.getUniqueId() + ".yml");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					player.sendMessage(ChatColor.GRAY
							+ "You have successfully left your class!");
					return true;
				}
			}
			if (args.length == 2) {
				/*
				 * sets players class to args[2] if it exists and they arent
				 * already in a class Adds this and specified class perks to the
				 * player's yaml file
				 */
				if (args[0].equalsIgnoreCase("join")
						|| args[0].equalsIgnoreCase("j")) {
					if (MOCUtils.checkForClass(args[1])) {
						YamlConfiguration temp = new YamlConfiguration();
						if (MOCUtils.getClass(player).getName()
								.equalsIgnoreCase("none")) {
							try {
								temp.load(new File("plugins" + File.separator
										+ "MythsOfCreation" + File.separator
										+ "PlayerData" + File.separator
										+ player.getUniqueId() + ".yml"));
							} catch (FileNotFoundException e2) {
								e2.printStackTrace();
							} catch (IOException e2) {
								e2.printStackTrace();
							} catch (InvalidConfigurationException e2) {
								e2.printStackTrace();
							}
							temp.set("class", (args[1]));
							try {
								temp.save("plugins" + File.separator
										+ "MythsOfCreation" + File.separator
										+ "PlayerData" + File.separator
										+ player.getUniqueId() + ".yml");
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							player.sendMessage(ChatColor.GRAY
									+ "You have successfully joined the "
									+ args[1] + " class!");
							return true;
						} else {
							player.sendMessage(ChatColor.DARK_RED
									+ "You must leave your current class first! /class leave");
							return true;
						}
					} else {
						player.sendMessage(ChatColor.DARK_RED
								+ "Class does not exist! View classes with /class list");
						return true;
					}
				}
			}
			return false;
		}
		// easy alias for /class kit
		if (cmd.getName().equalsIgnoreCase("ckit")) {
			kit(player);
			return true;
		}
		return false;
	}

	/*
	 * gets the class kit from the main class and checks player file to see if
	 * cooldown is over Currently set at 24 hour cooldown
	 */
	public void kit(Player player) {
		long t = YamlConfiguration.loadConfiguration(
				new File("plugins" + File.separator + "MythsOfCreation"
						+ File.separator + "PlayerData" + File.separator
						+ player.getUniqueId() + ".yml")).getLong("kitTime");
		if ((System.currentTimeMillis() - t) >= 86400000
				|| YamlConfiguration.loadConfiguration(
						new File("plugins" + File.separator + "MythsOfCreation"
								+ File.separator + "PlayerData"
								+ File.separator + player.getUniqueId()
								+ ".yml")).getLong("kitTime", -1) == -1) {
			List<ItemStack> is = new ArrayList<ItemStack>();
			is = MOCUtils.getClass(player).getKit();
			for (ItemStack i : is) {
				player.getInventory().addItem(i);
			}
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
			temp.set("kitTime", System.currentTimeMillis());
			try {
				temp.save("plugins" + File.separator + "MythsOfCreation"
						+ File.separator + "PlayerData" + File.separator
						+ player.getUniqueId() + ".yml");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			player.sendMessage(ChatColor.GOLD
					+ "You have been given your class kit!");
			return;
		} else {
			player.sendMessage(toFriendlyTime(((86400000 - (System.currentTimeMillis() - t))) / 1000));
		}
	}

	public String toFriendlyTime(long seconds) {
		long minutes = 0;
		long hours = 0;
		long days = 0;
		if (seconds / 60 >= 1) {
			minutes = seconds / 60;
			seconds = seconds % 60;
		}
		if (minutes / 60 >= 1) {
			hours = minutes / 60;
			minutes = minutes % 60;
		}
		if (hours / 24 >= 1) {
			days = hours / 24;
			hours = hours % 24;
		}
		if (days > 0) {
			return ChatColor.DARK_RED + "You must wait another "
					+ ChatColor.GOLD + days + " days " + hours + " hours "
					+ minutes + " minutes " + seconds + " seconds"
					+ ChatColor.DARK_RED + " before using this command again!";
		}
		if (hours > 0) {
			return ChatColor.DARK_RED + "You must wait another "
					+ ChatColor.GOLD + hours + " hours " + minutes
					+ " minutes " + seconds + " seconds" + ChatColor.DARK_RED
					+ " before using this command again!";
		}
		if (minutes > 0) {
			return ChatColor.DARK_RED + "You must wait another "
					+ ChatColor.GOLD + minutes + " minutes " + seconds
					+ " seconds" + ChatColor.DARK_RED
					+ " before using this command again!";
		}
		if (seconds > 0)
		{
			return ChatColor.DARK_RED + "You must wait another "
					+ ChatColor.GOLD + seconds + " seconds"
					+ ChatColor.DARK_RED + " before using this command again!";
		}
		return "";
	}

}
