package dev.davidgame.tilegame.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	
	//Static Stuff Here
	
	public static Tile[] tiles = new Tile[256];
	public static Tile dirtTile = new DirtTile(0); 
	public static Tile mudTile = new MudTile(1);
	public static Tile stoneTile = new StoneTile(2);
	
	//Class
	
	public static final int TILEWIDTH = 48, TILEHEIGHT = 48;
	protected BufferedImage texture;
	protected final int id;
	
	public Tile(BufferedImage texture, int id) {
		this.texture = texture; 
		this.id = id;
		tiles[id] = this;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
	}
	
	public boolean isSolid() {
		return false;
	}
	
	public int getId() {
		return id;
	}

}
