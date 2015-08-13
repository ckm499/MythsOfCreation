package me.NerfFlamer.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class MobDeathListener implements Listener{
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onMobDeath(EntityDeathEvent e)
	{
		Player p = e.getEntity().getKiller();
		if (e.getEntity().getType().getName().equals("Zombie"))
		{
			p.sendMessage("You killed a zombie");
			//give player 1 nxp
		}
		if (e.getEntity().getType().getName().equals("Skeleton"))
		{
			//give player 1 nxp
		}
		if (e.getEntity().getType().getName().equals("Spider"))
		{
			//give player 1 nxp
		}
		if (e.getEntity().getType().getName().equals("Creeper"))
		{
			//give player 1 nxp
		}
		if (e.getEntity().getType().getName().equals("Witch"))
		{
			//give player 2 nxp
		}
		if (e.getEntity().getType().getName().equals("Blaze"))
		{
			//give player 2 nxp
		}
		if (e.getEntity().getType().getName().equals("Ghast"))
		{
			//give player 3 nxp
		}
		if (e.getEntity().getType().getName().equals("PigZombie"))
		{
			//give player 1 nxp
		}
	}
}
