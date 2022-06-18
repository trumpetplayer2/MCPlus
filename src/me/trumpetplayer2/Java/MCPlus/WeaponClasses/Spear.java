package me.trumpetplayer2.Java.MCPlus.WeaponClasses;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Spear extends WeaponClass{
    private static String id = "Spear";
	
	//Initialization
	public Spear() {
		super(new ItemStack(Material.TRIDENT), new ItemStack(Material.TRIDENT).getItemMeta(), id);
		super.setItemName(ChatColor.GRAY + "Default " + id);
	}
	
	public Spear(ItemStack i) {
		super(i, i.getItemMeta(), id);
	}
	
	public Spear(ItemStack i, ItemMeta m) {
		super(i, m, id);
	}
	
	public Spear(ItemStack i, String name) {
		super(i, i.getItemMeta(), name);
	}
	
	public void updateItemMeta(ItemMeta m) {
		super.updateItemMeta(m, id);
	}
}
