package de.mathisneunzig.progag.economy;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EconomyCommands {
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(cmd.getName().equalsIgnoreCase("money")) {
			
			if(sender instanceof Player) {
				
				Player p = (Player) sender;
				Account a = new Account(p);
				
				if(p.hasPermission("progAG.money.normal")) {
					
					if(args.length == 0) {
						
						p.sendMessage(ChatColor.GREEN+"["+ChatColor.WHITE+"Money"+ChatColor.GREEN+"] Du hast noch "+a.getBalance()+" progCoins");
						
					} if(args.length == 3 && args[0].equalsIgnoreCase("pay")) {
						
						Player t = Bukkit.getPlayer(args[1]);
						double amount = Double.parseDouble(args[2]);
						
						p.sendMessage(ChatColor.GREEN+"["+ChatColor.WHITE+"Money"+ChatColor.GREEN+"] Du hast noch "+a.getBalance()+" progCoins");
						
					}
					
				}
				
			}
			
		}
		
		return false;
		
	}
	
}
