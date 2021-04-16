package deck;

import interfaces.enums.CardType;

public abstract class Spell extends Card {
	private static final long serialVersionUID = 7639787353138028833L;
	public final CardType CARD_TYPE = CardType.SPELL;
	
	public Spell(String title, String description, int cost) {
		super(title, description, cost);
	}
	
	public void onDraw() {
		System.out.println("Spell's on draw effect triggered!");
	}
	public void onPlay() {
		System.out.println("Spell's on play effect triggered!");
	}
	
	public String toString() {
		return String.format("(%s) %s", CARD_TYPE.name(), super.getTitle());
	}
}
