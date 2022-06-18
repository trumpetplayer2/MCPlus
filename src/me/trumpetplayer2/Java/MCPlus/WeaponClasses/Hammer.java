package me.trumpetplayer2.Java.MCPlus.WeaponClasses;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Hammer extends WeaponClass{
    private static String id = "Hammer";
	
	//Initialization
	public Hammer() {
		super(new ItemStack(Material.IRON_AXE), new ItemStack(Material.IRON_AXE).getItemMeta(), id);
		super.setItemName(ChatColor.GRAY + "Default " + id);
	}
	
	public Hammer(ItemStack i) {
		super(i, i.getItemMeta(), id);
	}
	
	public Hammer(ItemStack i, ItemMeta m) {
		super(i, m, id);
	}
	
	public Hammer(ItemStack i, String name) {
		super(i, i.getItemMeta(), name);
	}
	
	public void updateItemMeta(ItemMeta m) {
		super.updateItemMeta(m, id);
	}
}
