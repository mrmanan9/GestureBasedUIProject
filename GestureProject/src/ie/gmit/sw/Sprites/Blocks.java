package ie.gmit.sw.Sprites;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Blocks {
	
	//  create a arraylist for 
	//handle collision 
	public ArrayList<Rectangle> wall = new ArrayList<Rectangle>();
	
	//constructor
	public Blocks(){
		//make for blocks 
		makeBlocks(55, 450);
		makeBlocks(255, 450);
		makeBlocks(455, 450);
		makeBlocks(655, 450);
	}
	
	public void makeBlocks(int xPos, int yPos){
		
		//variables 
		int wallWidth = 3;
		int x = 0;
		int y = 0;
		
		//create a for loop
		for(int i = 0; i < 13; i++){
			if((14 + (i * 2) + wallWidth < 22 + wallWidth)){
				// find the xpos - i * 3
				row(14 + (i * 2) + wallWidth, xPos - (i * 3), yPos + (i * 3));
				x = (i * 3) + 3;
			}else{
				row(22 + wallWidth, xPos - x, yPos + (i * 3));
				y = (i * 3);
			}
		}
		
	}

	//this method to organise each block we create 
	public void row(int rows, int xPos, int yPos){
		for(int i = 0; i < rows; i++){
			//create rectangle 
			Rectangle brick = new Rectangle(xPos + (i * 3), yPos, 3, 3);
			wall.add(brick);
		}
	}
	
	//draw blocks
	public void draw(Graphics2D g){
		//set the color 
		g.setColor(Color.WHITE);
		for(int i = 0; i < wall.size(); i++){
			g.fill(wall.get(i));
		}
	}
}
