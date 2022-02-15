/**
 * 
 */
package com.komal.studytest;

import java.util.Scanner;

/**
 * @author kkadam
 *
 */
public class Median {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int array_size = in.nextInt();
		
		if (array_size > 1000000 || array_size < 0)
			return;
		int ones = 0;

		int prevInt = -1;
		for (int i = 0; i < array_size; i++) {
			int nextInt = in.nextInt();
			if (nextInt > 1 || nextInt < 0) {
				System.out.println("Non binary array");
				ones = 0;
				return;
			}

			if (prevInt == 0 && nextInt == 1) {
				System.out.println("Non sorted array");
				ones = 0;
				return;
			}
			if (nextInt == 1)
				ones++;
			prevInt = nextInt;

		}
		System.out.print(ones);
	}

}
