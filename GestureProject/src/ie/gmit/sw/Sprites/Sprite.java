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
	private int width;
	private int height;
	
	//buffered image
	private ArrayList<BufferedImage> sprites = new ArrayList<BufferedImage>();
	//current sprite 
	private byte currentSprite;
	
	// x and y position of the sprite on the screen
	// speed var is for the speed on the screen
	public Sprite(double xpos, double ypos,int width, int height, int speed) {
		this.xpos = xpos;
		this.ypos = ypos;
		this.speed = speed;
		
		//timer
		timer = new Timer();
		
		//width and height
		this.width = width;
		this.height = height;
	}
	
	//draw 
	public void draw(Graphics2D g) {
		//checks if the sprite is destroyed then returns 
		if (isSpriteAnimDestroyed())
			return;
		//otherwise it draws it 
		//draw sprite 
		g.drawImage(sprites.get(currentSprite), (int) getXpos(), (int) getYpos(),width, height, null);
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
			currentSprite = 0;//resets the animation 
			timer.resetTimer();
		}else if (timer.timerEvent(speed) && currentSprite != limit) {
			currentSprite++;
		} 
	}
	
	private void playAnimation() {
		if (timer.isTimerReady(speed) && currentSprite != limit && !isDestoryAfterAnim()) {
			play = false;
			currentSprite = 0; //resets the animation 
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
	//checks 
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

	public boolean isLoop() {
		return loop;
	}

	public void setLoop(boolean loop) {
		this.loop = loop;
	}

	public byte getCurrentSprite() {
		return currentSprite;
	}

	public void setCurrentSprite(byte currentSprite) {
		this.currentSprite = currentSprite;
	}

	public double getYpos() {
		return ypos;
	}

	public void setYpos(double ypos) {
		this.ypos = ypos;
	}
}
