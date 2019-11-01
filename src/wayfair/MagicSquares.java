/*
 * https://leetcode.com/problems/magic-squares-in-grid/
*/	
package wayfair;

import java.util.HashSet;
import java.util.Set;

public class MagicSquares {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * int[][] grid = new int[][] { {4,3,8,4}, {9,5,1,9}, {2,7,6,2} };
		 */		
		int[][] grid = new int[][] {
			{5,5,5},
	        {5,5,5},
	        {5,5,5}	
		};
		
		System.out.println(new MagicSquares().numMagicSquaresInside(grid));

	}

	boolean isMagic(int[][] grid, int startRow, int startColumn) {
		Set<Integer> set = new HashSet<Integer>();
		for(int i=0; i<=2; i++)
			for(int j=0; j<=2; j++) {
				int temp = grid[startRow+i][startColumn+j];
				if(temp<1 || temp>9 || set.contains(temp))
					return false;
				set.add(temp);
			}
				
		//top
		int top = grid[startRow][startColumn]+grid[startRow][startColumn+1]+grid[startRow][startColumn+2];
		// bottom
		int val = grid[startRow+2][startColumn]+grid[startRow+2][startColumn+1]+grid[startRow+2][startColumn+2];
		if(top!=val)
			return false;
	
		// left
		val = grid[startRow][startColumn]+grid[startRow+1][startColumn]+grid[startRow+2][startColumn];
		if(top!=val)
			return false;
		
		// right
		val = grid[startRow][startColumn+2]+grid[startRow+1][startColumn+2]+grid[startRow+2][startColumn+2];
		if(top!=val)
			return false;
		
		//diagonal1
		val = grid[startRow][startColumn]+grid[startRow+1][startColumn+1]+grid[startRow+2][startColumn+2];
		if(top!=val)
			return false;
		
		//diagonal2
		val = grid[startRow+2][startColumn]+grid[startRow+1][startColumn+1]+grid[startRow][startColumn+2];
		if(top!=val)
			return false;
		
		return true;
	}
	public int numMagicSquaresInside(int[][] grid) {
		if(grid==null)
			return 0;
		int rows = grid.length;
		if(rows < 3)
			return 0;
		if(grid[0]==null)
			return 0;
		int columns = grid[0].length;
		if(columns<3)
			return 0;
		
		int count = 0;
		for(int i=0; i<=rows-3; i++)
			for(int j=0; j<=columns-3; j++)
				if(isMagic(grid, i, j))
					count++;
		
		return count;
    }

}
