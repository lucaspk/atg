package graph;

import java.util.ArrayList;
import java.util.List;

public class RawGraph {
	
	private List<String> rawGraph;
	
	public RawGraph() {
		this.rawGraph = new ArrayList<String>();
	}
	
	public RawGraph(final List<String> rawGraph) {
		this.rawGraph = rawGraph;
	}
	
	public static int getVertexNumber(final RawGraph graph) {
		return graph.getVertexNumber();
	}

	public static int getEdgeNumber(final RawGraph graph) {
		return graph.getNumEdges();
	}
	
	public List<String> getRawGraph() {
		return rawGraph;
	}
	
	public void setRawGraph(List<String> rawGraph) {
		this.rawGraph = rawGraph;
	}
	
	public int getNumEdges() {
		return rawGraph.size() - 1;
	}
	
	public int getVertexNumber () {
		return Integer.parseInt(getEdge(0));
	}
	
	public String getEdge(final int i) {
		return rawGraph.get(i);
	}
	
	public String[] getEdgeSplittedBy(final String regex, final int i) {
		String vertexes = getEdge(i);
		
		return vertexes.split(regex);
	}
}
