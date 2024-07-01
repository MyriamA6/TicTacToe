package jeu;

import java.util.ArrayList;

public class Jouer {
	private int[][] state= {{-1,-1,-1},{-1,-1,-1},{-1,-1,-1}};

	public Jouer() {
	}
	
	public boolean winningState(int y) {
		boolean res = false;
		for (int i=0;i<3; i++) {
			boolean tp= true;
			for(int j=0;j<3;j++) {
				tp = tp && (state[i][j]==y);
			}
			res = res || tp;
		}
		
		for (int i=0; i<3; i++) {
			res = res || (state[0][i]==y && state[1][i]==y && state[2][i]==y);
		}
		
		res= res || (state[0][0]==y && state[1][1]==y && state[2][2]==y) || (state[0][2]==y && state[1][1]==y && state[2][0]==y);
		return res;
	}
	
	public ArrayList<Integer> playableMove() {
		ArrayList<Integer> legal_move= new ArrayList<Integer>();
		int cpt=0;
		for (int i=0;i<3; i++) {
			for(int j=0;j<3;j++) {
				if (state[i][j]==-1) {
					legal_move.add(cpt);
				}
				cpt++;
			}
		}
		return legal_move;
	}
	
	public void play (int cell, int y) {
		ArrayList <Integer> legal_move = playableMove();
		if (legal_move.contains(cell)){
			switch (cell) {
	    		case 0 :
	    			state[0][0]=y;
	    			break;
	    		case 1 :
	    			state[0][1]=y;
	    			break;
	    		case 2 :
	    			state[0][2]=y;
	    			break;
	    		case 3 :
	    			state[1][0]=y;
	    			break;
	    		case 4 :
	    			state[1][1]=y;
	    			break;
	    		case 5 :
	    			state[1][2]=y;
	    			break;
	    		case 6 :
	    			state[2][0]=y;
	    			break;
	    		case 7 :
	    			state[2][1]=y;
	    			break;
	    		case 8 :
	    			state[2][2]=y;
	    			break;
			}
		}
		else {
			System.out.println("Impossible move");
		}
	}
	
	public void pretty_Printing() {
		int i=0;
		for(int j=0; j<3;j++) {
			System.out.println(""+state[j][0]+" | "+state[j][1]+" | "+state[j][2]);
			if (i<2) {
				System.out.println("-------------");
			}
			i+=1;
		}
	}
}
