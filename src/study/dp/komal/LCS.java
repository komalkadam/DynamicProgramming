/**
 * 
 */
package study.dp.komal;

import java.util.Scanner;

/**
 * @author komal
 *
 */
public class LCS {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();

		for (int i = 0; i < testcases; i++) {
			int str1Length = in.nextInt();
			int str2Length = in.nextInt();
			String str1 = in.next();
			String str2 = in.next();
			System.out.println(findLCS(str1, str2).length());
		}

	}

	public static String findLCS(String x, String y) {
		if (x.length() == 0 || y.length() == 0)
			return "";
		if (x.charAt(x.length() - 1) == y.charAt(y.length() - 1))
			return findLCS(x.substring(0, x.length() - 1),
					y.substring(0, y.length() - 1))
					+ x.charAt(x.length() - 1);

		return maxLength(findLCS(x, y.substring(0, y.length() - 1)),
				findLCS(x.substring(0, x.length() - 1), y));
	}

	private static String maxLength(String lcs, String lcs2) {
		return lcs.length() > lcs2.length() ? lcs : lcs2;
	}

}
