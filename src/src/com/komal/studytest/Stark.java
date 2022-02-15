/**
 * 
 */
package com.komal.studytest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author kkadam
 *
 */
public class Stark {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int test_cases = in.nextInt();

		List<Integer> inputs = new ArrayList<>();

		if (test_cases > 10 || test_cases < 1)
			return;

		for (int i = 0; i < test_cases; i++) {
			int rounds = in.nextInt();
			if (rounds > 1000 || rounds < 1)
				return;

			int points = in.nextInt();
			if (points > rounds || points < 1)
				return;

			int sansa = rounds - points;
			int arya = points + 1;

			while (sansa > arya) {
				sansa--;
			}

			arya = rounds - sansa;

			int remaining = rounds - arya;
			int ways = 1;

			while (remaining == 0) {
				ways++;
				remaining--;
			}

			inputs.add(ways);

		}

		for (Integer integer : inputs) {
			System.out.println(integer);
		}

	}

}
