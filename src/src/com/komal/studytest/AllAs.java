/**
 * 
 */
package com.komal.studytest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author kkadam
 *
 */
public class AllAs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int num_testcases = in.nextInt();
		
		if (num_testcases > 10 || num_testcases < 1)
			return;
		
		List<String> inputs = new ArrayList<>();
		
		
		for (int i = 0; i < num_testcases; i++) {
			String input_str = in.next();
			if (input_str.length() > 10000000 || input_str.length() < 1)
				return;
			inputs.add(input_str);
			
		}
		
		for (String string : inputs) {
			int[] count = new int[26];
			
			for (int i = 0; i < string.length(); i++) {
				int test = string.charAt(i);
				count[test%97] = count[test%97] + 1;
			}
			
			int max = 0;
			for (int i = 0; i < count.length; i++)  {
				if (count[i] > max)
					max = count[i];
			}
			
			for (int i = 0; i < count.length; i++) {
				if (count[i] == max) {
					char maxChar = (char) (i + 97);
					System.out.println(maxChar);
					break;
				}
			}
		}
		
		
		
	}

}
