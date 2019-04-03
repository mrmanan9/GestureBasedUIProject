package ie.gmit.sw.Sprites;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Sprite {
	
	// variables 
	private double xpos;
	private double ypos;
	private int speed;
	private boolean loop = false;
	private boolean play = false;
	private boolean destoryAfterAnim = false;
	
	//buffered image
	private ArrayList<BufferedImage> sprites = new ArrayList<BufferedImage>();
	
	// x and y position of the sprite on the screen
	// speed var is for the speed on the screen
	public Sprite(double xpos, double ypos, int speed) {
		this.xpos = xpos;
		this.ypos = ypos;
		this.speed = speed;
	}
	
	//draw 
	public void draw(Graphics2D g) {
		
	}
	//update 
	public void update(double delta) {
		
	}
	
	public void playerAnimation(boolean play, boolean destroy) {
		this.play = play;
		this.destoryAfterAnim = destroy;
	}
	
	//this adds a sprite animation 
	public void addSprite(BufferedImage spriteMap, int xPos, int yPos,int width, int height) {
		sprites.add(spriteMap.getSubimage(xPos, yPos, width, height));
	}

}
