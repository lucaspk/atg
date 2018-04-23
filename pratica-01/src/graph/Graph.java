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
	
	public Graph(final RawGraph rawGraph){
		this.edges = new ArrayList<Edge>();
		this.vertexNumber = RawGraph.getVertexNumber(rawGraph);
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