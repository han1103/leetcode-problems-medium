import java.util.LinkedList;
import java.util.List;

public class Graph {
	List<Integer>[] adjList;
	
	Graph(int n) {
		adjList = new LinkedList[n];
		for(int i=0; i<n; i++)
			adjList[0] = new LinkedList<Integer>();
	}
	
	void addEdge(int a, int b) {
		adjList[a].add(b);
	}
}
