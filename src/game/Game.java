package game;

import java.util.Scanner;

import exceptions.NoMoreCardsToDrawException;

public class Game {
	private Player player1;
	private Player player2;

	// Constructor
	public Game(Player player1, Player player2) {
		setPlayer1(player1);
		setPlayer2(player2);
	}

	// Getters and setters

	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	// Subroutines
	public void start() {
		System.out.printf("Starting game between %s and %s.\n", player1.getName(), player2.getName());
		Board board = new Board(player1, player2);
		board.getP1().reset();
		board.getP2().reset();
		
		try {
			board.getP1().draw(4);
			board.getP2().draw(4);
			
			runDriver(board);
		} catch (NoMoreCardsToDrawException e) {
			String losingPlayerName = board.getTurnPlayer().getName();
			String winningPlayerName = board.getOppositeTurnPlayer().getName();

			System.out.printf("%s ran out of cards!\n%s WINS!!!\n", losingPlayerName, winningPlayerName);
		}

		System.out.println("End.");
	}

	private void runDriver(Board board) throws NoMoreCardsToDrawException {
		boolean gameEnded = false;
		Scanner scanner = new Scanner(System.in);

		String playerName = board.getTurnPlayer().getName();

		int availableMana = board.getTurnPlayer().getAvailableMana();

		while (gameEnded == false) {
			playerName = board.getTurnPlayer().getName();
			availableMana = board.getTurnPlayer().getAvailableMana();
			System.out.printf("%s to play. %d mana available.\n", playerName, availableMana);

			System.out.printf("Your hand: %s\n", board.getTurnPlayer().hand());

			System.out.println("\nType your command:");
			System.out.println("1. show stats;");
			System.out.println("2. select card in hand;");
			System.out.println("3. select card on the field;");
			System.out.println("4. show graveyard;");
			System.out.println("5. pass turn;");
			System.out.println("6. resign;");
			int command = scanner.nextInt();

			switch (command) {
			case (1):
				showStats(board);
				break;
			case (2):
				System.out.println("selecting card in hand");
				break;
			case (3):
				System.out.println("selecting card on the field");
				break;
			case (4):
				System.out.println("showing graveyard");
				break;
			case (5):
				System.out.println("Passing turn...");
				board.passTurn();
				break;
			case (6):
				System.out.println("Resigning...");
				gameEnded = true;
				break;
			default:
				System.out.println("Command not recognized.");
				break;
			}
		}
		scanner.close();
	}

	private void showStats(Board board) {
		Player player = board.getTurnPlayer();
		int cardsLeft = player.deck().size();

		System.out.printf("%s's stats:\nHP: %s\nMana: %d\nTurn: %d\nCards left in deck: %d\n", player.getName(),
				player.getHp(), player.getMana(), board.getTurn(), cardsLeft);
	}
}
