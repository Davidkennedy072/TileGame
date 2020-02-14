package dev.davidgame.tilegame.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import dev.davidgame.tilegame.Handler;

public abstract class Entity {
	
	protected Handler handler;
	protected float x, y; 
	protected int width, height;
	protected int hit_Circle_Radius = 30;
	protected Rectangle bounds; 
	
	public Entity(Handler handler, float x, float y, int width, int height, int hitRadius) {
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.hit_Circle_Radius = hitRadius;
		
		bounds = new Rectangle(0,0, width, height);
	}
	
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
