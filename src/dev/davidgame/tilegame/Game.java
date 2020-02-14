package dev.davidgame.tilegame;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import dev.davidgame.tilegame.display.Display;
import dev.davidgame.tilegame.graphics.Assets;
import dev.davidgame.tilegame.graphics.GameCamera;
import dev.davidgame.tilegame.input.KeyManager;
import dev.davidgame.tilegame.input.MouseManager;
import dev.davidgame.tilegame.state.GameState;
import dev.davidgame.tilegame.state.MenuState;
import dev.davidgame.tilegame.state.State;

public class Game implements Runnable {
	
	private Display display; 
	private int width, height; 
	public String title;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g; 
	
	//States
	public State gameState;
	public State menuState;
	
	//Debug
	public boolean debug = true;
	
	//Input
	private KeyManager keyManager; 
	private MouseManager mouseManager;
	
	//Camera
	private GameCamera gameCamera; 
	
	//Handler
	private Handler handler;
	
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		this.keyManager = new KeyManager();
		this.mouseManager = new MouseManager(); 
	}
	
	private void init() {
		display = new Display(title, width, height);
		display.getJFrame().addKeyListener(this.keyManager);
		
		display.getJFrame().addMouseListener(mouseManager);
		display.getJFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		
		Assets.init();
		
		handler = new Handler(this);
		gameCamera = new GameCamera(handler, 0,0);
		
		gameState = new GameState(handler); 
		menuState = new MenuState(handler); 
		State.setState(menuState);
	}
	
	
	private void tick() {
		keyManager.tick();
		if(State.getState() != null) {
			State.getState().tick();
		}
	}
	
	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, width, height); // Clear Full Screen
		// Draw Here
		
		if(State.getState() != null) {
			State.getState().render(g);
		}
		
		//End Drawing
		bs.show();
		g.dispose();
	}
	
	public void run() {
		
		init();
		
		int fps = 40;
		double timePerTick = 1000000000/fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		int updates = 0;
		
		while(this.running) {
			now = System.nanoTime();
			delta += (now-lastTime)/timePerTick; 
			timer += now - lastTime;
			lastTime = now;
			updates = updates + 1;
			
			if(delta >= 1) {
				tick();
				render();
				ticks++;
				delta = delta -1 ;
			}
			
			if(timer >= 1000000000) {
				display.getJFrame().setTitle(title + ": fps " + ticks + ", ups " + updates);
				ticks = 0;
				timer = 0;
				updates = 0;
			}
		}
		stop();
	}
	
	public KeyManager getKeyManager() {
		return keyManager;
	}
	
	public MouseManager getMouseManager() {
		return mouseManager;
	}
	
	public GameCamera getGameCamera() {
		return gameCamera; 
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public Graphics getGraphics() {
		return g;
	}
	
	public synchronized void start() {
		if(running == true) {
			return;
		}
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {
		if(running ==false) {
			return;
		}
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
