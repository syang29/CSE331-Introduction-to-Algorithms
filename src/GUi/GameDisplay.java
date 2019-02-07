package GUi;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import code.BakersDozen;
import code.Card;
import code.FreeCell;
import code.Pile;
import code.AcesUp;

public class GameDisplay extends JPanel{
		
		/**
	 * 
	 */
		private static final long serialVersionUID = 1L;
		private static final Border UNSELECTED_BORDER = BorderFactory.createEmptyBorder(5, 5, 5, 5);
	    private static final Border SELECTED_BORDER = BorderFactory.createMatteBorder(5, 5, 5, 5,Color.BLACK);
	    private JOptionPane displayMessage;
    	private Card selectedCard;   
	    private Pile selectedPile;
	    private GameMouseListener selectedMouseListener;
		private String nameOfGame;
				
		private FreeCell fcGame;
		private BakersDozen bdGame;
		private AcesUp auGame;
		
	 	public GameDisplay(){
	 		Pile pile = new Pile("D");
	 		
			for(int i=0; i<52; i++){
				this.add(pile.getCard(i).getIcon());
			}
			displayMessage = new JOptionPane();
			displayMessage.setVisible(true);
	 	}
	 	// create the menu bar for game
	 	
	 	
	 	private void newFreeCellGame(){
	 		this.removeAll();
	 		displayMessage = new JOptionPane();
			displayMessage.setVisible(true);
	 		JPanel tableaus = new JPanel();
	 		JPanel homecells = new JPanel();
	 		JPanel freecells = new JPanel();
	 		
	 		
	 		this.add("Homecells", homecells);
	 		this.add("Freecells",freecells);
	 		this.add("Tableaus",tableaus);
	 		
	 		tableaus.setVisible(true);
	 		homecells.setVisible(true);
	 		freecells.setVisible(true);
	 		
	 		
	 		nameOfGame = "Freecell";
	 		FreeCell newGame = new FreeCell();
	 		fcGame = newGame;
	 		for(int i = 0; i < 8; i++) {
	 			tableaus.add(fcGame.getTableauPile(i).getPileOfIcons());
	 			fcGame.getTableauPile(i).topCard().getIcon().addMouseListener(
	 					new GameMouseListener(fcGame.getTableauPile(i).topCard(),fcGame.getTableauPile(i)));
	 			
	 		}
	 		
	 		for(int i = 0; i < 4; i++) {
	 			homecells.add(fcGame.getHomeCellPile(i).getPileOfIcons());
	 			fcGame.getHomeCellPile(i).getPileOfIcons().getComponent(0).addMouseListener(new GameMouseListener(
	 					null,fcGame.getHomeCellPile(i)));
	 			freecells.add(fcGame.getFreeCellPile(i).getPileOfIcons());
	 			fcGame.getFreeCellPile(i).getPileOfIcons().getComponent(0).addMouseListener(new GameMouseListener(
	 					null,fcGame.getFreeCellPile(i)));
	 			
	 		}
	 		
	 	}
	 	
