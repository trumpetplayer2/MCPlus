package me.trumpetplayer2.Java.MCPlus;

import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import me.trumpetplayer2.Java.MCPlus.Debug.StoreInv;
import me.trumpetplayer2.Java.MCPlus.Items.Coin;
import me.trumpetplayer2.Java.MCPlus.Items.EXPBottle;
import me.trumpetplayer2.Java.MCPlus.Items.IronHeartTotem;
import me.trumpetplayer2.Java.MCPlus.Items.Instruments.Playable;
import me.trumpetplayer2.Java.MCPlus.Listeners.CraftingEventListener;
import me.trumpetplayer2.Java.MCPlus.Listeners.InventoryClickListener;
import me.trumpetplayer2.Java.MCPlus.Listeners.MobDeathListener;
import me.trumpetplayer2.Java.MCPlus.Listeners.PlayerQuitListener;
import me.trumpetplayer2.Java.MCPlus.Listeners.PotionEffectListener;
import me.trumpetplayer2.Java.MCPlus.Listeners.TotemUseListener;
import me.trumpetplayer2.Java.MCPlus.WeaponClasses.Axe;
import me.trumpetplayer2.Java.MCPlus.WeaponClasses.Broadsword;
import me.trumpetplayer2.Java.MCPlus.WeaponClasses.Dagger;
import me.trumpetplayer2.Java.MCPlus.WeaponClasses.Hammer;
import me.trumpetplayer2.Java.MCPlus.WeaponClasses.OneHandedSword;
import me.trumpetplayer2.Java.MCPlus.WeaponClasses.Rapier;
import me.trumpetplayer2.Java.MCPlus.WeaponClasses.Spear;
import me.trumpetplayer2.Java.MCPlus.WeaponClasses.WeaponClass;
import me.trumpetplayer2.Java.MCPlus.Weapons.Weapon;



public class Main extends JavaPlugin implements Listener {
	
    	public StoreInv invStorage = new StoreInv();
    
	//Basic Enable
	@Override
	public void onEnable() {
		//Start, reload
		this.saveDefaultConfig();
		this.getServer().getPluginManager().registerEvents(this, this);
		getServer().getPluginManager().registerEvents(new MobDeathListener(), this);
		getServer().getPluginManager().registerEvents(new CraftingEventListener(), this);
		getServer().getPluginManager().registerEvents(new TotemUseListener(this), this);
		getServer().getPluginManager().registerEvents(new PotionEffectListener(), this);
		getServer().getPluginManager().registerEvents(new InventoryClickListener(this), this);
		getServer().getPluginManager().registerEvents(new PlayerQuitListener(this), this);
		loadConfig();
	}
	
	//Basic Disable Code
	@Override
	public void onDisable() {
		//Disable, reload
		restoreInv();
	}

	public void help(CommandSender sender) {
		//If the command "/Pyroshot" is typed, bring up help menu
		sender.sendMessage(ChatColor.BLUE + "-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-");
		sender.sendMessage(ChatColor.BLUE + "          MC+ Command Help         ");
		sender.sendMessage(ChatColor.BLUE + "-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-");
		sender.sendMessage(ChatColor.BLUE + "'/MCPlus Help' -> Shows this area in chat");
		sender.sendMessage(ChatColor.BLUE + "'/MCPlus Give (Item)' -> Gives you an item (Player only)");
		sender.sendMessage(ChatColor.BLUE + "'/MCPlus ResetAttribute' -> Resets a players Attributes (IE: Health, Player only)");
		sender.sendMessage(ChatColor.BLUE + "'/MCPlus AddWeaponClass (Weapon Class)' -> Sets the weapon class on the item held.");
		sender.sendMessage(ChatColor.BLUE + "-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-");
	}
	
	public void invalidPermission(CommandSender sender){
		//Invalid perm message
		sender.sendMessage(ChatColor.DARK_RED + "Invalid Permission");
	}
	
