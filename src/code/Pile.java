package code;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import GUi.CardDisplay;

public class Pile {
private Card[] arr;
int _size;
String type;
private JLayeredPane pileOfIcons;
private Comparator<Integer> comp;

	public Pile(String param){
		// Uses an array that has room for all the cards it might hold
		//if deck pile created, automatically adds 52 different card instances and then shuffles
		arr = new Card[52];
		_size = 0;
		type = param;
		pileOfIcons = new JLayeredPane();
		if(param == "D") {
			
			
			
			pileOfIcons.setVisible(true);
			for(int j = 1; j < 14 ; j++) {
				for(int k = 0 ; k < 4; k++) {
					Card temp = new Card(j,k);
					this.addCard(temp);
											
				}
			
			}
			
		}
		else {
			
			pileOfIcons.setPreferredSize(new Dimension(95,1600));
			pileOfIcons.setVisible(true);
			pileOfIcons.add(new CardDisplay("gold"), new Integer(0));
		
		}	
		comp = new rankComp();
	}
	//shuffles the pile. usually only used for deck
	public void shuffle() {
		Card[] deckPile = arr;
		for(int i = 0; i < 52;i++) {
			
			Card cardToShuffle = deckPile[i];
			int spotToTake = (int)(Math.random()*52);
			deckPile[i] = deckPile[spotToTake];
			deckPile[spotToTake] = cardToShuffle;
			
		}
		pileOfIcons.removeAll();
		for(int i = 0; i < 52; i++) {
			pileOfIcons.add(arr[i].getIcon(), new Integer(i));
		}
		arr = deckPile;
	}
	//returns the type of pile
	public String getType(){
		// Uses the method to check what type pile is
		return type;
	}
	
	//self contained addCard method for each type of pile (has conditionals for each type of pile's add card rules)
	public boolean addCard(Card elem) {
		// Add the element to the card array
		Card topCard = this.topCard();
		
		if(type.equals("BDT")) {
			if(topCard == null) {
				return false;
			}else if(topCard.getRankAsNumber() -1 == elem.getRankAsNumber()) {
				arr[_size] = (elem);
				elem.getIcon().setVerticalAlignment(JLabel.TOP);
		        elem.getIcon().setHorizontalAlignment(JLabel.CENTER);
				
				elem.getIcon().setBounds(0,_size*25 , 95 ,130 );
				elem.getIcon().setVisible(true);
				pileOfIcons.add(elem.getIcon(), new Integer(_size+1));
				_size += 1;
				return true;
			}else {
				return false;
			}
		}else if(type.equals("FCT")) {
			if(topCard == null) {
				arr[_size] = (elem);
				elem.getIcon().setVerticalAlignment(JLabel.TOP);
		        elem.getIcon().setHorizontalAlignment(JLabel.CENTER);
				
				elem.getIcon().setBounds(0,_size*25 , 95 ,130 );
				elem.getIcon().setVisible(true);
				pileOfIcons.add(elem.getIcon(), new Integer(_size+1));
				_size += 1;
				return true;
			}else if(elem.getColor().equals(topCard.getColor()) == false && topCard.getRankAsNumber() -1 == elem.getRankAsNumber()) {
				arr[_size] = elem;
				elem.getIcon().setVerticalAlignment(JLabel.TOP);
		        elem.getIcon().setHorizontalAlignment(JLabel.CENTER);
				elem.getIcon().setBounds(0,_size*25 , 95 ,130 );
				elem.getIcon().setVisible(true);
				pileOfIcons.add(elem.getIcon(), new Integer(_size+1));
				_size += 1;
				return true;
			}else {
				return false;
			}
		}else if(type.contains("H")) {
			if(topCard==null) {
				if(elem.getRankAsNumber() == 1) {
					arr[_size] = (elem);
					elem.getIcon().setVerticalAlignment(JLabel.TOP);
			        elem.getIcon().setHorizontalAlignment(JLabel.CENTER);
			       
					elem.getIcon().setBounds(0,0 , 95 ,130 );
					elem.getIcon().setVisible(true);
					pileOfIcons.add(elem.getIcon(), new Integer(_size+1));
					_size++;
					return true;
				}else {
					return false;
				}
			}else if (elem.getSuit() == topCard.getSuit() && topCard.getRankAsNumber() +1 == elem.getRankAsNumber()) {
				arr[_size] = (elem);
				elem.getIcon().setVerticalAlignment(JLabel.TOP);
		        elem.getIcon().setHorizontalAlignment(JLabel.CENTER);
				elem.getIcon().setBounds(0,0 , 95 ,130 );
				elem.getIcon().setVisible(true);
				pileOfIcons.add(elem.getIcon(), new Integer(_size+1));
				_size++;
				return true;
			}else {
				return false;
			}
		}else if(type.equals("FF")) {
			if(topCard == null) {
				arr[_size] = (elem);
				elem.getIcon().setVerticalAlignment(JLabel.TOP);
		        elem.getIcon().setHorizontalAlignment(JLabel.CENTER);
				elem.getIcon().setBounds(0,0 , 95 ,130 );
				elem.getIcon().setVisible(true);
				pileOfIcons.add(elem.getIcon(), new Integer(_size+1));
				_size++;
				return true;
			}else {
				return false;
			}
		}else if(type.equals("D")) {
			
				arr[_size] = elem;
				elem.getIcon().setVisible(true);
				pileOfIcons.add(elem.getIcon(), new Integer(_size));
				_size++;
				return true;		
		
			//more code needed here
			
			
			
			
			
		}
		
		return false;
		
		// increase _size
		
	}
	//remove top card
	public boolean removeCard(){
		// if size is empty can't remove a card
		if(_size == 0){
			return false;
		}else if(type.contains("T") || type == "D" || type == "FF") {
			// delete the top card
			pileOfIcons.remove(arr[_size-1].getIcon());
			arr[_size-1] = null;
			
			
			// decrease _size
			_size -= 1;
			return true;
		}
		return false;
		
		//stockpile remove code needs to be implemented
		//may or may not be here
		
		
		
		
	}
	
