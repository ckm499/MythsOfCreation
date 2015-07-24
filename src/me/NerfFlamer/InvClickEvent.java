package me.NerfFlamer;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InvClickEvent implements Listener {
	
	Main plugin = Main.hook();
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		Player player = (Player) e.getWhoClicked();
		
		if(e.getCurrentItem() == null) {
			return;
		}
		
		if(!e.getCurrentItem().hasItemMeta()) {
			return;
		}
		
		if(e.getInventory().getName().contains("Shop")) {
			Integer pointamount = plugin.pointData.get(player.getUniqueId());
			
			Integer price = Integer.parseInt(e.getCurrentItem().getItemMeta().getLore().get(2));
			if(pointamount <= price) {
				
				
				
			}
		}
	}
	
}