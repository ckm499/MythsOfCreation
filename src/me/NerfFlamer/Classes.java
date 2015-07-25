package me.NerfFlamer;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Classes {
	String name = "";
	List<ItemStack> kit = new ArrayList<ItemStack>();
	List<String> defaultPerks = new ArrayList<String>();
	
	public Classes(String n, List<String> k, List<String> perks)
	{
		name = n;
		kit = translateKit(k);
		defaultPerks = perks;
	}
	
	public List<ItemStack> translateKit(List<String> k)
	{
		List<ItemStack> translated = new ArrayList<ItemStack>();
		for(String s : k)
		{
			ItemStack temp = new ItemStack(Material.getMaterial(s));
			translated.add(temp);
		}
		return translated;
	}
}
