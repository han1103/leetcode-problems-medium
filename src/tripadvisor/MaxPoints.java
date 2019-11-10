/*
 * https://leetcode.com/problems/max-points-on-a-line/
*/	
package tripadvisor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxPoints {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		  int[][] points = new int[][] { {1,1},{2,2},{3,3} };
		 
		//int[][] points = new int[][] { {0,0}, {1,65536} ,{65536,0} };
		/*
		 * int[][] points = new int[][] { { 0, 9 }, { 138, 429 }, { 115, 359 }, { 115,
		 * 359 }, { -30, -102 }, { 230, 709 }, { -150, -686 }, { -135, -613 }, { -60,
		 * -248 }, { -161, -481 }, { 207, 639 }, { 23, 79 }, { -230, -691 }, { -115,
		 * -341 }, { 92, 289 }, { 60, 336 }, { -105, -467 }, { 135, 701 }, { -90, -394
		 * }, { -184, -551 }, { 150, 774 } };
		 */		/*
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

		System.out.println(new MaxPoints().maxPoints(points));
	}

	class Point {
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
		int x;
		int y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;			
		}	
		
	}
	
	Map<Point, Integer> map = new HashMap<MaxPoints.Point, Integer>();
	
	List<Point> preProcessPoints(int[][] points) {
		List<Point> list = new ArrayList<Point>();
 		for(int[] point: points) {
			Point pt = new Point(point[0], point[1]);
			if(!map.containsKey(pt)) {
				list.add(pt);
			}
			map.put(pt, map.getOrDefault(pt, 0)+1);
		}
 		
 		return list;
	}

	public int maxPoints(int[][] points) {
		if (points == null)
			return 0;
		if (points.length <= 2)
			return points.length;

		List<Point> pointList = preProcessPoints(points);
		if (pointList.size() <= 2) {
			int retVal = 0;
			for(Point point : pointList)
				retVal += map.getOrDefault(point, 1);
			
			return retVal;
		}
		
		int currPoints = map.getOrDefault(pointList.get(0), 1) + map.getOrDefault(pointList.get(1), 1);
		for (int i = 0; i < pointList.size() - 2; i++) {
			/*
			 * int maxPointsPossible = pointList.size() - i;
			 * 
			 * if (maxPointsPossible <= currPoints) return currPoints;
			 */
			for (int j = i + 1; j < pointList.size() - 1; j++) {
				/*
				 * maxPointsPossible = pointList.size() - j + 1;
				 * 
				 * if (maxPointsPossible <= currPoints) break;
				 */
				int numPointsSameLine = map.getOrDefault(pointList.get(i), 1) + map.getOrDefault(pointList.get(j), 1);
				long yDiff = (pointList.get(j).y - pointList.get(i).y);
				long xDiff = (pointList.get(j).x - pointList.get(i).x);
				for (int k = j + 1; k < pointList.size(); k++) {
					long xDiffCurr = pointList.get(k).x - pointList.get(i).x;
					long yDiffCurr = pointList.get(k).y - pointList.get(i).y;
					if (yDiff * xDiffCurr == xDiff * yDiffCurr) {
						numPointsSameLine+=map.getOrDefault(pointList.get(k), 1);
					}
				}
				currPoints = Math.max(currPoints, numPointsSameLine);
			}
		}

		return currPoints;
	}

	/*
	 * public int maxPoints(int[][] points) { if (points == null) return 0; if
	 * (points.length <= 2) return points.length;
	 * 
	 * int currPoints = 2; for (int i = 0; i < points.length - 2; i++) { int
	 * maxPointsPossible = points.length - i;
	 * 
	 * if (maxPointsPossible <= currPoints) return currPoints;
	 * 
	 * for (int j = i + 1; j < points.length - 1; j++) { maxPointsPossible =
	 * points.length - j + 1;
	 * 
	 * if (maxPointsPossible <= currPoints) break;
	 * 
	 * int numPointsSameLine = 2; long yDiff = (points[j][1] - points[i][1]); long
	 * xDiff = (points[j][0] - points[i][0]); for (int k = j + 1; k < points.length;
	 * k++) { long xDiffCurr = points[k][0] - points[i][0]; long yDiffCurr =
	 * points[k][1] - points[i][1]; if (yDiff * xDiffCurr == xDiff * yDiffCurr)
	 * numPointsSameLine++; } currPoints = Math.max(currPoints, numPointsSameLine);
	 * } }
	 * 
	 * return currPoints; }
	 */

}
