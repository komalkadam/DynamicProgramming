/**
 * 
 */
package com.komal.studytest;

import java.util.Scanner;

/**
 * @author kkadam
 *
 */
public class Pattern {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int user_input = in.nextInt();
		if (user_input < 0 || user_input > 1000)
			return;
		
		for (int i = 0; i < user_input; i++) {
			if (i >= 1)
				System.out.print("\n");
			for (int j = 0; j < user_input - 1; j++) {
				System.out.print("*");
				if (j != user_input - 2 )
					System.out.print(" ");
				
			}
			
		}
	}

}