	 	private void newBakersDozenGame(){
	 		this.removeAll();
	 		displayMessage = new JOptionPane();
			displayMessage.setVisible(true);
	 		JPanel tableaus = new JPanel();
	 		JPanel homecells = new JPanel();
	 		
	 		this.add(homecells);
	 		this.add(tableaus);
	 	
	 		tableaus.setVisible(true);
	 		homecells.setVisible(true);
	 		
	 		
	 	
	 		nameOfGame = "Bakers Dozen";
	 		BakersDozen newGame = new BakersDozen();
	 		bdGame = newGame;
	 		for(int i = 0; i < 13; i++) {
	 			tableaus.add(bdGame.getTableauPile(i).getPileOfIcons());
	 			bdGame.getTableauPile(i).topCard().getIcon().addMouseListener(
	 					new GameMouseListener(bdGame.getTableauPile(i).topCard(),bdGame.getTableauPile(i)));
	 		}
	 		for(int i = 0; i < 4; i++) {
	 			homecells.add(bdGame.getHomeCellPile(i).getPileOfIcons());
	 			bdGame.getHomeCellPile(i).getPileOfIcons().getComponent(0).addMouseListener(new GameMouseListener(
	 					null,bdGame.getHomeCellPile(i)));
	 		}
	 	
	 	}
	 	private void newAcesUpGame() {
	 		this.removeAll();
	 		displayMessage = new JOptionPane();
			displayMessage.setVisible(true);
	 		JPanel tableaus = new JPanel();
	 		JPanel homecell= new JPanel();
	 		JPanel stock = new JPanel();
	 		
	 		this.add(stock);
	 		this.add(homecell);
	 		this.add(tableaus);
	 		
	 		tableaus.setVisible(true);
	 		homecell.setVisible(true);
	 		stock.setVisible(true);
	 		nameOfGame = "Aces Up";
	 		AcesUp newGame = new AcesUp();
	 		auGame = newGame;
	 		
	 		for(int i = 0; i < 4; i++) {
	 			tableaus.add(auGame.getTableauPile(i).getPileOfIcons());
	 			MouseListener temp=new GameMouseListener(auGame.getTableauPile(i).topCard(),auGame.getTableauPile(i));
	 			auGame.getTableauPile(i).topCard().getIcon().addMouseListener(temp);
	 			auGame.getTableauPile(i).topCard().getIcon().setLis(temp);
	 		}
	 		
	 		for(int i = 0; i < 1; i++) {
	 			homecell.add(auGame.getHomeCellPile(i).getPileOfIcons());
	 			MouseListener temp1 = new GameMouseListener(null,auGame.getHomeCellPile(i));
	 			auGame.getHomeCellPile(i).getPileOfIcons().getComponent(0).addMouseListener(temp1);
	 			CardDisplay hold = (CardDisplay)auGame.getHomeCellPile(i).getPileOfIcons().getComponent(0);
	 			hold.setLis(temp1);
	 			stock.add(auGame.getStockPile(i).getPileOfIcons());
	 			MouseListener temp2 = new GameMouseListener(null,auGame.getStockPile(i));
	 			auGame.getStockPile(i).getPileOfIcons().getComponent(0).addMouseListener(temp2);
	 			CardDisplay hold2 = (CardDisplay)auGame.getStockPile(i).getPileOfIcons().getComponent(0);
	 			hold2.setLis(temp2);
	 			
	 		}
	 		//need to include loops for implementation of piles
	 	}
	 	
	 	 public void select(JLabel toSet) {
	   	      toSet.setBorder(SELECTED_BORDER);
	   	      toSet.repaint();
	   	    }

	   	    public void unselect(JLabel toSet) {
	   	      toSet.setBorder(UNSELECTED_BORDER);
	   	      toSet.repaint();
	   	    }     
	   
	 	//Makes the mouse listener for cards that need it that changes color of border if supposed to and switches cards
	    //around if allowed by the add and remove methods.
	    public class GameMouseListener implements MouseListener{
	    	JLabel toAffect;
	    	Card cardToAffect;
	    	Pile cardLocation;
	    	GameMouseListener mouseReference;
	    	
