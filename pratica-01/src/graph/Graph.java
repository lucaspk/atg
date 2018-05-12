package graph;

import java.util.*;

public class Graph {
	
	private int vertexNumber;
		
	private List<Edge> edges;

	boolean weighted;
	
	public Graph(){
		this.edges = new ArrayList<>();
	}
	
	public Graph(final int vertexNumber, final List<Edge> edges){
		this.vertexNumber = vertexNumber;
		this.edges = edges;
	}
				
	public static int getVertexNumber(final Graph graph) {
		return graph.getVertexNumber();
	}

	public static int getEdgeNumber(final Graph graph) {
		return graph.getEdgeNumber();
	}

	public int getVertexNumber() {
		return vertexNumber;
	}

	public int getEdgeNumber() {
		return edges.size();
	}

	public List<Edge> getEdges() {
		return edges;
	}
	
	public void setVertexNumber(final int vertexNumber) {
		this.vertexNumber = vertexNumber;
	}
		
	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}

	public boolean isWeighted() {
		return weighted;
	}

	public void setWeighted(boolean weighted) {
		this.weighted = weighted;
	}

	public Object[] toArray() {
		return edges.toArray();
	}
	
	public String toString() {
		return Arrays.toString(toArray());
	}

}
