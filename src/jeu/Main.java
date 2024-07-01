package jeu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Main {
	private static Scanner choix = new Scanner(System.in);
	private static int counter=0;


	public static void main(String[] args){
		JButton b0 =new JButton();
		JButton b1 =new JButton();
		JButton b2 =new JButton();
		JButton b3 =new JButton();
		JButton b4 =new JButton();
		JButton b5 =new JButton();
		JButton b6 =new JButton();
		JButton b7 =new JButton();
		JButton b8 =new JButton();	
	
		MyPanel fond = new MyPanel(); //create a fond
		fond.addImage("src//fondTictactoe.png", 0, 0);
			
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(505,505);
		
		// Set bounds and properties for each button
        setButtonProperties(b0, 0, 0);
        setButtonProperties(b1, 170, 0);
        setButtonProperties(b2, 342, 0);
        setButtonProperties(b3, 0, 162);
        setButtonProperties(b4, 170, 164);
        setButtonProperties(b5, 342, 162);
        setButtonProperties(b6, 0, 342);
        setButtonProperties(b7, 170, 342);
        setButtonProperties(b8, 342, 342);

        JButton[] boutons = {b0,b1,b2,b3,b4,b5,b6,b7,b8};
        for (int i=0; i<9;i++) {
        	frame.add(boutons[i]);
        }

        frame.add(fond);
		frame.setVisible(true);
		start_Game(boutons,fond);		
	}
	
	private static void setButtonProperties(JButton button, int x, int y) {
        button.setBounds(x, y, 156, 156);
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
    }
	
	private static void setActionListener(JButton b, int i, MyPanel fond, Jouer partie) {
		b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if (counter % 2==0) {
            		drawMove(i,0,fond);
            		partie.play(i, 0);
            	}
            	else {
            		drawMove(i,1,fond); 
            		partie.play(i, 1);
            	}
            	counter++;
            	b.setEnabled(false);
                fond.revalidate();
                fond.repaint();
                
            }
        });
		
	}

	
	public static void start_Game(JButton[] boutons,MyPanel fond) {
		ImageIcon logo = new ImageIcon("src//smile.jpg");

		
		Jouer partie= new Jouer();
		
		//int moveJ1=0;
		//int moveJ2=0;
		ArrayList<Integer> legal_move=partie.playableMove();
		
		boolean verif=true;
		for (int i=0; i<9;i++) {
        	setActionListener(boutons[i],i,fond,partie);
        }
		partie.pretty_Printing();
		
		while (legal_move.size()>0 && !(partie.winningState(0) || partie.winningState(1))) {
			
			/*System.out.println("Player 1, you can play these moves :");
			print_List(legal_move);
			System.out.println("What is your choice : ");
			moveJ1=choix.nextInt();
						
			partie.play(moveJ1, 0);
			drawMove(moveJ1,0,fond);*/

			//partie.pretty_Printing();
			if (partie.winningState(0)) {
				System.out.println("Player 1, you won !");
				verif=false;
				for (int i=0; i<9;i++) {
		        	boutons[i].setEnabled(false);
		        }
	            JOptionPane.showOptionDialog(null, "Player 1, you won!","Results",JOptionPane.PLAIN_MESSAGE,JOptionPane.PLAIN_MESSAGE,logo,null,null);
				break;
			}
			/*legal_move=partie.playableMove();
			System.out.println("Player 2, you can play these moves :");
			print_List(legal_move);
			System.out.println("What is your choice : ");
			//moveJ2=choix.nextInt();
			
			partie.play(moveJ2, 1);
			
			//drawMove(moveJ2,1,fond);

			legal_move=partie.playableMove();
			partie.pretty_Printing();*/
		}
		if (partie.winningState(0) && verif) {
			System.out.println("Player 1, you won !");
			for (int i=0; i<9;i++) {
	        	boutons[i].setEnabled(false);
	        	
	        }
            JOptionPane.showOptionDialog(null, "Player 1, you won!","Results",JOptionPane.PLAIN_MESSAGE,JOptionPane.PLAIN_MESSAGE,logo,null,null);
		}
		else if (partie.winningState(1)) {
			System.out.println("Player 2, you won !");
			for (int i=0; i<9;i++) {
	        	boutons[i].setEnabled(false);
	        }
            JOptionPane.showOptionDialog(null, "Player 2, you won!","Results",JOptionPane.PLAIN_MESSAGE,JOptionPane.PLAIN_MESSAGE,logo,null,null);
		}
		else if (!(partie.winningState(0)) && !(partie.winningState(1))){
			System.out.println("It's a tie, well done ! ");
            JOptionPane.showOptionDialog(null, "It's a tie, well done !","Results",JOptionPane.PLAIN_MESSAGE,JOptionPane.PLAIN_MESSAGE,logo,null,null);

		}
	}
	
	
	public static void drawMove(int cell, int y, MyPanel pan) {
		String ImagePath;
		if (y==0) {
			ImagePath="src//croixTictactoe.png";
		}
		else {
			ImagePath="src//cercleTictactoe.png";		
		}
		switch (cell) {
			case 0 :
				pan.addImage(ImagePath,0,0);
				break;
			case 1 :
				pan.addImage(ImagePath,170,0);
				break;
			case 2 :
				pan.addImage(ImagePath,342,0);
				break;
			case 3 :
				pan.addImage(ImagePath,0,162);
				break;
			case 4 :
				pan.addImage(ImagePath,170,164);
				break;
			case 5 :
				pan.addImage(ImagePath,342,162);
				break;
			case 6 :
				pan.addImage(ImagePath,0,342);
				break;
			case 7 :
				pan.addImage(ImagePath,170,342);
				break;
			case 8 :
				pan.addImage(ImagePath,342,342);
				break;
			}
	}

	
	
	
	public static void print_List(ArrayList<Integer> list) {
		for (int elem : list) {
			System.out.print(elem + " | ");
		}
		System.out.println();
		
	}
	


}
