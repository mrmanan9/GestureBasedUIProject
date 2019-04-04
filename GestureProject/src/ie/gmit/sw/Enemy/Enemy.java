package ie.gmit.sw.Enemy;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import ie.gmit.sw.Sprites.Blocks;
import ie.gmit.sw.Sprites.Player;
import ie.gmit.sw.Sprites.Sprite;

public class Enemy implements EnemyType{
	
	//create rectangle for bullet
	private Rectangle rectangle;
	
	//speed 
	private double speed = 1.0d; 
	
	//sprite for enemy
	private Sprite enemy;
	
	// this is the height and widgth of the canvas 
	private float canvasWidth = 770;
	private float canvasHeight = 652;
	
	ArrayList<BufferedImage> bfArray = new ArrayList<>();
	
	public Enemy(double xPos, double yPos, int width, int height, String imgPath){
		
		enemy = new Sprite(xPos, yPos,width,height, 300);
		
		try {
			//open the cannon image 
			BufferedImage bfEnemy1 = ImageIO.read(new File("./Images/a1.png"));
			BufferedImage bfEnemy2 = ImageIO.read(new File("./Images/b1.png"));
			
			bfArray.add(bfEnemy1);
			bfArray.add(bfEnemy2);
			
			for (int i = 0; i < 2; i++) {
				enemy.addSprite(bfArray.get(i), 0 +(i*88), 0, 88, 88);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		this.setRectangle(new Rectangle((int) enemy.getXpos(), (int) enemy.getYpos(), width, height));
		enemy.setLoop(true);
	}

	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		enemy.draw(g);
	}

	@Override
	public void update(double delta, Player player, Blocks blocks) {
		// TODO Auto-generated method stub
		enemy.update(delta);
	}

	@Override
	public void changeDirection(double delta) {
		// TODO Auto-generated method stub
		speed *= -1.15d;
		enemy.setXpos(enemy.getXpos() - (delta * speed));
		this.getRectangle().x = (int) enemy.getXpos();
		
		enemy.setYpos(enemy.getYpos() + (delta * 15));
		this.getRectangle().y = (int) enemy.getYpos();
	}

	@Override
	public boolean deathScene() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean collide(int i, Player player, Blocks blocks, ArrayList<EnemyType> enemies) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isOutOfBounds() {
		if(rectangle.x > 0 && rectangle.x < canvasWidth - rectangle.width)
			return false;
		return true;
	}
	
	///getters and setters 
	public Rectangle getRectangle() {
		return rectangle;
	}

	public void setRectangle(Rectangle rectangle) {
		this.rectangle = rectangle;
	}

	

}
