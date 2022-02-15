/**
 * 
 */
package com.komal.studytest;

import java.util.Scanner;

/**
 * @author kkadam
 *
 */
public class Calendar {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		
		int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int month = in.nextInt();
		int startweekday = in.nextInt();
		
		if (month > 12 || month < 1)
			return;
		
		if (startweekday > 7 || startweekday < 1)
			return;
		
		int columns = 0;
		
		
		
		int daysInFirstWeek = 7 - startweekday + 1;
		int remainingDays =  monthDays[month-1] - daysInFirstWeek;
		columns = (remainingDays/7) + 1;
		
		if (remainingDays % 7 > 0)
			columns++;
		
		
		System.out.print(columns);
	}

}
