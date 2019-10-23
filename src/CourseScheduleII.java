/*
 * https://leetcode.com/problems/course-schedule-ii/
*/
public class CourseScheduleII {
	int[] result;
	boolean[] globalVisited;
	boolean[] iterationVisited;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private Graph setupGraph(int numCourses, int[][] prerequisites) {
		Graph graph = new Graph(numCourses);
		
		for(int[] pair : prerequisites)
			graph.adjList[pair[0]].add(pair[1]);
		
		return graph;
	}
	
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		result = new int[numCourses];
		
		Graph graph = setupGraph(numCourses, prerequisites);
		
		
		return result;
	}
}
