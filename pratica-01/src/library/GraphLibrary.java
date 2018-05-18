package library;

import graph.*;

public class GraphLibrary {
	
	public Graph readGraph(String path) {
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
	
	public String BFS(Graph graph, int v) {
		return GraphSearcher.bfs(graph, v);
	}
	
	public String DFS(Graph graph, int v) {
		return GraphSearcher.dfs(graph, v);
	}
	
	public boolean connected(Graph graph) {
		return GraphConnectivity.isConnected(graph);
	}

	public String shortestPath(Graph graph, int v1, int v2) {
		return "";
	}
	
	public String mst(Graph graph) {
		return "";
	}
	

}
