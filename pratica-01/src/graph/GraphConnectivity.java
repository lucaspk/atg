package graph;

import java.util.ArrayList;

public class GraphConnectivity {

    public static boolean isConnected(final Graph graph) {

        boolean[] visited = new boolean[graph.getVertexNumber() + 2];
        Integer firstVertex = graph.getAVertex();
        int count = 0;
        for(boolean b: dfsAux(graph, firstVertex, visited)){
            if (b){
                count ++;
            }
        }

        return count == graph.getVertexNumber();
    }

    private static boolean[] dfsAux(Graph graph,
                                 Integer firstVertex,
                                 boolean[] visited) {

        visited[firstVertex] = true;

        for (Edge edge : graph.getAdjacents(firstVertex)) {
            Integer v1 = edge.getV1();
            Integer v2 = edge.getV2();
            Integer vertexInt = v2;

            if (visited[v2]) vertexInt = v1;

            if (!visited[vertexInt]) {
                dfsAux(graph, vertexInt, visited);
            }
        }
        return visited;
    }
}