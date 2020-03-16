package dev.davidgame.tilegame.graphics;

import java.awt.image.BufferedImage;

public class Assets {
	//To add new images:
	//1) Refresh texture folders by selecting and pressing F5
	
	private static final int width = 50, height = 50;
	
	public static BufferedImage victide, person, mirror, back, wing, saw, vargas, greentree, zombie;
	public static BufferedImage dirt, mud, stone;
	public static BufferedImage woodenchest;
	public static BufferedImage[] btn_start;
	
	public static void init() {
		
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImager("/textures/CombinedTextures_1.png"));
		btn_start = new BufferedImage[2];
		btn_start[0] = sheet.crop(width, 0, width, height);
		btn_start[1] = sheet.crop(2*width, 0, width, height);
		person = sheet.crop(0, 0, width, height);
		//wing = sheet.crop(3*width, 1*height, width, height);
		saw = sheet.crop(1*width, 1*height, width, height);
		
		vargas = ImageLoader.loadImager("/textures/Fencer_Vargas.png");
		victide = ImageLoader.loadImager("/textures/Victide_Enchantment_.png");
		dirt = ImageLoader.loadImager("/textures/Dirt_Block.png");
		mud = ImageLoader.loadImager("/textures/Mud_Block.png");
		stone = ImageLoader.loadImager("/textures/Stone_Block.png");
		greentree = ImageLoader.loadImager("/textures/Tree_1.png");
		
		woodenchest = ImageLoader.loadImager("/textures/Wooden_chest.png");
		
		zombie = ImageLoader.loadImager("/textures/Zombie.png");
	}
}
