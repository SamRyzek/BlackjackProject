package com.skilldistillery.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Cards> cards;
        
	
	public List<Cards> getCards() {
		return cards;
	}

	public void setCards(List<Cards> cards) {
		this.cards = cards;
	}

	public void suffleCards() {
		
		
    		Collections.shuffle(cards);
      
    }
	
	public void addCard(Cards c) {
		if(cards == null) {
			cards = new ArrayList<Cards>();
			cards.add(c);
		}
		else {
			cards.add(c);
		}
	}
		
	
	
	public Cards deliverCardsForGame() {
		
		return cards.remove(0);
	
		
	}
}

