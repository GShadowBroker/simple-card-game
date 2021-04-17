package deck;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import interfaces.Stackable;

public class Hand implements Serializable, Iterable<Card>, Stackable {
	private static final long serialVersionUID = -6610474645489634115L;
	private ArrayList<Card> cardsInHand = new ArrayList<Card>(5);

	// Public methods
	public ArrayList<Card> getAll() {
		return cardsInHand;
	}

	public Card get(int index) throws IndexOutOfBoundsException {
		return cardsInHand.get(index);
	}

	public void add(Card card) {
		cardsInHand.add(card);
	}

	public void addMultiple(List<Card> cards) {
		cardsInHand.addAll(cards);
	}

	public Card remove(int index) throws IndexOutOfBoundsException {
		return cardsInHand.remove(index);
	}

	public void removeAll() {
		cardsInHand.clear();
	}

	public void shuffle() {
		Collections.shuffle(cardsInHand);
	}

	public int size() {
		return cardsInHand.size();
	}
	
	public String toString() {
		return cardsInHand.toString();
	}

	@Override
	public Iterator<Card> iterator() {
		return cardsInHand.iterator();
	}
}
