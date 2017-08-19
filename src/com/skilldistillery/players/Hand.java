package com.skilldistillery.players;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.cards.Cards;

public class Hand {
	private List<Cards> cards;
	public Hand() {
		// TODO Auto-generated constructor stub
	}
	public List<Cards> getCards() {
		return cards;
	}
	public void setCards(List<Cards> cards) {
		this.cards = cards;
	}
	
	public void addCard(Cards card) {
		if(this.cards == null) {
			this.cards = new ArrayList<>();
			this.cards.add(card);
		}else {
			this.cards.add(card);
		}
	}

}
