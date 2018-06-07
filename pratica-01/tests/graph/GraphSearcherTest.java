package graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphSearcherTest {

    //grafo exemplo
    private String file1 = "src/smallGraph1.txt";
    private String file2 = "src/graphNotConnected.txt";
    
    private Graph graph1, graph2;

    @Test
    void dfs() {
        Edge e1 = new Edge(1,2);
        Edge e2 = new Edge(2,3);
        Edge e3 = new Edge(2,6);
        Edge e4 = new Edge(4,2);
        Edge e5 = new Edge(4,6);
        Edge e6 = new Edge(6,5);
        Edge e7 = new Edge(6,7);

        Graph graph = new Graph();

        graph.addEdge(1, e1);
        graph.addEdge(3, e2);
        graph.addEdge(5, e6);
        graph.addEdge(7, e7);
        graph.addEdge(4, e4);
        graph.addEdge(4, e5);
        graph.addEdge(2, e1);
        graph.addEdge(2, e2);
        graph.addEdge(2, e3);
        graph.addEdge(6, e6);
        graph.addEdge(6, e7);


        String output = GraphSearcher.dfs(graph, 4);

        String expected = "4 - - 0" + System.getProperty("line.separator")
                + "2 - 4 1" + System.getProperty("line.separator")
                + "1 - 2 2" + System.getProperty("line.separator")
                + "3 - 2 2" + System.getProperty("line.separator")
                + "6 - 4 1" + System.getProperty("line.separator")
                + "5 - 6 2" + System.getProperty("line.separator")
                + "7 - 6 2" + System.getProperty("line.separator");

        assertEquals(expected, output);
    }

    @Test
    void bfs() {
        graph1 = GraphCreator.createGraph(file1);
        graph2 = GraphCreator.createGraph(file2);

        // busca de um grafo normal a partir do primeiro vertice
        String expected1 = "1 - 0 -\n"
                + "2 - 1 1\n"
                + "3 - 1 1\n"
                + "4 - 2 2";
        String output1 = GraphSearcher.bfs(graph1, 1);
        assertEquals(expected1,output1);

        // busca a partir de um vertice desconectado
        String expected2 = "6 - 0 -";
        String output2 = GraphSearcher.bfs(graph2, 6);
        assertEquals(expected2,output2);

        // busca de um grafo desconectado
        String expected3 = "1 - 0 -\n"
                + "2 - 1 1\n"
                + "3 - 2 2\n"
                + "4 - 2 2\n"
                + "5 - 3 4";
        String output3 = GraphSearcher.bfs(graph2, 1);
        assertEquals(expected3,output3);

        // iniciando a busca a partir de um vertice inexistente
        String expected4 = "5 - 0 -";
        String output4 = GraphSearcher.bfs(graph1, 5);
        assertEquals(expected4,output4);
    }
}