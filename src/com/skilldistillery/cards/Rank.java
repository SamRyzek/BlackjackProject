package com.skilldistillery.cards;

public enum Rank {

    TWO(2), 
    THREE(3), 
    FOUR(4), 
    FIVE(5), 
    SIX(6), 
    SEVEN(7), 
    EIGHT(8), 
    NINE(9), 
    TEN(10), 
    JACK(10), 
    QUEEN(10), 
    KING(10), 
    ACE(11, 1);
	
	int valueHigh;
	int valueLow;

	private Rank(int valueHigh) {
		this.valueHigh = valueHigh;
	}
	
	private Rank(int valueHigh, int valueLow) {
		this.valueHigh = valueHigh;
		this.valueLow = valueLow;
	}

	public int getValueLow() {
		return valueLow;
	}

	public void setValueLow(int valueLow) {
		this.valueLow = valueLow;
	}

	public int getValueHigh() {
		return valueHigh;
	}

	public void setValueHigh(int valueHigh) {
		this.valueHigh = valueHigh;
	}
	
	
}
