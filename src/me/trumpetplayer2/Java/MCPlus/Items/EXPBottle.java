package me.trumpetplayer2.Java.MCPlus.Items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class EXPBottle extends ItemStack{
	public EXPBottle() {
		super(Material.EXPERIENCE_BOTTLE);
		ItemMeta expMeta = super.getItemMeta();
		expMeta.setDisplayName(ChatColor.GOLD + "Experience Bottle");
		super.setItemMeta(expMeta);
	}
}
