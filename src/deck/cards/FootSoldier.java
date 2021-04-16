package deck.cards;

import deck.Creature;
import exceptions.NoMoreCardsToDrawException;
import game.Board;

public class FootSoldier extends Creature {
	private static final long serialVersionUID = 4172474633951134242L;
	private static final String title = "Foot Soldier";
	private static final String description = String.format("When %s dies, draw one card.", title);
	private static final int cost = 1;
	private static final int health = 1;
	private static final int attack = 1;
	private static final int defense = 1;

	public FootSoldier() {
		super(title, description, cost, health, attack, defense);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onAttack() {
		// TODO Auto-generated method stub
		super.onAttack();
	}

	@Override
	public void onDeath() {
		// TODO Auto-generated method stub
		super.onDeath();
	}

	@Override
	public void onPlay(Board board) throws NoMoreCardsToDrawException {
		// TODO Auto-generated method stub

	}

	@Override
	public void onDraw(Board board) throws NoMoreCardsToDrawException {
		// TODO Auto-generated method stub

	}

	@Override
	public void onSentToGrave(Board board) throws NoMoreCardsToDrawException {
		System.out.printf("%s's effect activated! %s\n", title, description);
		board.getTurnPlayer().draw();
	}

}
