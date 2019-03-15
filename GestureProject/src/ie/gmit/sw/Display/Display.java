package ie.gmit.sw.Display;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Display extends Canvas implements Runnable{

	// variables 
	private static final long serialVersionUID = 1L;

	//Thread
	private boolean running = false;
	private Thread thread;

	//displays and where the program first starts 
	public static void main(String[] args) {

		//intialise the display class 
		Display display = new Display();

		//set the jframe window 
		// this is for when we run the prograam on the desktop
		JFrame frame = new JFrame();
		// add the canvas to the jframe 
		frame.add(display);
		frame.pack();
		// set the name of the jframe
		frame.setTitle("GUI Project");

		// if the x is pressed then JFrame exits 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//displays the canvas
		// cant change the size of the canvas
		frame.setResizable(false);
		frame.setVisible(true);

		//the layout
		//frame.setLayout(null);
		// the size of the canvas 
		frame.setSize(770,652);
		
		//start the thread
		display.start();
	}

	// shares resources 
	// run the thread
	public synchronized void start() {
		//each time this is run this will share the resources with another thread
		if(running) {
			return;
		}

		running = true;
		thread =  new Thread(this);

		//start the thread
		thread.start();
	}
	
	//stop the thread 
	public synchronized void stop() {
		//stop the thread
		if(running) {
			return;
		}
		running = false;
		
		// stop the thread 
		try {
			thread.join();
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}// print error if doesnt 
	}

	//implement runnable 
	@Override
	public void run() {
		
		//make a counter so it prints the game is running 
		// after 1000 times
		int counter = 0;
		int FPS;
		
		//get the current time 
		long timer = System.currentTimeMillis();
		long lastLoopTime = System.nanoTime();
		final int TARGET_FPS = 60;
		final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;
		int frames = 0;
		
		//create createBufferStrategy to start drawing the game 
		this.createBufferStrategy(3);
		BufferStrategy bs = this.getBufferStrategy();

		while(running) {
			
			// this here is to change the sprite fps
			long now = System.nanoTime();
			long updateLength = now - lastLoopTime;
			lastLoopTime = now;
			double delta = updateLength / ((double) OPTIMAL_TIME);
			
			//update the frame 
			frames++;
			
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				FPS = frames;
				frames = 0;
				System.out.println(FPS);
			}
			
			// call the draw method 
			draw(bs);
			update(delta);
			
			try {
				Thread.sleep(((lastLoopTime - System.nanoTime()) + OPTIMAL_TIME) / 1000000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			counter++;
			if(counter == 1000) {
				System.out.println("The Game is Running");
			}
		}
		
	}// end of run method 
	
	public void draw(BufferStrategy bs) {
		// this is a good way to use buffered image so there isnt
		// a flicker also it doesnt take too many resources
		do {
			do {
				// this here sets the background color to black
				Graphics2D g = (Graphics2D) bs.getDrawGraphics();
				g.setColor(Color.BLACK);
				// file the whole jframe black 
				// give it some extra height and width
				g.fillRect(0, 0, 825,710);
			
				// dispose when done 
				g.dispose();
				
			} while (bs.contentsRestored());
			//shows the current thing that was drawn 
			bs.show();
		}  while (bs.contentsLost());	
	}
	
	// this will change the position from the update 
	public void update(double delta) {
		
	}
}
