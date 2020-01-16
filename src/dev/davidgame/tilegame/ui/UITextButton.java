package dev.davidgame.tilegame.ui;

import java.awt.Graphics;

public class UITextButton extends UIText{
	
	public UITextButton(String string, float x, float y) {
		super(x, y, string);
	}
	
	@Override
	public void tick() {
		
	}
	
	@Override
	public void render(Graphics g) {
		g.drawString(string, (int) x, (int) y);
		this.findBounds(g, string);
		this.displayBounds(g);
	}
}
