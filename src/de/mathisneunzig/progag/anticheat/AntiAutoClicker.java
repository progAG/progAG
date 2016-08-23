package de.mathisneunzig.progag.anticheat;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffectType;

import de.mathisneunzig.progag.Main;

public class AntiAutoClicker implements Listener {
	
	
	private Main pl;
	
	public AntiAutoClicker(Main pl) {
		
		this.pl = pl;
	}
	
	private int count;
	
	
	@EventHandler
	public void onAutoClicker(PlayerInteractEvent e) {
		
		Player p = e.getPlayer();
		
		if(p.hasPotionEffect(PotionEffectType.FAST_DIGGING)) {
			
			
			
		} else {
			
			count++;
			
		}
		
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		
		final Player p = e.getPlayer();
		
		@SuppressWarnings("deprecation")
		int click = pl.getServer().getScheduler().scheduleAsyncRepeatingTask(pl, new Runnable() {

			public void run() {
				
				if(count >= 24) {
					
					pl.getReportManager().reportPlayerByConsole(ChatColor.RED + "Der Spieler "+p.getDisplayName()+" klickt zu schnell." + "["+count+" C/s]");
					
				}
				
				count = 0;
			
			}
			
		}, 0L, 20L);
		
	}
	
}
