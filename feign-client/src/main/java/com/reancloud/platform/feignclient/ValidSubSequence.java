/**
 * 
 */
package com.reancloud.platform.feignclient;

import java.util.Arrays;
import java.util.List;

/**
 * @author kkadam
 *
 */
public class ValidSubSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isValidSubsequence(Arrays.asList(1, 1, 1, 1, 1), Arrays.asList(1, 1, 1)));

	}

	public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
	    // Write your code here.
			int potentialMatchFromSeq = 0;
			for (int i = 0; i < array.size(); i++) {
				if (potentialMatchFromSeq < sequence.size()) {
					if (array.get(i) == sequence.get(potentialMatchFromSeq)) {
						potentialMatchFromSeq++;
					}
				}
				
			}
			if (potentialMatchFromSeq == sequence.size())
				return true;
			return false;
			/*int initialSeq = 0;
			for (int i = 0; i < sequence.size(); i++) {
				int prevInitialSeq = initialSeq;
				for (int j = initialSeq; j < array.size(); j++) {
					if (sequence.get(i) == array.get(j)) {
						if (i == sequence.size() - 1)
								return true;
						
						initialSeq = j+1;
						break;
					}
				}
				if (prevInitialSeq == initialSeq)
					return false;
			}
	    return false;*/
	  }
}
