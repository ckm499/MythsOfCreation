package me.NerfFlamer;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	public static Main instance;

	public static Main hook;
	
	Main plugin = Main.hook();
	
	public Map<UUID, Integer> pointData = new HashMap<UUID, Integer>();

	@Override
	public void onEnable() {
		
	}
	
	static Main hook() {
		
		return instance;
	}

	@Override
	public void onDisable() {
		
	}
	
}