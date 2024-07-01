package jeu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class MyFrame extends JFrame implements ActionListener{
	MyPanel fond;
	
	public MyFrame() {
		
		fond = new MyPanel(); //create a fond
		fond.addImage("src//fondTictactoe.png", 0, 0);
			
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(505,505);
		frame.add(fond);
		frame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
