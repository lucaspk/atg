package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class GraphSearcher {

    final static String TREE_FORMAT = "%s - %s %s" + System.lineSeparator();

    public static String dfs(final Graph graph, final Integer firstVertex) {
        boolean[] visited = new boolean[graph.getVertexNumber() + 2];

        return dfsAux(graph, firstVertex, null, 0, visited);
    }

    private static String dfsAux(Graph graph, 
                                 Integer firstVertex, 
                                 Integer parent, 
                                 Integer depth, 
                                 boolean[] visited) {

        StringBuilder dfsTree = new StringBuilder();

        visited[firstVertex] = true;

        String treeOutput = String.format(TREE_FORMAT, firstVertex, parent == null ? "-": parent, depth);
        dfsTree.append(treeOutput);
        
        for (Edge edge : graph.getAdjacents(firstVertex)) {
        	Integer v1 = edge.getV1();
        	Integer v2 = edge.getV2();
            Integer vertexInt = v2;
            
            if (visited[v2]) vertexInt = v1;
            
            if (!visited[vertexInt]) {
                dfsTree.append(dfsAux(graph, vertexInt, firstVertex, depth + 1, visited));
            }
        }        
        return dfsTree.toString();
	}    

    public static String bfs(final Graph graph, final Integer firstVertex) {
        
        List<String> test = new ArrayList();

    	boolean[] visited = new boolean[graph.getVertexNumber() + 2];
        
        LinkedList<Integer> queue = new LinkedList<Integer>();

        int level = 0;
        
        visited[firstVertex] = true;
        queue.add(firstVertex);
        
        test.add(firstVertex + " - " + level + " -");

        while (queue.size() != 0) {

        	int head = queue.poll();

            boolean auxVisited = false;
            
            for (Edge edge : graph.getAdjacents(head)) {

            	int adjacent;
            	if (edge.getV1() == head) {
            		adjacent = edge.getV2();
            	} else {
            		adjacent = edge.getV1();
            	}
                
                if (!visited[adjacent]) {
                	if(!auxVisited) { 
                		level += 1;
                		auxVisited = true;
                	}

                    test.add(adjacent + " - " + level + " " + head);
                    
                    visited[adjacent] = true;
                    queue.add(adjacent);
                }
            }
        }
        Collections.sort(test);
        return DFSFormattedResult(test);
    }
    
    private static String DFSFormattedResult(List<String> array) {
    	String result = array.get(0);
    	for (int i = 1; i < array.size(); i++) {
			result += "\n" + array.get(i);
		}
    	return result;
    }
}