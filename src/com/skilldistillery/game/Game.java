
package com.skilldistillery.game;

import java.util.Scanner;

import com.skilldistillery.cards.Cards;
import com.skilldistillery.cards.Deck;
import com.skilldistillery.cards.Rank;
import com.skilldistillery.cards.Suit;
import com.skilldistillery.players.Dealer;
import com.skilldistillery.players.Gambler;
import com.skilldistillery.players.Hand;
import com.skilldistillery.players.Player;

public class Game {
	Dealer dealer = new Dealer();
	Gambler gambler = new Gambler();
	Scanner kb = new Scanner(System.in);

	// main
	public static void main(String[] args) {
		Game game = new Game();
		game.run();
	}

	// methods
	public void run() {

		Hand gamblerHand = new Hand();
		Hand dealerHand = new Hand();
		Deck deck = initializeDeck();

		// populate deck
		dealer.setDeck(deck); // passes the populated deck to the dealer

		gambler.setHand(gamblerHand); // giving gambler a hand
		// (currently the hand has no cards)
		dealer.setHand(dealerHand); // giving dealer a hand
		// (currently the hand has no cards)

		System.out.println("*******************************************");
		System.out.println("*                                         *");
		System.out.println("*      Let's play some Blackjack!!        *");
		System.out.println("*                                         *");
		System.out.println("*******************************************");
		System.out.println();

		gambler.getHand().addCard(dealer.getDeck().deliverCardsForGame());
		// gets a card from the dealer's deck
		dealer.getHand().addCard(dealer.getDeck().deliverCardsForGame());
		// gets a card from the dealer's deck
		gambler.getHand().addCard(dealer.getDeck().deliverCardsForGame());
		dealer.getHand().addCard(dealer.getDeck().deliverCardsForGame());

		printHand(gambler);
		printHand(dealer);
		initialCheck(gambler, dealer);
		// method calls
		if (calculateHand(gambler) != 21 && calculateHand(dealer) != 21) {

			stayOrHold(gambler);
		}

	}

	public void stayOrHold(Player player) {
		int sum = calculateHand(player);
		if (player instanceof Gambler) {
			while (sum < 21 && sum != 21) {
				System.out.println("Would you like a [C]ard or [H]old? ");
				String playerR = kb.nextLine().toUpperCase();

				if (playerR.equals("C")) {
					gambler.getHand().addCard(dealer.getDeck().deliverCardsForGame());
					// gets a card from the
					// dealer's deck

					printHand(gambler);
				} else if (playerR.equals("H")) {
					checkForWin(gambler, dealer);
					System.out.println("Gambler has selected to hold!");
					break;
				} else {
					System.err.println("Please enter a valid selection! " + "[C] for card or [H] for hold!");

					String playerRe = kb.nextLine().toUpperCase();

					if (playerRe.equals("C")) {
						gambler.getHand().addCard(dealer.getDeck().deliverCardsForGame());
						// gets a card from the
						// dealer's deck
						printHand(gambler);
						if (calculateHand(player) > 21) {
							break;
						}
					} else if (playerR.equals("H")) {
						checkForWin(gambler, dealer);
						System.out.println("Gambler has selected to hold!");
						break;
					}
				}

				sum = calculateHand(player);
			}
		}

		if (calculateHand(player) < 21) {
			sum = calculateHand(dealer);

			while (sum < 17) {
				dealer.getHand().addCard(dealer.getDeck().deliverCardsForGame());
				sum = calculateHand(dealer);

			}

		}

		System.out.println();
		printHand(player);
		printHand(dealer);
		checkForWin(gambler, dealer);

	}

	public void printHand(Player player) {

		if (player instanceof Gambler) {
			System.out.println("Gambler's Hand: ");
			System.out.println("-------------");
			for (Cards dg : gambler.getHand().getCards()) {
				System.out.println(dg);
			}
		}
		if (player instanceof Dealer) {
			System.out.println("Dealer's Hand: ");
			System.out.println("--------------");
			for (Cards cg : dealer.getHand().getCards()) {
				System.out.println(cg);
			}
		}

		System.out.println("Total: " + calculateHand(player));
		System.out.println();
	}

	public int calculateHand(Player player) {
		int sum = 0;
		for (Cards card : player.getHand().getCards()) {
			sum = card.getRank().getValueHigh() + sum;
		}
		for (Cards card : dealer.getHand().getCards()) {
			if (card.getRank().equals(Rank.ACE) && sum > 21) {
				sum = sum - 10;
			}
		}
		for (Cards card : gambler.getHand().getCards()) {
			if (card.getRank().equals(Rank.ACE) && sum > 21) {
				sum = sum - 10;
			}
		}

		return sum;
	}

	public void checkForWin(Player player, Player dealer) {
		System.out.println("Player: " + calculateHand(player));
		System.out.println("Dealer: " + calculateHand(dealer));
		if (calculateHand(player) > 21) {
			System.out.println("Player Busts! Dealer wins!");
		} else if (calculateHand(dealer) > 21) {
			System.out.println("Dealer Busted! Player won!");
		} else if (((calculateHand(player) > calculateHand(dealer)))) {
			System.out.println("Gambler won");
		} else if (calculateHand(player) == calculateHand(dealer)) {
			System.out.println("Game is a push");
		} else if (((calculateHand(player) < calculateHand(dealer)))) {
			System.out.println("Dealer won");
		}
	}

	public void initialCheck(Player player, Player dealer) {
		if (calculateHand(gambler) == 21 && calculateHand(dealer) < 21) {
			System.out.println("Blackjack Gambler wins");
		} else if (calculateHand(dealer) == 21 && calculateHand(player) < 21) {
			System.out.println("Blackjack Dealer wins");
		} else if (calculateHand(dealer) == 21 && calculateHand(player) == 21) {

			System.out.println("Blackjack Dealer and Player push!");
		}
	}

	public Deck initializeDeck() {
		Deck deck = new Deck();
		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				deck.addCard(new Cards(r, s));
			}
		}
		deck.suffleCards();
		return deck;

	}
}