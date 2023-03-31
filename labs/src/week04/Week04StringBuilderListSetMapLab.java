package week04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Week04StringBuilderListSetMapLab {

	public static void main(String[] args) {

		// 1. Why would we use a StringBuilder instead of a String?
		// 		a. Instantiate a new StringBuilder
		//		b. Append the characters 0 through 9 to it separated by dashes
		// 				Note:  make sure no dash appears at the end of the StringBuilder
		StringBuilder sb = new StringBuilder();
		sb.append("0-1-2-3-4-5-6-7-8-9");
		System.out.println(sb);
		
		// 2. List of String:
		//		a. Create a list of Strings 
		//		b. Add 5 Strings to it, each with a different length
		List<String> list = new ArrayList<>();
		
		list.add("Hello");
		list.add("Hi");
		list.add("Tomorrow");
		list.add("Hey");
		list.add("Goodbye");
		
		System.out.println(list);
		
		// 3. Write and test a method that takes a list of strings 
		//			and returns the shortest string
		
		
		// 4. Write and test a method that takes a list of strings 
		//			and returns the list with the first and last element switched

		
		// 5. Write and test a method that takes a list of strings 
		//			and returns a string with all the list elements concatenated to each other,
		// 			separated by a comma

		
		// 6. Write and test a method that takes a list of strings and a string 
		//			and returns a new list with all strings from the original list
		// 			containing the second string parameter (i.e. like a search method)

		
		// 7. Write and test a method that takes a list of integers 
		//			and returns a List<List<Integer>> with the following conditions specified
		//			for the return value:
		//		a. The first List in the returned value contains any number from the input list 
		//			that is divisible by 2
		//		b. The second List contains values from the input list that are divisible by 3
		//		c. The third containing values divisible by 5, and 
		//		d. The fourth all numbers from the input List not divisible by 2, 3, or 5

		
		// 8. Write and test a method that takes a list of strings 
		//			and returns a list of integers that contains the length of each string


		
		// 9. Create a set of strings and add 5 values
		Set<String> set = new HashSet<String>();
		
		set.add("Monday");
		set.add("Tuesday");
		set.add("Wednesday");
		set.add("Thursday");
		set.add("Friday");
		
		System.out.println(set);
		
		// 10. Write and test a method that takes a set of strings and a character 
		//			and returns a set of strings consisting of all the strings in the
		// 			input set that start with the character parameter.


		
		// 11. Write and test a method that takes a set of strings 
		//			and returns a list of the same strings
	
		

		// 12. Write and test a method that takes a set of integers 
		//			and returns a new set of integers containing only even numbers 
		//			from the original set


		
		// 13. Create a map of string and string and add 3 items to it where the key of each
		// 			is a word and the value is the definition of the word
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("car", "a type of motor vehicle with four wheels");
		map.put("hat", "an article of clothing worn on top of the head");
		map.put("baseball", "a small ball that is thrown, caught or hit");
	
		System.out.println(map);
		
		// 14. Write and test a method that takes a Map<String, String> and a string 
		// 			and returns the value for a key in the map that matches the
		// 			string parameter (i.e. like a language dictionary lookup)

		
		// 15. Write and test a method that takes a List<String> 
		//			and returns a Map<Character, Integer> containing a count of 
		//			all the strings that start with a given character
		
		List<Integer> numList = new ArrayList<>();
		
		numList.add(1);
		numList.add(2);
		numList.add(3);
		numList.add(4);
		numList.add(5);
		
		Set<Integer> numSet = new HashSet<>();
		
		numSet.add(6);
		numSet.add(7);
		numSet.add(8);
		numSet.add(9);
		numSet.add(10);
		
		System.out.println(shortWord(list));
		System.out.println(switched(list));
		System.out.println(concat(list));
		System.out.println(searchList(list, "Hello"));
		System.out.println(listConditions(numList));
		System.out.println(stringToInt(list));
		System.out.println(charIn(set, 'T'));
		System.out.println(copyStrings(set));
		System.out.println(evenInts(numSet));
		System.out.println(dictionary(map, "hat"));
		System.out.println(countStrings(list));
	}
	
	
	// Method 15:
	public static Map<Character, Integer> countStrings(List<String> list) {
		Map<Character, Integer> result = new HashMap<Character, Integer>();
		char character = 'H';
		int count = 1;
		for (String str : list) {
			if (str.charAt(0) == character) {
				result.put(character, count++);
			}
		}
		return result;
	}
	
	// Method 14:
	public static String dictionary(Map<String, String> map, String word) {
		String def = "";
		if (map.containsKey(word)) {
			def = map.get(word);
		}
		return def;
	}

	// Method 12:
	public static Set<Integer> evenInts(Set<Integer> numSet) {
		Set<Integer> evenNums = new HashSet<>();
		for(int num : numSet) {
			if (num % 2 == 0) {
				evenNums.add(num);
			}
		}
		return evenNums;
	}

	// Method 11:
	public static List<String> copyStrings(Set<String> set) {
		List<String> copyList = new ArrayList<String>();
		for (String str : set) {
			copyList.add(str);
		}
		return copyList;
	}

	// Method 10:
	public static Set<String> charIn(Set<String> set, char c) {
		Set<String> newSet = new HashSet<String>();
		for (String str : set) {
			if (str.charAt(0) == c) {
				newSet.add(str);
			}
		}
		return newSet;
	}
	
	// Method 8:
	public static List<Integer> stringToInt(List<String> list) {
		List<Integer> ints = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			ints.add(list.get(i).length());
		}
		return ints;
	}

	// Method 7:
	public static List<Integer> listConditions(List<Integer> numList) {
		List<Integer> listDiv2 = new ArrayList<Integer>();
		List<Integer> listDiv3 = new ArrayList<Integer>();
		List<Integer> listDiv5 = new ArrayList<Integer>();
		List<Integer> others = new ArrayList<Integer>();
		
		for (int num : numList) {
			if (num % 2 == 0) {
				listDiv2.add(num);
			} else if (num % 3 == 0) {	
				listDiv3.add(num);
			} else if (num % 5 == 0) {
				listDiv5.add(num);
			} else {
				others.add(num);
			}
		}
		return listDiv2;
	}

	// Method 6:
	public static List<String> searchList(List<String> list, String str) {
		List<String> newList = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			if (str.equals(list.get(i))) {
				newList.add(list.get(i));
			}
		}
		return newList;
	}

	// Method 5:
	public static String concat(List<String> list) {
		String newStr = "";
		for (String str : list) {
			newStr += str + ", ";
		}
		return newStr;
	}
	
	// Method 4:
	public static List<String> switched(List<String> list) {
		String word1 = list.get(0);
		String word2 = list.get(list.size() - 1);
		list.set(0, word2);
		list.set(list.size() - 1, word1);
		
		return list;	
	}
	
	// Method 3:
	public static String shortWord(List<String> list) {
		String shortestWord = list.get(0);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).length() < shortestWord.length()) {
				shortestWord = list.get(i);
			}
		}
		return shortestWord;
	}

}