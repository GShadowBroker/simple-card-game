package game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import deck.Card;
import deck.Creature;
import deck.Deck;
import deck.Graveyard;
import deck.Hand;
import deck.Spell;
import exceptions.BoardIsFullException;
import exceptions.NoMoreCardsToDrawException;
import exceptions.NotEnoughManaException;

public class Player implements Serializable {
	private static final long serialVersionUID = 6309854488555703288L;
	private String name;
	private Deck deck;
	private Hand hand;
	private Graveyard graveyard;
	private List<Creature> field = new ArrayList<Creature>(5);
	private int hp = 20;
	private int mana = 1;
	private int availableMana = 1;

	public Player(String name, Deck deck, Hand hand, Graveyard graveyard) {
		setName(name);
		setDeck(deck);
		setHand(hand);
		setGraveyard(graveyard);
	}

	// Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Deck deck() {
		return deck;
	}

	private void setDeck(Deck deck) {
		this.deck = deck;
	}

	public Hand hand() {
		return hand;
	}

	private void setHand(Hand hand) {
		this.hand = hand;
	}

	public Graveyard graveyard() {
		return graveyard;
	}

	private void setGraveyard(Graveyard graveyard) {
		this.graveyard = graveyard;
	}

	public List<Creature> getField() {
		return field;
	}

	public void setField(List<Creature> field) {
		this.field = field;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public int getAvailableMana() {
		return availableMana;
	}

	public void setAvailableMana(int availableMana) {
		this.availableMana = availableMana;
	}

	// Public methods

	public void reset() {
		deck.reset();
		hand.getAll().clear();
		graveyard.getAll().clear();
		field.clear();
		setHp(20);
		setMana(1);
		setAvailableMana(getMana());
	}

	public List<Card> draw() throws NoMoreCardsToDrawException {
		List<Card> cardsDrawn = new ArrayList<Card>(1);

		if (deck.size() < 1) {
			throw new NoMoreCardsToDrawException();
		}

		Card card = deck.remove(0);
		cardsDrawn.add(card);
		hand.add(card);
		return cardsDrawn;
	}

	public List<Card> draw(int numOfCards) throws NoMoreCardsToDrawException {
		List<Card> cardsDrawn = new ArrayList<Card>(numOfCards);

		if (numOfCards > deck.size()) {
			throw new NoMoreCardsToDrawException();
		}

		if (numOfCards == 1) {
			Card card = deck.remove(0);
			cardsDrawn.add(card);
			hand.add(card);
			return cardsDrawn;
		} else {
			for (int i = 0; i < numOfCards; i++) {
				Card card = deck.remove(0);
				cardsDrawn.add(card);
				hand.add(card);
			}
			return cardsDrawn;
		}
	}

	public void playCard(int handIndex, Board board)
			throws BoardIsFullException, IndexOutOfBoundsException, NoMoreCardsToDrawException, NotEnoughManaException {

		Card card = hand.get(handIndex);
//		
		if (card.getCost() > availableMana) {
			throw new NotEnoughManaException();
		}

		System.out.printf("%s has played %s!\n", name, card);

		// If board is full, throw exception
		if (field.size() >= 5) {
			throw new BoardIsFullException();
		}

		// Subtract mana
		setAvailableMana(getAvailableMana() - card.getCost());
		// remove from hand
		hand.remove(handIndex);
		// activate onplay effect
		card.onPlay(board);

		// if creature, add to field. If spell, send to grave and activate onsenttograve
		if (card instanceof Creature) {
			field.add((Creature) card);
			return;
		} else if (card instanceof Spell) {
			graveyard.add(card);
			card.onSentToGrave(board);
		}
		// NEED TO handle battlefield type

	}
}
