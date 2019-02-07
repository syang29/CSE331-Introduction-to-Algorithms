package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import code.AcesUp;
import code.Card;
import code.Pile;

public class AcesUpAllPileTests {

	@Test
	public void testInitTab() {
		AcesUp game = new AcesUp();
		assertEquals(1,game.getTableauPile(0).getSize());
	}
	@Test 
	public void tabAddLegalTest() {
		Pile test0 = new Pile("AUT");
		test0.takeDuringDeal(new Card(12,2));
		test0.takeDuringDeal(new Card(5,2));
		test0.takeDuringDeal(new Card(8,3));
		Pile test1 = new Pile("AUT");
		Pile test2 = new Pile("AUS");
		test2.takeDuringDeal(new Card(5,1));
		test2.takeDuringDeal(new Card(9,1));
		test2.takeDuringDeal(new Card(8,3));
		
		//can i add to an empty spot, can i add from stock to tablea, can i add from tableau to tableau
		assertTrue(test1.legalAndBlatantAdd(test0.topCard(), test0));
		assertFalse(test1.legalAndBlatantAdd(test0.topCard(), test0));
		assertTrue(test1.legalAndBlatantAdd(test2.topCard(), test2));
		assertTrue(test0.legalAndBlatantAdd(test2.topCard(), test2));
		
	}
	
	@Test
	public void tabRemoveLegalTest() {
		Card one = new Card(8,1);
		ArrayList<Card> toTest = new ArrayList<Card>();
		toTest.add(new Card(5,3));
		toTest.add(new Card(10,2));
		toTest.add(one);
		toTest.add(new Card(9,1));
		Pile test0 = new Pile("AUT");
		test0.takeDuringDeal(new Card(12,2));
		test0.takeDuringDeal(new Card(5,2));
		test0.takeDuringDeal(one);
		Pile test1 = new Pile("AUT");
		Pile test2 = new Pile("AUH");
		assertTrue(test0.legalAndBlatantRemove(toTest, test1));
		test0.takeDuringDeal(one);
		assertTrue(test0.legalAndBlatantRemove(toTest, test2));
		ArrayList<Card> toTest2 = new ArrayList<Card>();
		toTest.add(new Card(5,3));
		toTest.add(new Card(10,2));
		toTest.add(one);
		toTest.add(new Card(9,3));
		assertFalse(test0.legalAndBlatantRemove(toTest2, test2));
		
	}
	@Test 
	public void tabAddChangeTest() {
		Pile test0 = new Pile("AUT");
		test0.takeDuringDeal(new Card(12,2));
		test0.takeDuringDeal(new Card(5,2));
		test0.takeDuringDeal(new Card(8,3));
		Pile test1 = new Pile("AUT");
		Pile test2 = new Pile("AUS");
		test2.takeDuringDeal(new Card(5,1));
		test2.takeDuringDeal(new Card(9,1));
		test2.takeDuringDeal(new Card(8,3));
		
		//can i add to an empty spot, can i add from stock to tablea, can i add from tableau to tableau
		int size = test1.getSize();
		test1.legalAndBlatantAdd(test0.topCard(), test0);
		assertEquals(test1.topCard(), test0.topCard());
		assertEquals(test1.getSize(),size+1);
		
	}
	@Test
	public void tabRemoveChangeTest() {
		Card one = new Card(8,1);
		ArrayList<Card> toTest = new ArrayList<Card>();
		toTest.add(new Card(5,3));
		toTest.add(new Card(10,2));
		toTest.add(one);
		toTest.add(new Card(9,1));
		Pile test0 = new Pile("AUT");
		test0.takeDuringDeal(new Card(12,2));
		test0.takeDuringDeal(new Card(5,2));
		test0.takeDuringDeal(one);
		Pile test1 = new Pile("AUT");
		int size = test0.getSize();
		Card top = test0.topCard();
		test0.legalAndBlatantRemove(toTest, test1);
		
		assertFalse(test0.topCard().equals(top));
		assertEquals(test0.getSize(),size-1);
				
	}
	
