package me.NerfFlamer.Commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class PerkThread implements Runnable{
	
	long t = 0;
	Player p;
	String m;
	
	public PerkThread(Player player, long time, String msg)
	{
		p = player;
		t = time;
		m = msg;
	}

	@Override
	public void run() {
		p.sendMessage(ChatColor.GRAY + m);
	}

}
