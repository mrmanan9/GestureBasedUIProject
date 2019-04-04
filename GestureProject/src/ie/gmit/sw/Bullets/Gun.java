package ie.gmit.sw.Bullets;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;

import ie.gmit.sw.Sprites.Blocks;

public class Gun extends CannonBulletsTypes{
	
	//variables for bullet
	private Rectangle bullet;
	private final double speed = 2.5d;
	
	// this is the height and widgth of the canvas 
	private float canvasWidth = 770;
	private float canvasHeight = 652;
		

	public Gun(double xpos, double ypos, int width, int height) {
		this.setxPos(xpos);
		this.setyPos(ypos);
		this.setWidth(width);
		this.setHeight(height);
		
		//instialise the bullet rectangle 
		this.bullet = new Rectangle((int) getxPos(),(int) getyPos(), getWidth(), getHeight());
	}

	@Override
	public void draw(Graphics2D g) {
		//check if rectangle is null
		if(bullet == null)
			return;
		
		//else set tthe color of the bullet to white 
		g.setColor(Color.WHITE);
		//and fill it 
		g.fill(bullet);
		
	}

	@Override
	public void update(double delta, Blocks blocks) {
		// TODO Auto-generated method stub
		if(bullet == null)
			return;
		//update bullet here 
		this.setyPos(getyPos() - (delta * speed));
		bullet.y = (int) this.getyPos();
		wallCollide(blocks);
		isOutofBounds();
	}

	@Override
	public boolean collisionRect(Rectangle rectangle) {
//		check if the rectangle is null
		if(this.bullet == null)
			return false;
		// if not 
		//check if it intersects 
		// if intersects then bullet is null
		if(bullet.intersects(rectangle)){
			this.bullet = null;
			return true;
		}
		//else return false 
		return false;
	}

	@Override
	public boolean collisionPoly(Polygon polygon) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean destory() {
		// checks if the bullet is destroyed 
		if(bullet == null)
			return true;
		//else return false 
		return false;
	}

	@Override
	protected void wallCollide(Blocks blocks) {
		// TODO Auto-generated method stub
		//check if the bullet hits the block
		for(int i = 0; i < blocks.wall.size(); i++){
			// if the bullet hits the block then
			if(bullet.intersects(blocks.wall.get(i))){
				//remove that part of the wall
				blocks.wall.remove(i);
				//destry the bullet
				bullet = null;
//				and return 
				return;
			}
		}
		
	}

	@Override
	protected void isOutofBounds() {
		//checks if bullet is destroyed 
		if(this.bullet == null)
			return;
		//if not then check ifs out of bound 
		if(bullet.y < 0 || bullet.y > canvasHeight || bullet.x < 0 || bullet.x > canvasWidth){
			// if it is then destroy the bullet 
			bullet = null;
		}
		
	}

}
