package dev.davidgame.tilegame.inventory;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import dev.davidgame.tilegame.Handler;

public class Inventory {
	
	private Handler handler;
	private boolean active = false;
	
	public Inventory(Handler handler) {
		this.handler = handler;
	}
	
	public void tick() {
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_E)) {
			//Inventory Key E
			active = !active; //Turning inventory on and off
		}
		if(!active) {
			return;
		}
		if(handler.getGame().debug) {
			System.out.println("INVENTORY SCREEN ON");
		}
	}
	
	public void render(Graphics g) {
		if(!active) {
			return;
		}
		
	}
	
	//GETTERS and SETTERS

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}
	
	

}
