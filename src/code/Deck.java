package code;

import code.Card;

public class Deck {
	
	private Card[] allCards;
	
	public Deck() {
		allCards = new Card[52];
		for(int i = 0; i <52; i++) {
			for(int j = 1; j < 14 ; j++) {
				for(int k = 0 ; k < 4; k++) {
					allCards[i] = new Card(j,k);
											
				}
			}
		}
	}
	
	public void shuffle() {
		for(int i = 0; i < 52;i++) {
			Card cardToShuffle = allCards[i];
			int spotToTake = (int)(Math.random()*52+1);
			allCards[i] =allCards[spotToTake];
			allCards[spotToTake] = cardToShuffle;
			
		}
	}
	public Card getCard(int i) {
		
		return allCards[i];
	}
	
}
