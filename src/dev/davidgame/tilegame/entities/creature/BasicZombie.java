package dev.davidgame.tilegame.entities.creature;

import java.awt.Graphics;

import dev.davidgame.tilegame.Handler;
import dev.davidgame.tilegame.graphics.Assets;

public class BasicZombie extends Creature {
	
	private int moveTime = 0;

	public BasicZombie(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		xMove = 1;
		yMove = 0;
		
	}

	@Override
	public void tick() {
		moveTime = moveTime + 1;
		move();
		if(moveTime == 60) {
			move();
			xMove = -xMove;
			moveTime = 0;
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.zombie, (int)(x - handler.getGameCamera().getxOffset()), 
				(int)(y - handler.getGameCamera().getyOffset()), width, height, null);
	}
	
	public void ambientMove() {
		
	}

}