	public boolean legalAdd(Pile origin) {
		
		if(type.equals("AUS")) {
			return false;
		}else if(type.equals("AUT") && origin.getType().equals("AUS")){
			return true;
		}else if(type.equals("AUT") && (false == origin.getType().equals("AUS"))) {
			if(_size == 0) {
				return true;
			}else {
				return false;
			}
		}else if(type.equals("AUH") && origin.getType().equals("AUT")) {
			return true;
			
		}else {
			return false;
		}
	}
	
	public ArrayList<Card> dealStock(){
		ArrayList<Card> retVal = new ArrayList<Card>();
		if(_size != 0) {
			for(int i = 0; i < 4; i++) {
		
				retVal.add(topCard());
				this.blatantRemove();
			}
		}	
		return retVal;
	}
	
	public boolean legalRemoveAndAdd(ArrayList<Card> allTopCardsOfPileType, Pile toGo) {
		if(legalRemove(allTopCardsOfPileType,toGo)&& toGo.legalAdd(this)) {
			return true;
		}else {
			return false;
		}
	}
	public boolean legalRemove(ArrayList<Card> allTopCardsOfPileType,Pile toGo) {
		if(_size == 0) {return false;}
		else {
			if(type.equals("AUS")) {
				return true;
			}else if(type.equals("AUH")) {
				return false;
			}else if(type.equals("AUT")) {
				if(toGo.getType().equals("AUH")) {
					HashMap<Integer,ArrayList<Card>> container = new HashMap<Integer,ArrayList<Card>>();
					int suit = 5;
					for(int i = 0; i < allTopCardsOfPileType.size(); i++) {
						if(container.containsKey(allTopCardsOfPileType.get(i).getSuitAsNumber())) {
							suit = allTopCardsOfPileType.get(i).getSuitAsNumber();
							container.get(suit).add(allTopCardsOfPileType.get(i));
							
						}else {
							ArrayList<Card> temp = new ArrayList<Card>();
							temp.add(allTopCardsOfPileType.get(i));
							container.put(allTopCardsOfPileType.get(i).getSuitAsNumber(), temp);
						}
					}
					if(arr[_size-1].getSuitAsNumber() == suit) {
						
						int biggest = -1;
						for(Card card : container.get(suit)) {
							if(comp.compare(card.getRankAsNumber(), biggest) > 0) {
								biggest = card.getRankAsNumber();
							}
						}
						if(arr[_size-1].getRankAsNumber()!= biggest) {
							
							return true;
						}else {
							return false;
						}
					}else {return false;}
				}else{return true;}
			}
		}return false;
	}
	
	public void blatantAdd(Card elem) {
		if(type.equals("AUT")) {
			arr[_size] = (elem);
			elem.getIcon().setVerticalAlignment(JLabel.TOP);
	        elem.getIcon().setHorizontalAlignment(JLabel.CENTER);
			
			elem.getIcon().setBounds(0,_size*25 , 95 ,130 );
			elem.getIcon().setVisible(true);
			pileOfIcons.add(elem.getIcon(), new Integer(_size+1));
			_size += 1;
		}else {
			arr[_size] = (elem);
			elem.getIcon().setVerticalAlignment(JLabel.TOP);
			elem.getIcon().setHorizontalAlignment(JLabel.CENTER);
			elem.getIcon().setBounds(0,0 , 95 ,130 );
			elem.getIcon().setVisible(true);
			pileOfIcons.add(elem.getIcon(), new Integer(_size+1));
			_size++;
		}	
	}
	
