package dev.davidgame.tilegame.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

import dev.davidgame.tilegame.Handler;

public abstract class Entity {
	
	public static final int DEFAULT_HEALTH = 100;
	public static final int DEFAULT_HIT_RADIUS = 0;
	
	protected Handler handler;
	protected float x, y; 
	protected int width, height;
	protected int hit_Circle_Radius;
	protected Rectangle bounds; 
	
	protected boolean active = true;
	protected int health;
	
	public Entity(Handler handler, float x, float y, int width, int height, int hitRadius) {
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		this.hit_Circle_Radius = DEFAULT_HIT_RADIUS;
		this.health = DEFAULT_HEALTH; 
		bounds = new Rectangle(0,0, width, height);
	}
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
	public void hurt(int amt) {
		health = health - amt;
		if(health <= 0) {
			active = false;
			die();
		}
	}
	
	public abstract void die();

	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	public boolean checkEntityCollisions(float xOffset, float yOffset) {
		for(Entity e: handler.getWorld().getEntityManager().getEntities()) {
			if(e.equals(this)) {
				continue;
			}
			if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset))){
				return true;
			} 
		}
		return false;
	}
	
	public Rectangle getCollisionBounds(float xOffset, float yOffset) {
		return new Rectangle((int) (x + bounds.x + xOffset), 
				(int) (y + bounds.y + yOffset), bounds.width, bounds.height);
	}
	
	public Ellipse2D.Float getAttackCircle(float xOffset, float yOffset){
		return new Ellipse2D.Float(x - hit_Circle_Radius/2 + width/2 + xOffset, 
				y - hit_Circle_Radius/2 + height/2 - yOffset, 
				hit_Circle_Radius, hit_Circle_Radius);
	}
	
	//HIT CIRCLE DISPLAY
	protected void DisplayHitCircle(Graphics g) {
		g.setColor(new Color(255, 0, 0, 127));
		g.fillOval((int)(x - hit_Circle_Radius/2 + width/2 - handler.getGameCamera().getxOffset()), 
				(int)(y - hit_Circle_Radius/2 + height/2 - handler.getGameCamera().getyOffset()), 
				hit_Circle_Radius, hit_Circle_Radius);
	}
	
	//DEBUG DISPLAY
	
	protected void DisplayBounds(Graphics g) {
			g.setColor(Color.red);
			g.drawRect((int)(x + bounds.x - handler.getGameCamera().getxOffset()), 
					(int)(y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
			
	}
	
	protected void DisplayEntityPoint(Graphics g) {
		g.setColor(Color.green);
		g.drawOval((int) (x - handler.getGameCamera().getxOffset()), 
				(int) (y - handler.getGameCamera().getyOffset()), 5, 5);
	}
	
	//GETTERS SETTERS

	public float getX() {
		return x;
	}
	
	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	} 
	
}
