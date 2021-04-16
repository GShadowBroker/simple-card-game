package interfaces;

import java.util.*;

import deck.Card;

public interface StackOfCards {
	public List<Card> getAll();

	public Card get(int index) throws IndexOutOfBoundsException;

	public void add(Card card);

	public void addMultiple(List<Card> cards);

	public Card remove(int index) throws IndexOutOfBoundsException;
	
	public void removeAll();
	
	public void shuffle();

	public int size();
	
	public String toString();
}
