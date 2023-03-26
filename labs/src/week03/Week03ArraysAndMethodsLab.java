package week03;

import java.util.Arrays;

public class Week03ArraysAndMethodsLab {

	public static void main(String[] args) {
			
		//
		// Arrays:
		//
		
		// 1. Create an array with the following values 1, 5, 2, 8, 13, 6
		int[] nums = {1, 5, 2, 8, 13, 6};
		
		// 2. Print out the first element in the array
		System.out.println(nums[0]);
		
		// 3. Print out the last element in the array without using the number 5
		System.out.println(nums[nums.length - 1]);
		
		// 4. Print out the element in the array at position 6, what happens?
		//System.out.println(nums[6]);
		//Exception - out of bounds
		
		// 5. Print out the element in the array at position -1, what happens?
		//System.out.println(nums[-1]);
		//Exception - out of bounds
			
		// 6. Write a traditional for loop that prints out each element in the array
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
			
		// 7. Write an enhanced for loop that prints out each element in the array
		for (int num : nums) {
			System.out.println(num);
		}
		
		// 8. Create a new variable called sum, write a loop that adds 
		//			each element in the array to the sum
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		System.out.println(sum);
		
		// 9. Create a new variable called average and assign the average value of the array to it
		int average = sum/nums.length;
		System.out.println(average);
		
		// 10. Write an enhanced for loop that prints out each number in the array 
		//			only if the number is odd
		for (int num : nums) {
			if (num % 2 != 0) {
				System.out.println(num);
			}
		}
		
		// 11. Create an array that contains the values "Sam", "Sally", "Thomas", and "Robert"
		String[] names = {"Sam", "Sally", "Thomas", "Robert"};
		System.out.println(names[2]);
		
		// 12. Calculate the sum of all the letters in the new array
		int sum2 = 0;
		for (String name : names) {
			sum2 += name.length();
		}
		System.out.println(sum2);
		
		//
		// Methods:
		//
		
		// 13. Write and test a method that takes a String name and prints out a greeting. 
		//			This method returns nothing.
		
		
		// 14. Write and test a method that takes a String name and  
		//			returns a greeting.  Do not print in the method.

		
		// Compare method 13 and method 14:  
		//		a. Analyze the difference between these two methods.
		//		b. What do you find?
		//They are set up similarly but have different outputs. 
		//		c. How are they different?
		//The first method prints the String greeting but doesn't return anything. The second method returns the String greeting but doesn't print anything to the console. 
		
		// 15. Write and test a method that takes a String and an int and 
		//			returns true if the number of letters in the string is greater than the int
		
		
		// 16. Write and test a method that takes an array of string and a string and 
		//			returns true if the string passed in exists in the array
		
		
		// 17. Write and test a method that takes an array of int and 
		//			returns the smallest number in the array
	
		
		// 18. Write and test a method that takes an array of double and 
		//			returns the average
		

		// 19. Write and test a method that takes an array of Strings and 
		//			returns an array of int where each element
		//			matches the length of the string at that position

				
		// 20. Write and test a method that takes an array of strings and 
		//			returns true if the sum of letters for all strings with an even amount of letters
		//			is greater than the sum of those with an odd amount of letters.

	
		// 21. Write and test a method that takes a string and 
		//			returns true if the string is a palindrome

		String[] arrString = {"hello", "goodbye", "world"};
		int[] arrNum = {7, 23, 40, 6, 12};
		double[] arrDoub = {1.37, 20.6, 87.88, 34.9, 52.09};
		
		printGreeting("Bob");
		System.out.println(returnGreeting("John"));
		System.out.println(moreLetters("Hello", 3));
		System.out.println(stringInArray(arrString, "world"));
		System.out.println(smallestInt(arrNum));
		System.out.println(avgDouble(arrDoub));
		System.out.println(stringToInt(arrString));
		System.out.println(evenOdd(arrString));
		System.out.println(palindrome("mom"));
	}
	
	
	// Method 13:
	public static void printGreeting(String name) {
		System.out.println("Hello, " + name + "!");
	} 

	// Method 14:
	public static String returnGreeting(String name) {
		return ("Hello, " + name + "!");
	}
	
	// Method 15:
	public static boolean moreLetters(String word, int number) {
		if (word.length() > number) {
			return true;
		} else {
			return false;
		}
	}
	
	// Method 16:
	public static boolean stringInArray(String[] arr, String word) {
		boolean doesContain = Arrays.asList(arr).contains(word);
		return doesContain;
	}
	
	// Method 17:
	public static int smallestInt(int[] arr) {
		int small = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < small) {
				small = arr[i];
			}
		}
		return small;
	}
	
	// Method 18:
	public static double avgDouble(double[] arr) {
		double sum = 0;
		for (double num : arr) {
			sum += num;
		}
		double average = sum/arr.length;
		return average;
	}
	
	// Method 19:
	public static int[] stringToInt(String[] arr) {
		int[] ints = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			ints[i] = arr[i].length();
		}
		return ints;
	}
	
	// Method 20:
	public static boolean evenOdd(String[] arr) {
		int even = 0;
		int odd = 0;
		for (String str : arr) {
			if (str.length() % 2 == 0) {
				even += str.length();
			} else {
				odd += str.length();
			}
		}
		if (even > odd) {
			return true;
		} else {
			return false;
		}
	}
	
	// Method 21:
	public static boolean palindrome(String str) {
		char[] letters = new char[str.length()];
		for (int i = 0; i < str.length(); i++) {
			letters[i] = str.charAt(i);
		}
		String newWord = "";
		for (int i = letters.length - 1; i >= 0; i--) {
			newWord += letters[i];
		}
		return str.equals(newWord);
	}

}