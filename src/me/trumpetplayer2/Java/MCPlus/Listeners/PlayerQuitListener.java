package me.trumpetplayer2.Java.MCPlus.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import me.trumpetplayer2.Java.MCPlus.Main;

public class PlayerQuitListener implements Listener{
    private Main plugin;
    public PlayerQuitListener(Main mPlugin) {
	plugin = mPlugin;
    }
    @EventHandler
    public void playerLeave(PlayerQuitEvent e) {
	Player p = e.getPlayer();
	p.getInventory().setContents(plugin.invStorage.RestoreInv(p).getContents());
	p.updateInventory();
    }
}
