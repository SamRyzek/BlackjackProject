package com.skilldistillery.players;

import com.skilldistillery.cards.Deck;

public class Dealer extends Player {

	private Deck deck;
	
	public Dealer() {
		
	}
	
	public void paysGambler(){
		
	}
	

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Dealer [deck=");
		builder.append(deck);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
