package me.NerfFlamer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import me.NerfFlamer.Listeners.InvClickListener;
import me.NerfFlamer.Listeners.JoinListener;

import org.apache.commons.lang.StringUtils;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	public static Main instance;

	public static Main hook;
	
	public List<Classes> classes = new ArrayList<Classes>();
	

	@Override
	public void onEnable() {
		instance = this;
		getServer().getPluginManager().registerEvents(new InvClickListener(), this);
		getServer().getPluginManager().registerEvents(new JoinListener(), this);
		new NyxPointsCommand();
		new ClassCommand();
		this.saveDefaultConfig();
		classes.add(new Classes("none"));
		initializeClasses();
	}
	
	static Main getInstance() {
		
		return instance;
	}

	@Override
	public void onDisable() {
		this.saveConfig();
	}
	
	public void initializeClasses()
	{
		Set<String> c = this.getConfig().getConfigurationSection("Classes").getKeys(false);
		if (c.toString().indexOf(" ") == -1 && c.toString().length() > 2)
		{
			String name = c.toString().substring(1,c.toString().length());
			List<String> kit = this.getConfig().getStringList("Classes." + name + ".kit");
			List<String> perks = this.getConfig().getStringList("Classes." + name + ".perks");
			Classes cl = new Classes(name, kit, perks);
			classes.add(cl);
			return;
		}
		if (c.toString().indexOf(" ") >= 0)
		{
			List<String> names = new ArrayList<String>();
			String list = c.toString().substring(1) + " ";
			int count = StringUtils.countMatches(c.toString(), " ");
			for (int i = 0; i<=count; i++)
			{
				String temp = list.substring(0, list.indexOf(" ")-1);
				names.add(temp);
				list = list.substring(list.indexOf(" ") + 1);
			}
			for (String n : names)
			{
				List<String> kit = this.getConfig().getStringList("Classes." + n + ".Kit");
				List<String> perks = this.getConfig().getStringList("Classes." + n + ".Perks");
				Classes cl = new Classes(n, kit, perks);
				classes.add(cl);
			}
			return;
		}
	}
	public Classes getClass(Player p)
	{
		String name = YamlConfiguration.loadConfiguration(
				new File("plugins" + File.separator + "NyxPoints"
						+ File.separator + "PlayerData" + File.separator + p.getUniqueId() + ".yml"))
				.getString("class");
		for (Classes c : classes)
		{
			if (c.getName().equalsIgnoreCase(name))
			{
				return c;
			}
		}
		return classes.get(0);
	}
	public boolean checkForClass(String c)
	{
		for (Classes cl : classes)
		{
			if (cl.getName().equalsIgnoreCase(c))
			{
				return true;
			}
		}
		return false;
	}
}