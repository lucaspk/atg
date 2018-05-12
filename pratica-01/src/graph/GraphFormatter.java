package graph;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class GraphFormatter {

    public static String getAdjacencyList(Graph g) {
        String result = "";

        Map<Integer, SortedSet<Pair>> vertexes = new TreeMap<>();
        int v1, v2;
        float w;
        for (Edge edge : g.getEdges()) {
            v1 = edge.getV1();
            v2 = edge.getV2();
            w = edge.getWeight();
            if (!vertexes.containsKey(v1)) {
                vertexes.put(v1, new TreeSet());
            }
            if (!vertexes.containsKey(v2)) {
                vertexes.put(v2, new TreeSet());
            }
            vertexes.get(v1).add(new Pair(v2, w));
            vertexes.get(v2).add(new Pair(v1, w));
        }

        NumberFormat nf = new DecimalFormat("##.##");

        for (Map.Entry<Integer, SortedSet<Pair>> entry : vertexes.entrySet()) {
            result += entry.getKey() + " -";
            for (Pair p : entry.getValue()) {
                result += " " + p.v;
                if (g.isWeighted()) {
                    result += "(" + nf.format(p.w) + ")";
                }
            }
            result += "\n";
        }

        if (result.length() >= 2) {
            result = result.substring(0, result.length() - 1);
        }

        return result;
    }

    private static class Pair implements Comparable {
        private Integer v;
        private float w;

        private Pair (Integer v, float w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Object o) {
            Pair p = (Pair) o;
            return v.compareTo(p.v);
        }
    }

}