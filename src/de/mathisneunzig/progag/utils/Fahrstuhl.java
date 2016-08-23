package de.mathisneunzig.progag.utils;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;

public class Fahrstuhl {
	
	public void openElevator() {
		
		
		
	}
	
	public void closeElevator() {
		
		
		
	}
	
	public void openWall() {
		
		
		
	}
	
	public void closeWall() {
		
		
		
	}
	
	public boolean isReady(Player p) {
		
		Plugin worldguard = Bukkit.getServer().getPluginManager().getPlugin("WorldGuard");
		
		WorldGuardPlugin wg = (WorldGuardPlugin) worldguard;
		World world = p.getLocation().getWorld();
		RegionManager rgm = wg.getRegionManager(world);
		ApplicableRegionSet set = rgm.getApplicableRegions(p.getLocation());
		for(ProtectedRegion rg : set) {
			
			if(rg.getId().startsWith("elevator_1"))
				return true;
			
		}
		
		return false;
		
	}
	
}
