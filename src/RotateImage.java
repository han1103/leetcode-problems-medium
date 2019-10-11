/*
 * https://leetcode.com/problems/rotate-image/
*/;
public class RotateImage {
	public static void main(String[] args) {
		testMatrix(new int[][] { 
			{1,2},
			{3,4}
		});
		testMatrix(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } });
		testMatrix(new int[][] {
			{5, 1, 9, 11},
			{ 2, 4, 8, 10},
			{13, 3, 6, 7},
			{15, 14, 12, 16}
		});
	}

	static void testMatrix(int[][] matrix) {
		new RotateImage().rotate(matrix);

		for (int[] row : matrix) {
			for (int elem : row)
				System.out.print(elem + " ");
			System.out.println();
		}
		System.out.println("--------------------------");
	}

	public void rotate(int[][] matrix) {
		int n = matrix.length;

		for (int k = 0; k <= n / 2 - 1; k++)
			for (int i = k; i <= n - 2 -k; i++) {
				int temp1 = matrix[i][k];
				matrix[i][k] = matrix[n - 1 - k][i];
				int temp2 = matrix[k][n - 1 - k - i];
				matrix[k][n - 1 - k - i] = temp1;
				temp1 = matrix[n - 1 - k - i][n - 1 - k];
				matrix[n - 1 - k - i][n - 1 - k] = temp2;
				matrix[n - 1 - k][i] = temp1;
			}
	}
}
