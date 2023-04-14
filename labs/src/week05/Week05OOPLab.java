package week05;

import java.util.ArrayList;
import java.util.List;

public class Week05OOPLab {

	public static void main(String[] args) {
	
		
		// A standard deck of playing cards has 52 cards as specified below 
		//		i. There are 4 suits:  Clubs, Diamonds, Hearts, & Spades
		//				
		//	   ii. Each suit has 13 cards:  Two, Three, Four, Five, Six, Seven, 
		//									 Eight, Nine, Ten, Jack, Queen, King & Ace
		//
		//	  iii. Comparing Cards:  When comparing two cards, Ace is high and Two is low.
		//							 to make this easy, a Two will have a value of 2, a
		//							 Three will have a value of 3, ... and an Ace will have
		//							 a value of 14.
		//
		
		// 1. Card Class:
		//		Create a class called Card to represent a standard playing card. 
		//		Fields:   The Card class should have the following fields:
		// 			a. name field
		//			b. suit field
		//			c. value field for comparing against other cards.
		//
		//		Methods:  This class can have any useful method.
		//			a. describe() to display the card information to the Console.
		//			b. Getters & Setters 
		//
		
		System.out.println("\nQuestion 1: Card Class");
		// Add your code here to instantiate a Card
		
		//**Can you instantiate a class with a default constructor without defining it? When a more complete constructor is defined?
		Card tenDiamonds = new Card("Diamonds", 10);
		
		// Call the describe method on the newly instantiated card.
		
		tenDiamonds.describe();

		// 2. Deck Class:
		//		Create a class called Deck.
		//		Fields:  This class should have a list of Card field called cards 
		//				 that will hold all the cards in the deck. 
		//			List<Card> cards = new ArrayList<Card>(); 
		//
		//		Constructor: The constructor for the Deck Class should
		// 			instantiate all 52 standard playing cards and add them to the cards list.
		//
		//		Methods:  
		//			a.  describe() to describe the deck to the Console -- 
		//					print out all of the cards in the deck.
		//
		System.out.println("\nQuestion 2: Deck Class");
	    // Add your code here to instantiate a Deck	
	    
		List<String> suits = new ArrayList<String>();
		suits.add("Spades");
		suits.add("Diamonds");
		suits.add("Clubs");
		suits.add("Hearts");
		
	    Deck newDeck = new Deck(suits, 2, 15);
	    		
	    // Call the describe method on the newly instantiated deck.
	    
	    newDeck.describe();
	    
		// 3. Deck shuffle() Method:
		//		Add a shuffle method within the Deck Class
		System.out.println("\nQuestion 3: Deck shuffle() method");
		// Test your method here
		
		newDeck.shuffle();
		
		// Call the describe method on the newly shuffled deck.

		newDeck.describe();
		
		// 4. Deck draw() Method:
		//		Add a draw method within the Deck Class
		System.out.println("\nQuestion 4: Deck draw() method");
		// Test your method here
		
		newDeck.draw();
		
		// 5. Create Game Board:
		//		Create and test a method that takes an int as a parameter (representing the
		// 			number of players for a game) and returns a Map<String, List<Card>>
		// 			that represents each player (i.e. "Player 1", "Player 2", etc..) 
		//			and their cards.
		//
		// 			The method should create a new instance of Deck, shuffle it,
		// 			and deal the cards out to the "players" in the Map.
		System.out.println("\nQuestion 5: Create Game");
		// Call your method here

		//public Map<String, List<Card>> gameBoard(int numberOfPlayers) {
		//	
		//}
		
		
		
	} 
	
	// Method 5:

}
