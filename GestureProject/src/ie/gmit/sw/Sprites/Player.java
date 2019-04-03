package ie.gmit.sw.Sprites;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;

public class Player implements KeyListener{
	
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
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
