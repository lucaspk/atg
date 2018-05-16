package library;

import graph.UnweightedGraph;
import graph.Graph;
import graph.GraphReader;

public class GraphLibrary {

	public Graph readGraph(String path) {
		GraphReader graphReader = new GraphReader();
		return null;
	}
	
	public Graph readWeightedGraph(String path) {
		return null;
	}
	
	public int getVertexNumber(Graph graph) {
		return graph.getVertexNumber();
	}
	
	public int getEdgeNumber(Graph graph) {
		return graph.getEdgeNumber();
	}
	
	public float getMeanEdge(Graph graph) {
		return 0;
	}
	
	public String graphRepresentation(Graph graph, String type) {
		return "";
	}
	
	public String BFS(Graph graph, Integer v) {
		return "";
	}
	
	public String DFS(Graph graph, Integer v) {
		return "";
	}
	
	public boolean connected(Graph graph) {
		return true;
	}

	public String shortestPath(Graph graph, Integer v1, Integer v2) {
		return "";
	}
	
	public String mst(UnweightedGraph graph) {
		return "";
	}
	

}
