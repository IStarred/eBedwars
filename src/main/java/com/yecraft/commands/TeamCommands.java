package com.yecraft.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.yecraft.commands.TeamSet;

import java.util.ArrayList;
import java.util.List;

public class TeamCommands implements CommandExecutor{

	public static List<SubCommand> COMMANDS = new ArrayList<>();

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player){
			Player player = (Player) sender;
			if (player.isOp()){
				COMMANDS.forEach(subCommand -> subCommand.init(args, player));
			}
		}
		return true;
	}
	
}