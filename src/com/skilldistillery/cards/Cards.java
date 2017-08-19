package com.skilldistillery.cards;


public class Cards {
    private Rank rank;
    private Suit suit;

    public Cards(Rank r, Suit s) {
        rank = r;
        suit = s;
    }

    @Override
    public String toString() {
        return (rank + " of " + suit).toLowerCase();
    }
    
    public int compareTo(Cards card) {
		
    		int rCompare = (this.rank.compareTo(rank));
    		int sCompare = (this.suit.compareTo(suit));
    		
    		if (sCompare == 0) 
    		{
    			return sCompare; 
    		}else
    		return rCompare;
    	
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((rank == null) ? 0 : rank.hashCode());
        result = prime * result
                + ((suit == null) ? 0 : suit.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cards other = (Cards) obj;
        if (rank != other.rank)
            return false;
        if (suit != other.suit)
            return false;
        return true;
    }

	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

	public Suit getSuit() {
		return suit;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}

	
}

	


