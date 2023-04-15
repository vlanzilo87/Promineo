package week06_final_coding_project_war;

public class Card {
	//fields
	String name;
	String suit;
	int value;
		
	//constructor
	public Card(String suit, int value) {
		this.name = value + " of " + suit;
		this.suit = suit;
		this.value = value;
	}
		
	//getters/setters
	public String getName() {
		return name;
	}
		
	public void setName(String name) {
		this.name = name;
	}
		
	public String getSuit() {
		return suit;
	}
		
	public void setSuit(String suit) {
		this.suit = suit;
	}
		
	public int getValue() {
		return value;
	}
		
	public void setValue(int value) {
		this.value = value;
	}
		
	//describe method
	public void describe() {
		System.out.println("Your card is " + name);
		//System.out.println("Card suit is " + suit);
		//System.out.println("Card value is " + value);
	}
}
