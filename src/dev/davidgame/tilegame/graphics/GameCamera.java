package dev.davidgame.tilegame.graphics;

import dev.davidgame.tilegame.Handler;
import dev.davidgame.tilegame.entities.Entity;
import dev.davidgame.tilegame.tiles.Tile;

public class GameCamera {
	
	private Handler handler;
	private float xOffset, yOffset;
	
	public GameCamera(Handler handler, float xOffset, float yOffset){
		this.handler = handler;
		this.xOffset = xOffset;
		this.yOffset = yOffset; 
	}
	
	public void checkBlankSpace() {
		if(xOffset <0) {
			xOffset = 0;
		}else if(xOffset > handler.getWorld().getWidth()*Tile.TILEWIDTH - handler.getWidth()) {
			xOffset = handler.getWorld().getWidth()*Tile.TILEWIDTH - handler.getWidth();
		}
		
		if (yOffset < 0) {
			yOffset = 0;
		}else if(yOffset > handler.getWorld().getHeight()*Tile.TILEHEIGHT - handler.getHeight()) {
			yOffset = handler.getWorld().getHeight()*Tile.TILEHEIGHT - handler.getHeight();
		}
	}
	
	public void centerOnEntity(Entity e) {
		xOffset = e.getX() - handler.getGame().getWidth() / 2 + e.getWidth()/2;
		yOffset = e.getY() - handler.getGame().getHeight() / 2 + e.getHeight()/2;
		checkBlankSpace();
	}
	
	public void move(float xAmt, float yAmt) {
		xOffset = xOffset + xAmt;
		yOffset = yOffset + yAmt; 
		checkBlankSpace();
	}
	
	public float getxOffset() {
		return this.xOffset;
	}
	
	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}
	
	public float getyOffset() {
		return this.yOffset;
	}
	
	public void setyOffset(float yOffset) {
		this.yOffset = yOffset; 
	}

}
