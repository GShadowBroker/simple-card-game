package game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import deck.Creature;

public class Board implements Serializable {
	private static final long serialVersionUID = -5731207966560116089L;
	private Player player1;
	private Player player2;
	private Player turnPlayer;
	private Player oppositeTurnPlayer;
	private int turn = 1;
	private List<Creature> p1Field = new ArrayList<Creature>(5);
	private List<Creature> p2Field = new ArrayList<Creature>(5);
	private int p1Hp = 20;
	private int p2Hp = 20;
	private int p1Mana = 1;
	private int p1AvailableMana = 1;
	private int p2Mana = 1;
	private int p2AvailableMana = 1;

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

	public List<Creature> getP1Field() {
		return p1Field;
	}

	public void setP1Field(List<Creature> p1Field) {
		this.p1Field = p1Field;
	}

	public List<Creature> getP2Field() {
		return p2Field;
	}

	public void setP2Field(List<Creature> p2Field) {
		this.p2Field = p2Field;
	}

	public int getP1Hp() {
		return p1Hp;
	}

	public void setP1Hp(int p1Hp) {
		this.p1Hp = p1Hp;
	}

	public int getP2Hp() {
		return p2Hp;
	}

	public void setP2Hp(int p2Hp) {
		this.p2Hp = p2Hp;
	}

	public int getP1Mana() {
		return p1Mana;
	}

	public void setP1Mana(int p1Mana) {
		this.p1Mana = p1Mana;
	}

	public int getP2Mana() {
		return p2Mana;
	}

	public void setP2Mana(int p2Mana) {
		this.p2Mana = p2Mana;
	}

	public int getP1AvailableMana() {
		return p1AvailableMana;
	}

	public void setP1AvailableMana(int p1AvailableMana) {
		this.p1AvailableMana = p1AvailableMana;
	}

	public int getP2AvailableMana() {
		return p2AvailableMana;
	}

	public void setP2AvailableMana(int p2AvailableMana) {
		this.p2AvailableMana = p2AvailableMana;
	}

	// Public Methods
	public void passTurn() {

		if (turnPlayer.equals(player1)) {
			setTurnPlayer(player2);
			setOppositeTurnPlayer(player1);

			setP2Mana(getP2Mana() + 1);
			setP2AvailableMana(p2Mana);

			for (Creature card : p2Field) {
				if (card.isBattleSick()) {
					card.setBattleSick(false);
				}
			}

		} else {
			setTurnPlayer(player1);
			setOppositeTurnPlayer(player1);

			setP1Mana(getP1Mana() + 1);
			setP1AvailableMana(p1Mana);

			for (Creature card : p2Field) {
				if (card.isBattleSick()) {
					card.setBattleSick(false);
				}
			}
		}

		turn++;
	}
}
