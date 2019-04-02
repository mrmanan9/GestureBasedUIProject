package ie.gmit.sw.StateMachine;

import java.awt.Canvas;
import java.awt.Graphics2D;

public interface Statator {
	
	//interface for the state machine
	public void update(double delta);
	public void draw(Graphics2D g);
	public void init(Canvas canvas);

}
