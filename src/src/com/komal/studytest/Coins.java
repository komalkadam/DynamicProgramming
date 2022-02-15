/**
 * 
 */
package com.komal.studytest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author kkadam
 *
 */
public class Coins {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int array_size = in.nextInt();

		List<Integer> inputs = new ArrayList<>();

		if (array_size > 100000 || array_size < 1)
			return;

		int median = 0;

		for (int i = 0; i < array_size; i++) {
			int nextInt = in.nextInt();
			if (nextInt > 1000 || nextInt < 1)
				return;
			inputs.add(nextInt);
		}
		int sum = in.nextInt();
		Collections.sort(inputs);
		
		//System.out.println(inputs);
		if (array_size % 2 == 0) {
			int medianindex = array_size / 2;
			median = (inputs.get(medianindex) + inputs.get(medianindex - 1)) / 2;

		} else {
			int medianindex = (array_size + 1) / 2;
			median = inputs.get(medianindex-1);

		}
		System.out.print(median);
	}

}
