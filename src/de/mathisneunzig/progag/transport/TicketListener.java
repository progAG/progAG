package de.mathisneunzig.progag.transport;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

import de.mathisneunzig.progag.Main;

public class TicketListener implements Listener {
	
	private Main pl;
	public File ticketfile;
	public YamlConfiguration tickets;
	
	private Inventory verkauf = null;
	
	public TicketListener(Main pl) {
		
		this.pl = pl;
		
		if(ticketfile.exists()) {
			
			ticketfile = new File(pl.getDataFolder(), "tickets.yml");
			tickets = YamlConfiguration.loadConfiguration(ticketfile);
			
		}
		
	}
	
	public void sellTicket(Player p, Ticket t, int price) {
		
		if(pl.economyManager.getAccount(p.getUniqueId().toString()).substractMoney(t.getType().getPrice())) {
			
			
			
		}
		
	}
	
	@EventHandler
	public void onSignChange(SignChangeEvent e) {
		
		
		
	}
	
	@EventHandler
	public void onSignClick(PlayerInteractEvent e) {
		
		Player p = e.getPlayer();
		Block block = e.getClickedBlock();
		
		if(e.getAction() == Action.RIGHT_CLICK_BLOCK && block.getType() == Material.WALL_SIGN) {
			
			Sign sign = (Sign)block.getState();
			
			if(sign.getLine(0).equalsIgnoreCase("§b[Fahrkarten]")) {
				
				verkauf = Bukkit.createInventory(null, 9, "Fahrkarten");
				
			}
			
		}
		
	}
	
	public void onInventoryClick(InventoryClickEvent e) {
		
		Inventory i = e.getInventory();
		
		if(i.getName().startsWith("Ticket")) {
			
			
			
		}
		
	}
	
}
