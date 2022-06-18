package me.trumpetplayer2.Java.MCPlus.Listeners;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityResurrectEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

import me.trumpetplayer2.Java.MCPlus.Main;
import me.trumpetplayer2.Java.MCPlus.Items.IronHeartTotem;

public class TotemUseListener implements Listener{
	public Main plugin;
	
	HashMap<String, Integer> inUse = new HashMap<String, Integer>();
	HashMap<String, double[]> baseStatMap = new HashMap<String, double[]>();
	
	public TotemUseListener(Main mPlugin) {
		plugin = mPlugin;
	}
	
	@EventHandler
	public void useTotemEvent(EntityResurrectEvent e) {
		ItemStack totem = new ItemStack(Material.AIR);
		String hand = "";
		
		if(!(e.getEntity() instanceof Player)) {return;}
		Player p = (Player) e.getEntity();
		if(p.getInventory().getItemInMainHand().getType() == null && p.getInventory().getItemInOffHand().getType() == null) return;
		if(p.getInventory().getItemInMainHand().getType().equals(Material.TOTEM_OF_UNDYING)) {
		totem = p.getInventory().getItemInMainHand();
		hand = "Mainhand";
		}else if(p.getInventory().getItemInOffHand().getType().equals(Material.TOTEM_OF_UNDYING)) {
			totem = p.getInventory().getItemInOffHand();
			hand = "Offhand";
		}else {
			return;
		}
		//Now that we know what the info on the totem is, we can go through a switch based on the items name.
		ironHeartTotem(totem, e, hand);
	}
	
	public void ironHeartTotem(ItemStack totem, EntityResurrectEvent e, String hand) {
		ItemStack iht = new IronHeartTotem();
		if(!totem.getItemMeta().equals(iht.getItemMeta())) {return;}
		if(!(e.getEntity() instanceof Player)) return;
		Player p = (Player) e.getEntity();
		for (PotionEffect effect : p.getActivePotionEffects()) p.removePotionEffect(effect.getType());
		if(hand == "Mainhand") p.getInventory().getItemInMainHand().setAmount(4);
		if(hand == "Offhand") p.getInventory().getItemInOffHand().setAmount(4);
		
		
		//The totems effects go here
		p.sendMessage(ChatColor.GRAY + "You feel your soul weaken, and Iron take it's place");
		if(inUse.get(p.getName()) == null) inUse.put(p.getName(), 0);
		if(inUse.get(p.getName()) == 0) {
			double[] baseStats = new double[4];
			baseStats[0] = p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue();
			baseStats[1] = p.getAttribute(Attribute.GENERIC_ARMOR_TOUGHNESS).getBaseValue();
			baseStats[2] = p.getAttribute(Attribute.GENERIC_ARMOR).getBaseValue();
			baseStats[3] = p.getAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE).getBaseValue();
			baseStatMap.put(p.getName(), baseStats);
		}
		
		inUse.put(p.getName(), inUse.get(p.getName()) + 1);
		
		double newHealth = p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue()/2;
		if(newHealth < 2) newHealth = 2;
		
		p.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(newHealth);
		
		p.getAttribute(Attribute.GENERIC_ARMOR_TOUGHNESS).setBaseValue(20);
		p.getAttribute(Attribute.GENERIC_ARMOR).setBaseValue(30);
		p.getAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE).setBaseValue(1);
		
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
			  public void run(){
				  
				  if(inUse.get(p.getName()) <= 1) {
				  //If number of total runs = 1
				  double[] refreshStats = new double[4];
				  refreshStats = baseStatMap.get(p.getName());
				  p.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(refreshStats[0]);
					p.getAttribute(Attribute.GENERIC_ARMOR_TOUGHNESS).setBaseValue(refreshStats[1]);
					p.getAttribute(Attribute.GENERIC_ARMOR).setBaseValue(refreshStats[2]);
					p.getAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE).setBaseValue(refreshStats[3]);
				  inUse.put(p.getName(), 0);
				  p.sendMessage(ChatColor.GRAY + "You feel your soul return as the stiffness of the Iron fades");
			  }else {
				  inUse.put(p.getName(), inUse.get(p.getName()) - 1);
			  }
			  }
			}, 600L);//20L = 1 sec
	}
	
}
