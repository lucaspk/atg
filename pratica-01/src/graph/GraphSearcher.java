package graph;

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
    
    public static void main(String[] args) {
    	String file = "src/sample_graph.txt";
    	
    	Graph g = GraphCreator.createGraph(file);
    	
    	System.out.println(GraphSearcher.dfs(g, 1));
    	
	}

    

}