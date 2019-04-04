package ie.gmit.sw.Screen;

import java.awt.Canvas;
import java.awt.Graphics2D;

import ie.gmit.sw.Sprites.Player;
import ie.gmit.sw.StateMachine.Statator;

public class GameScreen implements Statator{
	
	//player cannon
	private Player cannon;
	// this is the height and widgth of the canvas 
	private float canvasWidth = 770;
	private float canvasHeight = 652;
	
	public GameScreen(){
		// send the constructor the positions 
		cannon = new Player(canvasWidth/2-50,canvasHeight-100 , 50, 50);
	}

	@Override
	public void update(double delta) {
		// TODO Auto-generated method stub
		cannon.update(delta);
	}

	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		// draw the cannon 
		cannon.draw(g);
	}

	@Override
	public void init(Canvas canvas) {
		// add the player listener to the canvas 
		// TODO Auto-generated method stub
		canvas.addKeyListener(cannon);
	}

}
