package dev.davidgame.tilegame.entities.creature;

import java.awt.Graphics;

import dev.davidgame.tilegame.Handler;
import dev.davidgame.tilegame.graphics.Assets;

public class BasicZombie extends Creature {

	public BasicZombie(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.zombie, (int)(x - handler.getGameCamera().getxOffset()), 
				(int)(y - handler.getGameCamera().getyOffset()), width, height, null);
	}

}
