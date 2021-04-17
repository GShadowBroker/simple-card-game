package deck;

import java.io.Serializable;
import java.util.*;

import interfaces.Stackable;

public class Deck implements Iterable<Card>, Stackable, Serializable {
	private static final long serialVersionUID = 6844087467977655447L;
	private List<Card> deckList = new ArrayList<Card>(30);
	private List<Card> cardsInDeck = new ArrayList<Card>(30);

	public Deck(List<Card> cardList) {
		buildDeck(cardList);
	}

	@Override
	public List<Card> getAll() {
		return cardsInDeck;
	}

	public void buildDeck(List<Card> cardList) {
		this.setDeckList(cardList);
		this.cardsInDeck = cardList;
		shuffle();
	}

	public List<Card> getDeckList() {
		return deckList;
	}

	public void setDeckList(List<Card> deckList) {
		this.deckList = deckList;
	}

	@Override
	public void shuffle() {
		Collections.shuffle(cardsInDeck);
	}

	@Override
	public Card get(int index) throws IndexOutOfBoundsException {
		return cardsInDeck.get(index);
	}

	@Override
	public void add(Card card) {
		cardsInDeck.add(card);
	}

	@Override
	public void addMultiple(List<Card> cards) {
		cardsInDeck.addAll(cards);
	}

	@Override
	public Card remove(int index) throws IndexOutOfBoundsException {
		return cardsInDeck.remove(index);
	}

	@Override
	public void removeAll() {
		cardsInDeck.clear();
	}

	@Override
	public int size() {
		return cardsInDeck.size();
	}

	public void reset() {
		cardsInDeck = deckList;
		shuffle();
	}

	@Override
	public String toString() {
		return cardsInDeck.toString();
	}

	@Override
	public Iterator<Card> iterator() {
		return cardsInDeck.iterator();
	}
}
