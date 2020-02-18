package dev.davidgame.tilegame.entities.statics;

import java.awt.Graphics;

import dev.davidgame.tilegame.Handler;
import dev.davidgame.tilegame.graphics.Assets;
import dev.davidgame.tilegame.items.Item;
import dev.davidgame.tilegame.tiles.Tile;

public class SawBlade extends StaticEntity {

	public SawBlade(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
		this.hit_Circle_Radius = 70;
	}

	@Override
	public void tick() {
		
	}
	
	@Override
	public void die() {
		handler.getWorld().getItemManager().addItem(Item.victideEnc.createNew((int) x, (int) y));
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.saw, (int) (x - handler.getGameCamera().getxOffset()),  
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}

}