	    	public GameMouseListener(Card pressed, Pile pileContainingCard) {
	    		displayMessage = new JOptionPane();
	    		if(pressed == null){
	    			cardToAffect = null;
	    			toAffect = null;
	    			cardLocation = pileContainingCard;
	    		}else {
	    			cardToAffect = pressed;
	    			toAffect = pressed.getIcon();
	    			cardLocation = pileContainingCard;
	    		}	
	    		mouseReference = this;
	    	}
	    	
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
			if(auGame == null) {	
				if(cardToAffect == null) {
					if(selectedCard == null) {
						displayMessage.createDialog("Invalid Move");
					}else if(cardLocation.legalAdd(selectedCard) && selectedPile.legalRemove()) {
						unselect(selectedCard.getIcon());
						cardLocation.getPileOfIcons().getComponent(0).removeMouseListener(mouseReference);
						
						cardLocation.addCard(selectedCard);
						selectedCard.getIcon().removeMouseListener(selectedMouseListener);
						selectedPile.removeCard();
						
						cardLocation.topCard().getIcon().addMouseListener(new GameMouseListener(
								cardLocation.topCard(),cardLocation));
						
						if(selectedPile.getSize() != 0) {
							selectedPile.topCard().getIcon().addMouseListener(new GameMouseListener(
									selectedPile.topCard(),selectedPile));
						}else {
							selectedPile.getPileOfIcons().getComponent(0).addMouseListener(new GameMouseListener(
									null,selectedPile));
						}
								
						
						selectedCard = null;
						selectedPile = null;
						selectedMouseListener = null;
						displayMessage.createDialog("Valid Move");
					}else {
						unselect(selectedCard.getIcon());
						selectedCard = null;
						selectedPile = null;
						selectedMouseListener = null;
						displayMessage.createDialog("Invalid Move");
					}
				}else 
					
						if(selectedCard == null) {
							select(toAffect);
							selectedCard = cardToAffect;
							selectedPile = cardLocation;
							selectedMouseListener = mouseReference;
						}else if(selectedCard.equals(cardToAffect)){
							unselect(toAffect);
							selectedCard = null;
							selectedPile = null;
							selectedMouseListener = null;
						}else {
							if(cardLocation.legalAdd(selectedCard) && selectedPile.legalRemove()) {
								unselect(selectedCard.getIcon());
								cardLocation.topCard().getIcon().removeMouseListener(mouseReference);
								
								cardLocation.addCard(selectedCard);
								selectedPile.removeCard();
								cardLocation.topCard().getIcon().removeMouseListener(selectedMouseListener);
								cardLocation.topCard().getIcon().addMouseListener(new GameMouseListener(
										cardLocation.topCard(),cardLocation));
								
								selectedCard = null;
								
								if(selectedPile.getSize() != 0) {
									selectedPile.topCard().getIcon().addMouseListener(new GameMouseListener(
											selectedPile.topCard(), selectedPile));
								}else {
									selectedPile.getPileOfIcons().getComponent(0).addMouseListener(new GameMouseListener(
											null, selectedPile));
								}
								selectedPile = null;
								displayMessage.createDialog("Valid Move");
							}else {
								unselect(selectedCard.getIcon());
								selectedCard = null;
								selectedPile = null;
								displayMessage.createDialog("Invalid Move");
							}
						}
			}else {
				if(cardLocation.getType().equals("AUS")) {
					if(cardLocation.getSize() > 0) {
						ArrayList<Card> tops = auGame.topCards();
						for(int i = 0; i < tops.size(); i++) {
							tops.get(i).getIcon().removeMouseListener(tops.get(i).getIcon().getLis());
						}
						cardLocation.topCard().getIcon().removeMouseListener(cardLocation.topCard().getIcon().getLis());
						ArrayList<Card> container = cardLocation.dealStock();
						for(int i = 0; i < container.size(); i++) {
							auGame.getTableauPile(i).blatantAdd(container.get(i));
							MouseListener temp = new GameMouseListener(auGame.getTableauPile(i).topCard(),auGame.getTableauPile(i));
							auGame.getTableauPile(i).topCard().getIcon().addMouseListener(temp);
							auGame.getTableauPile(i).topCard().getIcon().setLis(temp);
						}
						MouseListener temp = new GameMouseListener(cardLocation.topCard(),cardLocation);
						cardLocation.topCard().getIcon().addMouseListener(temp);
						cardLocation.topCard().getIcon().setLis(temp);
						//remember to change all places where I add mouselistener to icon to add it to card too
						//I'll have to remove action listener from previous top cards of tableaus, and
						//the top card of stock, give action listener to new top cards of tableaus and new top stock
						//solution, give each card their own action listener
					}else {
						displayMessage.createDialog("Invalid Move");
					}
				}else {
				if(cardToAffect == null) {
					if(selectedCard == null) {
						displayMessage.createDialog("Invalid Move");
					}else if(selectedPile.legalRemoveAndAdd(auGame.topCards(), cardLocation)) {
						
						unselect(selectedCard.getIcon());
						cardLocation.getPileOfIcons().getComponent(0).removeMouseListener(mouseReference);
						
						cardLocation.blatantAdd(selectedCard);
						selectedCard.getIcon().removeMouseListener(selectedMouseListener);
						selectedPile.blatantRemove();
						MouseListener temp1 = new GameMouseListener(cardLocation.topCard(),cardLocation);
						cardLocation.topCard().getIcon().addMouseListener(temp1);
						cardLocation.topCard().getIcon().setLis(temp1);
						if(selectedPile.getSize() != 0) {
							MouseListener temp2 = new GameMouseListener(selectedPile.topCard(),selectedPile);
							selectedPile.topCard().getIcon().addMouseListener(temp2);
							selectedPile.topCard().getIcon().setLis(temp2);
						}else {
							MouseListener temp3 = new GameMouseListener(null,selectedPile);
							selectedPile.getPileOfIcons().getComponent(0).addMouseListener(temp3);
							CardDisplay hold = (CardDisplay)selectedPile.getPileOfIcons().getComponent(0);
							hold.setLis(temp3);
						}
								
						
						selectedCard = null;
						selectedPile = null;
						selectedMouseListener = null;
						displayMessage.createDialog("Valid Move");
					}else {
						unselect(selectedCard.getIcon());
						selectedCard = null;
						selectedPile = null;
						selectedMouseListener = null;
						displayMessage.createDialog("Invalid Move");
					}
				}else 
					
						if(selectedCard == null) {
							select(toAffect);
							selectedCard = cardToAffect;
							selectedPile = cardLocation;
							selectedMouseListener = mouseReference;
						}else if(selectedCard.equals(cardToAffect)){
							unselect(toAffect);
							selectedCard = null;
							selectedPile = null;
							selectedMouseListener = null;
						}else {
							if(selectedPile.legalRemoveAndAdd(auGame.topCards(), cardLocation)) {
								unselect(selectedCard.getIcon());
								cardLocation.topCard().getIcon().removeMouseListener(mouseReference);
								
								cardLocation.blatantAdd(selectedCard);
								selectedPile.blatantRemove();
								cardLocation.topCard().getIcon().removeMouseListener(selectedMouseListener);
								MouseListener temp1 = new GameMouseListener(cardLocation.topCard(),cardLocation);
								cardLocation.topCard().getIcon().addMouseListener(temp1);
								cardLocation.topCard().getIcon().setLis(temp1);
								
								selectedCard = null;
								
								if(selectedPile.getSize() != 0) {
									MouseListener temp2 = new GameMouseListener(selectedPile.topCard(),selectedPile);
									selectedPile.topCard().getIcon().addMouseListener(temp2);
									selectedPile.topCard().getIcon().setLis(temp2);
								}else {
									MouseListener temp3 = new GameMouseListener(null, selectedPile);
									selectedPile.getPileOfIcons().getComponent(0).addMouseListener(temp3);
									CardDisplay hold = (CardDisplay)selectedPile.getPileOfIcons().getComponent(0);
									hold.setLis(temp3);
								}
								selectedPile = null;
								displayMessage.createDialog("Valid Move");
							}else {
								unselect(selectedCard.getIcon());
								selectedCard = null;
								selectedPile = null;
								displayMessage.createDialog("Invalid Move");
							}
						}
				}}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
	    	
	    }
	    
