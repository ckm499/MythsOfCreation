package me.NyxCraft.Listeners;

import me.NyxCraft.MOCUtils;

import org.bukkit.ChatColor;
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
			Player p = e.getEntity().getKiller();
			MOCUtils.addNxp(p, 10);
			p.sendMessage(ChatColor.GRAY + "You have earned 10 nxp for killing " + e.getEntity().getDisplayName() + "!");
			MOCUtils.checkAcheivement(p, "Defeat another player", 25);
		}
	}

}
