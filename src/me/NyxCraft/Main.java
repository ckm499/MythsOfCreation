package me.NyxCraft;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import me.NyxCraft.Commands.ClassCommand;
import me.NyxCraft.Commands.NyxPointsCommand;
import me.NyxCraft.Commands.PerkCommands;
import me.NyxCraft.Listeners.DamageListener;
import me.NyxCraft.Listeners.InvClickListener;
import me.NyxCraft.Listeners.ItemDropListener;
import me.NyxCraft.Listeners.ItemPlaceListener;
import me.NyxCraft.Listeners.JoinListener;
import me.NyxCraft.Listeners.MobDeathListener;
import me.NyxCraft.Listeners.PlayerDeathListener;

import org.apache.commons.lang.StringUtils;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	public static Main instance;
	
	//ArrayList that holds all the classes as listed in config.yml
	public List<Classes> classes = new ArrayList<Classes>();
	

	//registers commands, listeners and classes
	@Override
	public void onEnable() {
		setInstance();
		getServer().getPluginManager().registerEvents(new InvClickListener(), this);
		getServer().getPluginManager().registerEvents(new JoinListener(), this);
		getServer().getPluginManager().registerEvents(new ItemDropListener(), this);
		getServer().getPluginManager().registerEvents(new ItemPlaceListener(), this);
		getServer().getPluginManager().registerEvents(new MobDeathListener(), this);
		getServer().getPluginManager().registerEvents(new PlayerDeathListener(), this);
		getServer().getPluginManager().registerEvents(new DamageListener(), this);
		new NyxPointsCommand();
		new ClassCommand();
		new PerkCommands();
		if (!(new File("plugins" + File.separator + "MythsOfCreation"
										+ File.separator + "Acheivements.yml").isFile()))
		{
			YamlConfiguration temp = new YamlConfiguration();
			temp.createSection("firstPerk");
			try {
				temp.save("plugins" + File.separator + "MythsOfCreation"
						+ File.separator + "Acheivements.yml");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		this.saveDefaultConfig();
		classes.add(new Classes("none"));
		initializeClasses();
	}
	
	//you know what this is
	public static Main getInstance() {
		
		return instance;
	}
	
	public void setInstance()
	{
		instance = this;
	}

	@Override
	public void onDisable() {
		this.saveConfig();
	}
	
	//reads config and initializes the classes listed there with the Classes class
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
}