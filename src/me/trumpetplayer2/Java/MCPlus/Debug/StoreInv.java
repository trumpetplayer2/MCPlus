package me.trumpetplayer2.Java.MCPlus.Debug;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

import me.trumpetplayer2.Java.MCPlus.Items.Instruments.Playable;

public class StoreInv {
    private HashMap<String, Inventory> inventories = new HashMap<String, Inventory>();
    private HashMap<String, Playable> instruments = new HashMap<String, Playable>();
    
    public StoreInv() {}
    public void AddInv(Player p) {AddInv(p.getUniqueId().toString());}
    public void setInstrument(Player p, Playable instrument) {setInstrument(p.getUniqueId().toString(), instrument);}
    public StoreInv(Player p) {this(p.getUniqueId().toString());}
    public Inventory RestoreInv(Player p) {return RestoreInv(p.getUniqueId().toString());}
    public StoreInv(String uuid) {AddInv(uuid);}
    public boolean getInvStored(Player p) {return getInvStored(p.getUniqueId().toString());}
    public boolean checkInstrument(Player p) {return checkInstrument(p.getUniqueId().toString());}
    
    public boolean getInvStored(String uuid) {
	return inventories.containsKey(uuid);
    }
    
    public Inventory RestoreInv(String uuid) {
	if(!inventories.containsKey(uuid)) {
	    return(Bukkit.getPlayer(UUID.fromString(uuid)).getInventory());
	}else {
	    Inventory temp = inventories.get(uuid);
	    inventories.remove(uuid);
	    return(temp);
	}
    }
    
    public void restoreAllInv() {
	for(Map.Entry<String, Inventory> entry : inventories.entrySet()) {
	    Player p = Bukkit.getPlayer(UUID.fromString(entry.getKey()));
	    p.getInventory().setContents(RestoreInv(entry.getKey()).getContents());
	    p.updateInventory();
	}
    }
    
    public void AddInv(String uuid) {
	Inventory i = Bukkit.createInventory(null, InventoryType.PLAYER);
	i.setContents(Bukkit.getPlayer(UUID.fromString(uuid)).getInventory().getContents());
	inventories.put(uuid, i);
    }
    
    public void setInstrument(String uuid, Playable instrument) {
	instruments.put(uuid, instrument);
    }
    
    public Playable getInstrument(String uuid) {
	if(!instruments.containsKey(uuid)) {
	    Playable tempInstrument = new Playable();
	    return(tempInstrument);
	}else {
	    return(instruments.get(uuid));
	}
    }
    
    public boolean checkInstrument(String uuid) {
	return instruments.containsKey(uuid);
    }
    
}
