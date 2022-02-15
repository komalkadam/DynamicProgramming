/**
 * 
 */
package com.komal.studytest;

import java.util.Scanner;

/**
 * @author kkadam
 *
 */
public class Rectangle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int user_input = in.nextInt();
		if (user_input < 0 || user_input > 1000)
			return;
		
		for (int i = 1; i <= user_input; i++) {
			if (i > 1)
				System.out.print("\n");
			for (int j = 1; j <= user_input ; j++) {
				System.out.print(j);
				if (j != user_input  )
					System.out.print(" ");
				
			}
			
		}
	

	}

}
