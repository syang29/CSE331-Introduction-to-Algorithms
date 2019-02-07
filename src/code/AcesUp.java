package code;

import java.util.ArrayList;

import code.Card;
import code.Pile;

public class AcesUp {
	// Creates an array of tableu piles
	private Pile tableauPiles[];
	// Creates an array of homecell piles
	private Pile homeCellPiles[];
	// Creates an array of stock piles
	private Pile stockPiles[];
	
	// private piles declared may be changed due to the
	// fact that there is only 1 homecell pile and 1 stock pile
	// "AU" = acesup, "S" = stockpile
	
	private Pile deck;
	
	public AcesUp() {
// creates a deck & shuffles
		deck = new Pile("D");
		deck.shuffle();
// specifies the size of the tableu piles array
		tableauPiles = new Pile[4];
// specifies the size of the homecell piles array
		homeCellPiles = new Pile[1];
// specifies the size of the stock piles array
		stockPiles = new Pile[1];
		
		
// initializes each tableu pile
		for(int i=0; i<4; i++){
			tableauPiles[i] = new Pile("AUT");
			Card dealtCard = deck.topCard();
			tableauPiles[i].takeDuringDeal(dealtCard);
			deck.removeCard();
		}
		
// initializes each homecell pile 
		for(int i=0; i<1; i++){
			homeCellPiles[i] = new Pile("AUH");
		}
//initalizes each stock pile
		for(int i=0; i<1; i++){
			stockPiles[i] = new Pile("AUS");
			int iter = deck.getSize();
			for(int k = 0; k < iter;k++) {
				Card dealtCard = deck.topCard();
				stockPiles[i].takeDuringDeal(dealtCard);
				deck.removeCard();
			}
		}
		
	
		
	//note that the pile class needs to have changes and actions
	//implemented for stockpiles
		//more code must be implemented here
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
	
//returns the stock pile	
	public Pile getStockPile(int n){
		return stockPiles[n];
//returns the nth stock pile
	}
	
	//note that this part of code may change due to the 
	//fact that there is only 1 homecell pile and 1 stock pile 
	
	
	
//returns the deck pile
	public Pile getDeck() {
		return deck;
	}		
		
	public ArrayList<Card> topCards(){
		ArrayList<Card> retVal = new ArrayList<Card>();
		for(int i = 0; i < 4; i++) {
			retVal.add(tableauPiles[i].topCard());
		}
		return retVal;
	}
	
}
