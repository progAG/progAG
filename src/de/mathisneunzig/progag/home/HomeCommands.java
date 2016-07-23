package de.mathisneunzig.progag.home;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class HomeCommands implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(cmd.getName().equalsIgnoreCase("home")) {
			
			if(args.length == 0) {
				
				
				
			}
			
		}
		
		return false;
		
	}
	
}
