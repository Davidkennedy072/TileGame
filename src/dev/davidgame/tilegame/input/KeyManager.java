package dev.davidgame.tilegame.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {
	
	private boolean[] keys, justPressed, cantPress;
	public boolean up, down, left, right; //Movement
	public boolean n_attack; //Normal attack
	public boolean pick_up; //Pick Up Items
	
	public KeyManager() {
		keys = new boolean[256];
		justPressed = new boolean[keys.length];
		cantPress = new boolean[keys.length];
	}
	
	public void tick() {
		
		for (int i = 0; i < keys.length; i++) {
			// Loop through each key code. Allows key holding or key
			if(cantPress[i] == true && !keys[i]) {
				//If cantPress is true but key is no longer active
				cantPress[i] = false; //Key is now press able
			} else if(justPressed[i]){
				cantPress[i] = true; //Can not press until key is released
				justPressed[i] = false;
			}
			if(!cantPress[i] && keys[i]) {
				justPressed[i] = true;
			}
		}
		
		up = keys[KeyEvent.VK_UP];
		down = keys[KeyEvent.VK_DOWN];
		left = keys[KeyEvent.VK_LEFT];
		right = keys[KeyEvent.VK_RIGHT];
		
		n_attack = keys[KeyEvent.VK_Q]; //Normal attack
		pick_up = keys[KeyEvent.VK_F]; // Pick up Items
	}
	
	public boolean keyJustPressed(int keyCode) {
		if(keyCode <0 || keyCode >= keys.length) {
			return false;
		}
		return justPressed[keyCode];
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() < 0 || e.getKeyCode() >= keys.length) {
			// If key code is less than 0 or not in 256 array. Return
			return;
		}
		keys[e.getKeyCode()] = true;
		System.out.println("Pressed");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() < 0 || e.getKeyCode() >= keys.length) {
			// If key code is less than 0 or not in 256 array. Return
			return;
		}
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
