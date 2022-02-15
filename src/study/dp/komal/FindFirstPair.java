package com.hitachivantara.multicloud.providercost.azure;

import java.util.HashMap;

public class FindFirstPair {
	 static void findFirstPair(int[] array, int n) {
		 HashMap<Integer, Integer> hmDiffMap = new HashMap<>();
		 //boolean found = false;
		 for (int i : array) {
			if (hmDiffMap.containsKey(i)) {
				System.out.println(i + " + "+ hmDiffMap.get(i)  + " = " + n);
				//found = true;
				break;
			} else {
				hmDiffMap.put(n-i, i);
			}
		}
		 
		 
	 }

	static int calculateAngle(int hours, int minutes) {
		int minuteAngle = 0;
		int angle = 0;
		if (minuteAngle != 0) {
			minuteAngle = minutes * 6;
		}
		int hourAngle = 0;
		
		if (hours < 6) {
			hourAngle = hours * 30;
		} else {
			hourAngle = (12-hours) * 30;
		}
		
		if (minutes == 0) {
			return hourAngle;
		} else {
			return (hourAngle - minuteAngle);
		}
		
		
		//return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*findFirstPair(new int[]{1, 8, 3, 2}, 10);
        findFirstPair(new int[]{1, 2, 3, 2}, 4);
        findFirstPair(new int[]{1, 8, 3, 2}, 6);*/
		System.out.println(calculateAngle(3, 0)); //90 each 1 minutes = 6
		System.out.println(calculateAngle(6, 0));
		System.out.println(calculateAngle(9, 0));
		System.out.println(calculateAngle(10, 0));
	}

}
