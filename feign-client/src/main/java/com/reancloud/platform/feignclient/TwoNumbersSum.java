/**
 * 
 */
package com.reancloud.platform.feignclient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author kkadam
 *
 */
public class TwoNumbersSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = {-21, 301, 12, 4, 65, 56, 210, 356, 9, -47};//{3, 5, -4, 8, 11, 1, -1, 6};
		int targetSum = -5;
		/*int[] returnarray = twoNumberSum(array, targetSum);
		for (int i : returnarray) {
			System.out.println(i);
		}*/
		
		
		ArrayList<List<String>> competitions = new ArrayList<>();
		competitions.add(Arrays.asList("HTML", "C#"));
		competitions.add(Arrays.asList("C#", "Python"));
		competitions.add(Arrays.asList("Python", "HTML"));
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(0);
		result.add(0);
		result.add(1);
		
		System.out.println(tournamentWinner(competitions, result));
	}
	
	public static String tournamentWinner(
		      ArrayList<List<String>> competitions, ArrayList<Integer> results) {
				HashMap<String, Integer> scores = new HashMap<>();
				for(int i = 0; i < competitions.size(); i++) {
					List<String> participants = competitions.get(i);
					String winner = participants.get(0);
					int score = 3;
					if (results.get(i) == 0) {
						winner = participants.get(1);
					}
					if (scores.containsKey(winner))
						score = scores.get(winner) + 3;
					
					scores.put(winner, score);
				}	
				
				String maxScoreTeam = null;
				int maxScore = -1;
				for (String teamName : scores.keySet()) {
					if (scores.get(teamName) > maxScore) {
						maxScore = scores.get(teamName);
						maxScoreTeam = teamName;
					}
				}
		    // Write your code here.
		    return maxScoreTeam;
		  }
	
	public static int[] twoNumberSum(int[] array, int targetSum) {
	    // Write your code here.
		Arrays.sort(array);
		int[] sumArray = new int[0];
		boolean foundSum = false;
		for(int i = 0; i < array.length; i++) {
			for (int j=i+1; j < array.length; j++) {
				if (targetSum == (array[i] + array[j])) {
					sumArray = new int[2];
					sumArray[0] = array[i];
					sumArray[1] = array[j];
					foundSum = true;
					break;
				}
					
			}
			if (foundSum)
				break;
		}
		
	    return sumArray;
	  }

}