	//Command interface
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(label.equalsIgnoreCase("MCPlus")) {
		    Player p;
		    Boolean isPlayer = false;
		    if(sender instanceof Player) {
			p = (Player) sender;
			isPlayer = true;
		    }
		    
			if(args.length == 0) {
				help(sender);
				return false;
			}
			String subCommand = args[0];
			switch(subCommand.toLowerCase()) {
			case "help": help(sender);
						return false;
			case "give": 
			    if(sender.hasPermission("MCPlus.admin.give")) {
			    give(sender, args);
			    }else {
				invalidPermission(sender);
			    }
			    return false;
			case "resetattribute": 
			    if(sender.hasPermission("MCPlus.admin.resetattribute")) {
			    resetAttribute(sender);
			    }else {
				invalidPermission(sender);
			    }
			    return false;
			case "addweaponclass": 
			    if(sender.hasPermission("MCPlus.admin.addweaponclass")) {
			    addWeaponClass(sender, args);
			    }else {
				invalidPermission(sender);
			    }
			            return false;
			            
			case "play" :
			    if(sender.hasPermission("MCPlus.playInstrument") && isPlayer) {
				p = (Player) sender;
				    play(p, args);
				    }else {
					invalidPermission(sender);
				    }
				            return false;
			default: help(sender);
			}
		}
	return false;
}

	public void addWeaponClass(CommandSender s, String[] args) {
		if(!(s instanceof Player)) return;
		Player p = (Player) s;
		if(args.length < 2) {
			s.sendMessage(ChatColor.DARK_RED + "Please provide a valid weapon class.");
			return;
		}
		switch(args[1].toLowerCase()) {
		case "axe" : ItemStack axe = new Axe(p.getInventory().getItemInMainHand());
		p.getInventory().setItem(p.getInventory().getHeldItemSlot(), axe);
		return;
		
		
		default: 
			s.sendMessage(ChatColor.DARK_RED + "Please provide a valid weapon class.");
			return;
		}
		
	}
	
	public void play(Player p) {
	    play(p, "bell");
	}
	
	public void play(Player p, String[] s) {
	    if(s.length < 2) {
	    play(p, "bell");
	    }else if(s.length > 2) {
		p.sendMessage(ChatColor.DARK_RED + "Please provide a valid instrument. This should only require 1 word after play");
	    }else {
		play(p, s[1]);
	    }
	}
	
	public void play(Player p, String s) {
	    //Create a test enviornment
	    Playable tempInstrument = new Playable(s);
	    if(!invStorage.getInvStored(p)) {
		invStorage.AddInv(p);
		p.getInventory().setContents(tempInstrument.createInventory().getContents());
		p.updateInventory();
		invStorage.setInstrument(p, tempInstrument);
		p.sendMessage("Now using instrument " + s);
	    }else {
		p.getInventory().setContents(invStorage.RestoreInv(p).getContents());
		p.updateInventory();
		p.sendMessage("No longer playing an instrument");
	    }
	    
	}
	
	public void restoreInv() {
	    invStorage.restoreAllInv();
	}
	
	public void resetAttribute(CommandSender s) {
		if(!(s instanceof Player)) return;
		Player p = (Player) s;
		p.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(20);
		p.getAttribute(Attribute.GENERIC_ARMOR_TOUGHNESS).setBaseValue(0);
		p.getAttribute(Attribute.GENERIC_ARMOR).setBaseValue(0);
		p.getAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE).setBaseValue(0);
	}
	
	public void give(CommandSender sender, String[] args){
		if(!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.DARK_RED + "Only a player can use this command");
			return;}
		Player p = (Player) sender;
		if(args.length < 2) {
			sender.sendMessage(ChatColor.DARK_RED + "Please provide a valid item.");
			return;
		}
		switch(args[1].toLowerCase()) {
		case "ironhearttotem": ItemStack totem = new IronHeartTotem();
			p.getInventory().addItem(totem);
			return;
		case "coin": ItemStack coin = new Coin();
		p.getInventory().addItem(coin);
		return;
		case "expbottle": ItemStack bottle = new EXPBottle();
		p.getInventory().addItem(bottle);
		return;
		
		//Default Weapon Type
		case "defaultaxe": ItemStack axe = new Axe();
		p.getInventory().addItem(axe);
		return;
		case "defaultdagger": ItemStack dagger = new Dagger();
		p.getInventory().addItem(dagger);
		return;
		case "defaulthammer": ItemStack hammer = new Hammer();
		p.getInventory().addItem(hammer);
		return;
		case "defaultonehandedsword": ItemStack ohs = new OneHandedSword();
		p.getInventory().addItem(ohs);
		return;
		case "defaultrapier": Rapier rapier = new Rapier();
		newWeapon(p, rapier);
		return;
		case "defaultspear": ItemStack spear = new Spear();
		p.getInventory().addItem(spear);
		return;
		case "defaultbroadsword": ItemStack ths = new Broadsword();
		p.getInventory().addItem(ths);
		return;
		
		default: sender.sendMessage(ChatColor.DARK_RED + "Please provide a valid item.");
		return;
		}
	}
	
	public void loadConfig() {
		Recipes.registerNewRecipe(this);
		//Use this.getConfig().get**TYPEHERE**("header.level1.etc")
	};

	public void newWeapon(Player p, WeaponClass wClass) {
	    Weapon defaultWeapon = new Weapon(wClass);
	    defaultWeapon.giveWeapon(p);
	}
	
}
