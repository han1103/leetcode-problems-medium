/*
 * https://leetcode.com/problems/rotate-image/
*/;
public class RotateImage {
	public static void main(String[] args) {
		testMatrix(new int[][] { { 1, 2 }, { 3, 4 } });
		testMatrixTopBottom(new int[][] { { 1, 2 }, { 3, 4 } });
		testMatrix(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } });
		testMatrixTopBottom(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } });
		testMatrix(new int[][] { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } });
		testMatrixTopBottom(new int[][] { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } });
		testMatrix(new int[][] { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 },
				{ 21, 22, 23, 24, 25 } });
		testMatrixTopBottom(new int[][] { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 },
			{ 21, 22, 23, 24, 25 } });
	}

	static void printMatrix(int[][] matrix) {
		for (int[] row : matrix) {
			for (int elem : row)
				System.out.print(elem + " ");
			System.out.println();
		}
		System.out.println("--------------------------");		
	}
	
	static void testMatrix(int[][] matrix) {
		new RotateImage().rotate(matrix);
		printMatrix(matrix);
	}

	static void testMatrixN2(int[][] matrix) {
		new RotateImage().rotateN2Space(matrix);
		printMatrix(matrix);
	}

	static void testMatrixTopBottom(int[][] matrix) {
		new RotateImage().rotateTopBottom(matrix);
		printMatrix(matrix);
	}

	public void rotate(int[][] matrix) {
		int n = matrix.length;

		for (int k = 0; k <= n / 2 - 1; k++)
			for (int i = k; i <= n - 2 - k; i++) {
				int temp1 = matrix[i][k];
				matrix[i][k] = matrix[n - 1 - k][i];
				int temp2 = matrix[k][n - 1 - i];
				matrix[k][n - 1 - i] = temp1;
				temp1 = matrix[n - 1 - i][n - 1 - k];
				matrix[n - 1 - i][n - 1 - k] = temp2;
				matrix[n - 1 - k][i] = temp1;
			}
	}

	public void rotateN2Space(int[][] matrix) {
		int n = matrix.length;
		int[][] tempMatrix = new int[n][];
		for (int i = 0; i < n; i++) {
			tempMatrix[i] = new int[n];
			for (int j = 0; j < n; j++)
				tempMatrix[i][j] = matrix[i][j];
		}

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				matrix[j][i] = tempMatrix[n - 1 - i][j];
			}
	}

	public void rotateTopBottom(int[][] matrix) {
		int n = matrix.length;
		
		int topLI=0;
		int topLJ=0;
		int topRI=0;
		int topRJ=n-1;
		int bottomLI=n-1;
		int bottomLJ=0;
		int bottomRI=n-1;
		int bottomRJ=n-1;
		
		for(int i=0; i<=n/2-1; i++) {
			int topLIMove=topLI;
			int topLJMove=topLJ;
			int topRIMove=topRI;
			int topRJMove=topRJ;
			int bottomLIMove=bottomLI;
			int bottomLJMove=bottomLJ;
			int bottomRIMove=bottomRI;
			int bottomRJMove=bottomRJ;
			while(topLJMove<topRJ) {
				int temp = matrix[topLIMove][topLJMove];
				matrix[topLIMove][topLJMove] = matrix[bottomLIMove][bottomLJMove];
				matrix[bottomLIMove][bottomLJMove] = matrix[bottomRIMove][bottomRJMove];
				matrix[bottomRIMove][bottomRJMove] = matrix[topRIMove][topRJMove];
				matrix[topRIMove][topRJMove] = temp;
				topLJMove++;
				topRIMove++;
				bottomRJMove--;
				bottomLIMove--;
			}
			topLI++;
			topLJ++;
			topRI++;
			topRJ--;
			bottomLI--;
			bottomLJ++;
			bottomRI--;
			bottomRJ--;			
		}
	}
}
