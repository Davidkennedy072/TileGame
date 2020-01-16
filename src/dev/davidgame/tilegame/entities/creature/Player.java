package dev.davidgame.tilegame.entities.creature;

import java.awt.Color;
import java.awt.Graphics;

import dev.davidgame.tilegame.Handler;
import dev.davidgame.tilegame.graphics.Assets;

public class Player extends Creature {

	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
		this.bounds.x = width*1/4;
		this.bounds.y = height*1/4;
		this.bounds.width = width*1/2;
		this.bounds.height = height*1/2;
		
	}
	
	@Override
	public void tick() {
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
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
	}
}
