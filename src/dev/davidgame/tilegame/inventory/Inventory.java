package dev.davidgame.tilegame.inventory;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import dev.davidgame.tilegame.Handler;
import dev.davidgame.tilegame.items.Item;

public class Inventory {
	
	private Handler handler;
	private boolean active = false;
	private ArrayList<Item> inventoryItems;
	
	
	public Inventory(Handler handler) {
		this.handler = handler;
		inventoryItems = new ArrayList<Item>();
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
	
	//INVENTORY METHODS
	
	public void addItem(Item item) {
		//Add stackable check later
		for (Item i : inventoryItems) {
			if(i.getId() == item.getId()) {
				i.setCount(i.getCount() + item.getCount());
				return;
			}
		}
		inventoryItems.add(item);
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
