package graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphConnectivityTest {

	// grafo pequeno sem peso
	private String file1 = "src/smallGraph1.txt";
	// grafo pequeno com peso positivo
	private String file2 = "src/smallGraph2.txt";
	// grafo pequeno com peso negativo
	private String file3 = "src/smallGraph3.txt";

	// grafo grande sem peso
	private String file4 = "src/bigGraph1.txt";
	// grafo grande com pesos positivos e negativos
	private String file5 = "src/bigGraph2.txt";
	// grafo grande com pesos positivos
	private String file6 = "src/bigGraph3.txt";
	
	// grafo conectado
	private String file7 = "src/graphNotConnected.txt";
	// grafo não conectado
	private String file8 = "src/graphConnected.txt";
	


	private Graph graph1, graph2, graph3, graph4, graph5, graph6;

	@Test
	void isConnected() {
		graph1 = GraphCreator.createGraph(file7);
		graph2 = GraphCreator.createGraph(file8);
		assertEquals(false, GraphConnectivity.isConnected(graph1));
		assertEquals(true, GraphConnectivity.isConnected(graph2));
		
	}

	@Test
	public void testWeightedShortestPath() {

		graph2 = GraphCreator.createGraph(file2);
		graph3 = GraphCreator.createGraph(file3);
		graph5 = GraphCreator.createGraph(file5);
		graph6 = GraphCreator.createGraph(file6);

		// teste Menor caminho em um grafo pequeno com pesos positivos
		String expectedOutput = "1 5 3";
		assertEquals(expectedOutput, GraphConnectivity.getShortestPathWeighted(graph2, 1, 3));

		// teste menor caminho em um grafo pequeno com pesos negativos
		String expectedOutput2 = "O grafo contém um ciclo de pesos negativos.";
		assertEquals(expectedOutput2, GraphConnectivity.getShortestPathWeighted(graph3, 1, 3));

		// teste menor caminho em um grafo grande com pesos positivos e negativos
		String expectedOutput3 = "O grafo contém um ciclo de pesos negativos.";
		assertEquals(expectedOutput3, GraphConnectivity.getShortestPathWeighted(graph5, 1, 11));

		// teste menor caminho em um grafo grande com pesos positivos apenas
		String expectedOutput4 = "1 2 3 10 11";
		assertEquals(expectedOutput4, GraphConnectivity.getShortestPathWeighted(graph6, 1, 11));
	}

	@Test
	public void testUnweightedShortestPath() {
		graph1 = GraphCreator.createGraph(file1);
		graph4 = GraphCreator.createGraph(file4);
		
		//teste menor caminho em um grafo pequeno sem pesos
		String expectedOutput = "1 2 4";
		assertEquals(expectedOutput, GraphConnectivity.getShortestPathUnweighted(graph1, 1, 4));
		
		//teste menor caminho em um grafo grande sem pesos
		String expectedOutput2 = "1 2 3 10 11 12";
		assertEquals(expectedOutput2, GraphConnectivity.getShortestPathUnweighted(graph4, 1, 12));
		
		String expectedOutput3 = "13 8 4 5 11 12";
		assertEquals(expectedOutput3, GraphConnectivity.getShortestPathUnweighted(graph4, 13, 12));
	}
}