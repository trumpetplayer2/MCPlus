package me.trumpetplayer2.Java.MCPlus.Items.Instruments;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class Playable{
    Location loc;
    Sound instrument;
    int octave = 1;
    int natural = 1;
    public Playable(){
	instrument = Sound.BLOCK_NOTE_BLOCK_BELL;
    }
    
    public Playable(Sound s){
	instrument = s;
    }
    
    public Playable(String s){
	instrument = InstrumentFromString(s);
    }
    
    public void setInstrument(Sound s) {
	instrument = s;
    }
    
    public void setInstrument(String s) {
   	instrument = InstrumentFromString(s);
       }
    
    public Sound getInstrument() {
	return instrument;
    }
    
    public int getOctave() {
	return octave;
    }
    
    public Inventory createInventory() {
	return createInventory(Material.LIME_STAINED_GLASS_PANE, Material.CYAN_STAINED_GLASS_PANE, Material.BLUE_STAINED_GLASS_PANE);
    }
    
    public Inventory createInventory(Material m, Material u, Material d) {
	Inventory i = Bukkit.createInventory(null, InventoryType.PLAYER);
	//Create items
	ItemStack B = new ItemStack(m);
	ItemStack C = new ItemStack(m);
	ItemStack D = new ItemStack(m);
	ItemStack E = new ItemStack(m);
	ItemStack F = new ItemStack(m);
	ItemStack G = new ItemStack(m);
	ItemStack A = new ItemStack(m);
	ItemStack up = new ItemStack(u);
	ItemStack down = new ItemStack(d);
	ItemStack none = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
	//Assign items to inv
	none.setItemMeta(setDisplayName(none, ChatColor.WHITE + " "));
	down.setItemMeta(setDisplayName(down, "Down Half Step"));
	up.setItemMeta(setDisplayName(up, "Up Half Step"));
	
	
	if(natural == 1) {
	    B.setItemMeta(setDisplayName(B, "B"));
	    C.setItemMeta(setDisplayName(C, "C"));
	    D.setItemMeta(setDisplayName(D, "D"));
	    E.setItemMeta(setDisplayName(E, "E"));
	    F.setItemMeta(setDisplayName(F, "F"));
	    G.setItemMeta(setDisplayName(G, "G"));
	    A.setItemMeta(setDisplayName(A, "A"));
	    
	    i.setItem(0, B);
	    i.setItem(1, C);
	    i.setItem(2, D);
	    i.setItem(3, E);
	    i.setItem(4, F);
	    i.setItem(5, G);
	    i.setItem(6, A);
	    i.setItem(7, up);
	    i.setItem(8, down);
	}else {
	    B.setItemMeta(setDisplayName(B, "Bb"));
	    C.setItemMeta(setDisplayName(C, "C#"));
	    E.setItemMeta(setDisplayName(E, "Eb"));
	    F.setItemMeta(setDisplayName(F, "F#"));
	    G.setItemMeta(setDisplayName(G, "G#"));
	    
	    i.setItem(0, B);
	    i.setItem(1, none);
	    i.setItem(2, C);
	    i.setItem(3, E);
	    i.setItem(4, none);
	    i.setItem(5, F);
	    i.setItem(6, G);
	    i.setItem(7, up);
	    i.setItem(8, down);
	}
	for(int temp = 9; temp < 36; temp++) {
	    i.setItem(temp, none);
	}
	
	
	return i;
    }
    
    public ItemMeta setDisplayName(ItemStack i, String name) {
	ItemMeta m = i.getItemMeta();
	m.setDisplayName(name);
	return(m);
    }
    
    public int getNatural() {
	return natural;
    }
    
    public Sound InstrumentFromString(String s) {
	Sound temp;
	switch(s.toLowerCase()) {
	case "basedrum" : temp = Sound.BLOCK_NOTE_BLOCK_BASEDRUM;
		break;
	case "banjo" : temp = Sound.BLOCK_NOTE_BLOCK_BANJO;
		break;
	case "bass" : temp = Sound.BLOCK_NOTE_BLOCK_BASS;
		break;
	case "bell" : temp = Sound.BLOCK_NOTE_BLOCK_BELL;
		break;
	case "bit" : temp = Sound.BLOCK_NOTE_BLOCK_BIT;
		break;
	case "chime" : temp = Sound.BLOCK_NOTE_BLOCK_CHIME;
		break;
	case "cowbell" : temp = Sound.BLOCK_NOTE_BLOCK_COW_BELL;
		break;
	case "didgeridoo" : temp = Sound.BLOCK_NOTE_BLOCK_DIDGERIDOO;
		break;
	case "flute" : temp = Sound.BLOCK_NOTE_BLOCK_FLUTE;
		break;
	case "guitar" : temp = Sound.BLOCK_NOTE_BLOCK_GUITAR;
		break;
	case "harp" : temp = Sound.BLOCK_NOTE_BLOCK_HARP;
		break;
	case "hat" : temp = Sound.BLOCK_NOTE_BLOCK_HAT;
		break;
	case "ironxylo" : temp = Sound.BLOCK_NOTE_BLOCK_IRON_XYLOPHONE;
		break;
	case "ironxylophone" : temp = Sound.BLOCK_NOTE_BLOCK_IRON_XYLOPHONE;
		break;
	case "pling" : temp = Sound.BLOCK_NOTE_BLOCK_PLING;
		break;
	case "snare" : temp = Sound.BLOCK_NOTE_BLOCK_SNARE;
		break;
	case "drum" : temp = Sound.BLOCK_NOTE_BLOCK_SNARE;
		break;
	case "xylo" : temp = Sound.BLOCK_NOTE_BLOCK_XYLOPHONE;
		break;
	case "xylophone" : temp = Sound.BLOCK_NOTE_BLOCK_XYLOPHONE;
		break;
	case "trumpet" : temp = Sound.EVENT_RAID_HORN;
		break;
	case "amethyst" : temp = Sound.BLOCK_AMETHYST_BLOCK_HIT;
		break;
	case "ghast" : temp = Sound.ENTITY_GHAST_SCREAM;
		break;
	case "meow" : temp = Sound.ENTITY_CAT_AMBIENT;
		break;
	
	default : temp = Sound.BLOCK_NOTE_BLOCK_BELL;
		break;
	}
	return temp;
    }
    
    public void octaveChange(boolean up) {
	if(up) {
	    if(natural >= 2) {
		natural = 1;
		octave += 1;
		if(octave > 3) {
		    octave = 3;
		}
	    }else {
		natural += 1;
	    }
	}
	if(!up) {
	    if(natural <= 0) {
		natural = 1;
		octave -=1;
		if(octave < 1) {
		    octave = 1;
		}
	    }else {
		natural -= 1;
	    }
	}
    }
}
