package me.trumpetplayer2.Java.MCPlus;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

import me.trumpetplayer2.Java.MCPlus.Items.EXPBottle;
import me.trumpetplayer2.Java.MCPlus.Items.IronHeartTotem;

public class Recipes {
	public static void registerNewRecipe(JavaPlugin main) {
		registerEXPBottle(main);
		registerIronHeartTotem(main);
	}
	
	private static void registerIronHeartTotem(JavaPlugin main) {
		ItemStack iht = new IronHeartTotem();
		
		NamespacedKey key = new NamespacedKey(main, "ihtRecipe");
		ShapedRecipe recipe = new ShapedRecipe(key, iht);
		
		recipe.shape("CIC", "ITI", "CIC");
		
		recipe.setIngredient('C', Material.GOLD_NUGGET);
		recipe.setIngredient('T', Material.TOTEM_OF_UNDYING);
		recipe.setIngredient('I', Material.IRON_INGOT);
		
		Bukkit.addRecipe(recipe);
	}
	
	private static void registerEXPBottle(JavaPlugin main) {
		ItemStack expBottle = new EXPBottle();
		
		NamespacedKey key = new NamespacedKey(main, "expBottleR");
		ShapedRecipe recipe = new ShapedRecipe(key, expBottle);
		
		recipe.shape("CCC", "CBC", "CCC");
		
		recipe.setIngredient('C', Material.GOLD_NUGGET);
		recipe.setIngredient('B', Material.GLASS_BOTTLE);
		
		Bukkit.addRecipe(recipe);
	}
}
