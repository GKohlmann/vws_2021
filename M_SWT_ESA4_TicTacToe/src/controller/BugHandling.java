package controller;

/**
 * @author Grit Kohlmann
 */

public abstract class BugHandling implements BugHandlingActions{
	
	public void callAttentionToBug() {
		System.out.println("Attention: your input is invalid! Please try again.");
	}
}
