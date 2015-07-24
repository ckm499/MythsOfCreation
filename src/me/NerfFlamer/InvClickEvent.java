package me.NerfFlamer;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

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
			e.setCancelled(true);
			Integer pointamount = plugin.pointData.get(player.getUniqueId());
			
			Integer price = Integer.parseInt(e.getCurrentItem().getItemMeta().getLore().get(1));
			if(pointamount <= price) {
				player.sendMessage(ChatColor.RED + "You do not have enough coins!");
			}
			plugin.pointData.put(player.getUniqueId(), pointamount-price);
			player.sendMessage(ChatColor.GREEN + "You have purchased %item% for %price%!"
					.replaceAll("%item%", e.getCurrentItem().getType().name())
					.replaceAll("%price%", e.getCurrentItem().getItemMeta().getLore().get(1)));
			player.getInventory().addItem(new ItemStack(e.getCurrentItem().getType()));
		}
	}
	
}
