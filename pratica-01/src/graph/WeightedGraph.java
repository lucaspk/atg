package graph;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

public class WeightedGraph implements Graph {

    private Map<Integer, SortedSet<Pair>> adjacencyMap;

    private int edgeNumber;

    public WeightedGraph() {
        this.adjacencyMap = new TreeMap<>();
    }

    public SortedSet<Pair> getAdjacents(Integer v) {
        return this.adjacencyMap.get(v);
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
        return this.adjacencyMap.size();
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
        NumberFormat nf = new DecimalFormat("##.##");
        String result = "";

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
        NumberFormat nf = new DecimalFormat("##.##");
        String result = "";

        for (Integer v : this.adjacencyMap.keySet()) {
            result += " " + v;
        }
        result += "\n";

        boolean foundVertex = false;
        for (Integer v1 : this.adjacencyMap.keySet()) {
            result += v1;
            for (Integer v2 : this.adjacencyMap.keySet()) {
                foundVertex = false;
                for (Pair p : this.adjacencyMap.get(v1)) {
                    if (p.getVertex().equals(v2)) {
                        result += " " + nf.format(p.getWeight());
                        foundVertex = true;
                        break;
                    }
                }
                if (!foundVertex) {
                    result += " " + 0;
                }
            }
            result += "\n";
        }

        if (result.length() >= 2) {
            result = result.substring(0, result.length() - 1);
        }

        return result;
    }

    @Override
    public String getShortestPath(Integer source, Integer dest) {
        String result = "";

        // This implementation takes in a graph, represented as
        // lists of vertices and edges, and fills two arrays
        // (distance and predecessor) with shortest-path
        // (less cost/distance/metric) information

        // Step 1: initialize graph
        Map<Integer, VertexInfo> vertexInfoMap = new TreeMap<>();
        for (Integer v : this.adjacencyMap.keySet()) {
            vertexInfoMap.put(v, new VertexInfo(null, Float.POSITIVE_INFINITY));
        }

        vertexInfoMap.get(source).distance = 0; // The weight is zero at the source

        // Step 2: relax edges repeatedly
        for (int i = 1; i < this.getVertexNumber(); i++) {
            for (Integer v : this.adjacencyMap.keySet()) {
                for (Pair e : this.adjacencyMap.get(v)) {
                    if (vertexInfoMap.get(e.getVertex()).distance + e.getWeight() < vertexInfoMap.get(v).distance) {
                        vertexInfoMap.get(v).distance = vertexInfoMap.get(e.getVertex()).distance + e.getWeight();
                        vertexInfoMap.get(v).predecessor = e.getVertex();
                    }
                }
            }
        }

        // Step 3: check for negative-weight cycles

        for (Integer v : this.adjacencyMap.keySet()) {
            for (Pair e : this.adjacencyMap.get(v)) {
                if (vertexInfoMap.get(e.getVertex()).distance + e.getWeight() < vertexInfoMap.get(v).distance) {
                    return result + "O grafo contém um ciclo de pesos negativos.";
                }
            }
        }

        // Build result
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
}
