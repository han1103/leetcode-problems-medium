import java.util.LinkedList;
import java.util.List;

/*
 * https://leetcode.com/problems/course-schedule-ii/
*/
public class CourseScheduleII {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * int numCourses = 4; int[][] prerequisites = new int[][]
		 * {{1,0},{2,0},{3,1},{3,2}};
		 */ 
		int numCourses = 5;
		int[][] prerequisites = new int[][] { { 0, 4 }, { 2, 1 }, { 1, 3 }, { 3, 4 }, { 1, 4 } };
		
/*		int numCourses = 4;
		int[][] prerequisites = new int[][] { { 0, 1 }, { 1, 2}, {2, 3}, {2, 0}};
*/
		int[] result;
		result = new CourseScheduleII().findOrder(numCourses, prerequisites);

		for (int course : result)
			System.out.print(course + "->");
	}

	int[] result;
	boolean circle = false;
	boolean[] globalVisited;
	boolean[] iterationVisited;
	int index;

	public class Graph {
		List<Integer>[] adjList;
		
		Graph(int n) {
			adjList = new LinkedList[n];
			for(int i=0; i<n; i++)
				adjList[i] = new LinkedList<Integer>();
		}
		
		void addEdge(int a, int b) {
			adjList[a].add(b);
		}
	}
	
	private Graph setupGraph(int numCourses, int[][] prerequisites) {
		Graph graph = new Graph(numCourses);

		for (int[] pair : prerequisites)
			graph.adjList[pair[0]].add(pair[1]);

		return graph;
	}

	private boolean visitGraph(Graph graph, int node) {
		for (int dependingNode : graph.adjList[node]) {
			if (!globalVisited[dependingNode]) {
				if(iterationVisited[dependingNode])
					return true;
				iterationVisited[dependingNode] = true;
				if(visitGraph(graph, dependingNode))
					return true;
				iterationVisited[dependingNode] = false;
			}
		}
		globalVisited[node] = true;
		result[++index] = node;
		return false;
	}

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		result = new int[numCourses];

		Graph graph = setupGraph(numCourses, prerequisites);

		globalVisited = new boolean[numCourses];
		index = -1;		
		for (int i = 0; i < numCourses; i++)
			if (!globalVisited[i]) {
				iterationVisited = new boolean[numCourses];
				iterationVisited[i] = true;
				if(visitGraph(graph, i))
					return new int[0];
			}

		return result;
	}
}
