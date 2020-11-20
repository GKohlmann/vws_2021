package controller;

/**
 * @author Grit Kohlmann
 */

public abstract class Player {
	
	public static char currentPlayer = 'x';
    
	public Player(char CURRENTPLAYER) {
		currentPlayer = CURRENTPLAYER;
	}
	
	public void changePlayer(char CURRENTPLAYER) {
		currentPlayer = CURRENTPLAYER;
		
		if(currentPlayer == 'x') {
			currentPlayer = 'o';
		}
		else {
			currentPlayer = 'x';
		}
	}

}
