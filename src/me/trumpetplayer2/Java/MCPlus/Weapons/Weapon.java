package me.trumpetplayer2.Java.MCPlus.Weapons;

import org.bukkit.entity.Player;

import me.trumpetplayer2.Java.MCPlus.Skills.Skill;
import me.trumpetplayer2.Java.MCPlus.WeaponClasses.WeaponClass;

public class Weapon extends WeaponClass{
    private Skill skill;
    public Skill getSkill() {return skill;}
    
    
    public Weapon(WeaponClass weaponClass) {
	super(weaponClass);
    }
    
    public void setSkill(Skill newSkill) {
	skill = newSkill;
    }
    
    public void removeSkill() {
	skill = null;
    }
    
    public void updateSkill(Skill skill) {
	
    }
    
    public void giveWeapon(Player p) {
	p.getInventory().addItem(this);
    }
}
