import java.util.ArrayList;
import java.util.List;

/**
 *  4*4 matrix
 *  1 0 0 0
 *  0 1 0 0
 *  0 1 1 0
 *  1 1 1 1
 */

/**
 * @author kkadam
 *
 */
public class Problem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {
				{1, 0, 0, 0},
				{0, 1, 0, 0},
				{0, 1, 1, 0},
				{1, 1, 1, 1}
		};
		List<String> paths = new ArrayList<String>();
		findPath(matrix, 1, 1, 3, 3, paths);
	}
	
	public static void  findPath(int[][] matrix, int startRow, int startCol, int destRow, int destCol, List<String> paths) {
		//find the starting point from the first row
		int i = startRow;
		int j = startCol;
		
		while (i != destRow || j != destCol) {
			if (matrix[i][j+1] == 1) {
				System.out.println("Moving from ("+ i + "," + j+") to (" + i + ", "+ (j+1)+")");
				j++;
			} 
			if (matrix[i+1][j] == 1) {
				
				System.out.println("Moving from ("+ i + "," + j+") to (" + (i+1) + ", "+ (j)+")");
				i++;
			}
			
		}
		
	}

}
