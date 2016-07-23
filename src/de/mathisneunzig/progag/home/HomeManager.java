package de.mathisneunzig.progag.home;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import de.mathisneunzig.progag.Main;

public class HomeManager {
	
	private Main pl;
	
	public File file;
	public YamlConfiguration homes;
	
	public HomeManager(Main pl) {
		
		this.pl = pl;
		
	}
	
	public void createHome(Player p, String name) {
		
		new Home(p, name, pl);
		saveHomes();
		
	}
	
	public void removeHome(Player p, String name) {
		
		
		
	}
	
	public Home getHome(Player p, String name) {
		
		return new Home(p, name, pl);
		
	}
	
	public ArrayList<Home> getHomes(Player p) {
		
		return null;
		
	}
	
	public int getHomeCount(Player p) {
		
		return 0;
		
	}
	
	public int getMaxHomeCount(Player p) {
		
		return homes.getInt("");
		
	}
	
	public void saveHomes() {
		
		try {
			homes.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
