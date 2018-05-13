package graph;

import java.util.Map;

public interface Graph {

    Map getMap();

    void addEdge(int v1, int v2, float weight);

    int getVertexNumber();

    int getEdgeNumber();

    float getMeanEdge();

    String getAdjacencyList();

    String getAdjacencyMatrix();
}
