package de.mathisneunzig.progag;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.mathisneunzig.progag.anticheat.AntiCheatListener;
import de.mathisneunzig.progag.anticheat.AntiCheatManager;
import de.mathisneunzig.progag.chestshop.ShopListener;
import de.mathisneunzig.progag.chestshop.ShopManager;
import de.mathisneunzig.progag.economy.EconomyListener;
import de.mathisneunzig.progag.economy.EconomyManager;
import de.mathisneunzig.progag.economy.TaxManager;
import de.mathisneunzig.progag.gsmanager.GSListener;
import de.mathisneunzig.progag.gsmanager.GSManager;
import de.mathisneunzig.progag.home.HomeManager;
import de.mathisneunzig.progag.mysql.MySQLManager;
import de.mathisneunzig.progag.politics.ElectionManager;
import de.mathisneunzig.progag.politics.PoliticsManager;
import de.mathisneunzig.progag.quests.QuestListener;
import de.mathisneunzig.progag.quests.QuestManager;
import de.mathisneunzig.progag.transport.TicketListener;
import de.mathisneunzig.progag.transport.TrainListener;
import de.mathisneunzig.progag.utils.UUIDManager;

public class Main extends JavaPlugin {
	
	public PluginManager pm = Bukkit.getPluginManager();
	
	public AntiCheatManager anticheatmanager;
	
	public ShopManager shopManager;
	
	public TaxManager taxManager;
	public EconomyManager economyManager;
	
	public GSManager gsManager;
	
	public HomeManager homeManager;
	
	public MySQLManager mysqlManager;
	
	public ElectionManager electionManager;
	public PoliticsManager politicsManager;
	
	public QuestManager questManager;
	
	public UUIDManager uuidManager;
	
	public void onEnable() {
		
		loadCommands();
		loadListener();
		
	}
	
	public void onDisable() {
		
		economyManager.saveAccounts();
		gsManager.saveProfiles();
		homeManager.saveHomes();
		
	}
	
	public void loadCommands() {
		
		
		
	}
	
	public void loadListener() {
		
		pm.registerEvents(new AntiCheatListener(), this);
		pm.registerEvents(new ShopListener(), this);
		pm.registerEvents(new EconomyListener(), this);
		pm.registerEvents(new GSListener(), this);
		pm.registerEvents(new QuestListener(), this);
		pm.registerEvents(new TicketListener(this), this);
		pm.registerEvents(new TrainListener(), this);
		
	}
	
	public AntiCheatManager getAntiCheatManager() {
		
		return anticheatmanager;
		
	}
	
	public ShopManager getShopManager() {
		
		return shopManager;
		
	}
	
	public EconomyManager getEconomyManager() {
		
		return economyManager;
		
	}
	
	public TaxManager getTaxManager() {
		
		return taxManager;
		
	}
	
	public GSManager getGSManager() {
		
		return gsManager;
		
	}
	
	public HomeManager getHomeManager() {
		
		return homeManager;
		
	}
	
	public MySQLManager getMySQLManager() {
		
		return mysqlManager;
		
	}
	
	public ElectionManager getElectionManager() {
		
		return electionManager;
		
	}
	
	public PoliticsManager getPoliticsManager() {
		
		
		return politicsManager;
		
	}
	
	public QuestManager getQuestManager() {
		
		return questManager;
		
	}
	
	public UUIDManager getUUIDManager() {
		
		return uuidManager;		
	}
	
}
