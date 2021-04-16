package exceptions;

public class NoMoreCardsToDrawException extends Exception {

	/**
	 * this exception occurs when the player tries to draw more cards than his deck
	 * size, which causes him to lose the game.
	 **/
	private static final long serialVersionUID = -1316914592413868469L;

	public NoMoreCardsToDrawException() {
		super("Player tried to draw more cards than his deck size.");
	}

}
