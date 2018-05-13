package graph;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

public class UnweightedGraph implements Graph {
	
	private Map<Integer, SortedSet<Integer>> adjacencyMap;

	private int edgeNumber;
		
	public UnweightedGraph(){
		this.adjacencyMap = new TreeMap<>();
	}

	@Override
	public Map<Integer, SortedSet<Integer>> getMap() {
		return adjacencyMap;
	}

	@Override
	public void addEdge(int v1, int v2, float weight) {
		if (!this.adjacencyMap.containsKey(v1)) {
			this.adjacencyMap.put(v1, new TreeSet<>());
		}
		if (!this.adjacencyMap.containsKey(v2)) {
			this.adjacencyMap.put(v2, new TreeSet<>());
		}
		this.adjacencyMap.get(v1).add(v2);
		this.adjacencyMap.get(v2).add(v1);

		this.edgeNumber++;
	}

	@Override
	public int getVertexNumber() {
		return this.adjacencyMap.size();
	}

	@Override
	public int getEdgeNumber() {
		return this.edgeNumber;
	}

	@Override
	public float getMeanEdge() {
		return 0;
	}

	@Override
	public String getAdjacencyList() {
		String result = "";

		NumberFormat nf = new DecimalFormat("##.##");

		for (Map.Entry<Integer, SortedSet<Integer>> entry : this.adjacencyMap.entrySet()) {
			result += entry.getKey() + " -";
			for (Integer v : entry.getValue()) {
				result += " " + v;
			}
			result += "\n";
		}

		if (result.length() >= 2) {
			result = result.substring(0, result.length() - 1);
		}

		return result;
	}

	@Override
	public String getAdjacencyMatrix() {
		return null;
	}
}
