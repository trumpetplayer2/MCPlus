package me.trumpetplayer2.Java.MCPlus.WeaponClasses;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Dagger extends WeaponClass{
	//Initialization
    private static String id = "Dagger";
	
	//Initialization
	public Dagger() {
		super(new ItemStack(Material.IRON_SWORD), new ItemStack(Material.IRON_SWORD).getItemMeta(), id);
		super.setItemName(ChatColor.GRAY + "Default " + id);
	}
	
	public Dagger(ItemStack i) {
		super(i, i.getItemMeta(), id);
	}
	
	public Dagger(ItemStack i, ItemMeta m) {
		super(i, m, id);
	}
	
	public Dagger(ItemStack i, String name) {
		super(i, i.getItemMeta(), name);
	}
	
	public void updateItemMeta(ItemMeta m) {
		super.updateItemMeta(m, id);
	}
}
