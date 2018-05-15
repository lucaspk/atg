package graph;
import java.util.*;

public class Graph {
		
		private Map<Integer, Set<Edge>> nodeMap;

		private int vertexNumber;
		
		public Graph() {
			nodeMap = new HashMap();
		}

		public void addEdge(Integer vertex, Edge edge) {
			
		}
		
		public int getVertexNumber() {
			return vertexNumber;
		}

		
		public int getEdgeNumber() {
			return nodeMap.size();
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

		public String getShortestPath(Integer source, Integer dest) {
			return "";
		}
}

