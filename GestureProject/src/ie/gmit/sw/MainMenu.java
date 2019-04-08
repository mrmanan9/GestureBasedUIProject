package ie.gmit.sw;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JPanel;

import ie.gmit.sw.Enemy.Enemy;

// JPanel containing the main menu
public class MainMenu extends JPanel implements KeyListener {

	private static final long serialVersionUID = 1L;

	//variables 
	private boolean startGame = false;
	private long score = 0;

	private Color pOverlay = new Color(0, 0, 0, 200);
	// flag for when user pauses/unpauses game
	private boolean paused = false; 
	private boolean startAgain = false; 

	// for flipping 
	private int beatCount = 0;
	private int beat = 0;
	private Enemy[] aliens = {new Enemy(4,75,230),new Enemy(1,88,283),new Enemy(2,83,336),new Enemy(3,82,389)};

	// fonts 
	private Font fontL = new Font ("TimesRoman", Font.TRUETYPE_FONT | Font.ITALIC, 80);
	private Font fontM = new Font ("TimesRoman", Font.TRUETYPE_FONT | Font.ITALIC, 60);

	private Font fontS = new Font ("TimesRoman", Font.TRUETYPE_FONT | Font.ITALIC, 40);


	//main menu 
	public MainMenu() throws IOException, FontFormatException{
		super();
		voce.SpeechInterface.init("./resources", false, true, 
				"./resources", "start");
		setSize(800,700);
		addKeyListener(this);

	}

	public void addNotify(){
		super.addNotify();
		requestFocus();
	}

	public boolean getStatus(){
		return startGame;
	}

	public boolean getPauseStatus(){
		return paused;
	}
	
	public boolean startOver() {
		// TODO Auto-generated method stub
		return startAgain;
	}
	//reset the start game boolean to false after restarting 
	public void setStartOver(boolean b) {
		// TODO Auto-generated method stub
		this.startAgain = b;
	}

	public void setHiScore(long getScore) { score = getScore; }

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {
		// check if p has been pressed
		if (e.getKeyCode() == KeyEvent.VK_P ){
			System.out.println("P pressed for start");
			startGame = true;
		}
	}

	// for startint the game and quiting the menu 
	public void sppech() {

		System.out.println("Say Start!");

		boolean start = false;
		while (!start)
		{
			// Normally, applications would do application-specific things 
			// here.  For this sample, we'll just sleep for a little bit.
			try
			{
				Thread.sleep(300);
			}
			catch (InterruptedException e)
			{
			}
			while (voce.SpeechInterface.getRecognizerQueueSize() > 0)
			{
				String s = voce.SpeechInterface.popRecognizedString();

				//check if s is equal to start 
				if(s.contentEquals("start")) {
					// if it is then end the loop 
					//					start = true;
					//start the game 
					startGame = true;
				}
				else if(s.contentEquals("stop")) {
					paused = true;
				}
				else if(s.contentEquals("continue")) {
					paused = false;
				}
				else if(s.contentEquals("reset")) {
					startAgain = true;
				}
				else{
					s = "empty";
				}
				System.out.println("You said: " + s);
			}

		}

		voce.SpeechInterface.destroy();

	}

	public void paintComponent(Graphics g){
		//this counts how many times looped 
		beatCount += 1;

		if (beatCount%70 == 0) { 
			// move aliens when counter is divisible by beat modifier
			beat = 1 - beat; 
			// flips between 1 and 0
			beatCount = 0;
		}

		//menu background set color and fill 
		g.setColor(Color.BLACK); 
		g.fillRect(0,0,800,700);

		//Set the text here 
		Graphics2D comp2D = (Graphics2D)g;
		//chose the colour 
		g.setColor(Color.WHITE);
		comp2D.setFont(fontL);
		// name of the project or title 
		comp2D.drawString("Gesture Project",83,160);
		comp2D.setFont(fontM);

		// this is used to draw the alien images for x and y pos 
		int posX = 120;
		int posY = 270;

		// Initialize a colour var
		Color c;

		// here get the alien images from the array 
		// and draw them
		for(int i=1;i<4;i++){
			//get the image 
			Image alien = aliens[i].getImage(beat);

			//this just sets the background colour of the alien images 
			if(i == 2){
				c = Color.RED;
			}else if(i == 3) {
				c = Color.GREEN;
			}else {
				c = Color.BLUE;
			}

			//Separate the image by multiplying the x-axis by 120 to separate them
			g.drawImage(alien, posX + ( i*120), posY, c, null);
		}

		// other text 
		comp2D.drawString("Say Start",250,420);

	}
}
