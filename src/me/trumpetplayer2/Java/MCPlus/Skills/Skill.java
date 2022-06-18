package me.trumpetplayer2.Java.MCPlus.Skills;

import org.bukkit.entity.Player;

public class Skill{
    private int cooldown = 0;
    private String id;
    private String name;
    public int getCooldown() {return cooldown;}
    public String getID() {return id;}
    public String getName() {return name;}
    
    
    public Skill(String nname, String idd) {
	name = nname;
	id = idd;
    }
    
    
    //List of possible occurences. Override in Skills
    public void passiveEffect() {
	
    }
    
    public void crouchEffect() {
	
    }
    
    public void killEffect(Player killed) {
	
    }
    
    public void jumpEffect() {
	
    }
    
    public void rightClickEffect() {
	
    }
    
    public void recieveDamageEffect() {
	
    }
    
    public void moveEffect() {
	
    }
    
    public void dealDamageEffect() {
	
    }
    
}
