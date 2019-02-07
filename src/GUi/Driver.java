package GUi;



import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;





public class Driver extends JFrame{
static final long serialVersionUID = 0; 

  public Driver(){
	  // frame for menu and menu bar
	  super("Card Game");
	  GameDisplay game = new GameDisplay();
	  //menu work= new menu();
	  setJMenuBar(game.menuBar());
	  setContentPane(game);
  }


   public static void main(String[] args){
	//JOptionPane.showConfirmDialog(null, "click yes if screen appear"); might use this later 
	    
	   //display the GUI
	 JFrame work = new Driver();
	   
	 work.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 work.setVisible(true);
	
	 work.setSize(500, 500);

   }
	

	 


}

