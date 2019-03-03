package ie.gmit.sw;

import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;

public class Runner extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	public Runner() {
		//this is the title of the jframe 
		super("GUI Project");
		// if the x is pressed then JFrame exits 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //the layout
        setLayout(null);
        // the size of the canvas 
        setSize(770,652);
        
        //displays the canvas
        setResizable(false);
        setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[]args) throws IOException, FontFormatException{
        new Runner();
    }
}
