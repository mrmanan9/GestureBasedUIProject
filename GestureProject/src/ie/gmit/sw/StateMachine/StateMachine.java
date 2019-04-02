package ie.gmit.sw.StateMachine;

import java.awt.Canvas;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class StateMachine {
	
	//arraylist
	private ArrayList<Statator> states = new ArrayList<Statator>();
	// intialise the canvas 
	private Canvas canvas;
	private byte selectState = 0;
	
	public StateMachine(Canvas canvas) {
		//assign canvas 
		this.canvas = canvas;
	}

	//update the canvas 
	public void update(double delta) {
		// TODO Auto-generated method stub
		states.get(selectState).update(delta);
	}

	//draw on canvas 
	public void draw(Graphics2D g) {
		states.get(selectState).draw(g);
		
	}
	//remove key listener from canvas 
	public void setState(byte i) {
		for (int j = 0; j < canvas.getKeyListeners().length; j++) {
			canvas.removeKeyListener(canvas.getKeyListeners()[j]);	
		}	
		states.get(selectState).init(canvas);	
	}
	
	
	//getters and setters 
	public byte getStates() {
		return selectState;
	}
	
	
}
