package library;

import graph.UnweightedGraph;
import graph.GraphReader;

public class GraphLibrary {

	public UnweightedGraph readGraph(String path) {
		GraphReader graphReader = new GraphReader();
		return null;
	}
	
	public UnweightedGraph readWeightedGraph(String path) {
		return null;
	}
	
	public int getVertexNumber(UnweightedGraph graph) {
		return graph.getVertexNumber();
	}
	
	public int getEdgeNumber(UnweightedGraph graph) {
		return graph.getEdgeNumber();
	}
	
	public float getMeanEdge(UnweightedGraph graph) {
		return 0;
	}
	
	public String graphRepresentation(UnweightedGraph graph, String type) {
		return "";
	}
	
	public String BFS(UnweightedGraph graph, int v) {
		return "";
	}
	
	public String DFS(UnweightedGraph graph, int v) {
		return "";
	}
	
	public boolean connected(UnweightedGraph graph) {
		return true;
	}

	public String shortestPath(UnweightedGraph graph, int v1, int v2) {
		return "";
	}
	
	public String mst(UnweightedGraph graph) {
		return "";
	}
	

}
