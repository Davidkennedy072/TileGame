package dev.davidgame.tilegame.ui;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

import dev.davidgame.tilegame.Handler;
/**
 * @author David Kennedy
 * Creates UIText abstract template 
 *
 */

public abstract class UIText extends UIObject{
	
	protected Handler handler;
	protected float x, y;
	protected String string;
	protected boolean hovering = false;
	
	public UIText(Handler handler, String string, float x, float y) {
		super(x, y, 10, 10);
		this.handler = handler;
		this.string = string;
		
		
		
	}

	//protected void findBounds(String string) {
	//	FontMetrics metrics = handler.getGame().getGraphics().getFontMetrics();;
	//	Rectangle2D bounds = metrics.getStringBounds(string, handler.getGame().getGraphics());
	//	this.width = (int) bounds.getWidth();
	//	this.height = (int) bounds.getHeight();
	//	bounds = new Rectangle((int) x, (int) y, width, height);
	//}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	//DEBUG DISPLAY
	protected void displayBounds(Graphics g) {
		g.setColor(Color.red);
		g.drawRect((int) x, (int) (y - bounds.getHeight()), (int) bounds.getWidth(), (int) (bounds.getHeight()));
	}
	
}
