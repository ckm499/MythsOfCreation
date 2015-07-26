package me.NerfFlamer.Listeners;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class JoinListener implements Listener {

	@EventHandler
	public void onPlayerJoin(PlayerLoginEvent e) {
		if (new File("plugins" + File.separator + "NyxPoints" + File.separator
				+ "PlayerData" + File.separator + e.getPlayer().getUniqueId() + ".yml").isFile()) {
			return;
		} else {
			YamlConfiguration temp = new YamlConfiguration();
			temp.createSection("name");
			temp.createSection("class");
			temp.createSection("NyxPoints");
			temp.createSection("perks");
			temp.createSection("kitTime");
			temp.createSection("perms");
			temp.set("name", e.getPlayer().getDisplayName());
			temp.set("class", "none");
			temp.set("NyxPoints", 0);
			try {
				temp.save("plugins" + File.separator + "NyxPoints"
						+ File.separator + "PlayerData" + File.separator
						+ e.getPlayer().getUniqueId() + ".yml");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

}
