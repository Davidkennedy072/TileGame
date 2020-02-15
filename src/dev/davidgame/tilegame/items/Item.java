package dev.davidgame.tilegame.items;

import java.awt.image.BufferedImage;

import dev.davidgame.tilegame.Handler;

public class Item {

	public static final int ITEMWIDTH = 32, ITEMHEIGHT = 32, PICKED_UP = -1;
	
	protected Handler handler;
	protected BufferedImage texture;
	protected String name;
	protected final int id;
	
	protected int x, y, count;
	
	public Item(BufferedImage texture, String name, int id) {
		this.texture= texture;
		this.name = name;
		this.id = id;
	}
}
