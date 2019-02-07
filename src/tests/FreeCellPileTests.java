package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.Card;
import code.FreeCell;
import code.Pile;

public class FreeCellPileTests {

	@Test
	//Freecell piles in Freecell begin holding 0 cards
	public void fcInitialSetupTest() {
		FreeCell Test = new FreeCell();
		assertEquals(0, Test.getFreeCellPile(1).getSize());
		assertEquals(0, Test.getFreeCellPile(2).getSize());
		assertEquals(0, Test.getFreeCellPile(3).getSize());
		
	}
	//Freecell freecell pile correctly returns if adding a specific card is legal or illegal
	@Test
	public void fcAddCardTest() {
		FreeCell test = new FreeCell();
		Pile testPile = test.getFreeCellPile(1);

		assertTrue(testPile.addCard(new Card(1,3)));
		assertEquals(testPile.getSize(), 1);
		assertFalse(testPile.addCard(new Card(10,2)));

	}


	//Freecell freecell pile correctly returns if removing top card
	//is legal or illegal (e.g., if the freecell pile is NOT empty) [2 points]
	@Test
	public void fcRemoveCardTest() {
		FreeCell test = new FreeCell();
		Pile testPile = test.getFreeCellPile(1);
		assertFalse(testPile.removeCard());
		testPile.addCard(new Card(1,3));

		assertTrue(testPile.removeCard());
		assertEquals(testPile.getSize(), 0);

	}


	//Adding card to Freecell freecell pile increases its number of cards and 
	//results in that card being the freecell pile's new top card [2 points]
	@Test 
	public void fcAddCardTest2() {
		
		Pile testPile = new Pile("FF");
		Card put = new Card(5,3);
		testPile.addCard(put);
		assertEquals(testPile.getSize(),1);
		assertEquals(testPile.topCard(), put);
	}
}
