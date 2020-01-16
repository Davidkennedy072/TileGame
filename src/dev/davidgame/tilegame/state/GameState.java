package dev.davidgame.tilegame.state;

import java.awt.Graphics;

import dev.davidgame.tilegame.Game;
import dev.davidgame.tilegame.Handler;
import dev.davidgame.tilegame.entities.creature.Player;
import dev.davidgame.tilegame.entities.statics.SawBlade;
import dev.davidgame.tilegame.tiles.Tile;
import dev.davidgame.tilegame.worlds.World;

public class GameState extends State{
	
	private World world;
	
	public GameState(Handler handler) {
		super(handler);
		world = new World(handler, "resources/worlds/world1.txt");
		handler.setWorld(world);
		
	}
	@Override
	public void tick() {
		world.tick();
		
	}
	
	@Override
	public void render(Graphics g) {
		world.render(g);
	}
}
