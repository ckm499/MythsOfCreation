package me.NyxCraft.Commands;

import java.io.File;
import java.util.List;

import me.NyxCraft.Main;
import me.NyxCraft.PerkEffects;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

public class PerkCommands implements CommandExecutor {

	public PerkCommands() {
		Main.getInstance().getCommand("invis").setExecutor(this);
		Main.getInstance().getCommand("fury").setExecutor(this);
		Main.getInstance().getCommand("sheild").setExecutor(this);
		Main.getInstance().getCommand("sprint").setExecutor(this);
		Main.getInstance().getCommand("regen").setExecutor(this);
		Main.getInstance().getCommand("anvil").setExecutor(this);
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		Player p = (Player) sender;
		PerkEffects effect = new PerkEffects();
		List<String> perks = YamlConfiguration.loadConfiguration(
				new File("plugins" + File.separator + "MythsOfCreation"
						+ File.separator + "PlayerData" + File.separator
						+ p.getUniqueId() + ".yml")).getStringList("perks");
		if (cmd.getName().equalsIgnoreCase("anvil"))
		{
			if (perks.contains("ANVIL") || perks.contains("ALL"))
			{
				Inventory i = Bukkit.createInventory(null, InventoryType.ANVIL);
				 p.openInventory(i);
				 p.sendMessage(ChatColor.GRAY + "You have opened up an anvil!");
				 return true;
			}
			else {
				p.sendMessage(ChatColor.DARK_RED
						+ "You must purchase this perk before using it!");
				return true;
			}
		}
		if (cmd.getName().equalsIgnoreCase("invis")) {
			if (effect.invis(perks, p)) {
				return true;
			} else {
				p.sendMessage(ChatColor.DARK_RED
						+ "You must purchase this perk before using it!");
				return true;
			}
		}
		if (cmd.getName().equalsIgnoreCase("fury")) {
			if (effect.fury(perks, p)) {
				return true;
			} else {
				p.sendMessage(ChatColor.DARK_RED
						+ "You must purchase this perk before using it!");
				return true;
			}
		}
		if (cmd.getName().equalsIgnoreCase("sheild")) {
			if (effect.sheild(perks, p))
			{
				return true;
			} else {
				p.sendMessage(ChatColor.DARK_RED
						+ "You must purchase this perk before using it!");
				return true;
			}
		}
		if (cmd.getName().equalsIgnoreCase("sprint")) {
			if (effect.sprint(perks, p))
			{
				return true;
			} else {
				p.sendMessage(ChatColor.DARK_RED
						+ "You must purchase this perk before using it!");
				return true;
			}
		}
		if (cmd.getName().equalsIgnoreCase("regen")) {
			if (effect.regen(perks,  p))
			{
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
