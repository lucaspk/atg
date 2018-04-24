package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph {
	
	private int vertexNumber;
		
	private List<Edge> edges;
	
	public Graph(){
		this.edges = new ArrayList<Edge>();
	}
	
	public Graph(final List<Edge> edges){
		this.edges = edges;
	}
		
	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}
	
	public int getVertexNumber() {
		return vertexNumber;
	}
	
	public void setVertexNumber(final int vertexNumber) {
		this.vertexNumber = vertexNumber;
	}

	public int getEdgeNumber() {
		return edges.size();
	}
	
	public static int getVertexNumber(final Graph graph) {
		return graph.getVertexNumber();
	}

	public static int getEdgeNumber(final Graph graph) {
		return graph.getEdgeNumber();
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