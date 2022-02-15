import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;

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
public class TicTacToe {
	private static final String X_CHAR = "X";
	private static final String O_CHAR = "O";
	private static final String DRAW = "draw";
	private static final String INVALID = "invalid";
	private static final String INCOMPLETE = "incomplete";

	public static void main(String[] args) {
		JUnitCore.main("TicTacToe");
	}

	@Test
	public void tests() {

		// String str = identifyState(matrix);
		// System.out.println(str);
		Map<String, String[][]> testCases = new HashMap<String, String[][]>();
		Map<String, String> results = new HashMap<String, String>();

		String[][] incompleteMatrix = { { "X", "O", "O" }, { "X", "O", "X" }, { null, null, null } };
		testCases.put("incompleteMatrix", incompleteMatrix);
		results.put("incompleteMatrix", INCOMPLETE);

		String[][] invalidMatrix = { { "X", "X", "O" }, { "X", "O", "X" }, { null, null, null } };
		testCases.put("invalidMatrix", invalidMatrix);
		results.put("invalidMatrix", INVALID);

		String[][] drawMatrix = { { "O", "X", "O" }, { "X", "O", "O" }, { "X", "O", "X" } };
		testCases.put("drawMatrix", drawMatrix);
		results.put("drawMatrix", DRAW);

		String[][] xWinnerMatrix = { { "X", "X", "X" }, { "O", "O", "X" }, { "O", "X", "O" } };
		testCases.put("xWinnerMatrix", xWinnerMatrix);
		results.put("xWinnerMatrix", X_CHAR);

		String[][] oWinnerMatrix = { { "O", "X", "X" }, { "O", "O", "X" }, { "X", "X", "O" } };
		testCases.put("oWinnerMatrix", oWinnerMatrix);
		results.put("oWinnerMatrix", O_CHAR);

		for (String caseType : testCases.keySet()) {
			String result = identifyState(testCases.get(caseType));
			String expectedResult = results.get(caseType);
			Assert.assertEquals(
					"Result for caseType:" + caseType + " expected:" + expectedResult + " actual result:" + result,
					expectedResult, result);
		}

		// String result = identifyState(drawMatrix);
	}

	@Test
	public void XWinnerTests() {
		Map<String, String[][]> testCases = new HashMap<String, String[][]>();
		Map<String, String> results = new HashMap<String, String>();

		String[][] rowWinnerMatrix1 = { { "X", "X", "X" }, { "O", "O", "X" }, { "O", "X", "O" } };
		testCases.put("rowWinnerMatrix1", rowWinnerMatrix1);
		results.put("rowWinnerMatrix1", X_CHAR);

		String[][] rowWinnerMatrix2 = { { "O", "X", "O" }, { "X", "X", "X" }, { "O", "X", "O" } };
		testCases.put("rowWinnerMatrix2", rowWinnerMatrix2);
		results.put("rowWinnerMatrix2", X_CHAR);

		String[][] rowWinnerMatrix3 = { { "O", "X", "O" }, { "O", "X", "O" }, { "X", "X", "X" } };
		testCases.put("rowWinnerMatrix3", rowWinnerMatrix3);
		results.put("rowWinnerMatrix3", X_CHAR);

		String[][] diagonal1 = { { "X", "X", "O" }, { "O", "X", "O" }, { "O", "O", "X" } };
		testCases.put("diagonal1", diagonal1);
		results.put("diagonal1", X_CHAR);

		String[][] diagonal2 = { { "O", "X", "X" }, { "O", "X", "O" }, { "X", "O", "O" } };
		testCases.put("diagonal2", diagonal2);
		results.put("diagonal2", X_CHAR);

		for (String caseType : testCases.keySet()) {
			String result = identifyState(testCases.get(caseType));
			String expectedResult = results.get(caseType);
			Assert.assertEquals(
					"Result for caseType:" + caseType + " expected:" + expectedResult + " actual result:" + result,
					expectedResult, result);
		}
	}

	@Test
	public void incompleteTests() {
		String[][] incomplete = { { null, null, null }, { null, null, null }, { null, null, null } };
		String result = identifyState(incomplete);
		Assert.assertEquals("Incomplete tic-tac-toe", INCOMPLETE, result);
		
		String[][] incompleteWithInput = { { "X", "O", "O" }, { null, null, null }, { null, null, null } };
		String result1 = identifyState(incompleteWithInput);
		Assert.assertEquals("Incomplete tic-tac-toe", INCOMPLETE, result1);
	}
	
	@Test
	public void invalid() {
		String[][] incomplete = { { "X", "X", "X" }, { "X", "X", "X" }, { "X", "X", "X" } };
		String result = identifyState(incomplete);
		Assert.assertEquals("Invalid tic-tac-toe", INVALID, result);
	}

	public static String identifyState(String[][] matrix) {
		String result = null;
		int countX = 0;
		int countO = 0;
		int emptySpaces = 0;

		// check diagonally
		String firstCellChar = matrix[0][0];
		boolean bDiagonal = true;
		if (firstCellChar != null) {
			for (int i = 1; i < matrix.length; i++) {
				if (firstCellChar != matrix[i][i]) {
					bDiagonal = false;
					break;
				}
			}
		} else {
			bDiagonal = false;
		}

		// reverse diagonal
		String lastCellChar = matrix[0][matrix.length - 1];
		boolean bFoundResult = false;
		boolean bReverseDiagonal = true;
		if (!bDiagonal && lastCellChar != null) {
			for (int i = matrix.length - 1; i >= 0; i--) {
				if (lastCellChar != matrix[matrix.length - 1 - i][i]) {
					bReverseDiagonal = false;
					break;
				}
			}
		} else {
			bReverseDiagonal = false;
		}

		for (int i = 0; i < matrix.length ; i++) {
			for (int j = 0; j < matrix[i].length ; j++) {
				if (matrix[i][j] == null) {
					emptySpaces++;
				} else if (matrix[i][j] == X_CHAR) {
					countX++;
					if (!bDiagonal || !bReverseDiagonal || !bFoundResult ) 
						result = checkForWinner(matrix, result, i, j, X_CHAR);

				} else if (matrix[i][j] == O_CHAR) {
					countO++;
					if (!bDiagonal || !bReverseDiagonal|| !bFoundResult )
						result = checkForWinner(matrix, result, i, j, O_CHAR);
				}
				if (result != null) {
					bFoundResult = true;
				}

			}
		}
		// System.out.println("Empty spaces:" + emptySpaces);

		if (Math.abs(countX - countO) > 1)
			result = INVALID;
		else if (emptySpaces > 0)
			result = INCOMPLETE;
		else if (bDiagonal) {
			result = firstCellChar;
		} else if (bReverseDiagonal) {
			result = lastCellChar;
		} else if (result == null && emptySpaces == 0)
			result = DRAW;

		return result;
	}

	private static String checkForWinner(String[][] matrix, String result, int i, int j, String charToCheck) {
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

		return result;
	}

}
