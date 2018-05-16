package graph;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

public class GraphSearcher {

	public static String BFS(Graph graph, Integer v) {
		String response = "";
		int auxCont = 0;
		Map<Vertex, SortedSet<Edge>> nodeMap = graph.getNodeMap();
		
		Vertex root = searchRoot(nodeMap, v);
		
		System.out.println("MapHash: " + nodeMap.toString());
        System.out.println("Root " + root.toString());
        System.out.println("Root neighbor: " + nodeMap.get(root).toString());

        Deque<Vertex> queue = new LinkedList<Vertex>();
	    queue.add(root);
		
	    response += root.getValue() + " - " + auxCont + " - \n";
			    
	    while(!queue.isEmpty()) {
	    	
	    	auxCont += 1;
	        Vertex current = queue.removeFirst();
	        System.out.println("Current Value = " + current.getValue());
	        System.out.println("Current neighbor = " + nodeMap.get(current).toString());
	        current.setVisited();
	        
	        SortedSet<Edge> neighbors = nodeMap.get(current);
	        for (Edge neighbor : neighbors) {
	        	if (!neighbor.getV1().equals(current)) {
	        		if (!neighbor.getV1().isVisited()) {
	        			response += neighbor.getV1().getValue() + " - " + current.getValue() + " " + auxCont + "\n";
	        			queue.addFirst(neighbor.getV1());
	        		}
	            } else {
	        		if (!neighbor.getV2().isVisited()) {
	        			response += neighbor.getV2().getValue() + " - " + current.getValue() + " " + auxCont + "\n";
	        			queue.addFirst(neighbor.getV2());
	        		}
	            }
	        }
	    }
	    System.out.println(response);
	    return "";
	}
	    
	private static Vertex searchRoot(Map<Vertex, SortedSet<Edge>> map, Integer value) {
		for (Vertex entry : map.keySet()) {
			if (entry.getValue().equals(value)) {
				return entry;
			}
		}
		return null;
	}
}