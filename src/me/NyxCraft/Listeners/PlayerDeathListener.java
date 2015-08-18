package me.NyxCraft.Listeners;

import java.io.File;

import me.NyxCraft.MOCUtils;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathListener implements Listener{
	
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent e)
	{
		if (e.getEntity().getKiller() instanceof Player)
		{
			int reward = 0;
			Player p = e.getEntity().getKiller();
			int tier = YamlConfiguration.loadConfiguration(
					new File("plugins" + File.separator + "MythsOfCreation"
							+ File.separator + "PlayerData" + File.separator
							+ p.getUniqueId() + ".yml")).getInt("tier");
			String cl = YamlConfiguration.loadConfiguration(
					new File("plugins" + File.separator + "MythsOfCreation"
							+ File.separator + "PlayerData" + File.separator
							+ p.getUniqueId() + ".yml")).getString("class");
			if (tier == 1)
			{
				reward = 10;
			}
			if (tier == 2)
			{
				reward = 20;
			}
			if (tier == 3)
			{
				reward = 30;
			}
			if (tier == 4)
			{
				reward = 40;
			}
			if (tier == 5)
			{
				reward = 60;
			}
			if (tier == 6)
			{
				reward = 80;
			}
			if (tier == 7)
			{
				reward = 100;
			}
			if (tier == 8)
			{
				return;
			}
			if (cl.equals("Ares"))
			{
				reward = (int) (reward * 1.5);
			}
			MOCUtils.addNxp(p, reward);
			p.sendMessage(ChatColor.GRAY + "You have earned " + reward + " nxp for killing " + e.getEntity().getDisplayName() + "!");
			MOCUtils.checkAcheivement(p, "Defeat another player", 2);
		}
	}

}
