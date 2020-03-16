package dev.davidgame.tilegame.entities.creature;

import java.awt.Graphics;
import java.awt.geom.Ellipse2D;

import dev.davidgame.tilegame.Handler;
import dev.davidgame.tilegame.entities.Entity;
import dev.davidgame.tilegame.graphics.Assets;
import dev.davidgame.tilegame.inventory.Inventory;

public class Player extends Creature {

	//Attack Timer
	private long lastAttackTimer;
	private long attackCooldown = 1000; // 1000 ms = 1 sec
	private long attackTimer = attackCooldown;
	//Inventory
	private Inventory inventory;
	
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
		this.bounds.x = width*1/4;
		this.bounds.y = height*1/4;
		this.bounds.width = width*1/2;
		this.bounds.height = height*1/2;
		this.hit_Circle_Radius = 100;
		
		inventory = new Inventory(handler);
		
	}
	
	@Override
	public void tick() {
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
		//Attack
		checkAttacks();
		//Inventory
		inventory.tick();
	} 
	
	public void checkAttacks() {
		attackTimer = attackTimer + System.currentTimeMillis() - lastAttackTimer;
		lastAttackTimer = System.currentTimeMillis();
		if(attackTimer < attackCooldown) {
			return;
		}
		
		Ellipse2D.Float ar = getAttackCircle(0, 0);
		if(handler.getKeyManager().n_attack) {
			for(Entity e : handler.getWorld().getEntityManager().getEntities()) {
				if(e.equals(this))
					continue;
				if(ar.intersects(e.getCollisionBounds(0, 0))) {
					handler.getWorld().getCombatManager().basicAttack(e, 10);
				}
			}
		}
		attackTimer = 0;
	}
	
	@Override
	public void die() {
		System.out.println("You Lose");
	}
	
	private void getInput() {
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManager().up == true) {
			yMove = -speed;
		}
		if(handler.getKeyManager().down == true) {
			yMove = speed;
		}
		if(handler.getKeyManager().left == true) {
			xMove = -speed;
		}
		if(handler.getKeyManager().right == true) {
			xMove = speed;
		}
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.vargas, (int) (x - handler.getGameCamera().getxOffset()), 
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		inventory.render(g);
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	
	
}
