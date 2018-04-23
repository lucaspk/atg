package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph {
	
	private static int vertexNumber;
		
	private static List<Edge> edges = new ArrayList<Edge>();
	
	public static Graph createGraph(final List<String> rawGraph) {
		vertexNumber = getVertexNumber(rawGraph);
		
		setUpEdges(rawGraph);
		
		return new Graph();
	}

	private static void setUpEdges(final List<String> graph) {
		int size = graph.size();
		for (int i = 1; i < size; i++) {
			String vertexes = graph.get(i);
			String[] splitted = vertexes.split(" ");
			
			int v1 = Integer.parseInt(splitted[0]);
			int v2 =Integer.parseInt(splitted[1]);
			
			edges.add(new Edge(v1, v2));
		}
	}
	
	public static int getVertexNumber(final List<String> graph) {
		return Integer.parseInt(graph.get(0));
	}

	public static int getEdgeNumber(final List<String> graph) {
		return graph.size() - 1;
	}
	
	public int getVertexNumber() {
		return vertexNumber;
	}

	public int getEdgeNumber() {
		return edges.size();
	}
		
	public List<Edge> edges() {
		return edges;
	}
	
	public Object[] toArray() {
		return edges.toArray();
	}
	
	public String toString() {
		return Arrays.toString(toArray());
	}

}