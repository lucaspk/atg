package graph;

import java.util.Map;
import java.util.SortedSet;

public interface IGraph {

    Map getMap();

    void addEdge(int v1, int v2, float weight);

    int getVertexNumber();

    int getEdgeNumber();

    float getMeanEdge();

    String getAdjacencyList();

    String getAdjacencyMatrix();

    String getShortestPath(Integer v1, Integer v2);
}
