package me.trumpetplayer2.Java.MCPlus.Listeners;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPotionEffectEvent;
import org.bukkit.inventory.ItemStack;

import me.trumpetplayer2.Java.MCPlus.Debug.TellConsole;
import me.trumpetplayer2.Java.MCPlus.Items.IronHeartTotem;

public class PotionEffectListener implements Listener{
	TellConsole debug = new TellConsole();
	
	@EventHandler
	public void PotionEffect(EntityPotionEffectEvent e) {
		IronHeartTotem(e);
	}
	
	public void IronHeartTotem(EntityPotionEffectEvent e) {
		if(!(e.getEntity() instanceof Player)) {return;}
		Player p = (Player) e.getEntity();
		int newAmount = 0;
		boolean main = false;
		ItemStack totem = new IronHeartTotem();
		if(e.getCause() == EntityPotionEffectEvent.Cause.TOTEM) {
			if(p.getInventory().getItemInMainHand().getType() == Material.TOTEM_OF_UNDYING && p.getInventory().getItemInMainHand().getItemMeta() != null){
			totem.setAmount(p.getInventory().getItemInMainHand().getAmount());
			if(p.getInventory().getItemInMainHand().toString().equals(totem.toString())) {
				newAmount = p.getInventory().getItemInMainHand().getAmount() - 1;
				if(newAmount < 1) newAmount = 0;
				p.getInventory().getItemInMainHand().setAmount(newAmount);
				main = true;
				e.setCancelled(true);
				p.setHealth(p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue());
			}
			}
			if(p.getInventory().getItemInOffHand().getType() == Material.TOTEM_OF_UNDYING && p.getInventory().getItemInOffHand().getItemMeta() != null){
			totem.setAmount(p.getInventory().getItemInOffHand().getAmount());
			if(p.getInventory().getItemInOffHand().toString().equals(totem.toString()) && !main) {
				newAmount = p.getInventory().getItemInOffHand().getAmount() - 1;
				if(newAmount < 1) newAmount = 0;
				p.getInventory().getItemInOffHand().setAmount(newAmount);
				e.setCancelled(true);
				p.setHealth(p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue());
			}
			}
		}else{
		}
	}
}
