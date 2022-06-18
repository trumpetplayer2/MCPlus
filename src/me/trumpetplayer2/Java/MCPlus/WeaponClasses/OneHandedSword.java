package me.trumpetplayer2.Java.MCPlus.WeaponClasses;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class OneHandedSword extends WeaponClass{
    private static String id = "One Handed Sword";
	
	//Initialization
	public OneHandedSword() {
		super(new ItemStack(Material.IRON_SWORD), new ItemStack(Material.IRON_SWORD).getItemMeta(), id);
		super.setItemName(ChatColor.GRAY + "Default " + id);
	}
	
	public OneHandedSword(ItemStack i) {
		super(i, i.getItemMeta(), id);
	}
	
	public OneHandedSword(ItemStack i, ItemMeta m) {
		super(i, m, id);
	}
	
	public OneHandedSword(ItemStack i, String name) {
		super(i, i.getItemMeta(), name);
	}
	
	public void updateItemMeta(ItemMeta m) {
		super.updateItemMeta(m, id);
	}
}
