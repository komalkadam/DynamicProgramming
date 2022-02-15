/**
 * 
 */
package com.komal.studytest;

import java.util.Scanner;

/**
 * @author kkadam
 *
 */
public class Unity {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int array_size = in.nextInt();

		int[] inputs = new int[array_size];
		int[] outputs = new int[array_size];

		if (array_size > 1000 || array_size < 1)
			return;


		for (int i = 0; i < array_size; i++) {
			int nextInt = in.nextInt();
			if (nextInt > 1000 || nextInt < 0)
				return;
			inputs[i] = nextInt;
		}

		int j = 0;
		for (int i = 0; i < inputs.length; i++) {

			if (inputs[i] != 0)
				outputs[j++] = inputs[i];

		}
		
		if (j < array_size) {
			for (;j< array_size; j++) {
				outputs[j] = 0;
			}
		}
		for (int i = 0; i < outputs.length; i++) {
			System.out.print(outputs[i]);
			if(i != outputs.length-1)
				System.out.print(" ");
		}
			
	}

}
