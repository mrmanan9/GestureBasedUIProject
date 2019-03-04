package ie.gmit.sw;

<<<<<<< HEAD
import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
=======
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
>>>>>>> 6b0c586... added the runner file

import javax.swing.JFrame;

public class Runner extends JFrame implements ActionListener{

<<<<<<< HEAD
	private static final long serialVersionUID = 1L;
	
	public Runner() {
		super("GUI Project");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLayout(null);
        setSize(770,652);
        
        setResizable(false);
        setVisible(true);
	}
=======
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
>>>>>>> 6b0c586... added the runner file

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
<<<<<<< HEAD
	
	public static void main(String[]args) throws IOException, FontFormatException{
        new Runner();
    }
=======
>>>>>>> 6b0c586... added the runner file
}
