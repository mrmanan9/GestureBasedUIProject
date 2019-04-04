package ie.gmit.sw.Bullets;

import java.awt.Graphics2D;
import java.util.ArrayList;

import ie.gmit.sw.Sprites.Blocks;
import ie.gmit.sw.Sprites.Timer;

public class CannonBullet {
	//arraylist 
	public ArrayList<CannonBulletsTypes> weapons = new ArrayList<CannonBulletsTypes>();
	
	//timer 
	private Timer timer;

	//draw 
	public void draw(Graphics2D g){
		for(int i = 0; i < weapons.size(); i++){
			weapons.get(i).draw(g);
		}
	}
	//update 
	public void update(double delta, Blocks blocks){

		for(int i = 0; i < weapons.size(); i++){
			weapons.get(i).update(delta, blocks);
			//check if the weapon is destroyed them remove 
			if(weapons.get(i).destory()) {
				weapons.remove(i);
			}
		}
	}
	
	public void shootBullet(double xPos, double yPos, int width, int height){
		weapons.add(new Gun(xPos + 22, yPos + 15, width, height));
	}

}
