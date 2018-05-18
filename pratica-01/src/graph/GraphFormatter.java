package graph;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

public class GraphFormatter {

    public static String getAdjacencyList(Graph g) {
    	String result = "";

		NumberFormat nf = new DecimalFormat("##.##");
		
		for (Integer v : g.getNodeMap().keySet()) {
			result += v + " - ";
			String[] adjacents = new String[g.getAdjacents(v).size()];
			int index = 0;

			for (Edge e: g.getAdjacents(v)) {
				String weight = "";
				if (e.getWeight() != null) {
					weight = "(" + (nf.format(e.getWeight())).toString() + ")";
				}
				if (e.isLoop()) {
					adjacents[index] = v.toString() + weight;
				}
				else if (e.getV1() == v) {
					adjacents[index] = e.getV2().toString() + weight;
				} else {
					adjacents[index] = e.getV1().toString() + weight;
				}
				index ++;
			}
			result += formatLine(adjacents);
			if (index < g.getVertexNumber() - 1) {
				result += "\n";
			}
		}
	
		return result;

    }

	public static String getAdjacencyMatrix(Graph graph) {
        NumberFormat nf = new DecimalFormat("##.##");

		Map<Integer, Set<Edge>> adjacencyMap = graph.getNodeMap();
		String result = " ";
		Double weight = null;

		for (Integer v : adjacencyMap.keySet()) {
			result += " " + v;
		}
		result += "\n";
				
		for (Integer v1 : adjacencyMap.keySet()) {
			result += v1;
			for (Integer v2 : adjacencyMap.keySet()) {
				boolean auxAdjacent = false; 
				for (Edge e : adjacencyMap.get(v1)) {
					if (isAdjacent(v1, v2, e)) {
						auxAdjacent = true;
						weight = e.getWeight();
					}
				}
				
				if (!auxAdjacent) {
					result += " " + 0;
				} else {
					if (weight == null) {
						result += " " + 1;
					} else {
						result += " " + nf.format(weight);
					}
				}
					
			}
			result += "\n";
		}

		if (result.length() >= 2) {
			result = result.substring(0, result.length() - 1);
		}

		return result;
	}
	
	private static boolean isAdjacent(Integer v1, Integer v2, Edge e) {
		return e.isLoop() || (e.getV1() == v1 && e.getV2() == v2) || (e.getV2() == v1 && e.getV1() == v2);
	}

	private static String formatLine(String[] adjacents) {
		Arrays.sort(adjacents);
		String result = "";
		for (String vertice : adjacents) {
			result += vertice + " ";
		}
		return result.substring(0, result.length() - 1); 
	}}