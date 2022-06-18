package me.trumpetplayer2.Java.MCPlus.Items;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Coin extends ItemStack{
	
	private ItemMeta meta;
	
	public Coin() {
	super(Material.GOLD_NUGGET);
	meta = super.getItemMeta();
	meta.setDisplayName(ChatColor.GOLD + "Gold Coin");
	List<String> itemLore = new ArrayList<String>();
	itemLore.add(ChatColor.GOLD + "A Golden Coin");
	itemLore.add(ChatColor.GOLD + "from an Ancient Civilization");
	meta.setLore(itemLore);
	super.setItemMeta(meta);
	}
	
	public Coin(int count) {
		super(Material.GOLD_NUGGET, count);
		meta = super.getItemMeta();
		meta.setDisplayName(ChatColor.GOLD + "Gold Coin");
		List<String> itemLore = new ArrayList<String>();
		itemLore.add(ChatColor.GOLD + "A Golden Coin");
		itemLore.add(ChatColor.GOLD + "from an Ancient Civilization");
		meta.setLore(itemLore);
		super.setItemMeta(meta);
		}
	
	public ItemMeta getItemMeta() {return(meta);}
}
