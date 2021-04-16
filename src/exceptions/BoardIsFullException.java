package exceptions;

public class BoardIsFullException extends Exception {

	/**
	 * this exception occurs when the player tries to play a card when the board is full.
	 **/
	private static final long serialVersionUID = 4496536163003645026L;

	public BoardIsFullException() {
		super("The board is full. Cannot play more cards onto the field.");
	}

}
