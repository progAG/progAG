package de.mathisneunzig.progag.anticheat;

import org.bukkit.plugin.PluginManager;

import de.mathisneunzig.progag.Main;

public class AntiCheatManager {
	
	private Main pl;
	
	public AntiCheatManager(Main pl) {
		
		this.pl = pl;
		
	}
	
	public void loadCheats(PluginManager pm) {
		
		//Hier alle AntiHacks Listener registrieren
		pm.registerEvents(new AntiFly(pl), pl);
		
	}
	
}
