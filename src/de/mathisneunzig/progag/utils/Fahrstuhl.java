package de.mathisneunzig.progag.utils;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;

import de.mathisneunzig.progag.Main;

public class Fahrstuhl implements Listener, CommandExecutor {
	
	private Main pl;
	
	public Fahrstuhl(Main pl) {
		
		this.pl = pl;
		
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(cmd.getName().equalsIgnoreCase("elevator")) {
			
			if(args.length == 2 && args[0].equalsIgnoreCase("-p")) {
				
				Player p = Bukkit.getPlayer(args[1]);
				p.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 15, 5));
				startElevator();
				
			}
			
		}
		
		return false;
		
	}
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		
		Player p = e.getPlayer();
		
		if(isInRegion(p, "elevator_top")) {
			
			endElevator();
			
			p.getActivePotionEffects().clear();
			
			Bukkit.getScheduler().scheduleSyncDelayedTask(pl, new Runnable() {
				
				@Override
		        public void run() {

						openDoor();
					
				}
				
			}, 30L);
			
		} else if(isInRegion(p, "elevator_out")) {
			
			resetElevator();
			
		}
		
	}
	
	public void resetElevator() {
		
		
		
	}
	
	public void startElevator() {
		
		
		
	}
	
	public void endElevator() {
		
		
		
	}
	
	public void openDoor() {
		
		
		
	}
	
	public boolean isInRegion(Player p, String region) {
		
		Plugin worldguard = Bukkit.getServer().getPluginManager().getPlugin("WorldGuard");
		
		WorldGuardPlugin wg = (WorldGuardPlugin) worldguard;
		World world = p.getLocation().getWorld();
		RegionManager rgm = wg.getRegionManager(world);
		ApplicableRegionSet set = rgm.getApplicableRegions(p.getLocation());
		for(ProtectedRegion rg : set) {
			
			if(rg.getId().startsWith(region))
				return true;
			
		}
		
		return false;
		
	}
	
}
