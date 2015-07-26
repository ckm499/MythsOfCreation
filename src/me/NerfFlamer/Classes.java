package me.NerfFlamer;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Classes {
	String name = "";
	List<ItemStack> kit = new ArrayList<ItemStack>();
	List<String> defaultPerks = new ArrayList<String>();
	
	
	public Classes(String n)
	{
		name = n;
	}
	public Classes(String n, List<String> k, List<String> perks)
	{
		name = n;
		kit = translateKit(k);
		defaultPerks = perks;
	}
	
	public String getName()
	{
		return name;
	}
	public List<ItemStack> getKit()
	{
		return kit;
	}
	public List<?> getDefaultPerks()
	{
		return defaultPerks;
	}
	
	public void setName(String n)
	{
		name = n;
	}
	public void setKit(List<String> k)
	{
		kit = translateKit(k);
	}
	public void setDefaultPerks(List<String> perks)
	{
		defaultPerks = perks;
	}
	
	public List<ItemStack> translateKit(List<String> k)
	{
		List<ItemStack> translated = new ArrayList<ItemStack>();
		for(String s : k)
		{
			ItemStack temp = new ItemStack(Material.getMaterial(s.substring(0, s.length()-2)));
			temp.setAmount(Integer.parseInt(s.substring(s.indexOf(" "))));
			translated.add(temp);
		}
		return translated;
	}
}
