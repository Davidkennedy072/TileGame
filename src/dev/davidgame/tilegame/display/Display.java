package dev.davidgame.tilegame.display;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display {
	
	private JFrame frame;
	private Canvas canvas; 
	
	private String title;
	private int width, height; 
	
	public Display(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height; 
		
		createDisplay(); 
	}
	
	private void createDisplay() {
		this.frame = new JFrame(title); 
		this.frame.setSize(width,height);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setResizable(true);
		this.frame.setLocationRelativeTo(null);
		this.frame.setVisible(true);
		
		createCanvas();
		frame.add(canvas);
		frame.pack();
	}
	
	private void createCanvas() {
		this.canvas = new Canvas();
		this.canvas.setPreferredSize(new Dimension(width,height));
		this.canvas.setMaximumSize(new Dimension(width,height));
		this.canvas.setMinimumSize(new Dimension(width,height));
		this.canvas.setFocusable(false);
	}
	
	public Canvas getCanvas() {
		return this.canvas;
	}
	
	public JFrame getJFrame() {
		return this.frame;
	}
}
