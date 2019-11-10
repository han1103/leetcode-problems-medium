/*
 * https://leetcode.com/problems/max-points-on-a-line/
*/	
package tripadvisor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxPoints2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		  int[][] points = new int[][] { {1,1},{2,2},{3,3} };
		 
		//int[][] points = new int[][] { {0,0}, {1,65536} ,{65536,0} };
		
		/*
		 * int[][] points = new int[][] { { 0, 9 }, { 138, 429 }, { 115, 359 }, { -30,
		 * -102 }, { 230, 709 }, { -150, -686 }, { -135, -613 }, { -60, -248 }, { -161,
		 * -481 }, { 207, 639 }, { 23, 79 }, { -230, -691 }, { -115, -341 }, { 92, 289
		 * }, { 60, 336 }, { -105, -467 }, { 135, 701 }, { -90, -394 }, { -184, -551 },
		 * { 150, 774 } };
		 */		 		
		
		/*
		 * int[][] points = new int[][] { { 0, 9 }, { 138, 429 }, { 115, 359 }, { 115,
		 * 359 }, { -30, -102 }, { 230, 709 }, { -150, -686 }, { -135, -613 }, { -60,
		 * -248 }, { -161, -481 }, { 207, 639 }, { 23, 79 }, { -230, -691 }, { -115,
		 * -341 }, { 92, 289 }, { 60, 336 }, { -105, -467 }, { 135, 701 }, { -90, -394
		 * }, { -184, -551 }, { 150, 774 } };
		 */		 
		
		/*
		 * int[][] points = new int[][] { { 1, 1 }, { 3, 2 }, { 5, 3 }, { 4, 1 }, { 2, 3
		 * }, { 1, 4 } };
		 */		 		 
		 //int[][] points = new int[][] { {0,0}, {1,1}, {0,0}};
		 //int[][] points = new int[][] { {3,1}, {12,3} ,{3,1}, {-6,-1}};

		System.out.println(new MaxPoints2().maxPoints(points));
	}

	public int maxPoints(int[][] points) {
		if (points == null)
			return 0;
		if (points.length <= 2)
			return points.length;

		int currPoints = 1;
		for (int i = 0; i < points.length - 1; i++) {
			for (int j = i + 1; j < points.length; j++) {
				int thisMax=2;
				boolean dup = false;
				long yDiff=0, xDiff=0;
				if(points[j][0]==points[i][0] && points[j][1]==points[i][1]) {
					dup = true;
				}
				else {
					yDiff = points[j][1] - points[i][1];
					xDiff = points[j][0] - points[i][0];
				}
				for (int k = j + 1; k < points.length; k++) {
					if(dup) {
						if(points[k][0]==points[i][0] && points[k][1]==points[i][1])
							thisMax++;
						continue;
					}					
					long xDiffCurr = points[k][0] - points[i][0];
					long yDiffCurr = points[k][1] - points[i][1];
					if (yDiff * xDiffCurr == xDiff * yDiffCurr)
						thisMax++;
				}
				currPoints = Math.max(currPoints, thisMax);
			}			
		}

		return currPoints;
	}
}
