
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

	public static void main(String[] args) {
		Game game = new Game();
		game.run();
	}

	public void run() {
		// TODO Auto-generated constructor stub

		Hand gamblerHand = new Hand();
		Hand dealerHand = new Hand();
		Deck deck = initializeDeck();

		// populate deck
		dealer.setDeck(deck); // passes the populated deck to the dealer

		// for (Cards card : dealer.getDeck().getCards()) {
		// System.out.print(card + " ");
		// System.out.println(card.getRank().getValueHigh());
		//
		// }
		// System.out.println(dealer.getDeck().getCards().size());

		gambler.setHand(gamblerHand); // giving gambler a hand (currently the hand has no cards)
		dealer.setHand(dealerHand); // giving dealer a hand (currently the hand has no cards)

		System.out.println("Let's play some Blackjack!!");

		gambler.getHand().addCard(dealer.getDeck().deliverCardsForGame()); // gets a card from the dealer's deck
		dealer.getHand().addCard(dealer.getDeck().deliverCardsForGame()); // gets a card from the dealer's deck
		gambler.getHand().addCard(dealer.getDeck().deliverCardsForGame());
		dealer.getHand().addCard(dealer.getDeck().deliverCardsForGame());

		printHand(gambler);
		printHand(dealer);

		System.out.println("Would you like a [C]ard or [H]old? ");
		String playerR = kb.nextLine().toUpperCase();

		if (playerR.equals("C")) {
			gambler.getHand().addCard(dealer.getDeck().deliverCardsForGame()); // gets a card from the dealer's deck

			printHand(gambler);
		} else if (playerR.equals("H")) {
			System.out.println("Gambler has selected to hold!");
		} else {
			System.err.println("Please enter a valid selection!");
		}

	}

	public void printHand(Player player) {
		int sum = 0;

		if (player instanceof Gambler) {
			System.out.println("Player's Hand: ");
		}
		if (player instanceof Dealer) {
			System.out.println("Dealer's Hand: ");
		}
		for (Cards cg : player.getHand().getCards()) {
			System.out.println(cg);
			sum = cg.getRank().getValueHigh() + sum;
		}

		if (player instanceof Gambler) {
			System.out.println("Player's Total: " + sum);
		}
		if (player instanceof Dealer) {
			System.out.println("Dealer's Total: " + sum);
		}
		System.out.println();
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
