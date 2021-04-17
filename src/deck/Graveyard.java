package deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import interfaces.Stackable;

public class Graveyard implements Stackable, Iterable<Card> {
	private List<Card> cardsInGrave = new ArrayList<Card>(30);

	@Override
	public List<Card> getAll() {
		return cardsInGrave;
	}

	@Override
	public Card get(int index) throws IndexOutOfBoundsException {
		return cardsInGrave.get(index);
	}

	@Override
	public void add(Card card) {
		cardsInGrave.add(card);
	}

	@Override
	public void addMultiple(List<Card> cards) {
		cardsInGrave.addAll(cards);
	}

	@Override
	public Card remove(int index) throws IndexOutOfBoundsException {
		return cardsInGrave.remove(index);
	}

	@Override
	public void removeAll() {
		cardsInGrave.clear();
	}

	@Override
	public void shuffle() {
		Collections.shuffle(cardsInGrave);
	}

	@Override
	public int size() {
		return cardsInGrave.size();
	}
	
	@Override
	public String toString() {
		return cardsInGrave.toString();
	}

	@Override
	public Iterator<Card> iterator() {
		return cardsInGrave.iterator();
	}

}
