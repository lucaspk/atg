package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GraphTree {

	public static String mst(Graph graph) {
		//falta checar se é conectado antes de executar 'connected(graph)'
		
		Graph resultGraph = new Graph();
		
		Map<Integer, Set<Edge>> nodeMap = new HashMap<Integer, Set<Edge>>();
		nodeMap = graph.getNodeMap();
		
		List<ArrayList<Integer>> forest = new ArrayList<ArrayList<Integer>>();
		for (Integer i : nodeMap.keySet()) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.add(i);
			forest.add(temp);
		}
		
		if (!graph.getIsWeighted()) {
			return GraphSearcher.bfs(graph, forest.get(0).get(0));
		}
		
		List<Edge> edges = new ArrayList<Edge>();
		for (Set<Edge> s : nodeMap.values()) {
			for (Edge edge : s) {
				if (!edges.contains(edge)) {
					edges.add(edge);
				}
			}
		}
		
		edges.sort(Edge::compareTo2);
		Edge minWeightEdge;
		
		ArrayList<Edge> forestEdges = new ArrayList<Edge>();
		
		while(!edges.isEmpty()) {
			minWeightEdge = edges.get(0);
			edges.remove(0);
			
			Integer v1 = minWeightEdge.getV1();
			Integer v2 = minWeightEdge.getV2();
			
			ArrayList<Integer> tree1 = null;
			ArrayList<Integer> tree2 = null;
			
			for (int i = 0; i < forest.size(); i++) {
				if (forest.get(i).contains(v1)) {
					tree1 = forest.get(i);
					break;
				}
			}
			
			for (int i = 0; i < forest.size(); i++) {
				if (forest.get(i).contains(v2)) {
					tree2 = forest.get(i);
					break;
				}
			}

			if(!tree1.equals(tree2)) {
				forest.remove(tree1);
				forest.remove(tree2);
				tree1.addAll(tree2);
				forest.add(tree1);
				forestEdges.add(minWeightEdge);
				resultGraph.addEdge(minWeightEdge.getV1(), minWeightEdge);
				resultGraph.addEdge(minWeightEdge.getV2(), minWeightEdge);
			}
		}

		return GraphSearcher.bfs(resultGraph, forest.get(0).get(0));
	}
	
}