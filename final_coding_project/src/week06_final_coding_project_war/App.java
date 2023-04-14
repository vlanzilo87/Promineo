package week06_final_coding_project_war;

import java.util.ArrayList;
import java.util.List;
import week06_final_coding_project_war.Player;


public class App {

	public static void main(String[] args) {
		//card with greater value wins
		//objective - to have all the cards in your hand
		//deck divided evenly by number of players (52/2=26)
		
		//instantiate deck
		List<String> suits = new ArrayList<String>();
		suits.add("Spades");
		suits.add("Diamonds");
		suits.add("Clubs");
		suits.add("Hearts");
		
	    Deck deck = new Deck(suits, 2, 15);
	    
	    deck.describe();
	    
	   //shuffle deck
	    deck.shuffle();
	    
	    deck.describe();
	    
		//iterate 52 times through deck calling draw alternating between players
	    
	    List<Card> hand1 = new ArrayList<>();
	    List<Card> hand2 = new ArrayList<>();
	   
	    hand1.add(deck.draw());
	    hand2.add(deck.draw());
	    
	    System.out.println(hand1.get(0).name);
	    Player player_v = new Player("Player V");
	    System.out.println(player_v.getName());
	    player_v.setHand(hand1);
	    
	    
	    //for (int i = 0; i < deck.size(); i++) {
	    //	if (i % 2 == 0) {
	    //		deck.draw();
	    //	}
	    //}
	    	
	    
	    
		//loop through each players hand and call flip method
		
		//compare value of each players card, call incrementScore method for player whose card has greater value
		
		//after loop compare each players score and print final scores with the name of the player who won or "draw"
		
	}

}
