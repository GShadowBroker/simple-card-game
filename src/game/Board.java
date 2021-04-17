package game;

import java.io.Serializable;

import deck.Creature;
import exceptions.NoMoreCardsToDrawException;

public class Board implements Serializable {
	private static final long serialVersionUID = -5731207966560116089L;
	private Player player1;
	private Player player2;
	private Player turnPlayer;
	private Player oppositeTurnPlayer;
	private int turn = 1;
	private int round = 1;

	public Board(Player player1, Player player2) {
		setP1(player1);
		setP2(player2);

		setRandomStartingPlayer();
	}

	// Getters and Setters
	public Player getP1() {
		return player1;
	}

	private void setP1(Player player1) {
		this.player1 = player1;
	}

	public Player getP2() {
		return player2;
	}

	private void setP2(Player player2) {
		this.player2 = player2;
	}

	public Player getTurnPlayer() {
		return turnPlayer;
	}

	private void setTurnPlayer(Player turnPlayer) {
		this.turnPlayer = turnPlayer;
	}

	public Player getOppositeTurnPlayer() {
		return oppositeTurnPlayer;
	}

	private void setOppositeTurnPlayer(Player oppositeTurnPlayer) {
		this.oppositeTurnPlayer = oppositeTurnPlayer;
	}

	private void setRandomStartingPlayer() {
		int rand = (int) (Math.random() * 2);
		if (rand > 0) {
			setTurnPlayer(player1);
			setOppositeTurnPlayer(player2);
		} else {
			setTurnPlayer(player2);
			setOppositeTurnPlayer(player1);
		}
	}

	public int getTurn() {
		return turn;
	}

	public int getRound() {
		return round;
	}

	// Public Methods
	public void passTurn() throws NoMoreCardsToDrawException {

		if (turnPlayer.equals(player1)) {
			setTurnPlayer(player2);
			setOppositeTurnPlayer(player1);

			if (round > 1) {
				player2.setMana(player2.getMana() + 1);
				player2.setAvailableMana(player2.getMana());
			}
			
			player2.draw();

			for (Creature card : player2.getField()) {
				if (card.isBattleSick()) {
					card.setBattleSick(false);
				}
			}

		} else {
			setTurnPlayer(player1);
			setOppositeTurnPlayer(player1);

			if (round > 1) {
				player1.setMana(player1.getMana() + 1);
				player1.setAvailableMana(player1.getMana());
			}
			
			player1.draw();

			for (Creature card : player1.getField()) {
				if (card.isBattleSick()) {
					card.setBattleSick(false);
				}
			}
		}

		round++;
		if (round % 2 != 0) {
			turn++;
		}
	}
}
