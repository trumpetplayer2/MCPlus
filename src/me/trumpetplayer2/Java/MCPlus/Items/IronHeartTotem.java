package me.trumpetplayer2.Java.MCPlus.Items;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class IronHeartTotem extends ItemStack{
	
	private ItemMeta meta;
	
	public IronHeartTotem(){
		super(Material.TOTEM_OF_UNDYING);
		meta = super.getItemMeta();
		meta.setDisplayName(ChatColor.GRAY + "" + ChatColor.ITALIC + "" + ChatColor.BOLD + "Iron Heart Totem");
		List<String> itemLore = new ArrayList<String>();
		itemLore.add(ChatColor.DARK_AQUA + "This Totem Radiates Pure Resistance");
		itemLore.add(ChatColor.DARK_AQUA + "Though quite low durability");
		itemLore.add(ChatColor.DARK_AQUA + "It has an impecible defense");
		meta.setLore(itemLore);
		super.setItemMeta(meta);
	}
	
	public IronHeartTotem(int count){
		super(Material.TOTEM_OF_UNDYING, count);
		meta = super.getItemMeta();
		meta.setDisplayName(ChatColor.GRAY + "" + ChatColor.ITALIC + "" + ChatColor.BOLD + "Iron Heart Totem");
		List<String> itemLore = new ArrayList<String>();
		itemLore.add(ChatColor.DARK_AQUA + "This Totem Radiates Pure Resistance");
		itemLore.add(ChatColor.DARK_AQUA + "Though quite low durability");
		itemLore.add(ChatColor.DARK_AQUA + "It has an impecible defense");
		meta.setLore(itemLore);
		super.setItemMeta(meta);
	}
	
	public ItemMeta getItemMeta() {return(meta);}
}
