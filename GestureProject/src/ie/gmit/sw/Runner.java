package ie.gmit.sw;

import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;

public class Runner extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	public Runner() {
		super("GUI Project");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLayout(null);
        setSize(770,652);
        
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
