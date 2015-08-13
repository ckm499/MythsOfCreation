package me.NerfFlamer;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import me.NerfFlamer.Commands.PerkThread;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PerkEffects {

	ScheduledExecutorService stp = Executors.newScheduledThreadPool(5);
	long time = 0;

	public PerkEffects() {
	}

	public boolean invis(List<String> perks, Player p) {
		if (perks.contains("INVIS:1") || perks.contains("INVIS:2")
				|| perks.contains("INVIS:3") || perks.contains("ALL")) {
			if (perks.contains("INVIS:1")) {
				PotionEffect pe = new PotionEffect(
						PotionEffectType.INVISIBILITY, 60, 0);
				p.addPotionEffect(pe);
				time = 3000;
			} else if (perks.contains("INVIS:2")) {
				PotionEffect pe = new PotionEffect(
						PotionEffectType.INVISIBILITY, 80, 0);
				p.addPotionEffect(pe);
				time = 4000;
			} else if (perks.contains("INVIS:3") || perks.contains("ALL")) {
				PotionEffect pe = new PotionEffect(
						PotionEffectType.INVISIBILITY, 100, 0);
				p.addPotionEffect(pe);
				time = 5000;
			}
			p.sendMessage(ChatColor.GRAY + "You are now invisible!");
			PerkThread perk = new PerkThread(p, time,
					"You are no longer invisible!");
			stp.schedule(perk, time, TimeUnit.MILLISECONDS);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean fury(List<String> perks, Player p)
	{
		if (perks.contains("FURY:1") || perks.contains("FURY:2")
				|| perks.contains("FURY:3") || perks.contains("FURY:4")
				|| perks.contains("ALL")) {
			if (perks.contains("FURY:1")) {
				PotionEffect pe = new PotionEffect(
						PotionEffectType.INCREASE_DAMAGE, 60, 0);
				p.addPotionEffect(pe);
				time = 3000;
			}
			if (perks.contains("FURY:2")) {
				PotionEffect pe = new PotionEffect(
						PotionEffectType.INCREASE_DAMAGE, 60, 1);
				p.addPotionEffect(pe);
				time = 3000;
			}
			if (perks.contains("FURY:3")) {
				PotionEffect pe = new PotionEffect(
						PotionEffectType.INCREASE_DAMAGE, 80, 1);
				p.addPotionEffect(pe);
				time = 4000;
			}
			if (perks.contains("FURY:4") || perks.contains("ALL")) {
				PotionEffect pe = new PotionEffect(
						PotionEffectType.INCREASE_DAMAGE, 100, 1);
				p.addPotionEffect(pe);
				time = 5000;
			}
			p.sendMessage(ChatColor.GRAY + "Your fury has been unleashed!");
			PerkThread perk = new PerkThread(p, time,
					"Your fury has faded!");
			stp.schedule(perk, time, TimeUnit.MILLISECONDS);
			return true;
		}
			return false;
	}
	public boolean sheild(List<String> perks, Player p)
	{
		if (perks.contains("SHEILD:1") || perks.contains("SHEILD:2")
				|| perks.contains("SHEILD:3") || perks.contains("SHEILD:4")
				|| perks.contains("ALL")) {
			if (perks.contains("SHEILD:1")) {
				PotionEffect pe = new PotionEffect(
						PotionEffectType.DAMAGE_RESISTANCE, 60, 0);
				p.addPotionEffect(pe);
				time = 3000;
			}
			if (perks.contains("SHEILD:2")) {
				PotionEffect pe = new PotionEffect(
						PotionEffectType.DAMAGE_RESISTANCE, 60, 1);
				p.addPotionEffect(pe);
				time = 3000;
			}
			if (perks.contains("SHEILD:3")) {
				PotionEffect pe = new PotionEffect(
						PotionEffectType.DAMAGE_RESISTANCE, 80, 1);
				p.addPotionEffect(pe);
				time = 4000;
			}
			if (perks.contains("SHEILD:4") || perks.contains("ALL")) {
				PotionEffect pe = new PotionEffect(
						PotionEffectType.DAMAGE_RESISTANCE, 100, 1);
				p.addPotionEffect(pe);
				time = 5000;
			}
			p.sendMessage(ChatColor.GRAY
					+ "You have activated your sheild!");
			PerkThread perk = new PerkThread(p, time,
					"Your sheild has been lowered!");
			stp.schedule(perk, time, TimeUnit.MILLISECONDS);
			return true;
		}
		return false;
	}
	public boolean sprint(List<String> perks, Player p)
	{
		if (perks.contains("SPRINT:1") || perks.contains("SPRINT:2")
				|| perks.contains("SPRINT:3") || perks.contains("SPRINT:4")
				|| perks.contains("ALL")) {
			if (perks.contains("SPRINT:1")) {
				PotionEffect pe = new PotionEffect(PotionEffectType.SPEED,
						60, 0);
				p.addPotionEffect(pe);
				time = 3000;
			}
			if (perks.contains("SPRINT:2")) {
				PotionEffect pe = new PotionEffect(PotionEffectType.SPEED,
						60, 1);
				p.addPotionEffect(pe);
				time = 3000;
			}
			if (perks.contains("SPRINT:3")) {
				PotionEffect pe = new PotionEffect(PotionEffectType.SPEED,
						80, 1);
				p.addPotionEffect(pe);
				time = 4000;
			}
			if (perks.contains("SPRINT:4") || perks.contains("ALL")) {
				PotionEffect pe = new PotionEffect(PotionEffectType.SPEED,
						100, 1);
				p.addPotionEffect(pe);
				time = 5000;
			}
			p.sendMessage(ChatColor.GRAY + "You have activated sprint!");
			PerkThread perk = new PerkThread(p, time,
					"Sprint has worn off!");
			stp.schedule(perk, time, TimeUnit.MILLISECONDS);
			return true;
		}
		return false;
	}
	public boolean regen(List<String> perks, Player p)
	{
		if (perks.contains("REGEN:1") || perks.contains("REGEN:2")
				|| perks.contains("REGEN:3") || perks.contains("REGEN:4")
				|| perks.contains("ALL")) {
			if (perks.contains("REGEN:1")) {
				PotionEffect pe = new PotionEffect(
						PotionEffectType.REGENERATION, 100, 0);
				p.addPotionEffect(pe);
				time = 5000;
			}
			if (perks.contains("REGEN:2")) {
				PotionEffect pe = new PotionEffect(
						PotionEffectType.REGENERATION, 150, 0);
				p.addPotionEffect(pe);
				time = 7500;
			}
			if (perks.contains("REGEN:3")) {
				PotionEffect pe = new PotionEffect(
						PotionEffectType.REGENERATION, 100, 1);
				p.addPotionEffect(pe);
				time = 5000;
			}
			if (perks.contains("REGEN:4") || perks.contains("ALL")) {
				PotionEffect pe = new PotionEffect(
						PotionEffectType.REGENERATION, 150, 1);
				p.addPotionEffect(pe);
				time = 7500;
			}
			p.sendMessage(ChatColor.GRAY + "You have begun to gain health!");
			PerkThread perk = new PerkThread(p, time,
					"You have stopped gaining health!");
			stp.schedule(perk, time, TimeUnit.MILLISECONDS);
			return true;
		}
		return false;
	}
}
