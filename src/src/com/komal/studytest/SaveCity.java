/**
 * 
 */
package com.komal.studytest;

import java.util.Scanner;

/**
 * @author kkadam
 *
 */
public class SaveCity {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		String input_string = in.next();
		
		if (input_string.length() > 10000000 || input_string.length() < 0)
			return;
		
		int aCount = 0;
		StringBuilder finalString = new StringBuilder();

		for (int i = 0; i < input_string.length(); i++) {
			if (input_string.charAt(i) != 'a')
				finalString.append(input_string.charAt(i));
			else 
				aCount++;
		}
		
		for (int i = 0; i < aCount; i++) 
			finalString.insert(0, "a");
		
		System.out.println(finalString);
	}

}
