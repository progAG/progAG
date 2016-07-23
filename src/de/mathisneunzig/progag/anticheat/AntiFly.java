package de.mathisneunzig.progag.anticheat;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffectType;

import de.mathisneunzig.progag.Main;

public class AntiFly implements Listener {
	
	private Main pl;
	
	public AntiFly(Main pl) {
		
		this.pl = pl;
		
	}
	
	private int count;
	private int oldY, newY;
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onFly(PlayerMoveEvent e) {
		
		final Player p = e.getPlayer();
		
		if(p.hasPermission("progag.fly")) {
			
			//alles gut
			
		} else {
			
			if(p.hasPotionEffect(PotionEffectType.JUMP)) {
				
			} else {
				
				if(p.isFlying()) {
					
					pl.getReportManager().reportPlayerByConsole(ChatColor.RED + "Der Spieler "+p.getDisplayName()+" fliegt.");
					
				} else {
					
					int fly = pl.getServer().getScheduler().scheduleAsyncRepeatingTask(pl, new Runnable() {

						public void run() {
							
							if(p.getLocation().subtract(0, 2, 0).getBlock().getType() == Material.AIR) {
								
								count++;
								
							} else {
								
								count = 0;
								oldY = p.getLocation().getBlockY();
								
							}
							
							if(count > 15) {
								
								newY = p.getLocation().getBlockY();
								
								if(oldY < newY) {

									pl.getReportManager().reportPlayerByConsole(ChatColor.RED + "Der Spieler "+p.getDisplayName()+" fliegt." + "[Ping: "+pl.getPingManager().getPing(p)+" ms]");
									count = 0;
									
								}
								
							}
						
						}
						
					}, 0L, 5L);
					
				}
				
			}
			
		}
		
	}
	
}
