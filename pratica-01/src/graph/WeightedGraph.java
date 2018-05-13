package graph;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class WeightedGraph implements Graph {

    private Map<Integer, SortedSet<Pair>> adjacencyMap;

    private int edgeNumber;

    public WeightedGraph() {
        this.adjacencyMap = new TreeMap<>();
    }

    @Override
    public Map<Integer, SortedSet<Pair>> getMap() {
        return this.adjacencyMap;
    }

    @Override
    public void addEdge(int v1, int v2, float weight) {
        if (!this.adjacencyMap.containsKey(v1)) {
            this.adjacencyMap.put(v1, new TreeSet<>());
        }
        if (!this.adjacencyMap.containsKey(v2)) {
            this.adjacencyMap.put(v2, new TreeSet<>());
        }
        this.adjacencyMap.get(v1).add(new Pair(v2, weight));
        this.adjacencyMap.get(v2).add(new Pair(v1, weight));

        this.edgeNumber++;
    }

    @Override
    public int getVertexNumber() {
        return 0;
    }

    @Override
    public int getEdgeNumber() {
        return edgeNumber;
    }

    @Override
    public float getMeanEdge() {
        return 0;
    }

    @Override
    public String getAdjacencyList() {
        String result = "";

        NumberFormat nf = new DecimalFormat("##.##");

        for (Map.Entry<Integer, SortedSet<Pair>> entry : this.adjacencyMap.entrySet()) {
            result += entry.getKey() + " -";
            for (Pair p : entry.getValue()) {
                result += " " + p.getVertex() + "(" + nf.format(p.getWeight()) + ")";
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
