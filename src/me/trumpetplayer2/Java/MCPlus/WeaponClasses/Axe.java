package me.trumpetplayer2.Java.MCPlus.WeaponClasses;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Axe extends WeaponClass{
	
	private static String id = "Axe";
	
	//Initialization
	public Axe() {
		super(new ItemStack(Material.IRON_AXE), new ItemStack(Material.IRON_AXE).getItemMeta(), id);
		super.setItemName(ChatColor.GRAY + "Default " + id);
	}
	
	public Axe(ItemStack i) {
		super(i, i.getItemMeta(), id);
	}
	
	public Axe(ItemStack i, ItemMeta m) {
		super(i, m, id);
	}
	
	public Axe(ItemStack i, String name) {
		super(i, i.getItemMeta(), name);
	}
	
	public void updateItemMeta(ItemMeta m) {
		super.updateItemMeta(m, id);
	}
	
}
