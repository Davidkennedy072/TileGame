package dev.davidgame.tilegame.entities.creature;

import dev.davidgame.tilegame.Handler;
import dev.davidgame.tilegame.entities.Entity;
import dev.davidgame.tilegame.tiles.Tile;

public abstract class Creature extends Entity {
	
	
	public static final float DEFAULT_SPEED = 3.0f; 
	public static final int DEFAULT_CREATURE_WIDTH = 50;
	public static final int DEFAULT_CREATURE_HEIGHT = 50;
	public static final int DEFAULT_CREATURE_HIT_RADIUS = 100;
	
	protected float speed;
	protected float xMove, yMove;
	
	public Creature(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height, DEFAULT_CREATURE_HIT_RADIUS);
		this.speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
	}
	
	public void move() {
		// Tile Collision
		if(!checkCollision(x + bounds.x, y + bounds.y, xMove, yMove) && 
				!checkCollision(x + bounds.x + bounds.width, y + bounds.y, xMove, yMove) &&
				!checkCollision(x + bounds.x, y + bounds.y + bounds.height, xMove, yMove) &&
				!checkCollision(x + bounds.x + bounds.width, y + bounds.y + bounds.height, xMove, yMove)) {
			
			//Entity Collision
			if(!checkEntityCollisions(xMove, 0f)) {
				moveX();
			}
			if(!checkEntityCollisions(0f, yMove)) {
				moveY();
			}
		}else {
			System.out.println("collision");
		}
	}
	
	public void moveX() {
		x = x + xMove;
	}
	
	public void moveY() {
		y = y + yMove;
	}
	
	public void die() {
		
	}
	
	protected boolean checkCollision(float currentX, float currentY, float xMove, float yMove) {
		int tx = (int)(currentX + xMove)/Tile.TILEWIDTH;
		int ty = (int)(currentY + yMove)/Tile.TILEHEIGHT;
		return collisionWithTile(tx, ty);
	}
	
	protected boolean collisionWithTile(int x, int y) {
		return handler.getWorld().getTile(x, y).isSolid();
	}
	
	//GETTERS SETTERS
	
	public float getxMove() {
		return xMove;
	}
	
	public void setxMove(float xMove) {
		this.xMove = xMove;
	}
	
	public float getyMove() {
		return yMove;
	}
	
	public void setyMove(float yMove) {
		this.yMove = yMove; 
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
	public float getSpeed() {
		return this.speed;
	}
	
	public void setSpeed(float speed) {
		this.speed = speed;
	}
}
