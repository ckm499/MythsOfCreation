package me.NyxCraft.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class ItemDropListener implements Listener {

	@EventHandler
	public void onPlayerDropItem(PlayerDropItemEvent e) {
		Player p = e.getPlayer();
		if (e.getItemDrop().getItemStack().getItemMeta().hasLore()) {
			if (e.getItemDrop().getItemStack().getItemMeta().getLore().get(0)
					.equals("Fury")
					|| e.getItemDrop().getItemStack().getItemMeta().getLore()
							.get(0).equals("Sheild")
					|| e.getItemDrop().getItemStack().getItemMeta().getLore()
							.get(0).equals("Sprint")
					|| e.getItemDrop().getItemStack().getItemMeta().getLore()
							.get(0).equals("Regen")) {
				e.setCancelled(true);
				p.sendMessage(ChatColor.DARK_RED + "You can't drop this item!");
			}
		}
	}
}
