package ie.gmit.sw.Score;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import ie.gmit.sw.Cannon.Player;

//scores 
public class Scorekeeper{
	
	// user score
	private long score = 0; 
	 // stored hi score
    private long hiScore = 0;
    private Player ship;

    //score font 
    private Font font = new Font ("TimesRoman", Font.TRUETYPE_FONT | Font.PLAIN, 30);

    private BufferedReader inFile;
    private File highScore;
    private BufferedWriter outFile;

    public Scorekeeper() throws IOException, FontFormatException {
        highScore = new File("src/score.txt"); // get hi score
        inFile = new BufferedReader(new FileReader(highScore));
        try{
            hiScore = Long.parseLong(inFile.readLine(),10);
        }
        catch (NumberFormatException e){
            hiScore = 0;
        }
        inFile.close();
    }

    // gets ship data from other classes
    public void setShip(Player getShip) { ship = getShip; }

    public long getHiScore() { return hiScore; }

    public void add(long toAdd){
        score += toAdd;
    } // method used to add to score

    public void resetScore() { score = 0; } // resets core when user loses then restarts game

    // compares stored hi score value with current score; overwrites if larger
    // thanks to http://stackoverflow.com/questions/13729625/overwriting-txt-file-in-java
    public void calculateHiScore(){
        try {
            if (score > hiScore){
                highScore.delete();
                highScore = new File("src/hiscore.txt");
                outFile = new BufferedWriter(new FileWriter(highScore,false));
                outFile.write(String.valueOf(score));
                outFile.close();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void draw(Graphics g){ 
    	// draws score, user lives on screen
        Graphics2D comp2D = (Graphics2D)g;
        comp2D.setColor(Color.WHITE);
        comp2D.setFont(font);

        String pointString = "SCORE: " + score;
        if (pointString.length() > 19){
        	// prevents score from overflowing on screen
            score = 999999999999L;
            pointString = "SCORE: 999999999999";
        }
        comp2D.drawString(pointString,27,26);
        comp2D.drawString("LIVES x "+ship.getLives(),487,26);
    }
}
