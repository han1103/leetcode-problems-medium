/*
 * https://leetcode.com/problems/unique-paths/
*/
package mathworks;

public class UniquePaths {
	int m,n;
	int[][] cache;
	int uniquePathsRec(int i, int j) {
		if(i==m || j==n)
			return 1;
		if(cache[i][j]!=0)
			return cache[i][j];
		cache[i][j] = uniquePathsRec(i+1, j) + uniquePathsRec(i, j+1);
		return cache[i][j]; 
	}
	
	public int uniquePaths(int m, int n) {
		if(m==0 || n==0)
			return 0;
		if(m==1 || n==1)
			return 1;
		
		this.m = m;
		this.n = n;
		
		cache = new int[m][];
		for(int i=0; i<m; i++)
			cache[i] = new int[n];
		
		return uniquePathsRec(1, 1);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new UniquePaths().uniquePaths(7, 3));
	}

}
