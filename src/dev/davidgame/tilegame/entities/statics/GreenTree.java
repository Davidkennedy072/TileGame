package dev.davidgame.tilegame.entities.statics;

import java.awt.Graphics;

import dev.davidgame.tilegame.Handler;
import dev.davidgame.tilegame.graphics.Assets;
import dev.davidgame.tilegame.items.Item;

public class GreenTree extends StaticEntity{

	public GreenTree(Handler handler, float x, float y) {
		super(handler, x, y, 76, 142); //Width and Height from image
		
		this.bounds.x = width*1/4;
		this.bounds.y = height*1/4;
		this.bounds.width = width*1/2;
		this.bounds.height = height*1/2;
	}

	@Override
	public void tick() {
		
	}
	
	@Override
	public void die() {
		handler.getWorld().getItemManager().addItem(Item.woodChest.createNew((int) x, (int) y));
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.greentree, (int)(x - handler.getGameCamera().getxOffset()), 
				(int)(y - handler.getGameCamera().getyOffset()), width, height, null);
	}
	

}
