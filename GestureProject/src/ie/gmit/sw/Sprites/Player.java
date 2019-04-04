package ie.gmit.sw.Sprites;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;

import ie.gmit.sw.Display;

public class Player implements KeyListener{
	
	//speed of the cannon 
	private final double speed = 5.0d;
	
	// player sprite 
	private BufferedImage player;
	
	//variables
	private double xpos, ypos;
	private int width, height;
	
	//rectangle
	private Rectangle rect;
	
	// this is for movement and shooting
	private boolean left = false;
	private boolean	right = false;
	private boolean	shoot = false;
	
	//constructor 
	public Player(double xpos, double ypos, int width, int height) {
		this.xpos = xpos;
		this.ypos = ypos;
		this.height = height;
		this.width = width;
		
		//make a new rectangle 
		rect = new Rectangle((int)xpos, (int)ypos, width, height);
		try {
			//open the cannon image 
			player = ImageIO.read(new File("./Images/cannon.png"));
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	//draw the image here 
	public void draw(Graphics2D g) {
		// draw cannon //at the positions given
		g.drawImage(player,(int) xpos,(int) ypos, width, height, null);
	}
	
	public void update(double delta){
		//770 is the width of the canvas 
		// turn right if the right key is pressed 
		if(right && !left && xpos < 748 - width){
			xpos += speed * delta;
			rect.x = (int) xpos;
		// turn left if the left key is pressed 
		}if(!right && left && xpos > 10){
			xpos -= speed * delta;
			rect.x = (int) xpos;
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		//get the key value from user 
		int key = arg0.getKeyCode();
		// if the right key is pressed the right = true
		if(key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT){
			right = true;
			// if the left key is pressed then left is true 
		}else if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT){
			left = true;
		}
		// space for shooting 
		if (key == KeyEvent.VK_SPACE){
			shoot = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		int key = arg0.getKeyCode();
		//when the right key is released right is false 
		if(key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT){
			right = false;
		//when the left key is released left is false 
		}else if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT){
			left = false;
		}
		//space released shotting stops 
		if (key == KeyEvent.VK_SPACE){
			shoot = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
