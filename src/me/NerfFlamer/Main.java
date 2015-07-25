package me.NerfFlamer;

import me.NerfFlamer.Listeners.InvClickListener;
import me.NerfFlamer.Listeners.JoinListener;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	public static Main instance;

	public static Main hook;
	

	@Override
	public void onEnable() {
		instance = this;
		getServer().getPluginManager().registerEvents(new InvClickListener(), this);
		getServer().getPluginManager().registerEvents(new JoinListener(), this);
		new NyxPointsCommand();
	}
	
	static Main getInstance() {
		
		return instance;
	}

	@Override
	public void onDisable() {

	}
}