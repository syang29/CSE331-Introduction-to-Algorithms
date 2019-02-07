package code;





import java.awt.event.MouseListener;

import GUi.CardDisplay;

public class Card {
private String rank;
private String suit;
private int rankAsNumber;
private int suitAsNumber;
private String clr;
private CardDisplay picture;


/* The constructor uses rank and suit values as   
 * conditions to decide what each card represents 
 */
public Card(int rank1, int suit1) {
	if(rank1 >=2 && rank1 <=10){
		rank = rank1 + "";
	}
	else if(rank1 == 11){
		rank = "j";
	}
	else if (rank1 == 12){
		rank = "q";
	}
	else if(rank1 == 13){
		rank = "k";
	}
	else{
		rank = "a";
	}
	if(suit1 == 0){
		suit = "d";
		clr = "red";
	}
	else if(suit1 == 1){
		suit = "c";
		clr = "black";
	}
	else if(suit1 == 2){
		suit = "h";
		clr = "red";
	}
	else if(suit1 == 3){
		suit = "s";
		clr = "black";
	}
	// Stores rank as number for easy access
	rankAsNumber = rank1;
	// Stores suit as number for easy access
	suitAsNumber = suit1;
	picture = new CardDisplay(getRankAndSuit());
	picture.setVisible(true);
}

public String getRank(){
	// gets the rank
	return rank;
}

public String getSuit(){
	// gets the suit
	return suit;
}

public String getColor(){
	// gets the color
	return clr;
}

public int getRankAsNumber(){
	// gets rank as number
	return rankAsNumber;
}

public int getSuitAsNumber(){
	// gets suit as number
	return suitAsNumber;
}
public String getRankAndSuit(){
	return rank + suit;
}
public CardDisplay getIcon() {
	return picture;
}
public void resetIcon() {
	picture = new CardDisplay(getRankAndSuit());
}

}
