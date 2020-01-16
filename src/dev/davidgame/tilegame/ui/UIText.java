package dev.davidgame.tilegame.ui;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
/**
 * @author David Kennedy
 * Creates UIText abstract template 
 *
 */

public abstract class UIText {
	
	protected float x, y;
	protected String string;
	protected boolean hovering = false;
	protected Rectangle2D bounds;
	
	public UIText(float x, float y, String string) {
		this.x = x;
		this.y = y;
		this.string = string;
	}
	
	protected void findBounds(Graphics g, String string) {
		FontMetrics metrics = g.getFontMetrics();
		this.bounds = metrics.getStringBounds(string, g);
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	//DEBUG DISPLAY
	protected void displayBounds(Graphics g) {
		g.setColor(Color.red);
		g.drawRect((int) (x), (int) (y -bounds.getHeight()), (int) bounds.getWidth(), (int) (bounds.getHeight()));
	}
	
}
