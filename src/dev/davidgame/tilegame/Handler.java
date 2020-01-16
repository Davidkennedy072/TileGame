package dev.davidgame.tilegame;

import dev.davidgame.tilegame.graphics.GameCamera;
import dev.davidgame.tilegame.input.KeyManager;
import dev.davidgame.tilegame.input.MouseManager;
import dev.davidgame.tilegame.worlds.World;

public class Handler {
	
	private Game game;
	private World world;
	
	
	public Handler(Game game) {
		this.game = game;
	}
	
	public GameCamera getGameCamera() {
		return game.getGameCamera();
	}
	
	public KeyManager getKeyManager() {
		return game.getKeyManager();
	}
	
	public MouseManager getMouseManager() {
		return game.getMouseManager();
	}
	
	public int getWidth() {
		return game.getWidth();
	}
	
	public int getHeight() {
		return game.getHeight();
	}
	
	//Getters and Setters
	
	public Game getGame() {
		return game;
	}
	
	public void setGame(Game game) {
		this.game = game;
	}
	
	public World getWorld() {
		return world;
	}
	
	public void setWorld(World world) {
		this.world = world;
	}

}
