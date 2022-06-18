package me.trumpetplayer2.Java.MCPlus.Listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import me.trumpetplayer2.Java.MCPlus.Items.Coin;
import me.trumpetplayer2.Java.MCPlus.Items.EXPBottle;
import me.trumpetplayer2.Java.MCPlus.Items.IronHeartTotem;

public class CraftingEventListener implements Listener{
	@EventHandler
	public void prepCraft(PrepareItemCraftEvent e) {	
		expBottleCraft(e);
		ihtCraft(e);
	}
	
	public void ihtCraft(PrepareItemCraftEvent e) {
		ItemStack iht = new IronHeartTotem();
		ItemStack coin = new Coin();
		ItemStack air = new ItemStack(Material.AIR);
		
		if(!(e.getRecipe() instanceof ShapedRecipe)) {return;}
		ShapedRecipe crafted = (ShapedRecipe) e.getRecipe();
		if(crafted.getResult().equals(iht)) {
			Inventory i = e.getInventory();
			for(int a = 1; a< 10; a++) {
				if(!(a == 5 || a%2 == 0)) {
					if(!i.getItem(a).getItemMeta().equals(coin.getItemMeta())) {
						e.getInventory().setResult(air);
						return;
					}
				}
				if(a == 5) {
					if(i.getItem(a).getItemMeta().getLore() != null) {
						e.getInventory().setResult(air);
						return;
					}
				}
			}
		}
	}
	
	public void expBottleCraft(PrepareItemCraftEvent e) {
		ItemStack expBottle = new EXPBottle();
		ItemStack coin = new Coin();
		ItemStack air = new ItemStack(Material.AIR);
		
		if(!(e.getRecipe() instanceof ShapedRecipe)) {return;}
		ShapedRecipe crafted = (ShapedRecipe) e.getRecipe();
		if(crafted.getResult().equals(expBottle)) {
			Inventory i = e.getInventory();
			for(int a = 1; a< 10; a++) {
				if(a != 5) {
					if(!i.getItem(a).getItemMeta().equals(coin.getItemMeta())) {
						e.getInventory().setResult(air);
						return;
					}
				}
			}
		}
	}
}
