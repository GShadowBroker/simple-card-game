package deck.cards;

import java.util.UUID;

import deck.Spell;
import exceptions.NoMoreCardsToDrawException;
import game.Board;

public class KingsBlessing extends Spell {
	private static final long serialVersionUID = 912582372931969163L;
	private final static String title = "King's Blessing";
	private final static String description = "Draw two cards.";
	private final static int cost = 2;
	private final static UUID cardId = UUID.randomUUID();

	public KingsBlessing() {
		super(title, description, cost);
	}

	public UUID getCardId() {
		return cardId;
	}

	@Override
	public void onPlay(Board board) throws NoMoreCardsToDrawException {
		System.out.printf("%s's effect activated! %s\n", title, description);
		board.getTurnPlayer().draw(2);
	}

	@Override
	public void onDraw(Board board) throws NoMoreCardsToDrawException {

	}

	@Override
	public void onSentToGrave(Board board) {
		// TODO Auto-generated method stub

	}

}