	@Test
	public void testInitHom() {
		AcesUp game = new AcesUp();
		assertEquals(0,game.getHomeCellPile(0).getSize());
	}
	@Test 
	public void homAddLegalTest() {
		Pile test0 = new Pile("AUT");
		test0.takeDuringDeal(new Card(12,2));
		test0.takeDuringDeal(new Card(5,2));
		test0.takeDuringDeal(new Card(8,3));
		Pile test1 = new Pile("AUT");
		Pile test2 = new Pile("AUS");
		test2.takeDuringDeal(new Card(5,1));
		test2.takeDuringDeal(new Card(9,1));
		test2.takeDuringDeal(new Card(8,3));
		
		Pile test3 = new Pile("AUH");
		assertTrue(test3.legalAndBlatantAdd(test0.topCard(), test0));
		assertFalse(test3.legalAndBlatantAdd(test2.topCard(), test2));
		
		
	}
	
	@Test
	public void homRemoveLegalTest() {
		Card one = new Card(8,1);
		ArrayList<Card> toTest = new ArrayList<Card>();
		
		toTest.add(one);
		
		Pile test0 = new Pile("AUT");
		test0.takeDuringDeal(new Card(12,2));
		test0.takeDuringDeal(new Card(5,2));
		test0.takeDuringDeal(one);
		Pile test1 = new Pile("AUS");
		Pile test2 = new Pile("AUH");
		assertFalse(test2.legalAndBlatantRemove(toTest, test1));
		assertFalse(test2.legalAndBlatantRemove(toTest, test0));
		
	}
	@Test 
	public void homAddChangeTest() {
		Pile test0 = new Pile("AUT");
		test0.takeDuringDeal(new Card(12,2));
		test0.takeDuringDeal(new Card(5,2));
		test0.takeDuringDeal(new Card(8,3));
		Pile test1 = new Pile("AUT");
		Pile test2 = new Pile("AUS");
		test2.takeDuringDeal(new Card(5,1));
		test2.takeDuringDeal(new Card(9,1));
		test2.takeDuringDeal(new Card(8,3));
		Pile test3 = new Pile("AUH");
		//can i add to an empty spot, can i add from stock to tablea, can i add from tableau to tableau
		int size = test3.getSize();
		test3.legalAndBlatantAdd(test0.topCard(), test0);
		assertEquals(test3.topCard(), test0.topCard());
		assertEquals(test3.getSize(),size+1);
		
	}
	@Test
	public void testInitSt() {
		AcesUp game = new AcesUp();
		assertEquals(48,game.getStockPile(0).getSize());
	}
	@Test 
	public void stAddLegalTest() {
		Pile test0 = new Pile("AUT");
		test0.takeDuringDeal(new Card(12,2));
		test0.takeDuringDeal(new Card(5,2));
		test0.takeDuringDeal(new Card(8,3));
		
		Pile test2 = new Pile("AUS");
		
		assertFalse(test2.legalAndBlatantAdd(test0.topCard(), test0));
		assertFalse(test2.legalAndBlatantAdd(new Card(5,1), test0));
		
	}
	
	@Test
	public void stRemoveLegalTest() {
		Card one = new Card(8,1);
		ArrayList<Card> toTest = new ArrayList<Card>();
		
		toTest.add(one);
		
		Pile test0 = new Pile("AUT");
		test0.takeDuringDeal(new Card(12,2));
		test0.takeDuringDeal(new Card(5,2));
		
		Pile test1 = new Pile("AUS");
		assertFalse(test1.legalAndBlatantRemove(toTest, test0));
		test1.takeDuringDeal(new Card(12,2));
		assertTrue(test1.legalAndBlatantRemove(toTest, test0));
		
		
	}
	@Test 
	public void stDealStockTest() {
		Card testing = new Card(12,2);
		Pile test0 = new Pile("AUS");
		test0.takeDuringDeal(testing);
		test0.takeDuringDeal(new Card(5,2));
		test0.takeDuringDeal(new Card(8,3));
		test0.takeDuringDeal(new Card(5,1));
		test0.takeDuringDeal(new Card(9,1));
		
		
		//can i add to an empty spot, can i add from stock to tablea, can i add from tableau to tableau
		
		test0.dealStock();
		assertEquals(test0.topCard(),testing);
		assertEquals(test0.getSize(),1);
		
	}
	
	
}
