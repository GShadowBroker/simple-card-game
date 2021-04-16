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

public class Player implements Serializable {
	private static final long serialVersionUID = 6309854488555703288L;
	private String name;
	private Deck deck;
	private Hand hand;
	private Graveyard graveyard;

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

	// Public methods
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
			throws BoardIsFullException, IndexOutOfBoundsException, NoMoreCardsToDrawException {

		Card card = hand.get(handIndex);

		System.out.printf("%s has played %s!\n", name, card);

		boolean isEven = board.getTurn() % 2 == 0;
		List<Creature> field = isEven ? board.getP2Field() : board.getP1Field();

		// If board is full, throw exception
		if (field.size() >= 5) {
			throw new BoardIsFullException();
		}

		hand.remove(handIndex);
		card.onPlay(board);

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
