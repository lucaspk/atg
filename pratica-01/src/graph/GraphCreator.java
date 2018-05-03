package graph;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GraphCreator {
	
	private static List<Edge> edges;
	
	public static Graph createGraph(final String filePath) {
		
		RawGraph rawGraph = GraphReader.read(filePath);
		
		edges = getEdges(rawGraph);
		
		int vertexNumber = rawGraph.getVertexNumber();

		Graph g = new Graph(vertexNumber, edges);
		
		return g;
	}
		
	private static List<Edge> getEdges(final RawGraph rawGraph) {
		int size = rawGraph.getNumEdges();

		List<Edge> edges = new ArrayList<Edge>();

		for (int i = 1; i <= size; i++) {

			String[] splitted = rawGraph.getEdgeSplittedBy(" ", i);
			
			int v1 = Integer.parseInt(splitted[0]);
			int v2 = Integer.parseInt(splitted[1]);
			
			edges.add(new Edge(v1, v2));
		}
		return edges;
	}

}
