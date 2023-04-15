package week06_final_coding_project_war;

import java.util.ArrayList;
import java.util.List;
import week06_final_coding_project_war.Player;

public class App {

	public static void main(String[] args) {
		//card with greater value wins
		//objective - to have all the cards in your hand
		//deck divided evenly by number of players (52/2=26)
		
		//Instantiate deck of cards
		List<String> suits = new ArrayList<String>();
		suits.add("Spades");
		suits.add("Diamonds");
		suits.add("Clubs");
		suits.add("Hearts");
		
	    Deck deck = new Deck(suits, 2, 15);
	    //deck.describe();
	    
	    //Shuffle deck
	    deck.shuffle();
	    //deck.describe();
	    
		//Iterate 52 times through deck calling draw, alternating between players
	    List<Card> hand1 = new ArrayList<>();
	    List<Card> hand2 = new ArrayList<>();
	   
	    for (int i = 0; i < deck.size(); i++) {
	    	if (i % 2 == 0) {
	    		hand1.add(deck.draw());
	    	} else {	
	    		hand2.add(deck.draw());
	    	}
	    }
	    // System.out.println(hand1.get(0).name);
	    
	    //Instantiate players
	    Player player_1 = new Player("Player #1");
	    //System.out.println(player_1.getName());
	    player_1.setHand(hand1);
	    
	    Player player_2 = new Player("Player #2");
	    //System.out.println(player_2.getName());
	    player_2.setHand(hand2);
	    
		//Loop through each players hand and call flip method
	    //Compare value of each players card, call incrementScore method for player whose card has greater value
	    System.out.println("###***TIME TO PLAY WAR***###");
	    System.out.println();
	    
	    for (int i = 1; i <= 26; i++) {
			System.out.println("Hand #" + i);
			int card1 = player_1.flip().getValue();
			int card2 = player_2.flip().getValue();
			if (card1 > card2) {
				player_1.incrementScore();
				System.out.println("Player #1 wins this hand!");
			} else if (card1 < card2) {
				player_2.incrementScore();
				System.out.println("Player #2 wins this hand!");
			} else {
				System.out.println("Draw...");
			}
			System.out.println("Player #1 your score is: " + player_1.getScore());
		    System.out.println("Player #2 your score is: " + player_2.getScore());
		    System.out.println();
		}
	    
//		List<Card> player_1_hand = new ArrayList<>();
//		List<Card> player_2_hand = new ArrayList<>();
//		
//		//player 1 flip
//		for (Card card : hand1) {
//			player_1_hand.add(card);
//		}
//		
//		//player 2 flip
//		for (Card card : hand2) {
//			player_2_hand.add(card);
//		}
	    
//		for (int i = 0; i < player_1_hand.size(); i++) {
//			
//		}
		    
		//after loop compare each players score and print final scores with the name of the player who won or "draw"
		System.out.println("The Final Scores are: \n" + "Player #1 with " + player_1.getScore() + "\n" + "Player #2 with " + player_2.getScore());
		if (player_1.getScore() > player_2.getScore()) {
			System.out.println("Player #1 won the game!");
		} else if (player_1.getScore() < player_2.getScore()) {
			System.out.println("Player #2 won the game!");
		} else {
			System.out.println("It's a Draw...");
		}
	}
}
