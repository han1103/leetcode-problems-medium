/*
 * https://leetcode.com/problems/spiral-matrix-ii/
*/
public class SpiralMatrix2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = new SpiralMatrix2().generateMatrix(5);
		
		for(int[] row: matrix) {
			for(int elem: row)
				System.out.print(elem+"\t");
			System.out.println();
		}		
	}

	public int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][];
		
		for(int i=0; i<n; i++)
			matrix[i] = new int[n];
			
		int num=0;
		for(int i=0; i<n/2; i++) {
			//top row : row i
			for(int j=i; j<n-i; j++)
				matrix[i][j]=(++num);
			
			//right column : column n-i-1
			for(int k=i+1; k<n-1-i; k++)
				matrix[k][n-i-1]=(++num);
			
			//bottom row : row n-1-i
			for(int j=n-i-1; j>=i; j--)
				matrix[n-1-i][j]=(++num);

			//left column : column i
			for(int k=n-2-i; k>i; k--)
				matrix[k][i]=(++num);
		}
		
		if(n%2==1)
			matrix[(n-1)/2][(n-1)/2]=(++num);
			
		return matrix;
	}
}
