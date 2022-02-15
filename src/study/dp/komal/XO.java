import java.util.ArrayList;
import java.util.List;

/**
 * 
 */

/**
 * @author kkadam
 *
 */

/*
 * Click `Run` to execute the snippet below!
 * 
 * 
 * Tic-tac-toe
 * 
 * 1. X and O 2. 3 consecutive occurences - horizontally/vertically/diagonally
 * (2 diagonals) makes a winner 3. Players take alternate turns
 * 
 * String identifyState(String [][] matrix) 1. X 2. O 3. Incomplete 4. Draw 5.
 * Invalid
 * 
 * Write Unit tests after completing
 */
public class XO {
	public static void main(String[] args) {
		// ArrayList<String> strings = new ArrayList<String>();
		// strings.add("Hello, World!");
		// strings.add("Welcome to CoderPad.");
		// strings.add("This pad is running Java " + Runtime.version().feature());

		// for (String string : strings) {
		// System.out.println(string);
		// }
		//JUnitCore.main("Solution");
		
	}
	
	//@Tests
	public static void tests() {
		
		//String str = identifyState(matrix);
		//System.out.println(str);
		List<String[][]> testCases = new ArrayList<String[][]>();
		List<String> results = new ArrayList<String>();
		
		String[][] incompleteMatrix = { { "X", "O", "O" }, { "X", "O", "X" }, { null, null, null } };
		testCases.add(incompleteMatrix);
		results.add("incomplete");
		
		
		String[][] invalidMatrix = { { "X", "X", "O" }, { "X", "O", "X" }, { null, null, null } };
		testCases.add(invalidMatrix);
		results.add("invalid");
		
		String[][] drawMatrix = { { "X", "O", "O" }, { "X", "O", "O" }, { "O", "X", "X" } };
		testCases.add(drawMatrix);
		results.add("draw");
		
		String[][] xWinnerMatrix = { { "X", "X", "X" }, { "O", "O", "X" }, { "O", "X", "O" } };
		testCases.add(xWinnerMatrix);
		results.add("X");
		
		String[][] oWinnerMatrix = { { "O", "X", "X" }, { "O", "O", "X" }, { "X", "X", "O" } };
		testCases.add(oWinnerMatrix);
		results.add("O");
		
		
		for (int i = 0; i < testCases.size(); i++) {
			String result = identifyState(testCases.get(i));
			System.out.println("Expected result == "+ results.get(i));
			System.out.println("Actual result == "+ result);
			
		}
		//String result = identifyState(testCases.get(testCases.size()-1));
	}
	public static String identifyState(String[][] matrix) {
		String result = null;
		int countX = 0;
		int countO = 0;
		int emptySpaces = 0;

		for (int i = 0; i < matrix.length && result == null; i++) {
			for (int j = 0; j < matrix[i].length && result == null; j++) {
				if (matrix[i][j] == null) {
					emptySpaces++;
				} else if (matrix[i][j] == "X") {
					countX++;
					result = checkForWinner(matrix, result, i, "X");

				} else if (matrix[i][j] == "O") {
					countO++;
					result = checkForWinner(matrix, result, i, "O");
				}

			}
		}
		System.out.println("Empty spaces:" + emptySpaces);

		if (Math.abs(countX - countO) > 1)
			result = "invalid";
		else if (emptySpaces > 0)
			result = "incomplete";
		else if (result == null && emptySpaces == 0)
			result = "draw";

		return result;
	}
	

	private static String checkForWinner(String[][] matrix, String result, int i, String charToCheck) {
		// for checking row
		int row = 0;
		for (; row < matrix.length; row++) {
			if (matrix[i][row] != charToCheck) {
				break;
			}
		}
		if (row == matrix.length) {
			result = charToCheck;
		}

		// for checking column
		int column = 0;
		for (; column < matrix.length; column++) {
			if (matrix[column][i] != charToCheck) {
				break;
			}
		}
		if (column == matrix.length) {
			result = charToCheck;
		}

		// for checking diagonal
		int diagonal = 0;
		for (; diagonal < matrix.length; diagonal++) {
			if (matrix[diagonal][diagonal] != charToCheck) {
				break;
			}
		}
		if (diagonal == matrix.length) {
			result = charToCheck;
		}
		return result;
	}

}
