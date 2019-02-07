package code;


public class FreeCell {
	private Pile tableauPiles[];
	private Pile homeCellPiles[];
	private Pile freeCellPiles[];
	private Pile deck;
	
	//"F"=freecell,"BD"=bakersdozen,"T"=tableaupile,"H"=homecellpile,"FF"=freecellpile,"D"=deck
	
		public FreeCell() {
			// creates a deck & shuffles
			deck = new Pile("D");
			deck.shuffle();
		
			// specifies the size of the tableu piles array
			tableauPiles = new Pile[8];
			// specifies the size of the homecell piles array
			homeCellPiles = new Pile[4];
			// specifies the size of the freecell piles array
			freeCellPiles = new Pile[4];
			// initializes each tableu pile
			for(int i=0; i<8; i++){
				tableauPiles[i] = new Pile("FCT");
			}
			// initializes each homecell pile 
			for(int i=0; i<4; i++){
				homeCellPiles[i] = new Pile("FCH");
			}
			// initializes each freecell pile
			for(int i=0; i<4; i++){
				freeCellPiles[i] = new Pile("FF");
			}
			// loop through the deck of cards
			// put into tableauPiles
			for(int i=0; i<4; i++){
				// deal
				for(int j = 0; j < 7; j++) {
					Card dealtCard = deck.topCard();
					tableauPiles[i].takeDuringDeal(dealtCard);
					deck.removeCard();
				}
			}for(int i = 4; i < 8; i++) {
				for(int j = 0; j < 6; j++) {
					Card dealtCard = deck.topCard();
					tableauPiles[i].takeDuringDeal(dealtCard);
					deck.removeCard();
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
		
		//returns the freecell pile
		public Pile getFreeCellPile(int n){
			return freeCellPiles[n];
			// returns the nth freeCellPile 
		}
		
		//returns the deck pile
		public Pile getDeck() {
			return deck;
		}

		
	
}
