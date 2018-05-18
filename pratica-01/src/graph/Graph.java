package graph;
import java.util.*;

public class Graph {
		
		private Map<Integer, Set<Edge>> nodeMap;
		private boolean isWeighted;
		
		public Graph() {
			isWeighted = false;
			nodeMap = new TreeMap<>();
		}

		public void addEdge(Integer vertex, Edge edge) {
			this.isWeighted = true;
			if (nodeMap.containsKey(vertex)) {
				nodeMap.get(vertex).add(edge);
			} else {
				Set<Edge> edgesSet = new TreeSet<Edge>();
				edgesSet.add(edge);
				nodeMap.put(vertex, edgesSet);
			}
		}
		
		public Map<Integer, Set<Edge>> getNodeMap() {
			return nodeMap;
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

		public Set<Edge> getAdjacents(Integer v) {
			return this.nodeMap.get(v);
		}

		public String getShortestPath(Integer source, Integer dest) {
			return "";
		}
		
		public boolean getIsWeighted() {
			return isWeighted;
		}
}

