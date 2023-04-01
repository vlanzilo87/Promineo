package general_practice;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class practice {

	public static void main(String[] args) {
		//	1.	Create an array of int called ages that contains the following values: 3, 9, 23, 64, 2, 8, 28, 93.
		//		a.	Programmatically subtract the value of the first element in the array from the value in the last element of the array (i.e. do not use ages[7] in your code). Print the result to the console.  
		//		b.	Add a new age to your array and repeat the step above to ensure it is dynamic (works for arrays of different lengths).
		//		c.	Use a loop to iterate through the array and calculate the average age. Print the result to the console.
		int[] ages = {3, 9, 23, 64, 2, 8, 28, 93, 57};
		System.out.println(ages[1]);
		
		System.out.println(ages[ages.length - 1] - ages[0]);
		
		double sum = 0;
		for (int age : ages) {
			sum += age;
		}
		double average = sum/ages.length;
		System.out.println(average);
		
		
		//	2.	Create an array of String called names that contains the following values: “Sam”, “Tommy”, “Tim”, “Sally”, “Buck”, “Bob”.
		//		a.	Use a loop to iterate through the array and calculate the average number of letters per name. Print the result to the console.
		//		b.	Use a loop to iterate through the array again and concatenate all the names together, separated by spaces, and print the result to the console.
		String[] names = {"Sam", "Tommy", "Tim", "Sally", "Buck", "Bob"};
		System.out.println(names[0]);
		
		double letters = 0;
		for (String name : names) {
			letters += name.length();
		}
		System.out.println(letters / names.length);
		
		String newString = "";
		for (String name : names) {
			newString += name + " ";
		}
		System.out.println(newString);
	
		//	3.	How do you access the last element of any array?
		//array[array.length - 1];
		
		//	4.	How do you access the first element of any array?
		//array[0];
		
		//	5.	Create a new array of int called nameLengths. Write a loop to iterate over the previously created names array and add the length of each name to the nameLengths array.
		int[] nameLengths = new int[names.length];
		for (int i = 0; i < names.length; i++) {
			nameLengths[i] = names[i].length();
		}
		
		//	6.	Write a loop to iterate over the nameLengths array and calculate the sum of all the elements in the array. Print the result to the console.
		int sumz = 0;
		for (int letterz : nameLengths) {
			sumz += letterz;
		}
		System.out.println(sumz);
		
		double[] doubles = {32.1, 100.65, 4.5, 87.77, 59.345};
		System.out.println(doubles[3]);
		
		double[] moreDoubles = {13.78, 92.45, 40.11, 76.902, 146.9};
		System.out.println(moreDoubles[4]);
		
		System.out.println(repeatWord("Hey", 5));
		System.out.println(fullName("Bo", "Jangles"));
		System.out.println(over100(ages));
		System.out.println(dubAvg(doubles));
		System.out.println(greaterThan(doubles, moreDoubles));
		System.out.println(willBuyDrink(true, 15.05));
		System.out.println(isString(names, "Tim"));
	}
		//	7.	Write a method that takes a String, word, and an int, n, as arguments and returns the word concatenated to itself n number of times. (i.e. if I pass in “Hello” and 3, I expect the method to return “HelloHelloHello”).
	public static String repeatWord(String userWord, int numTimes) {
		String wordString = "";
		for (int i = 0; i < numTimes; i++) {
			wordString += userWord;
		}
		return wordString;
	}
		
		//	8.	Write a method that takes two Strings, firstName and lastName, and returns a full name (the full name should be the first and the last name as a String separated by a space).
	public static String fullName(String firstName, String lastName) {
		String fullName = firstName + " " + lastName;
		return fullName;
	}
		//	9.	Write a method that takes an array of int and returns true if the sum of all the ints in the array is greater than 100.
	public static boolean over100(int[] nums) {
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		if (sum > 100) {
			return true;
		} else {
			return false;
		}
	}
	
		//	10.	Write a method that takes an array of double and returns the average of all the elements in the array.
	public static double dubAvg(double[] dubs) {
		double sum = 0;
		for (double dub : dubs) {
			sum += dub;
		}
		return sum/dubs.length;
	}
	
		//	11.	Write a method that takes two arrays of double and returns true if the average of the elements in the first array is greater than the average of the elements in the second array.
	public static boolean greaterThan(double[] dubs, double[] doubles) {
		double sum1 = 0;
		double sum2 = 0;
		
		for (double dub : dubs) {
			sum1 += dub;
		}
		for (double dub : doubles) {
			sum2 += dub;
		}
		if (sum1 > sum2) {
			return true;
		} else {
			return false;
		}
	}
	
		//	12.	Write a method called willBuyDrink that takes a boolean isHotOutside, and a double moneyInPocket, and returns true if it is hot outside and if moneyInPocket is greater than 10.50.
	public static boolean willBuyDrink(boolean isHotOutside, double moneyInPocket) {
		if (isHotOutside && moneyInPocket > 10.50) {
			return true;
		} else {
			return false;
		}
	}
	
		//	13.	Create a method of your own that solves a problem. In comments, write what the method does and why you created it.
	//This method searches for a specified string in an array of strings. Useful when looking up a name in a list. 
	public static boolean isString(String[] strings, String string) {
		boolean tf = false;
		for (String str : strings) {
			if (str.equals(string)) {
				tf = true;
			}
		}
		return tf;
	}
	
}
