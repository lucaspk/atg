package graph;
import java.util.*;

public class Graph {
		
		private Map<Integer, Set<Edge>> nodeMap;
		
		public Graph() {
			nodeMap = new TreeMap<>();
		}

		public void addEdge(Integer vertex, Edge edge) {
			if (nodeMap.containsKey(vertex)) {
				nodeMap.get(vertex).add(edge);
			} else {
				Set<Edge> edgesSet = new TreeSet<Edge>();
				edgesSet.add(edge);
				nodeMap.put(vertex, edgesSet);
			}
		}
		
		public int getVertexNumber() {
			return nodeMap.keySet().size();
		}

		
		public int getEdgeNumber() {
			return nodeMap.values().size();
		}

		
		public float getMeanEdge() {
			return 0;
		}

		
		public String getAdjacencyList() {
			return "";
		}

		public String getAdjacencyMatrix() {
			return "";

		}

		Integer getAVertex(){
			return nodeMap.keySet().iterator().next();
		}

		public Set<Edge> getAdjacents(Integer v) {
			return this.nodeMap.get(v);
		}

		public String getShortestPath(Integer source, Integer dest) {
			return "";
		}
}

