package tests;


import static org.junit.Assert.*;
import org.junit.Test;

import code.BakersDozen;
import code.Card;
import code.FreeCell;
import code.Pile;


public class TableauPileTests {

	
	@Test
	public void fcInitialSetupTest(){
		//Tableau piles in Freecell initially hold 6 or 7 cards 
		FreeCell test=new FreeCell();
		Pile testPile = test.getTableauPile(1);
		assertTrue(testPile.getSize() ==  6 || testPile.getSize() ==7);
		
	}
	
	@Test
	public void bdInitialSetupTest(){
		//Tableau piles in Baker's Dozen initially hold 4 cards
		BakersDozen test = new BakersDozen();
		Pile testPile = test.getTableauPile(1);
		assertEquals(4,testPile.getSize());
	}
	
	@Test
	public void fcSelectiveAddTest(){
		//Freecell tableau pile correctly determines if adding a specific card is legal or illegal 
		Pile testPile = new Pile("FCT");
		assertTrue(testPile.addCard(new Card(5,2)));
		assertTrue(testPile.addCard(new Card(4,3)));
		assertFalse(testPile.addCard(new Card(4,2)));
		assertFalse(testPile.addCard(new Card(3,3)));
		
	}
	
	@Test
	public void bdSelectiveAddTest(){
	// Baker's Dozen tableau pile correctly determines 
    // if adding a specific card is legal or illegal
		Pile testPile = new Pile("BDT");
		assertFalse(testPile.addCard(new Card(5,2)));
		testPile.takeDuringDeal(new Card(7,2));
		assertTrue(testPile.addCard(new Card(6,2)));
		assertTrue(testPile.addCard(new Card(5,3)));
		assertFalse(testPile.addCard(new Card(6,3)));
	}
	@Test
	public void fcRemoveLegalTest(){
	//Freecell tableau pile correctly returns if removing top card is legal or illegal 
		
		
		Pile testPile = new Pile("FCT");
		assertFalse(testPile.removeCard());
		testPile.addCard(new Card(1,3));
		assertTrue(testPile.removeCard());	
	}
	
	//Baker's Dozen tableau pile correctly returns if removing top card is legal or 
	//illegal (e.g., if the tableau pile is NOT empty) [4 points]
	@Test
	public void bdRemoveLegalTest() {
		
		
		Pile testPile = new Pile("BDT");
		assertFalse(testPile.removeCard());
		testPile.takeDuringDeal(new Card(1,3));
		assertTrue(testPile.removeCard());
	}
		
	//Adding card to Freecell tableau pile increases its number of cards and results in 
	//that card being the tableau pile's new top card [4 points]
	@Test 
	public void fcAddIncrementTest() {
		
		Pile testPile = new Pile("FCT");
		testPile.addCard(new Card(5,3));
		assertEquals(testPile.getSize(), 1);
		Card check = new Card(4,2);
		testPile.addCard(check);
		
		assertEquals(testPile.getSize(), 2);
		assertEquals(testPile.topCard(),check);
	}
	
	//Adding card to Baker's Dozen tableau pile increases its number of cards and results 
	//in that card being the tableau pile's new top card [4 points]
	@Test
	public void bdAddIncrementTest() {
		Pile testPile = new Pile("BDT");
		testPile.addCard(new Card(5,3));
		assertEquals(testPile.getSize(), 0);
		testPile.takeDuringDeal(new Card(6,2));
		Card check = new Card(5,2);
		testPile.addCard(check);
		assertEquals(testPile.getSize(),2);
		
		assertEquals(testPile.topCard(),check);
	}
	
	//Removing card from Freecell tableau pile decreases its number of cards and results in 
	//following card being the new top card [4 points]
	@Test
	public void fcRemoveIncrementTest() {
		Pile testPile = new Pile("FCT");
		Card testing = new Card(5,3);
		testPile.takeDuringDeal(testing);
		testPile.addCard(new Card(4,2));
		testPile.removeCard();
		assertEquals(testPile.getSize(), 1);
		assertEquals(testPile.topCard(),testing);
	}
	
	
	//Removing card from Baker's Dozen tableau pile decreases its number of cards and results in 
	//following card being the new top card [4 points]
	@Test
	public void bdRemoveIncrementTest() {
		Pile testPile = new Pile("BDT");
		Card testing = new Card(5,3);
		testPile.takeDuringDeal(testing);
		testPile.addCard(new Card(4,3));
		testPile.removeCard();
		assertEquals(testPile.getSize(), 1);
		assertEquals(testPile.topCard(),testing);
		
	}
}
	
	
	