	public boolean removeAndAdd(ArrayList<Card> all,Pile toGo) {
		if(legalRemoveAndAdd(all,toGo)) {
			if(toGo.getType().equals("AUT")){
				toGo.blatantAdd(this.topCard());
			}else {
				toGo.blatantAdd(this.topCard());
			}
			pileOfIcons.remove(arr[_size-1].getIcon());
			arr[_size-1] = null;
			
			// decrease _size
			_size -= 1;
			return true;
			
		}else {
			return false;
		}
	}
	public void blatantRemove() {
		pileOfIcons.remove(arr[_size-1].getIcon());
		arr[_size-1] = null;
		
		// decrease _size
		_size -= 1;
	}
	public boolean legalAndBlatantAdd(Card elem, Pile origin) {
		if(legalAdd(origin)) {
			arr[_size] = elem;
			_size++;
			return true;
		}else {return false;}
	}
	
	public boolean legalAndBlatantRemove(ArrayList<Card> all, Pile toGo) {
		if(legalRemove(all,toGo)) {
			arr[_size-1] = null;
			_size--;
			return true;
		}else {return false;}
	}
	
	private class rankComp implements Comparator<Integer>{
		@Override
		public int compare(Integer arg0, Integer arg1) {
			// TODO Auto-generated method stub
			return arg0-arg1;
		}
	}
	////gets top card
	public Card topCard(){
		// get the top card
		if(_size == 0){
			return null;
		}
		return arr[_size-1];
	}
	//gets size
	public int getSize(){
		// get the size
		return _size;
	}
	//gets card in this arr at index i
	public Card getCard(int i) {
		if(arr[i] != null) {
			return arr[i];
		}
		return null;
				
	}
	//set card at index i in this arr to elem
	public void setCard(int i, Card elem) {
		arr[i] = elem;
		
				
	}
	public void takeDuringDeal(Card elem) {
		if(type.contains("S")) {
			arr[_size] = (elem);
			elem.getIcon().setVerticalAlignment(JLabel.TOP);
	        elem.getIcon().setHorizontalAlignment(JLabel.CENTER);
			elem.getIcon().setVisible(true);
			elem.getIcon().setBounds(0,0 , 95 ,130 );
			pileOfIcons.add(elem.getIcon(), new Integer(_size+1));
			_size++;
		}else {
			arr[_size] = (elem);
			elem.getIcon().setVerticalAlignment(JLabel.TOP);
			elem.getIcon().setHorizontalAlignment(JLabel.CENTER);
			elem.getIcon().setVisible(true);
			elem.getIcon().setBounds(0,_size*25 , 95 ,130 );
			pileOfIcons.add(elem.getIcon(), new Integer(_size+1));
			_size++;
		}
	}
	public Card[] getCards(){
		return arr;
	}
	public JLayeredPane getPileOfIcons() {
		return pileOfIcons;
	}
	public boolean legalAdd(Card elem) {
		Card topCard = this.topCard();
		
		if(type.equals("BDT")) {
			if(topCard == null) {
				return false;
			}else if(topCard.getRankAsNumber() -1 == elem.getRankAsNumber()) {
				
				return true;
			}else {
				return false;
			}
		}else if(type.equals("FCT")) {
			if(topCard == null) {
				
				return true;
			}else if(elem.getColor().equals(topCard.getColor()) == false && topCard.getRankAsNumber() -1 == elem.getRankAsNumber()) {
				
				return true;
			}else {
				return false;
			}
		}else if(type.contains("H")) {
			if(topCard==null) {
				if(elem.getRankAsNumber() == 1) {
					
					return true;
				}else {
					return false;
				}
			}else if (elem.getSuit() == topCard.getSuit() && topCard.getRankAsNumber() +1 == elem.getRankAsNumber()) {
				
				return true;
			}else {
				return false;
			}
		}else if(type.equals("FF")) {
			if(topCard == null) {
				
				return true;
			}else {
				return false;
			}
		}else if(type.equals("D")) {
			return true;
		}
		
		return false;
		
	}
	
	public boolean legalRemove() {
		if(_size == 0){
			return false;
		}else if(type.contains("T") || type == "D" || type == "FF") {
			// delete the top card
			
			return true;
		}
		return false;
	}
	
}
