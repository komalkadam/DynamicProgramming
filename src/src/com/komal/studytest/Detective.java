/**
 * 
 */
package com.komal.studytest;

import java.util.Scanner;

/**
 * @author kkadam
 *
 */
public class Detective {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int n1 = in.nextInt();
		int n2 = in.nextInt();

		if (Math.abs(n1) > 1000 || Math.abs(n1) < 1)
			return;
		if (Math.abs(n2) > 1000 || Math.abs(n2) < 1)
			return;

		if ((n1 < 0 && n2 > 0) || (n2 < 0 && n1 > 0)) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}

	}

}
