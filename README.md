###BLACKJACK	 Project
### Samuel Ryzek 8/18/2017

###Overview
This project is a command-line blackjack game.


###Topics Covered
Inheritance
Object Oriented Design and Analysis
Enums

###Rules of Blackjack
https://en.wikipedia.org/wiki/Blackjack

###Program

This program provides a simple version of blackjack. The player -"gambler" plays against the dealer who run via computer AI. Gambler's are given the option to take a card or to hold. If either the gambler or dealer go over 21, the game is over. Likewise, if either player is dealt a 21, a blackjack condition exists and the player that was dealt the 21 wins. More functionality, such as wagers, splitting of cards, doubling down, and a more robust AI are planned for later. 

The programs structure is built around 2 enums, and 7 objects. The enums are used to define suit and value of cards. Player is a superclass for gambler and dealer. Cards are created in the card object and passed to the deck where a deck is created. The deck class is also responsible for removing cards when the have been dealt. From the deck, hands are created for the gambler and the dealer. Game logic in class Game then decides the winner and loser. Additionally, in the game class, the gambler is given the choice to stay or hold. 