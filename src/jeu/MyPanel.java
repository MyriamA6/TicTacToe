package jeu;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MyPanel extends JPanel{
	
	ArrayList<Image> images;
	ArrayList<ArrayList<Integer>> positions;
	
	public MyPanel() {
		images=new ArrayList<Image>();
		positions = new ArrayList<ArrayList<Integer>>();
		this.setPreferredSize(new Dimension(505,505));
	}
	
	public void addImage(String imagePath, int x, int y) {
        Image img = new ImageIcon(imagePath).getImage();
        images.add(img);
        ArrayList<Integer> position= new ArrayList<Integer>();
        position.add(x);
        position.add(y);
        positions.add(position);
        repaint(); // Redessine le panneau pour afficher la nouvelle image
    }
	
	public void paint(Graphics g){
		Graphics2D g2 =(Graphics2D) g;
        for(int i=0; i<images.size();i++) {
        	g2.drawImage(images.get(i), positions.get(i).get(0),positions.get(i).get(1),this);
        }
   }

}
