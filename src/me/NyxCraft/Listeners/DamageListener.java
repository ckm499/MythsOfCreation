package me.NyxCraft.Listeners;

import java.io.File;
import java.util.List;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class DamageListener implements Listener{

	@EventHandler
	public void onDamageByEntity(EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
			List<String> perks = YamlConfiguration.loadConfiguration(
					new File("plugins" + File.separator + "MythsOfCreation"
							+ File.separator + "PlayerData" + File.separator
							+ p.getUniqueId() + ".yml")).getStringList("perks");
			if (e.getDamager() instanceof Player) {
				Player dmg = (Player)e.getDamager();
				List<String> damager = YamlConfiguration.loadConfiguration(
						new File("plugins" + File.separator + "MythsOfCreation"
								+ File.separator + "PlayerData" + File.separator
								+ dmg.getUniqueId() + ".yml")).getStringList("perks");
				if (perks.contains("DODGE:1")) {
					double chance = 100 * Math.random();
					if (chance <= 5) {
						e.setCancelled(true);
					}
				}
				if (perks.contains("DODGE:2")) {
					double chance = 100 * Math.random();
					if (chance <= 10) {
						e.setCancelled(true);
					}
				}
				if (perks.contains("DODGE:3")) {
					double chance = 100 * Math.random();
					if (chance <= 15) {
						e.setCancelled(true);
					}
				}
				if (perks.contains("DODGE:4") || perks.contains("ALL")) {
					double chance = 100 * Math.random();
					if (chance <= 20) {
						e.setCancelled(true);
					}
				}
				if (perks.contains("BLOCK:1")) {
					double chance = 100 * Math.random();
					if (chance <= 3) {
						e.setDamage(0);
					}
				}
				if (perks.contains("BLOCK:2")) {
					double chance = 100 * Math.random();
					if (chance <= 6) {
						e.setDamage(0);
					}
				}
				if (perks.contains("BLOCK:3")) {
					double chance = 100 * Math.random();
					if (chance <= 9) {
						e.setDamage(0);
					}
				}
				if (perks.contains("BLOCK:4") || perks.contains("ALL")) {
					double chance = 100 * Math.random();
					if (chance <= 12) {
						e.setDamage(0);
					}
				}
				//player affected changes here
				if (damager.contains("SLOW:1"))
				{
					double chance = 100 * Math.random();
					if (chance <= 2)
					{
						PotionEffect pe = new PotionEffect(PotionEffectType.SLOW, 60, 0);
						p.addPotionEffect(pe);
					}
				}
				if (damager.contains("SLOW:2"))
				{
					double chance = 100 * Math.random();
					if (chance <= 4)
					{
						PotionEffect pe = new PotionEffect(PotionEffectType.SLOW, 60, 0);
						p.addPotionEffect(pe);
					}
				}
				if (damager.contains("SLOW:3"))
				{
					double chance = 100 * Math.random();
					if (chance <= 6)
					{
						PotionEffect pe = new PotionEffect(PotionEffectType.SLOW, 60, 0);
						p.addPotionEffect(pe);
					}
				}
				if (damager.contains("SLOW:4"))
				{
					double chance = 100 * Math.random();
					if (chance <= 8)
					{
						PotionEffect pe = new PotionEffect(PotionEffectType.SLOW, 60, 0);
						p.addPotionEffect(pe);
					}
				}
				if (damager.contains("SLOW:5"))
				{
					double chance = 100 * Math.random();
					if (chance <= 10)
					{
						PotionEffect pe = new PotionEffect(PotionEffectType.SLOW, 60, 0);
						p.addPotionEffect(pe);
					}
				}
			}
			//changes back
			if (perks.contains("RESIST:1")) {
				e.setDamage(e.getDamage() * .98);
			}
			if (perks.contains("RESIST:2")) {
				e.setDamage(e.getDamage() * .96);
			}
			if (perks.contains("RESIST:3")) {
				e.setDamage(e.getDamage() * .94);
			}
			if (perks.contains("RESIST:4")) {
				e.setDamage(e.getDamage() * .92);
			}
			if (perks.contains("RESIST:5") || perks.contains("ALL")) {
				e.setDamage(e.getDamage() * .9);
			}
		}
	}
}
