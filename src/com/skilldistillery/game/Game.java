package com.skilldistillery.game;

import com.skilldistillery.cards.Cards;
import com.skilldistillery.cards.Deck;
import com.skilldistillery.cards.Rank;
import com.skilldistillery.cards.Suit;
import com.skilldistillery.players.Dealer;
import com.skilldistillery.players.Gambler;
import com.skilldistillery.players.Hand;

public class Game {
	Dealer dealer = new Dealer();
	Gambler gambler = new Gambler(); 
	
	public static void main(String[] args) {
		Game game = new Game();
		game.run();
	}

	public void run() {
		// TODO Auto-generated constructor stub
		
		Hand gamblerHand = new Hand();
		Hand dealerHand = new Hand();
		Deck deck = initializeDeck();
		
		//populate deck
		dealer.setDeck(deck); //passes the populated deck to the dealer
		
		
		for (Cards card : dealer.getDeck().getCards()) {
			System.out.print(card + " ");
			System.out.println(card.getRank().getValueHigh());
			
		}
		System.out.println(dealer.getDeck().getCards().size());
		
		gambler.setHand(gamblerHand); //giving gambler a hand (currently the hand has no cards)
		dealer.setHand(dealerHand); //giving dealer a hand (currently the hand has no cards)
		
		gambler.getHand().addCard(dealer.getDeck().deliverCardsForGame()); //gets a card from the dealer's deck
		dealer.getHand().addCard(dealer.getDeck().deliverCardsForGame()); //gets a card from the dealer's deck
		gambler.getHand().addCard(dealer.getDeck().deliverCardsForGame());
		dealer.getHand().addCard(dealer.getDeck().deliverCardsForGame());
		
		int sumGambler = 0;
		System.out.println("Player Hand: ");
		for (Cards c : gambler.getHand().getCards()) {
			System.out.println(c);
			sumGambler = c.getRank().getValueHigh() + sumGambler;
		}
		System.out.println("Player Total: ");
		System.out.println(sumGambler);
		
		int sumDealer = 0;
		System.out.println("Dealer Hand: ");
		for (Cards c : dealer.getHand().getCards()) {
			System.out.println(c);
			sumDealer = c.getRank().getValueHigh() + sumDealer;
		}
		System.out.println("Dealer Total: ");
		System.out.println(sumDealer);
		 
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
