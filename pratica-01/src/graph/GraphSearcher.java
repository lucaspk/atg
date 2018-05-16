package graph;

import java.util.Deque;
import java.util.LinkedList;

public class GraphSearcher {

	public static void BFS(Graph graph, Integer v) {
	    Deque<Integer> queue = new LinkedList<Integer>();
	    queue.add(v);
	    while(!queue.isEmpty()) {
	        Integer current = queue.getFirst();

	    }
	}
}