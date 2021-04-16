package deck;

import java.io.Serializable;

import exceptions.NoMoreCardsToDrawException;
import game.Board;

public abstract class Card implements Serializable {
	private static final long serialVersionUID = -5059256567214049142L;
	// instance variables
	private String title;
	private String description;
	private int cost;

	// constructor
	public Card(String title, String description, int cost) {
		super();
		this.title = title;
		this.description = description;
		this.cost = cost;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public abstract String toString();

	public abstract void onPlay(Board board) throws NoMoreCardsToDrawException;

	public abstract void onDraw(Board board) throws NoMoreCardsToDrawException;

	public abstract void onSentToGrave(Board board) throws NoMoreCardsToDrawException;
}
