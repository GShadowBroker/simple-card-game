package exceptions;

public class NotEnoughManaException extends Exception {
	private static final long serialVersionUID = -2846235451777199558L;

	public NotEnoughManaException() {
		super("Player doesn't have enough mana for the action.");
	}
}
