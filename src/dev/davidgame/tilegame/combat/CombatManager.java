package dev.davidgame.tilegame.combat;

import java.awt.Graphics;

import dev.davidgame.tilegame.Handler;
import dev.davidgame.tilegame.entities.Entity;

public class CombatManager {
	//Need to implement system that stores each attack from all different entities
	//Once system ticks, it implements all the attacks against each enemy
	//Maybe an combatEvent class that stores the entity and the damage
	//Similar in structure to EntityManager
	
	private int damageAmount;

	private Handler handler;
	
	public CombatManager(Handler handler) {
		this.handler = handler;
	}
	
	public void hurt(Entity e, int amt) {
		e.hurt(amt);
		damageAmount = amt;
		System.out.println("Hurt");
	}
	
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
	}
}
