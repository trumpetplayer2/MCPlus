package me.trumpetplayer2.Java.MCPlus.Debug;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class TellConsole {
	public TellConsole() {
		
	}
	
	public TellConsole(String text) {
		Bukkit.getConsoleSender().sendMessage("[" + ChatColor.BLUE + "Minecraft" + ChatColor.AQUA + " Plus" + ChatColor.DARK_AQUA + " Debug" + ChatColor.RESET + "]" + text);
	}
	
	public void debug(String text) {
		Bukkit.getConsoleSender().sendMessage("[" + ChatColor.BLUE + "Minecraft" + ChatColor.AQUA + " Plus" + ChatColor.DARK_AQUA + " Debug" + ChatColor.RESET + "]" + text);
	}
}
