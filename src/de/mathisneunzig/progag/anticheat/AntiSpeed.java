package de.mathisneunzig.progag.anticheat;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffectType;

import de.mathisneunzig.progag.Main;

public class AntiSpeed implements Listener {
	
private Main pl;
	
	public AntiSpeed(Main pl) {
		
		this.pl = pl;
	}
	
	private int count;
	private int oldX, newX, oldZ, newZ;
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onSpeed(PlayerMoveEvent e) {
		
		final Player p = e.getPlayer();
		
		if(p.hasPermission("progag.speed")) {
			
			
			
		} else {
			
			if(p.hasPotionEffect(PotionEffectType.SPEED)) {
				
			} else {
				
				oldX = p.getLocation().getBlockX();
				oldZ = p.getLocation().getBlockZ();
				
				int speed = pl.getServer().getScheduler().scheduleAsyncRepeatingTask(pl, new Runnable() {

					public void run() {
						
						newX = p.getLocation().getBlockX();
						newZ = p.getLocation().getBlockZ();
						
						if((newX - oldX > 10 || newX - oldX < -10) || (newZ - oldZ > 10 || newZ - oldZ < -10)) {

							pl.getReportManager().reportPlayerByConsole(ChatColor.RED + "Der Spieler "+p.getDisplayName()+" sprintet zu schnell!" + ChatColor.YELLOW + " [SpeedVerdacht]");
							
						}
						
						oldX = p.getLocation().getBlockX();
						oldZ = p.getLocation().getBlockZ();
					
					}
					
				}, 20L, 20L);
					
			}
				
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
