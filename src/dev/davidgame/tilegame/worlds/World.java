package dev.davidgame.tilegame.worlds;

import java.awt.Graphics;

import dev.davidgame.tilegame.Handler;
import dev.davidgame.tilegame.combat.CombatManager;
import dev.davidgame.tilegame.entities.EntityManager;
import dev.davidgame.tilegame.entities.creature.BasicZombie;
import dev.davidgame.tilegame.entities.creature.Player;
import dev.davidgame.tilegame.entities.statics.GreenTree;
import dev.davidgame.tilegame.entities.statics.SawBlade;
import dev.davidgame.tilegame.items.ItemManager;
import dev.davidgame.tilegame.tiles.Tile;
import dev.davidgame.tilegame.utils.Utils;

public class World {
	
	private Handler handler; 
	private int width, height; // In terms of tiles of map
	private int spawnX, spawnY; //Player starting position
	private int[][] tiles; 
	//Entities
	private EntityManager entityManager;
	//Item
	private ItemManager itemManager; 
	//Combat
	private CombatManager combatManager;
	
	public World(Handler handler, String path) {
		this.handler = handler;
		entityManager = new EntityManager(handler, new Player(handler, 200, 200));
		itemManager = new ItemManager(handler);
		combatManager = new CombatManager(handler);
		//Temporary Entity Spawn Code
		entityManager.addEntity((new GreenTree(handler, 500, 100)));
		entityManager.addEntity((new GreenTree(handler, 100, 320)));
		entityManager.addEntity((new GreenTree(handler, 200, 200)));
		entityManager.addEntity((new SawBlade(handler, 350, 200)));
		entityManager.addEntity((new BasicZombie(handler, 400, 600)));
		
		loadWorld(path);
		
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
	}
	
	public void tick() {
		itemManager.tick();
		entityManager.tick();
		combatManager.tick(); //Will be used in future
	}
	
	public void render(Graphics g) {
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset()/Tile.TILEWIDTH);
		int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset()+handler.getWidth())/Tile.TILEWIDTH + 1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset()/Tile.TILEHEIGHT);
		int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset()+handler.getHeight())/Tile.TILEHEIGHT + 1); 
		
		for(int y = yStart; y< yEnd; y++) {
			for (int x = xStart; x < xEnd; x++) {
				getTile(x, y).render(g, (int)(x*Tile.TILEWIDTH - handler.getGameCamera().getxOffset()), 
						(int)(y*Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
		//Items
		itemManager.render(g);
		//Entities
		entityManager.render(g);
		combatManager.render(g);

	}

	public Tile getTile(int x, int y) {
		
		if(x<0 || y<0 || x >= width || y>= height) {
			System.out.println("Player position not inside map");
			return Tile.dirtTile;
		}
		
		Tile t = Tile.tiles[tiles[x][y]];
		if(t ==null) {
			return Tile.dirtTile;
		}
		return t;
	}
	
	private void loadWorld(String path) {
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]); 
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		tiles = new int[width][height];
		for(int y=0; y< height; y++) {
			for(int x=0; x<width; x++) {
				tiles[x][y] = Utils.parseInt(tokens[(x+y*width) + 4 ]);
			}
		}
			
	}
	
	// GETTERS and SETTERS
	
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public ItemManager getItemManager() {
		return itemManager;
	}

	public void setItemManager(ItemManager itemManager) {
		this.itemManager = itemManager;
	}

	public CombatManager getCombatManager() {
		return combatManager;
	}

}
