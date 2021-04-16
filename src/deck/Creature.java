package deck;

import interfaces.enums.CardType;

public abstract class Creature extends Card {
	private static final long serialVersionUID = -913567126466403180L;
	public final CardType CARD_TYPE = CardType.CREATURE;
	private int health;
	private int attack;
	private int defense;
	private boolean isBattleSick = true;

	public Creature(String title, String description, int cost, int health, int attack, int defense) {
		super(title, description, cost);
	}
	
	// Getters and setters
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}
	
	// Methods
	public void onPlay() {
		System.out.println("Creature on play effect triggered!");
	}

	public void onAttack() {
		System.out.println("Creature on attack effect triggered!");
	}

	public void onDeath() {
		System.out.println("Creature on death effect triggered!");
	}
	
	public String toString() {
		return String.format("(%s) %s", CARD_TYPE.name(), super.getTitle());
	}

	public boolean isBattleSick() {
		return isBattleSick;
	}

	public void setBattleSick(boolean isBattleSick) {
		this.isBattleSick = isBattleSick;
	}
}
