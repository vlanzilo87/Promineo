package general_practice;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class practice {

	static void addX(int[] arr, int x) {
		System.out.println("**Original**");
		// Add your code below this line for Requirement 1
		
		for (int num : arr) {
			System.out.println(num);
			num += x;
		} 
			
		// Add your code above this line for Requirement 1
			
		System.out.println("**New Array**");
		// Add your code below this line for Requirement 2
			
		for (int num : arr) {
			num += x;
			System.out.println(num);
		}
		System.out.print(arr[1]);	
		// Add your code above this line for Requirement 2
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int x;
		int[] arr = { 5, 10, 44, -4, 10 };
		x = in.nextInt();
		int num = 0;
		addX(arr, x);
	}
}
