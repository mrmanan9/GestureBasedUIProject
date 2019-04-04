package ie.gmit.sw.Bullet;

import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;

import ie.gmit.sw.Sprites.Blocks;

public abstract class CannonBullets {
	
	//variable 
	//position and width and height 
	protected double xPos, yPos;
	protected int width, height;
	
	//create the methos that we want to implement 
	public abstract void draw(Graphics2D g);
	public abstract void update(double delta, Blocks blocks);
	// for collision 
	public abstract boolean collisionRect(Rectangle rectangle);
	public abstract boolean collisionPoly(Polygon polygon);
	public abstract boolean destory();
	
	protected abstract void wallCollide(Blocks blocks);
	protected abstract void isOutofBounds();
	
	
	// getters and setters 
	public double getxPos() {
		return xPos;
	}
	public void setxPos(double xPos) {
		this.xPos = xPos;
	}
	public double getyPos() {
		return yPos;
	}
	public void setyPos(double yPos) {
		this.yPos = yPos;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	

}
