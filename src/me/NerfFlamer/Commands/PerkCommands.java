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

public class PerkCommands implements CommandExecutor{
	
	public PerkCommands()
	{
		Main.getInstance().getCommand("invis").setExecutor(this);
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		Player p = (Player)sender;
		List<String> perks = YamlConfiguration.loadConfiguration(
				new File("plugins" + File.separator + "MythsOfCreation"
						+ File.separator + "PlayerData" + File.separator + p.getUniqueId() + ".yml"))
				.getStringList("perks");
		if (cmd.getName().equalsIgnoreCase("invis"))
		{
			if (perks.contains("INVIS"))
			{
				PotionEffect pe = new PotionEffect(PotionEffectType.INVISIBILITY, 60, 0);
				p.addPotionEffect(pe);
				p.sendMessage(ChatColor.GRAY + "You are now invisible!");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				p.sendMessage(ChatColor.GRAY + "You are no longer invisible!");
				return true;
			}
			else {
				p.sendMessage(ChatColor.DARK_RED + "You must purchase this perk first!");
			}
		}
		return false;
	}
}
