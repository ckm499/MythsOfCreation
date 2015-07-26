package me.NerfFlamer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

public class ClassCommand implements CommandExecutor {

	public ClassCommand() {
		Main.getInstance().getCommand("class").setExecutor(this);
		Main.getInstance().getCommand("c").setExecutor(this);
		Main.getInstance().getCommand("ckit").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		Player player = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("class")
				|| cmd.getName().equalsIgnoreCase("c")
				&& sender instanceof Player) {
			
			if (args.length == 0) {
				player.sendMessage(ChatColor.RED
						+ "Not enough arguments! Usage: /class (args)");
				return true;
			}
			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("kit")
						|| args[0].equalsIgnoreCase("k")) {
					kit(player);
					return true;
				}
				if (args[0].equalsIgnoreCase("info")
						|| args[0].equalsIgnoreCase("i")) {
					player.sendMessage(ChatColor.GOLD + "Class: "
							+ ChatColor.YELLOW
							+ Main.getInstance().getClass(player).getName());
					return true;
				}
			}
			return false;
		}
		if (cmd.getName().equalsIgnoreCase("ckit"))
		{
			kit(player);
			return true;
		}
		return false;
	}

	public void kit(Player player) {
		if ((System.currentTimeMillis() - YamlConfiguration.loadConfiguration(
				new File("plugins" + File.separator + "NyxPoints"
						+ File.separator + "PlayerData" + File.separator
						+ player.getUniqueId() + ".yml")).getLong("kitTime")) >= 86400000 || YamlConfiguration.loadConfiguration(
								new File("plugins" + File.separator + "NyxPoints"
										+ File.separator + "PlayerData" + File.separator
										+ player.getUniqueId() + ".yml")).getLong("kitTime", -1) == -1) {
			List<ItemStack> is = new ArrayList<ItemStack>();
			is = Main.getInstance().getClass(player).getKit();
			for (ItemStack i : is) {
				player.getInventory().addItem(i);
			}
			YamlConfiguration temp = new YamlConfiguration();
			try {
				temp.load(new File("plugins" + File.separator + "NyxPoints"
						+ File.separator + "PlayerData" + File.separator
						+ player.getUniqueId() + ".yml"));
			} catch (FileNotFoundException e2) {
				e2.printStackTrace();
			} catch (IOException e2) {
				e2.printStackTrace();
			} catch (InvalidConfigurationException e2) {
				e2.printStackTrace();
			}
			temp.set("kitTime", System.currentTimeMillis());
			try {
				temp.save("plugins" + File.separator + "NyxPoints"
						+ File.separator + "PlayerData" + File.separator
						+ player.getUniqueId() + ".yml");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			player.sendMessage(ChatColor.GOLD
					+ "You have been given your class kit!");
			return;
		} else {
			player.sendMessage(ChatColor.RED
					+ "You must wait the full 24 hours before using your kit again!");
		}
	}

}
