package graph;

public class GraphCreator {
		
	public static Graph createGraph(final String filePath) {

		RawGraph rawGraph = GraphReader.read(filePath);

		return createGraphAux(rawGraph);
	}
	
	private static Graph createGraphAux(final RawGraph rawGraph) {
		int size = rawGraph.getNumEdges();
		System.out.println(size);
		Graph graph = new Graph();
		
		for (int i = 1; i <= size; i++) {

			String[] splitted = rawGraph.getEdgeSplittedBy(" ", i);
			
			int v1 = Integer.parseInt(splitted[0]);
			int v2 = Integer.parseInt(splitted[1]);

			Edge edge = new Edge(v1, v2);
			
			if (splitted.length == 3) {
				double weight = Double.parseDouble(splitted[2]);
				edge.setWeight(weight);
			}
			graph.addEdge(v1, edge);
			graph.addEdge(v2, edge);
		}
		
		return graph;
	}
	public static void main(String[] args) {
		Graph g = GraphCreator.createGraph("src/sample_graph.txt");
		System.out.println(g.getEdgeNumber());
	}
}
