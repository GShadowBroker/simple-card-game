
import java.util.*;
import deck.*;
import deck.cards.Assassinate;
import deck.cards.FootSoldier;
import deck.cards.KingsBlessing;
import game.Game;
import game.Player;

public class App {
	public static void main(String[] args) {
		Creature footSoldier = new FootSoldier();
		Spell assassinate = new Assassinate();
		Spell kingsBlessing = new KingsBlessing();

		List<Card> cards1 = new ArrayList<Card>(7);
		cards1.add(footSoldier);
		cards1.add(assassinate);
		cards1.add(kingsBlessing);
		cards1.add(kingsBlessing);
		cards1.add(footSoldier);
		cards1.add(footSoldier);
		cards1.add(footSoldier);

		List<Card> cards2 = new ArrayList<Card>(7);
		cards2.add(footSoldier);
		cards2.add(assassinate);
		cards2.add(kingsBlessing);
		cards2.add(kingsBlessing);
		cards2.add(footSoldier);
		cards2.add(footSoldier);
		cards2.add(footSoldier);

		Deck deck1 = new Deck(cards1);
		Deck deck2 = new Deck(cards2);
		
		Hand hand1 = new Hand();
		Hand hand2 = new Hand();
		
		Graveyard grave1 = new Graveyard();
		Graveyard grave2 = new Graveyard();

		Player player1 = new Player("Gledyson", deck1, hand1, grave1);
		Player player2 = new Player("Zezinho", deck2, hand2, grave2);
		
		Game game = new Game(player1, player2);
		
		game.start();
	}
}
