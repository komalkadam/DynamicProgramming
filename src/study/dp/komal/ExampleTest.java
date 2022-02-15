/**
 * 
 */
package com.hitachivantara.multicloud.providercost.azure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author kkadam
 *
 */
class mythread extends Thread{
	public mythread() {
		super("my thread");
		start();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(this);
	}
	
}
public class ExampleTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// anagram
		/*String str = "words";
		// rearrange(str, 0);
		ArrayList<String> anagrams = new ArrayList<>();
		for (int i = str.length() - 1; i >= 0; i--) {
			char ch = str.charAt(i);
			if (anagrams.size() == 0) {
				anagrams.add(str.charAt(i) + "");
			} else {
				// rearrange(str, i++, end, anagrams);
				// char ch = str.charAt(i);
				ArrayList<String> temp = new ArrayList<String>(anagrams);
				for (String string : temp) {
					anagrams.add(ch + string);
					anagrams.add(string + ch);
				}

			}

		}*/
		// rearrange(str, 0, str.length() ,anagrams);
		/*for (String string : anagrams) {
			if (string.length() == str.length())
				System.out.println(string);
		}*/
		//System.out.println(anagrams.size());
		//ArrayList<String> anagrams1 = new ArrayList<>();
		//permutation(str, anagrams1);
		//new mythread();
		List<String> countries = Arrays.asList("Germany", "England", "China",
				"Denmark", "Brazil", "France", "Australia");
		Optional<String> countryName = 	countries.stream().reduce((c1, c2)->c1.length()>c2.length()?c1:c2);
		countryName.ifPresent(System.out::println);
		

	}
	
	
	public static void main(char[] args) {
		System.out.println("in char main");
	}

	public static void permutation(String input, ArrayList<String> anagrams1) {
		permutation("", input, anagrams1);
	}

	/*
	 * * Recursive method which actually prints all permutations * of given String,
	 * but since we are passing an empty String * as current permutation to start
	 * with, * I have made this method private and didn't exposed it to client.
	 */
	private static void permutation(String perm, String word, ArrayList<String> anagrams1) {
		if (word.isEmpty()) {
			anagrams1.add(perm+word);
			//System.out.println(perm + word);
		} else {
			for (int i = 0; i < word.length(); i++) {
				permutation(perm + word.charAt(i), word.substring(0, i) + word.substring(i + 1, word.length()), anagrams1);
			}
		}
	}

	// Read more:
	// https://javarevisited.blogspot.com/2015/08/how-to-find-all-permutations-of-string-java-example.html#ixzz7CU1cJFEd//

	private static void rearrange(String str, int i, int end, ArrayList<String> anagrams) {
		// TODO Auto-generated method stub
		if (i == end - 1) {
			anagrams.add(str.charAt(i) + "");
		} else {
			rearrange(str, i++, end, anagrams);
			char ch = str.charAt(i);
			ArrayList<String> temp = new ArrayList<String>(anagrams);
			for (String string : temp) {
				anagrams.add(ch + string);
				anagrams.add(string + ch);
			}

		}

	}

}
