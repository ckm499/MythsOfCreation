package me.NyxCraft.Commands;

import java.io.File;
import java.util.Arrays;

import me.NyxCraft.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.file.YamlConfiguration;

public class NyxPointsCommand implements CommandExecutor {
	
	//sets this class as the executor for commands
	public NyxPointsCommand()
	{
		Main.getInstance().getCommand("nyxpoints").setExecutor(this);
		Main.getInstance().getCommand("np").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {

		if (cmd.getName().equalsIgnoreCase("nyxpoints")
				|| cmd.getName().equalsIgnoreCase("np")
				&& sender instanceof Player) {

			Player p = (Player) sender;
			//assigns pointamount to the nyxpoint value in the p file
			Integer pointamount = YamlConfiguration.loadConfiguration(
					new File("plugins" + File.separator + "MythsOfCreation"
							+ File.separator + "PlayerData" + File.separator + p.getUniqueId() + ".yml"))
					.getInt("NyxPoints");
			if(args.length == 0)
			{
				p.sendMessage(ChatColor.RED + "Not enough arguments! Usage: /nyxpoints (args)");
				return true;
			}
			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("balance")
						|| args[0].equalsIgnoreCase("bal")) {
					p.sendMessage(ChatColor.GOLD + "NyxPoints: "
							+ ChatColor.YELLOW + pointamount);
					return true;
				}
			}
			//you know what this does
			if (args[0].equalsIgnoreCase("shop")
					|| args[0].equalsIgnoreCase("s")) {

				ItemStack commonKey = new ItemStack(Material.TRIPWIRE_HOOK);
				ItemMeta commonKeyMeta = commonKey.getItemMeta();
				commonKeyMeta.setDisplayName("" + ChatColor.BOLD
						+ ChatColor.WHITE + "Common Dungeon Key");
				commonKeyMeta.setLore(Arrays.asList(ChatColor.GRAY + "Price: ",
						ChatColor.GRAY + "2"));
				commonKey.setItemMeta(commonKeyMeta);
				Inventory shop = Bukkit.createInventory(null, 9, "Shop");
				shop.setItem(0, commonKey);
				p.openInventory(shop);
				return true;
			}
			if (args[0].equalsIgnoreCase("kit"))
			{
				p.sendMessage(Main.getInstance().classes.get(0).getKit().get(0) + " " + Main.getInstance().classes.get(0).getKit().get(1));
			}
		}

		return false;

	}

}
