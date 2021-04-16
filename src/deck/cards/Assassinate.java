package deck.cards;

import java.util.UUID;

import deck.Spell;
import game.Board;

public class Assassinate extends Spell {
	private static final long serialVersionUID = 1933803333153797530L;
	private final static String title = "Assassinate";
	private final static String description = "Kill a creature.";
	private final static int cost = 4;
	private final static UUID cardId = UUID.randomUUID();

	public Assassinate() {
		super(title, description, cost);
		// TODO Auto-generated constructor stub
	}

	public UUID getCardId() {
		return cardId;
	}

	@Override
	public void onPlay(Board board) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onDraw(Board board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSentToGrave(Board board) {
		// TODO Auto-generated method stub
		
	}
}
