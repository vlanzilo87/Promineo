package week06_final_coding_project_war;

import java.util.ArrayList;
import java.util.List;
//import week06_final_coding_project_war.Deck;

public class Player {
	//fields
	List<Card> hand = new ArrayList<>();
	String name;
	int score;
	
	//constructor
	public Player(String name) {
		this.name = name;
		score = 0;
	}
	
	//getters/setters
	public List<Card> getHand() {
		return hand; 
	}
	
	public void setHand(List<Card> hand) {
		this.hand = hand;
		System.out.println(hand.get(0).name);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	//describe method
	public void describe() {
		System.out.println("Player name: " + name);
		System.out.println(name + "has a score of " + score);
		
		for (Card card : hand) {
			System.out.println(card.name);
		}
	}
	
	//flip method
	public Card flip() {
		Card card = this.hand.remove(0);
		return card;
	}
	
	//draw method
	public void drawCard(List<Card> cards) {
		Card card = cards.remove(0);
		hand.add(card);
	}
	//public void drawCard(List<Card> cards) {
	//	hand.add(((Deck) cards).draw());
	//}
	
	//incrementScore method
	public void incrementScore() {
		score++;
	}
}
