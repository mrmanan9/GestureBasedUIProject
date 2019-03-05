package ie.gmit.sw.Display;

import java.awt.Canvas;

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
		frame.setLayout(null);
		// the size of the canvas 
		frame.setSize(770,652);
		
		//start the thread
		display.start();
	}

	// shares resources 
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
		
		while(running) {
			counter++;
			if(counter == 1000) {
				System.out.println("The Game is Running");
			}
		}
	}// end of run method 
}
