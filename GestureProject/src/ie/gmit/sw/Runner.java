package ie.gmit.sw;

import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;

import ie.gmit.sw.Block.Shield;
import ie.gmit.sw.Bullet.BulletMan;
import ie.gmit.sw.Cannon.Player;
import ie.gmit.sw.Enemy.AlienMan;
import ie.gmit.sw.Score.Scorekeeper;

public class Runner extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;

	private javax.swing.Timer myTimer;

	// first JPanel
	private static MainMenu menu; 
	private boolean gameStart = false;
	
	//check if game is paused 
	private boolean paused = false;
	//start again
	private boolean startAgain;

	// component classes of the game
	private static Listener overseer;
	private Player player;
	private AlienMan enemies;
	private Scorekeeper score;
	private Shield shield;
	private BulletMan shotsFired;
	//number of wins by the user, keeps track of subsequent alien start location
	private int wave = 0; 

	public Runner() throws IOException, FontFormatException{
		super("GUI Project");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(null);
		setSize(770,652);

		menu = new MainMenu();
		score = new Scorekeeper();

		menu.setHiScore(score.getHiScore());

		//add menu to the jfrmae 
		add(menu);

		myTimer = new javax.swing.Timer(10,this); // update every 10 ms
		myTimer.start();

		setResizable(false);
		setVisible(true);
	}

	private void nextLevel() throws IOException, FontFormatException { 
		// called every time user wins (all aliens destroyed), resets game setup
		remove(overseer);
		if (wave < 10){
			wave += 1;
		}
		player.addLife();
		enemies = new AlienMan(wave,score,player,shield);
		shotsFired = new BulletMan(player,enemies,shield);
		overseer = new Listener(player,enemies,score,shield,shotsFired);
		add(overseer);
	}

	private void startOverGame() throws IOException, FontFormatException {

		if (overseer != null){
			remove(overseer);
		}

		wave = 0;
		player = new Player();
		shield = new Shield();
		score.setShip(player);
		score.resetScore();
		enemies = new AlienMan(wave,score,player,shield);
		shotsFired = new BulletMan(player,enemies,shield);
		overseer = new Listener(player,enemies,score,shield,shotsFired);
		add(overseer);
	}

	public void actionPerformed(ActionEvent evt){ // event listener stuff, update classes every 10 ms
	
		Object source = evt.getSource();
		//check if paasued or not
		paused = menu.getPauseStatus();
		
		if(source == myTimer){
			if (gameStart) {
				if (overseer.stillPlaying() && !overseer.isPaused() && !player.gotHit()) { 
					// only move when not paused and player still alive
					overseer.move(); // move player
					if (enemies.metronome()) { // if aliens have moved
						shotsFired.setAlienShots(enemies.attack()); // launch attack
					}
					enemies.ufoTrack(); // move mystery UFO regardless of beat
					shotsFired.trackBullets(); // move shots if they exist
				}

				if (!overseer.stillPlaying()) {
					
					// start again
					startAgain = menu.startOver();
					
					//delete everything
					enemies.ufoDestroy();
					score.calculateHiScore();
					
					//start again
					if(startAgain) {
						try {
							menu.setStartOver(false);
							startOverGame();
						} catch (IOException | FontFormatException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				}

				overseer.repaint();

				if (enemies.aliensGone()) { // if no aliens left
					// error handling in case font doesn't exist
					try {
						nextLevel();
					} catch (IOException e) {
						e.printStackTrace();
					} catch (FontFormatException e) {
						e.printStackTrace();
					}
				}

				if (overseer.doRestartGame()) { // check if player wants to restart game
					// error handling in case font doesn't exist
					try {
						startOverGame();
					} catch (IOException e) {
						e.printStackTrace();
					} catch (FontFormatException e) {
						e.printStackTrace();
					}
				}
				
				// this here pasues the game but atm moment its very buggy 
				// unpause this for the pasue menu 
				if(paused) {
					overseer.setPaused(true);
					overseer.repaint();
				}
				if(!paused) {
					overseer.setPaused(false);
					overseer.repaint();
				}
			}
			else {
				gameStart = menu.getStatus();
				if (gameStart){ // initialize if player starts game
					remove(menu);

					// error handling in case font doesn't exist
					try {
						startOverGame();
					} catch (IOException e) {
						e.printStackTrace();
					} catch (FontFormatException e) {
						e.printStackTrace();
					}
				}
				
				menu.repaint();
			}
			
		}
	}

	public static void main(String[]args) throws IOException, FontFormatException{
		new Runner();

		// run the speech recognition to start the game 
		menu.sppech();

	}
}
