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
	private Timer timer;
	private int limit;
	
	//buffered image
	private ArrayList<BufferedImage> sprites = new ArrayList<BufferedImage>();
	//current sprite 
	private byte currentSprite;
	
	// x and y position of the sprite on the screen
	// speed var is for the speed on the screen
	public Sprite(double xpos, double ypos, int speed) {
		this.xpos = xpos;
		this.ypos = ypos;
		this.speed = speed;
	}
	
	//draw 
	public void draw(Graphics2D g) {
		//draw sprite 
		g.drawImage(sprites.get(currentSprite), (int) getXpos(), (int) getYpos(), null);
	}
	//update 
	public void update(double delta) {
		//if sprite is destroyed then 
		// finish this method 
		if (isSpriteAnimDestroyed())
			return;
		//if not the finish the method
		if (loop && !play)
			loopAnimation();
		if (play && !loop)
			playAnimation();
		
	}
	
	public void playerAnimation(boolean play, boolean destroy) {
		this.play = play;
		this.destoryAfterAnim = destroy;
	}
	
	//this adds a sprite animation 
	public void addSprite(BufferedImage spriteMap, int xPos, int yPos,int width, int height) {
		sprites.add(spriteMap.getSubimage(xPos, yPos, width, height));
	}
	
	
	// stop the animation
	public void stopAnimation() {
		loop = false;
		play = false;
	}
	
	// reset the animation
	public void resetSprite() {
		loop = false;
		play = false;
		currentSprite = 0;
	}
	
	private void loopAnimation() {
		if (timer.isTimerReady(speed) && currentSprite != limit) {
			currentSprite = 0;
			timer.resetTimer();
		}else if (timer.timerEvent(speed) && currentSprite != limit) {
			currentSprite++;
		} 
	}
	
	private void playAnimation() {
		if (timer.isTimerReady(speed) && currentSprite != limit && !isDestoryAfterAnim()) {
			play = false;
			currentSprite = 0;
		} else if (timer.isTimerReady(speed) && currentSprite == limit && isDestoryAfterAnim()) {
			sprites = null;
		}else if (timer.timerEvent(speed) && currentSprite != limit) {
			currentSprite++;
		}
	
	}
	//checks if the sprite animation is destroyed 
	public boolean isSpriteAnimDestroyed() {
		if (sprites == null)
			return true;

		return false;
	}
	
	public boolean isDestoryAfterAnim() {
		return destoryAfterAnim;
	}
	
	//getteres and setters 
	public double getXpos() {
		return xpos;
	}

	public void setXpos(double xpos) {
		this.xpos = xpos;
	}

	public double getYpos() {
		return ypos;
	}

	public void setYpos(double ypos) {
		this.ypos = ypos;
	}
	
	
	

}
