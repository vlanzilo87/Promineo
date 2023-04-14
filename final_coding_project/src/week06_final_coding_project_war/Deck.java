package week06_final_coding_project_war;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {
	//fields
	List<Card> cards = new ArrayList<>();
	
	//constructor
	public Deck(List<String> suits, int valueStart, int valueEnd) {
		//spades, diamonds, clubs, hearts/2,3,4,5,6,7,8,9,10,J-11,Q-12,K-13,A-14
		for (String suit : suits) {
			for (int i = valueStart; i < valueEnd; i++) {
				cards.add(new Card(suit, i)); //able to instantiate Card without "Card cardname = "
			}
			for (Card card : cards) {
				if (card.value == 11) {
					card.name = "Jack of " + card.suit;
				} else if (card.value == 12) {
					card.name = "Queen of " + card.suit;
				} else if (card.value == 13) {
					card.name = "King of " + card.suit;
				} else if (card.value == 14) {
					card.name = "Ace of " + card.suit;
				}
			}
		}
	}
	
	//getters/setters
	public List<Card> getCards() {
		return cards;
	}
	
	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
	
	//shuffle method
	public void shuffle() {
		//List<Card> shuffledDeck = new ArrayList<Card>();
		Collections.shuffle(cards);//instead of cards can use this
	}
	
	//draw method
	public Card draw() {
		//Random rand = new Random();
		//Card card = cards.get(rand.nextInt(cards.size()));
		//System.out.println(card.name);
		//cards.remove(card);
		Card card = cards.remove(0);
		System.out.println("This is " + card.name);
		return card;
	}
	
	//describe method
	public void describe() {
//		for (Card card : cards) {
//			if (card.value == 11) { //can use .getValue()
//				System.out.println("Jack of " + card.suit);
//			} else if (card.value == 12) {
//				System.out.println("Queen of " + card.suit);
//			} else if (card.value == 13) {
//				System.out.println("King of " + card.suit);
//			} else if (card.value == 14) {
//				System.out.println("Ace of " + card.suit);
//			} else {
//				System.out.println(card.name);
//			}
		for (Card card : cards) {
			System.out.println(card.name);
		}
	}

	//needed size of deck
	public int size() {
		// TODO Auto-generated method stub
		return 52;
	}
}
