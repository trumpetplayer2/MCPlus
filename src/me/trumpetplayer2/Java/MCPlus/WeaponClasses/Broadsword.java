package me.trumpetplayer2.Java.MCPlus.WeaponClasses;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Broadsword extends WeaponClass{
    private static String id = "Broadsword";
	
	//Initialization
	public Broadsword() {
		super(new ItemStack(Material.IRON_SWORD), new ItemStack(Material.IRON_SWORD).getItemMeta(), id);
		super.setItemName(ChatColor.GRAY + "Default " + id);
	}
	
	public Broadsword(ItemStack i) {
		super(i, i.getItemMeta(), id);
	}
	
	public Broadsword(ItemStack i, ItemMeta m) {
		super(i, m, id);
	}
	
	public Broadsword(ItemStack i, String name) {
		super(i, i.getItemMeta(), name);
	}
	
	public void updateItemMeta(ItemMeta m) {
		super.updateItemMeta(m, id);
	}
}