	    public String getNameOfGame() {
	    	return nameOfGame;
	    }
	    public JMenuBar menuBar(){
	 		
 			JMenuBar menuBar= new JMenuBar();				
 			JMenu game = new JMenu("Menu");
 			MenuPick click= new MenuPick();
 			// add sub menu for new game 
 			menuBar.add(game);
 			addItem(game,"Free Cell", click);
 			addItem(game,"Bakers Dozen", click);
 			addItem(game,"Aces Up", click);
 			addItem(game,"Exit", click);
 			
 			addItem(game, "Don't press me.", click);
 			addItem(game, "Oh! What's this?", click);

 			return menuBar;
 				
 		}	

	 	// access different menu 
	 	private void addItem(JMenu menu,String button,ActionListener click){
	 		JMenuItem menuChoice = new JMenuItem(button);
	 		menuChoice.addActionListener(click);
	 		menu.add(menuChoice);
	 			
	 	}
	 	// action when a sub menu is clicked 
	 	private class MenuPick implements ActionListener {
	 	    public void actionPerformed(ActionEvent evt) {
	 	         String menuChoice = evt.getActionCommand();
	 	         if (menuChoice.equals("Exit")){
	 	        	 System.exit(0);
	 	         }
	 	         else if(menuChoice.equals("Free Cell")){ 
	 	            JOptionPane.showConfirmDialog(null, "Free Cell");
	 	            newFreeCellGame();
	 	            	
	 	         }
	 	         else if(menuChoice.equals("Bakers Dozen")){ 
	 	        	JOptionPane.showConfirmDialog(null, "Bakers Dozen");
	 	        	newBakersDozenGame();
	 	           
	 	         }
	 	         else if(menuChoice.equals("Aces Up")){
	 	        	JOptionPane.showConfirmDialog(null, "Aces Up");
	 	        	newAcesUpGame();
	 	         }
	 	         if (menuChoice.equals("Oh! What's this?")){
	 	        	 JOptionPane.showMessageDialog(displayMessage, "ITS A SPICY SURPRISE! Yes, I know. Exciting isn't it?");
	 	        	 JOptionPane.showMessageDialog(displayMessage, "',:^)");
	 	         }
	 	         if (menuChoice.equals("Don't press me.")){
	 	        	JOptionPane.showMessageDialog(displayMessage, "Why did you do it?");
	 	        	JOptionPane.showMessageDialog(displayMessage, "Look at what you got yourself into.");
	 	        	JOptionPane.showMessageDialog(displayMessage, "Are you happy with yourself?");
	 	        	JOptionPane.showMessageDialog(displayMessage, "Because I know that I'm not!");
	 	        	JOptionPane.showMessageDialog(displayMessage, "If only you listened.....");
	 	        	JOptionPane.showMessageDialog(displayMessage, "Oh well, no more playing for you!");
	 	        	System.exit(0);
	 	         }
	 	    }
	 	}
	 	
	 		

}

