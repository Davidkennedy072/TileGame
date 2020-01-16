package dev.davidgame.tilegame.tiles;

import dev.davidgame.tilegame.graphics.Assets;

public class StoneTile extends Tile{
	
	public StoneTile(int id) {
		super(Assets.stone, id);
	}
	
	@Override
	public boolean isSolid() {
		return true; 
	}

}
