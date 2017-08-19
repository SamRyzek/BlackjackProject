package com.skilldistillery.players;

import com.skilldistillery.cards.Deck;

public class Dealer extends Player {

	private Hand hand;
	private Deck deck;
	
	public Dealer() {
		// TODO Auto-generated constructor stub
	}
	
	public void paysGambler(){
		
	}
	
	
	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}
	
	
	
}
