package de.mathisneunzig.progag.home;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import de.mathisneunzig.progag.Main;

public class Home {
	
	private Main pl;
	
	public File file;
	public YamlConfiguration homes;
	
	private String name;
	
	public Home(Player p, String name, Main pl) {
		
		this.pl = pl;
		
		File file = new File(pl.getDataFolder()+"/homes.yml");
		
		if(!(file.exists())) {
			
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		homes = YamlConfiguration.loadConfiguration(file);
		
		
		
	}
	
	public Location getLocation() {
		
		Location loc;
		
		return loc;
		
	}
	
}
