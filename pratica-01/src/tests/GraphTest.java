package tests;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import graph.*;

public class GraphTest {
	
	private String file = "src/sample_graph.txt";
	private String file2 = "src/sample_weighted_graph.txt";
	private String file3 = "src/sample_weighted_graph2.txt";
	private Graph g, weightedG, weightedG2;
	
	@Before
	public void setUp() throws IOException {	
		g = GraphCreator.createGraph(file);
		weightedG = GraphCreator.createGraph(file2);
		weightedG2 = GraphCreator.createGraph(file3);
	}

	@Test
	public void testAdjacencyList() {
		String expectedOutput = "1 - 2 5\n2 - 1 5\n3 - 5\n4 - 5\n5 - 1 2 3 4";

		Assert.assertEquals(expectedOutput, GraphFormatter.getAdjacencyList(g));
	}

	@Test
	public void testAdjacencyMatrix() {
		String expectedOutput = "  1 2 3 4 5\n1 0 1 0 0 1\n2 1 0 0 0 1\n3 0 0 0 0 1\n4 0 0 0 0 1\n5 1 1 1 1 0";

		Assert.assertEquals(expectedOutput, GraphFormatter.getAdjacencyMatrix(g));
	}

	@Test
	public void testWeightedAdjacencyList() {
		String expectedOutput = "1 - 2(0,1) 5(1)\n2 - 1(0,1) 5(0,2)\n3 - 4(-9,5) 5(5)\n4 - 3(-9,5) 5(2,3)\n5 - 1(1) 2(0,2) 3(5) 4(2,3)";

		Assert.assertEquals(expectedOutput, GraphFormatter.getAdjacencyList(weightedG));
	}

	@Test
	public void testWeightedAdjacencyMatrix() {
		String expectedOutput = "  1 2 3 4 5\n1 0 0,1 0 0 1\n2 0,1 0 0 0 0,2\n3 0 0 0 -9,5 5\n4 0 0 -9,5 0 2,3\n5 1 0,2 5 2,3 0";

		Assert.assertEquals(expectedOutput, GraphFormatter.getAdjacencyMatrix(weightedG));
	}

	@Test
	public void testWeightedShortestPathWithNegativeCicle() {
		String expectedOutput = "O grafo contém um ciclo de pesos negativos.";

		Assert.assertEquals(expectedOutput, weightedG.getShortestPath(1, 5));
	}

	@Test
	public void testWeightedShortestPath() {
		String expectedOutput = "1 2 5";

		Assert.assertEquals(expectedOutput, weightedG2.getShortestPath(1, 5));
	}

	@Test
	public void testUnweightedShortestPath() {
		String expectedOutput = "1 5";

		Assert.assertEquals(expectedOutput, g.getShortestPath(1, 5));
	}

	@Test
	public void testGetVertexNumber() {
		Assert.assertEquals(5, g.getVertexNumber());
	}

	@Test
	public void testGetEdgeNumber() {
		Assert.assertEquals(5, g.getEdgeNumber());
	}
	
	@Test
	public void testBFS() {
		System.out.println(GraphSearcher.bfs(g, 1));
	}
	
	@Test
	public void testDFS() {
		System.out.println(GraphSearcher.dfs(g, 1));
	}

	@Test
	public void testConnectivity(){
		Assert.assertEquals(true, GraphConnectivity.isConnected(g));
		Assert.assertEquals(true, GraphConnectivity.isConnected(weightedG));
		Assert.assertEquals(true, GraphConnectivity.isConnected(weightedG2));
	}
}
