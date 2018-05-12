package graph;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GraphCreator {
	
	private static List<Edge> edges;
	
	public static Graph createGraph(final String filePath, boolean weighted) {

		RawGraph rawGraph = GraphReader.read(filePath);

		edges = getEdges(rawGraph);

		int vertexNumber = rawGraph.getVertexNumber();

		Graph g = new Graph(vertexNumber, edges);
		g.setWeighted(weighted);

		return g;
	}

	public static Graph createGraph(final String filePath) {
		return createGraph(filePath, false);
	}

	public static Graph createWeightedGraph(final String filePath) {
		return createGraph(filePath, true);
	}

	private static List<Edge> getEdges(final RawGraph rawGraph) {
		int size = rawGraph.getNumEdges();

		List<Edge> edges = new ArrayList<Edge>();

		for (int i = 1; i <= size; i++) {

			String[] splitted = rawGraph.getEdgeSplittedBy(" ", i);
			
			int v1 = Integer.parseInt(splitted[0]);
			int v2 = Integer.parseInt(splitted[1]);
			if (splitted.length == 3) {
				float w = Float.parseFloat(splitted[2]);
				edges.add(new Edge(v1, v2, w));
			} else {
				edges.add(new Edge(v1, v2));
			}
		}
		return edges;
	}

}
