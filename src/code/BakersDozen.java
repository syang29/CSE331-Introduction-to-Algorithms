package code;

import code.Card;
import code.Pile;

public class BakersDozen {
// Creates an array of tableu piles
private Pile tableauPiles[];
// Creates an array of homecell piles
private Pile homeCellPiles[];
private Pile deck;



	public BakersDozen() {
		// creates a deck and shuffles
		deck = new Pile("D");
		deck.shuffle();
		
		// specifies the size of the tableau piles array 
		tableauPiles = new Pile[13];
		// specifies the size of the homecell piles array
		homeCellPiles = new Pile[4];
		// initializes each tableau pile 
		for(int i=0; i<13; i++){
			tableauPiles[i] = new Pile("BDT");
		}
		// initializes each homecell pile
		for(int i=0; i<4; i++){
			homeCellPiles[i] = new Pile("BDH");
		}
		// loop through the deck of cards to deal 13 piles
		for(int i=0; i<13; i++){
			// deals 4 cards per pile
			for(int j = 0; j < 4; j++) {
				Card dealtCard = deck.topCard();
				int kingIndex = 0;
		//if king, move to bottom of pile and if card there, brings that card to the top of pile where king was  
		//going to be added
				
						
					if(dealtCard.getRankAsNumber() == 13) {
						Card takeOut = tableauPiles[i].getCard(kingIndex);
						tableauPiles[i].setCard(kingIndex, dealtCard);
						tableauPiles[i].takeDuringDeal(takeOut);
						kingIndex++;
						deck.removeCard();
					}else {
						tableauPiles[i].takeDuringDeal(dealtCard);
						deck.removeCard();
				
					
				}
			}
		}
		
	}
	
	//returns the homecell pile
	public Pile getHomeCellPile(int n){
		return homeCellPiles[n];
		// returns the nth homeCellPile i.e. n = 1, or n = 2, or n = 3, or n = 4 
	}
	//returns the tableau pile
	public Pile getTableauPile(int n){
		return tableauPiles[n];
		// returns the nth tableuPile 
	}
	//returns the deck pile
	public Pile getDeck() {
		return deck;
	}
	

	
}
