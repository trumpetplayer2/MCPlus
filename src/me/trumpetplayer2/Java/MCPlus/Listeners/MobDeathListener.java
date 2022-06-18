package me.trumpetplayer2.Java.MCPlus.Listeners;

import java.util.List;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import me.trumpetplayer2.Java.MCPlus.Items.Coin;

public class MobDeathListener implements Listener{
	//On a mob getting killed
		@EventHandler
		public void onMobDeath(EntityDeathEvent e) {
			Entity killer = e.getEntity().getKiller();
			List<ItemStack> drops = e.getDrops();
			int coinCount = e.getDroppedExp();
			if(!(killer instanceof Player)) {return;}
			//Determine coin drops
			try {
				if(coinCount <1) {return;}
				}catch(Exception e1) {
					return;
				}
			if(coinCount > 64) {
				coinCount = 64;
			}
			
			//Set up the coin
			ItemStack coin = new Coin(coinCount);
			//Add Coin to drops
			drops.add(coin);
		}
}
