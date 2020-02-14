package dev.davidgame.tilegame.entities.statics;

import java.awt.Graphics;

import dev.davidgame.tilegame.Handler;
import dev.davidgame.tilegame.entities.Entity;
import dev.davidgame.tilegame.graphics.Assets;

public abstract class StaticEntity extends Entity {
	// DOES NOT MOVE. Creature class sibling 
	
	public static final int DEFAULT_STATIC_ENTITY_HIT_RADIUS = 0;
	
	public StaticEntity(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height, DEFAULT_STATIC_ENTITY_HIT_RADIUS); 
	}
	
}
	
	