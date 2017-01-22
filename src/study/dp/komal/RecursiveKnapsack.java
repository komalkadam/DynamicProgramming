/**
 * 
 */
package study.dp.komal;

import java.util.Scanner;

/**
 * @author komal
 *
 */
public class RecursiveKnapsack {
	static int max(int a, int b) {
		return (a > b) ? a : b;
	}

	// Returns the maximum value that can be put in a knapsack of capacity W
	static int knapSack(int totalWeight, int wt[], int val[], int n) {
		// Base Case
		if (n == 0 || totalWeight == 0)
			return 0;

		// If weight of the nth item is more than Knapsack capacity W, then
		// this item cannot be included in the optimal solution
		if (wt[n - 1] > totalWeight)
			return knapSack(totalWeight, wt, val, n - 1);

		// Return the maximum of two cases:
		// (1) nth item included
		// (2) not included
		else
			return max(
					val[n - 1]
							+ knapSack(totalWeight - wt[n - 1], wt, val, n - 1),
					knapSack(totalWeight, wt, val, n - 1));
	}

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

			System.out.println(knapSack(totalWeight, weights, values, n));
		}

	}

}
