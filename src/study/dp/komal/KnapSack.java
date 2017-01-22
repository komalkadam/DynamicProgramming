/**
 * 
 */
package study.dp.komal;

import java.util.Scanner;

/**
 * You are given weights and values of N items, put these items in a knapsack of
 * capacity W to get the maximum total value in the knapsack. Note that we have
 * only one quantity of each item, In other words, given two integer arrays
 * val[0..N-1] and wt[0..N-1] which represent values and weights associated with
 * N items respectively. Also given an integer W which represents knapsack
 * capacity, find out the maximum value subset of val[] such that sum of the
 * weights of this subset is smaller than or equal to W. You cannot break an
 * item, either pick the complete item, or don’t pick it (0-1 property). Input:
 * 
 * The first line of input contains an integer T denoting the number of test
 * cases. Then T test cases follow. Each test case consists of four lines. The
 * first line consists of N the number of items. The second line consists of W,
 * the maximum capacity of the knapsack. In the next line are N space separated
 * positive integers denoting the values of the N items and in the fourth line
 * are N space separated positive integers denoting the weights of the
 * corresponding items.
 * 
 * 
 * Output:
 * 
 * Print the maximum possible value you can get with the given conditions that
 * you can obtain for each test case in a new line. Constraints:
 * 
 * 1≤T≤100
 * 
 * 1≤N≤100
 * 
 * 1≤W≤100
 * 
 * 1≤wt[i]≤100
 * 
 * 1≤v[i]≤100
 * 
 * 
 * Example:
 * 
 * Input: 
 * 1 
 * 3 
 * 4 
 * 1 2 3 
 * 4 5 1 
 * Output: 
 * 3
 * 
 * @author komal
 *
 */
public class KnapSack {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();

		for (int i = 0; i < testcases; i++) {
			int n = in.nextInt();
			int totalWeight = in.nextInt();
			int[] weights = new int[n];
			int[] values = new int[n];

			for (int j = 0; j < n; j++)
				values[j] = in.nextInt();

			for (int j = 0; j < n; j++)
				weights[j] = in.nextInt();

			zeroOneKnapsack(n, totalWeight, weights, values);
		}

	}

	private static void zeroOneKnapsack(int n, int totalWeight, int[] weights,
			int[] values) {
		int[][] knapsack = new int[n + 1][totalWeight + 1];

		for (int item = 1; item < knapsack.length; item++) {
			for (int wt = 1; wt < knapsack[item].length; wt++) {
				if (weights[item - 1] > wt)
					knapsack[item][wt] = knapsack[item - 1][wt];
				else {
					int valOfWt = values[item - 1];
					int remainingWtIndex = wt - weights[item - 1];
					int remainingWt = knapsack[item - 1][remainingWtIndex];
					int totalCurrentRowWeight = valOfWt + remainingWt;
					int prevRowWeight = knapsack[item - 1][wt];
					knapsack[item][wt] = Math.max(totalCurrentRowWeight,
							prevRowWeight);
				}
			}
		}

		System.out.println(knapsack[n][totalWeight]);

	}

}
