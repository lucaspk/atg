package graph;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class GraphConnectivity {

	public static boolean isConnected(final Graph graph) {

		boolean[] visited = new boolean[graph.getVertexNumber() + 2];
		Integer firstVertex = graph.getAVertex();
		int count = 0;
		for (boolean b : dfsAux(graph, firstVertex, visited)) {
			if (b) {
				count++;
			}
		}

		return count == graph.getVertexNumber();
	}

	private static boolean[] dfsAux(Graph graph, Integer firstVertex, boolean[] visited) {

		visited[firstVertex] = true;

		for (Edge edge : graph.getAdjacents(firstVertex)) {
			Integer v1 = edge.getV1();
			Integer v2 = edge.getV2();
			Integer vertexInt = v2;

			if (visited[v2])
				vertexInt = v1;

			if (!visited[vertexInt]) {
				dfsAux(graph, vertexInt, visited);
			}
		}
		return visited;
	}

	public static String getShortestPathWeighted(Graph g, Integer source, Integer dest) {

		String result = "";
		Map<Integer, VertexInfo> vertexInfoMap = new TreeMap<>();

		for (Integer v : g.getNodeMap().keySet()) {
			vertexInfoMap.put(v, new VertexInfo(null, Double.POSITIVE_INFINITY));
		}

		vertexInfoMap.get(source).setDistance(0.0); 

			for (int i = 1; i < g.getVertexNumber(); i++) {
				for (Integer v : g.getNodeMap().keySet()) {
					for (Edge u : g.getAdjacents(v)) {
						
						relax(u.getV1(), u.getV2(), u.getWeight(), vertexInfoMap);
						relax(u.getV2(), u.getV1(), u.getWeight(), vertexInfoMap);

					}
				}
			}
		if (g.isWeighted()) {
			for (Integer v : g.getNodeMap().keySet()) {
				for (Edge e : g.getNodeMap().get(v)) {
					if (vertexInfoMap.get(e.getV1()).getDistance() + e.getWeight() < vertexInfoMap.get(v).getDistance()) {
						return result + "O grafo contém um ciclo de pesos negativos.";
					}
				}
			}
		}

		Integer currentVertex = dest;
		ArrayList<Integer> out = new ArrayList<>();
		while (currentVertex != null) {
			out.add(currentVertex);
			currentVertex = vertexInfoMap.get(currentVertex).predecessor;
		}
		for (int i = out.size() - 1; i >= 0; i--) {
			result += out.get(i) + " ";
		}

		if (result.length() >= 1) {
			result = result.substring(0, result.length() - 1);
		}

		return result;
	}
	
	public static String getShortestPathUnweighted(Graph g, Integer source, Integer dest) {

		String result = "";

		Map<Integer, VertexInfo> vertexInfoMap = new TreeMap<>();
		
		for (Integer v : g.getNodeMap().keySet()) {
			vertexInfoMap.put(v, new VertexInfo(null, Float.POSITIVE_INFINITY));
		}

		vertexInfoMap.get(source).setDistance(0); 

		for (int i = 1; i < g.getVertexNumber(); i++) {
			for (Integer v : g.getNodeMap().keySet()) {
				for (Edge u : g.getAdjacents(v)) {
					Integer aux;
					if (v == u.getV1()) {
						aux = u.getV2();
					} else {
						aux = u.getV1();
					}
					
					if (vertexInfoMap.get(aux).getDistance() + 1 < vertexInfoMap.get(v).getDistance()) {
						vertexInfoMap.get(v).setDistance(vertexInfoMap.get(aux).getDistance() + 1);
						vertexInfoMap.get(v).predecessor = aux;

					}
				}
			}
		}

		Integer currentVertex = dest;
		ArrayList<Integer> out = new ArrayList<>();
		while (currentVertex != null) {
			out.add(currentVertex);
			currentVertex = vertexInfoMap.get(currentVertex).predecessor;
		}
		for (int i = out.size() - 1; i >= 0; i--) {
			result += out.get(i) + " ";
		}

		if (result.length() >= 1) {
			result = result.substring(0, result.length()-1);
		}

		return result;
	}
	
	private static void relax(Integer v1, Integer v2, double weight, Map<Integer, VertexInfo> vertexInfoMap) {
    	if(vertexInfoMap.get(v2).distance > vertexInfoMap.get(v1).distance + weight) {
    		vertexInfoMap.get(v2).distance = vertexInfoMap.get(v1).distance + weight;
    		vertexInfoMap.get(v2).predecessor = v1;
    	}
	}
}