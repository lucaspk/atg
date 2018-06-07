package graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;

class GraphFormatterTest {
	
	// grafo pequeno sem peso
	private String file1 = "src/smallGraph1.txt";
	// grafo pequeno com peso positivo
	private String file2 = "src/smallGraph2.txt";
	// grafo pequeno com peso negativo
	private String file3 = "src/smallGraph3.txt";
	
	// grafo grande sem peso
	private String file4 = "src/graphNotConnected.txt";


	private Graph graph1, graph2, graph3, graph4, graph5, graph6;

	@BeforeEach
	public void setUp() throws IOException {
		graph1 = GraphCreator.createGraph(file1);
		graph2 = GraphCreator.createGraph(file2);
		graph3 = GraphCreator.createGraph(file3);
		graph4 = GraphCreator.createGraph(file4);

	}
	
    @Test
    void getAdjacencyList() {
		String expectedOutput2 = "1 - 4(0,1) 5(0,3)\n2 - 3(8)\n3 - 2(8) 4(1) 5(0,1)\n4 - 1(0,1) 3(1) 5(1)\n5 - 1(0,3) 3(0,1) 4(1)\n";
		assertEquals(expectedOutput2, GraphFormatter.getAdjacencyList(graph2));
		String expectedOutput3 = "1 - 4(0,1) 5(0,3)\n2 - 3(8) 4(-1)\n3 - 2(8) 4(1) 5(0,1)\n4 - 1(0,1) 2(-1) 3(1) 5(-2)5 - 1(0,3) 3(0,1) 4(-2)\n";
		assertEquals(expectedOutput3, GraphFormatter.getAdjacencyList(graph3));
		String expectedOutput4 = "1 - 2\n2 - 1 3 4\n3 - 2 4\n4 - 2 3 5\n5 - 4\n6 - 6\n";
		assertEquals(expectedOutput4, GraphFormatter.getAdjacencyList(graph4));
		String expectedOutput1 = "1 - 2 3\n2 - 1 3 4\n3 - 1 2\n4 - 2";
		assertEquals(expectedOutput1, GraphFormatter.getAdjacencyList(graph1));
    }

    @Test
    void getAdjacencyMatrix() {
		String expectedOutput2 = "  1 2 3 4 5\n1 0 0 0 0,1 0,3\n2 0 0 8 0 0\n3 0 8 0 1 0,1\n4 0,1 0 1 0 1\n5 0,3 0 0,1 1 0";
		assertEquals(expectedOutput2, GraphFormatter.getAdjacencyMatrix(graph2));
		String expectedOutput3 = "  1 2 3 4 5\n1 0 0 0 0,1 0,3\n2 0 0 8 -1 0\n3 0 8 0 1 0,1\n4 0,1 -1 1 0 -2\n5 0,3 0 0,1 -2 0";
		assertEquals(expectedOutput3, GraphFormatter.getAdjacencyMatrix(graph3));
		String expectedOutput4 = "  1 2 3 4 5 6\n1 0 1 0 0 0 0\n2 1 0 1 1 0 0\n3 0 1 0 1 0 0\n4 0 1 1 0 1 0\n5 0 0 0 1 0 0\n6 1 1 1 1 1 1";
		assertEquals(expectedOutput4, GraphFormatter.getAdjacencyMatrix(graph4));
		String expectedOutput1 = "  1 2 3 4\n1 0 1 1 0\n2 1 0 1 1\n3 1 1 0 0\n4 0 1 0 0";
		assertEquals(expectedOutput1, GraphFormatter.getAdjacencyMatrix(graph1));
    }
}