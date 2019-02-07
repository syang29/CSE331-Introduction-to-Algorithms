package GUi;

import java.awt.Dimension;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import code.Card;
import code.Pile;

public class CardDisplay extends JLabel{
	
	private MouseListener lis;
	
	public CardDisplay(String cards){
		//images fixed, if image didn't load download the card file
		String filename = ("/" +cards+".gif");
		loadAndSetImage(filename);	
	}
	private void loadAndSetImage(String fileNameRelativeToClassFile) {
	    ImageIcon cardImage;
	
	    java.net.URL imgURL = this.getClass().getResource(fileNameRelativeToClassFile);
	    if (imgURL != null) {
	      cardImage = new ImageIcon(imgURL);
	      
	    } else {
	      System.err.println("Couldn't find file: " + fileNameRelativeToClassFile);
	      System.err.print("self destruct mode active");
	      cardImage = null;
	 	
	    }
	    
	    setIcon(cardImage);
	    Dimension d = new Dimension(cardImage.getIconWidth() + 20, cardImage.getIconHeight() + 20);
	    
	    setSize(d);
	    setPreferredSize(d);
	    setMaximumSize(d);
	    setMinimumSize(d); 
	    
	  }
	public void setLis(MouseListener input) {
		lis = input;
	}
	public MouseListener getLis() {
		return lis;
	}
}

	
	

	
	    
	   
	  
	  
	  
	  
	

	


