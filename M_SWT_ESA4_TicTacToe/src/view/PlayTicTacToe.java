package view;

import java.util.Scanner;
import controller.Game;
import controller.Player;

/**
 * @author Grit Kohlmann
 */

public class PlayTicTacToe extends Player{
	
	public PlayTicTacToe (char CURRENTPLAYER) {
		super(currentPlayer);
	}

	public static void main(String[] args) {
		
		Scanner eingabe = new Scanner(System.in);
		Game game = new Game();
		game.initializeBoard();
		
		System.out.println("New game, new chance!");
		
		do {
			game.printBoard();
			
			int row = 0;
			int column = 0;
			
			
			do {
				System.out.println("Player " + game.getCurrentPlayer() + ", to place your sign please:\n"
						+ "enter the number of the row, a blank and the number of the column.");
				
				row = eingabe.nextInt() - 1;
				column = eingabe.nextInt() - 1;	
			}
			while (!game.setSign(row, column));
			
			game.changePlayer();
			
		}
		while(!game.checkAll() && !game.checkIfBoardCompleted());
		
		if (game.checkIfBoardCompleted() && !game.checkAll()) {
			System.out.println("This game ended up in a tie.");
		}
		else {
			game.printBoard();
			game.changePlayer();
			System.out.println(Character.toUpperCase(currentPlayer) + ": Congrats.");
		}
	}


}
