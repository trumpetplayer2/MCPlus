package me.trumpetplayer2.Java.MCPlus.WeaponClasses;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.trumpetplayer2.Java.MCPlus.Debug.TellConsole;

public class WeaponClass extends ItemStack{
	
	TellConsole debug = new TellConsole();
	
	public WeaponClass(ItemStack i, ItemMeta m, String id) {
		super(i);
		List<String> itemLore;
		if(m.getLore() != null) {
		itemLore = m.getLore();
		}else {
			itemLore = new ArrayList<String>();
		}
		if(itemLore.size() > 0) {
			String temp = itemLore.get(0).substring(0,11);
		if(temp.equals(ChatColor.GOLD + "Item Type")) {
			//Item already has a class, overwrite it
			itemLore.remove(0);
		}
		}
		itemLore.add(0, ChatColor.GOLD + "Item Type: " + ChatColor.BLUE + id);
		m.setLore(itemLore);
		super.setItemMeta(m);
	}
	
	public WeaponClass(WeaponClass self) {
	    super(self);
	}
	
	//Updates
	public void updateItemMeta(ItemMeta m, String id) {
	    updateItemMeta(m, id, false);
	}
	
		public void updateItemMeta(ItemMeta m, String id, boolean Skill) {
		    if(!Skill) {
			List<String> itemLore;
			if(m.getLore() != null) {
			itemLore = m.getLore();
			}else {
				itemLore = new ArrayList<String>();
			}
			if(itemLore.size() > 0) {
				String temp = itemLore.get(0).substring(0,11);
			if(temp.equals(ChatColor.GOLD + "Item Type")) {
				//Item already has a class, overwrite it
				itemLore.remove(0);
			}
			}
				itemLore.add(0, ChatColor.GOLD + "Item Type: " + ChatColor.BLUE + id);
			super.setItemMeta(m);
		    }
		    if(Skill) {
			List<String> itemLore;
			if(m.getLore() != null) {
			itemLore = m.getLore();
			}else {
				itemLore = new ArrayList<String>();
			}
			if(itemLore.size() > 1) {
				String temp = itemLore.get(0).substring(0,7);
			if(temp.equals(ChatColor.GOLD + "Skill")) {
				//Item already has a class, overwrite it
				itemLore.remove(1);
			}
			}
				itemLore.add(1, ChatColor.GOLD + "Item Type: " + ChatColor.BLUE + id);
			super.setItemMeta(m);
		    }
		}
		
		public void setItemName(String Name) {
			ItemMeta m = super.getItemMeta();
			m.setDisplayName(Name);
			super.setItemMeta(m);
		}
}
