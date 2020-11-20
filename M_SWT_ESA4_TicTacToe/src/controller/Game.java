package controller;

/**
 * @author Grit Kohlmann
 */

public class Game extends BugHandling{
	
	private char[][] board;
	private char currentPlayer;

	public Game() {
		board = new char[3][3];
		currentPlayer = 'x';
		initializeBoard();
	}
	
	public char getCurrentPlayer() {
		return currentPlayer;
	}
	
	public void initializeBoard() {
		for (int i = 0; i < 3; i++ ) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = '-';
			}
		}
	}
	
	public void printBoard() {
		System.out.println("-------------");
		for (int i = 0; i < 3; i++) {
			System.out.print("| ");
			for (int j = 0; j < 3; j++) {
				System.out.print(board[i][j] + " | ");
			}
			System.out.println();
			System.out.println("-------------");
		}		
	}
	
	public boolean checkIfBoardCompleted() {
		
		boolean isCompleted = true;
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == '-') {
					isCompleted = false;
				}
			}
		}
		return isCompleted;
	}
	
	public boolean checkFieldValues(char char1, char char2, char char3) {
		return ((char1 != '-') && (char1 == char2) && (char2 == char3));
	}
	
	private boolean checkRows() {
		for (int i = 0; i < 3; i++) {
			if (checkFieldValues(board[i][0], board[i][1], board[i][2]) == true) {
				return true;
			}
		}
		return false;
	}
	
	private boolean checkColumns() {
		for (int j = 0; j < 3; j++) {
			if (checkFieldValues(board[0][j], board[1][j], board[2][j]) == true) {
				return true;
			}
		}
		return false;
	}
	
	public boolean setDiagonalDown() {
		if (checkFieldValues(board[0][0], board[1][1], board[2][2]) != true) {
			return false; 
		}
		return true;
	}
	
	private boolean setDiagonalUp() {
		if (checkFieldValues(board[0][2], board[1][1], board[2][0]) != true) {
			return false; 
		}
		return true;
	}
	
	private boolean checkDiagonals() {
		return ((setDiagonalDown() == true) || (setDiagonalUp() == true));
	}
	
	public boolean checkAll() {
		return (checkRows() || checkColumns() || checkDiagonals());
	}
	
	public void changePlayer() {
		if(currentPlayer == 'x') {
			currentPlayer = 'o';
		}
		else {
			currentPlayer = 'x';
		}
	}
	
	public boolean setSign (int row, int column) {
		if ((row >= 0) && (row < 3)) {
			if ((column >= 0) && (column < 3)) {
				if (board[row][column] == '-') {
					board[row][column] = currentPlayer;
					return true;
				}
			}
			else {
				callAttentionToBug();
				
			}
		}
		return false;
	}
}