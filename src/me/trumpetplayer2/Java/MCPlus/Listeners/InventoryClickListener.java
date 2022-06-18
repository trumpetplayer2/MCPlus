package me.trumpetplayer2.Java.MCPlus.Listeners;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

import me.trumpetplayer2.Java.MCPlus.Main;
import me.trumpetplayer2.Java.MCPlus.Items.Instruments.Playable;

public class InventoryClickListener implements Listener{
    	private Main plugin;
    	public InventoryClickListener(Main mPlugin) {
    	    plugin = mPlugin;
    	}
	@EventHandler
	public void clickListener(InventoryClickEvent e) {
	    Player p = (Player) e.getWhoClicked();
	    ItemStack item = e.getCurrentItem();
	    //Music here
	    if(plugin.invStorage.getInvStored(p)) {
		e.setCancelled(true); 
		play(p, item);
		return;
		}
	    //Continued Below
	    
	}
	
	@EventHandler
	public void ItemDropListener(PlayerDropItemEvent e) {
	    Player p = (Player) e.getPlayer();
	    ItemStack item = e.getItemDrop().getItemStack();
	  //Music here
	    if(plugin.invStorage.getInvStored(p)) {
		e.setCancelled(true); 
		play(p, item);
		return;
		}
	    //Continued Below
	    
	}
	
	@EventHandler
	public void BlockPlaceListener(BlockPlaceEvent e) {
	    Player p = (Player) e.getPlayer();
	    ItemStack item = e.getItemInHand();
	  //Music here
	    if(plugin.invStorage.getInvStored(p)) {
		e.setCancelled(true); 
		play(p, item);
		return;
		}
	    //Continued Below
	    
	}
	
	public void play(Player p, ItemStack i) {
	    float pitch = 0f;
	    if(i.getItemMeta().getDisplayName() == null) {return;}
	    if(i.getItemMeta().getDisplayName().equalsIgnoreCase("Up Half Step")) {
		octaveChange(p.getUniqueId().toString(), true);
		return;
	    }else if(i.getItemMeta().getDisplayName().equalsIgnoreCase("Down Half Step")) {
		octaveChange(p.getUniqueId().toString(), false);
		return;
	    }
	    pitch = getPitchByName(p.getUniqueId().toString(), i.getItemMeta().getDisplayName());
	    p.getWorld().playSound(p.getLocation(), getInstrument(p.getUniqueId().toString()), 10, pitch);
	}
	
	public float getPitchByName(String uuid, String s) {
	    float temp = 0.1f;
	    switch(s) {
	    case "Bb" : temp = 0.62996f;
		break;
	    case "B" : temp = 0.66742f;
	    	break;
	    case "C" : temp = 0.70711f;
	    	break;
	    case "C#" : temp = 0.74915f;
	    	break;
	    case "D" : temp = 0.79370f;
	    	break;
	    case "Eb" : temp = 0.84090f;
	    	break;
	    case "E" : temp = 0.89090f;
	    	break;
	    case "F" : temp = 0.94387f;
	    	break;
	    case "F#" : temp = 1.0f;
	    	break;
	    case "G" : temp = 1.05946f;
	    	break;
	    case "G#" : temp = 1.12246f;
	    	break;
	    case "A" : temp = 1.18921f;
	    	break;
	    default : temp = 0.0f;
	    	break;
	    }
	    temp = temp * plugin.invStorage.getInstrument(uuid).getOctave();
	    return temp;
	}
	
	public void octaveChange(String uuid, boolean b) {
	    Player p = Bukkit.getPlayer(UUID.fromString(uuid));
	    Playable temp = plugin.invStorage.getInstrument(uuid);
	    temp.octaveChange(b);
	    plugin.invStorage.setInstrument(uuid, temp);
	    p.getInventory().setContents(plugin.invStorage.getInstrument(uuid).createInventory().getContents());
	    p.updateInventory();
	}
	
	public Sound getInstrument(String uuid) {
	    if(!plugin.invStorage.checkInstrument(uuid)) {return Sound.BLOCK_NOTE_BLOCK_BELL;}
	    else {
	    return plugin.invStorage.getInstrument(uuid).getInstrument();
	    }
	}
}
