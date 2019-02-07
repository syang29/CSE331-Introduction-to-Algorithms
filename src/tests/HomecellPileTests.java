package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import code.BakersDozen;
import code.Card;
import code.FreeCell;
import code.Pile;

public class HomecellPileTests {

	@Test
	public void freeCellInitiallyHoldTest() {
		// Test to see if Homecell piles in Freecell initially hold 0 cards
		FreeCell obj = new FreeCell();
		// Assert homeCell pile1 initially holds 0 cards
		assertEquals(0, obj.getHomeCellPile(1).getSize());
		// Assert homeCell pile2 initially holds 0 cards
		assertEquals(0, obj.getHomeCellPile(2).getSize());
		// Assert homeCell pile3 initially holds 0 cards
		assertEquals(0, obj.getHomeCellPile(3).getSize());
		
	}
	@Test
	public void bakersDozenInitiallyHoldTest() {
		// Test to see if Homecell piles in Baker's Dozen initially hold 0 cards 
		BakersDozen obj = new BakersDozen();
		// Assert homeCell pile1 initially holds 0 cards
		assertEquals(0, obj.getHomeCellPile(1).getSize());
		// Assert homeCell pile2 initially holds 0 cards
		assertEquals(0, obj.getHomeCellPile(2).getSize());
		// Assert homeCell pile3 initially holds 0 cards
		assertEquals(0, obj.getHomeCellPile(3).getSize());
		// Assert homeCell pile4 initially holds 0 cards
		
	}
	@Test
	public void freeCellCorrectlyAddingTest(){
		// Test to see if Freecell homecell pile correctly determines if adding a specific card is legal or illegal
			/*
			 * A card can be added to a homecell pile if it has the identical suit 
			 * and a value one more than the homecell's top card
			 * The added card becomes the homecell's new top card
			 */
		FreeCell obj = new FreeCell();
		// Creates a queen of hearts card object
		Card obj1 = new Card(12, 2);
		// Creates a ace of spades card object
		Card obj2 = new Card(1, 3);
		// Creates a 2 of spades card object
		Card obj3 = new Card(2, 3);
		// Creates a 3 of hearts card object
		Card obj4 = new Card(3, 2);
		// Creates a 4 of spades card object
		Card obj5 = new Card(4, 3);
		// Creates a 3 of spades card object
		Card obj6 = new Card(3, 3);
		// Assert it's illegal to add a queen of hearts because the pile is empty  
		assertFalse(obj.getHomeCellPile(1).addCard(obj1));
		// Assert it's legal to add an ace of spades
		assertTrue(obj.getHomeCellPile(1).addCard(obj2));
		// Assert it's legal to add a value one more than homecell's top card
		assertTrue(obj.getHomeCellPile(1).addCard(obj3));
		// Assert it's illegal to add card without the identical suit 
		assertFalse(obj.getHomeCellPile(1).addCard(obj4));
		/* Assert it's illegal to add card with identical suit, 
		 * but not a value one more than the homecell's top card
		 */
		assertFalse(obj.getHomeCellPile(1).addCard(obj5));
		/* Assert it's legal to add card with identical suit
		 * and a value one more than the homecell's top card 
		 */
		assertTrue(obj.getHomeCellPile(1).addCard(obj6));
		
	}
	@Test
	public void bakersDozenCorrectlyAddingTest(){
		// Test to see if Baker's Dozen homecell pile correctly determines if adding a specific card is legal or illegal
				/*
				 * A card can be added to a homecell pile if it has the identical suit 
				 * and a value one more than the homecell's top card
				 * The added card becomes the homecell's new top card
				 */
		BakersDozen obj = new BakersDozen();
		// Creates a queen of hearts card object
		Card obj1 = new Card(12, 2);
		// Creates a ace of spades card object
		Card obj2 = new Card(1, 3);
		// Creates a 2 of spades card object
		Card obj3 = new Card(2, 3);
		// Creates a 3 of hearts card object
		Card obj4 = new Card(3, 2);
		// Creates a 4 of spades card object
		Card obj5 = new Card(4, 3);
		// Creates a 3 of spades card object
		Card obj6 = new Card(3, 3);
		// Assert it's illegal to add a queen of hearts because the pile is empty  
		assertFalse(obj.getHomeCellPile(1).addCard(obj1));
		// Assert it's legal to add an ace of spades
		assertTrue(obj.getHomeCellPile(1).addCard(obj2));
		// Assert it's legal to add a value one more than homecell's top card
		assertTrue(obj.getHomeCellPile(1).addCard(obj3));
		// Assert it's illegal to add card without the identical suit 
		assertFalse(obj.getHomeCellPile(1).addCard(obj4));
		/* Assert it's illegal to add card with identical suit, 
		 * but not a value one more than the homecell's top card
		 */
		assertFalse(obj.getHomeCellPile(1).addCard(obj5));
		/* Assert it's legal to add card with identical suit
		 * and a value one more than the homecell's top card 
		 */
		assertTrue(obj.getHomeCellPile(1).addCard(obj6));
	}
	@Test
	public void freeCellCorrectlyReturnsTest() {
		// Test to see if Freecell homecell pile correctly returns if removing top card is legal or illegal (e.g., always false) 
		FreeCell obj = new FreeCell();
		Card obj1 = new Card(1, 0);
		// Assert that cards can't be removed from a empty homecell pile
		assertFalse((obj.getHomeCellPile(1)).removeCard());
		// Add an ace to the empty homecell
		obj.getHomeCellPile(1).addCard(obj1);
		// Assert that cards can't be removed from a homecell pile
		assertFalse((obj.getHomeCellPile(1)).removeCard());
	}
	//Baker's Dozen homecell pile correctly returns if removing top card is legal or illegal
	@Test
	public void homeCellCorrectlyReturns() {
		Pile Test = new Pile("BDH");
		assertFalse(Test.removeCard());
		Test.addCard(new Card(5, 3));
		assertFalse(Test.removeCard());
	}
	//Adding card to Freecell homecell pile increases its number of cards 
	//and results in that card being the homecell pile's new top card
	@Test
	public void homeCellAddTest() {
		FreeCell Test= new FreeCell();
		Pile Result = Test.getHomeCellPile(1);
		Card card = new Card(1,3);
		Result.addCard(card);
		assertFalse(Result.removeCard());
		assertEquals(Result.topCard(), card);
	}
	//Adding card to Baker's Dozen homecell pile increases its number of cards and
	//results in that card being the homecell pile's new top card
	@Test
	public void bakersDozenAddTest() {
		BakersDozen Test = new BakersDozen();
		Pile Result = Test.getHomeCellPile(1);
		Card card = new Card(1,3);
		int size = Result.getSize();
		Result.addCard(card);
		assertEquals(Result.getSize(), size + 1);
		assertEquals(Result.topCard(), card);
	}
	
}












