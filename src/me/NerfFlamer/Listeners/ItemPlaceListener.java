package me.NerfFlamer.Listeners;

import java.io.File;
import java.util.List;

import me.NerfFlamer.PerkEffects;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class ItemPlaceListener implements Listener{
	
	@EventHandler
	public void onPlace(PlayerInteractEvent e)
	{
		Player p = e.getPlayer();
		PerkEffects effect = new PerkEffects();
		List<String> perks = YamlConfiguration.loadConfiguration(
				new File("plugins" + File.separator + "MythsOfCreation"
						+ File.separator + "PlayerData" + File.separator
						+ p.getUniqueId() + ".yml")).getStringList("perks");
		if ((p.getItemInHand().getItemMeta().getLore().get(0).equals("Fury") || 
				p.getItemInHand().getItemMeta().getLore().get(0).equals("Sheild") || 
				p.getItemInHand().getItemMeta().getLore().get(0).equals("Sprint") || 
				p.getItemInHand().getItemMeta().getLore().get(0).equals("Regen")) && 
				(e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR))
		{
			if (e.getPlayer().getItemInHand().getItemMeta().getLore().get(0).equals("Fury"))
			{
				if (effect.fury(perks, p))
				{
					return;
				}
				else {
					p.sendMessage(ChatColor.DARK_RED
					    + "You must purchase this perk before using it!");
				}
			}
			if (e.getPlayer().getItemInHand().getItemMeta().getLore().get(0).equals("Sheild"))
			{
				if (effect.sheild(perks, p))
				{
					return;
				}
				else {
					p.sendMessage(ChatColor.DARK_RED
					    + "You must purchase this perk before using it!");
				}
			}
			if (e.getPlayer().getItemInHand().getItemMeta().getLore().get(0).equals("Sprint"))
			{
				if (effect.sprint(perks, p))
				{
					return;
				}
				else {
					p.sendMessage(ChatColor.DARK_RED
					    + "You must purchase this perk before using it!");
				}
			}
			if (e.getPlayer().getItemInHand().getItemMeta().getLore().get(0).equals("Regen"))
			{
				if (effect.regen(perks, p))
				{
					return;
				}
				else {
					p.sendMessage(ChatColor.DARK_RED
					    + "You must purchase this perk before using it!");
				}
			}
		}
	}
}
