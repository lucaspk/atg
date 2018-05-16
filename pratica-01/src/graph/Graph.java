package graph;
import java.util.*;

public class Graph {
		
		private Map<Vertex, SortedSet<Edge>> nodeMap;
		
		public Graph() {
			nodeMap = new HashMap<>();
		}

		public void addEdge(Vertex vertex, Edge edge) {
			if (nodeMap.containsKey(vertex)) {
				nodeMap.get(vertex).add(edge);
			} else {
				SortedSet<Edge> edgesSet = new TreeSet<Edge>();
				edgesSet.add(edge);
				nodeMap.put(vertex, edgesSet);
			}
		}
		
		public Map<Vertex, SortedSet<Edge>> getNodeMap() {
			return nodeMap;
		}
		
		public int getVertexNumber() {
			System.out.println(nodeMap.keySet());
			return nodeMap.keySet().size();
		}

		
		public int getEdgeNumber() {
			return nodeMap.values().size();
		}

		
		public float getMeanEdge() {
			return (2 * getEdgeNumber()) / getVertexNumber();
		}

		
		public String getAdjacencyList() {
			return "";
		}

		public String getAdjacencyMatrix() {
			return "";
		}

		public String getShortestPath(Integer source, Integer dest) {
			return "";
		}
}

