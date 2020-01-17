package dev.davidgame.tilegame.ui;

import java.awt.Graphics;

import dev.davidgame.tilegame.Handler;

public class UITextButton extends UIText{
	
	public UITextButton(Handler handler, String string, float x, float y) {
		super(handler, string, x, y);
	}
	
	@Override
	public void tick() {
		
	}
	
	@Override
	public void render(Graphics g) {
		g.drawString(string, (int) x, (int) y);
		this.displayBounds(g);
	}

	@Override
	public void onClick() {
		
	}
}
