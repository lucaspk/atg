package graph;

import java.util.ArrayList;
import java.util.List;

public class GraphCreator {
	
	private static List<Edge> edges;
	
	public static Graph createGraph(final String filePath, boolean weighted) {

		RawGraph rawGraph = GraphReader.read(filePath);

		Graph g;
		if (weighted) {
			g = new WeightedGraph();
		} else {
			g = new UnweightedGraph();
		}

		addEdges(g, rawGraph);


		return g;
	}

	public static UnweightedGraph createGraph(final String filePath) {
		return (UnweightedGraph) createGraph(filePath, false);
	}

	public static WeightedGraph createWeightedGraph(final String filePath) {
		return (WeightedGraph) createGraph(filePath, true);
	}

	private static void addEdges(Graph g, final RawGraph rawGraph) {
		int size = rawGraph.getNumEdges();

		for (int i = 1; i <= size; i++) {

			String[] splitted = rawGraph.getEdgeSplittedBy(" ", i);
			
			int v1 = Integer.parseInt(splitted[0]);
			int v2 = Integer.parseInt(splitted[1]);
			if (splitted.length == 3) {
				float w = Float.parseFloat(splitted[2]);
				g.addEdge(v1, v2, w);
			} else {
				g.addEdge(v1, v2, 0);
			}
		}
	}

}
