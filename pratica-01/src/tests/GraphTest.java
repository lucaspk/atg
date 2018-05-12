package tests;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import graph.*;

public class GraphTest {
	
	private String file = "src/sample_graph.txt";
	private String file2 = "src/sample_weighted_graph.txt";
	private Graph g, weightedG;
	
	@Before
	public void setUp() throws IOException {	
		g = GraphCreator.createGraph(file);
		weightedG = GraphCreator.createWeightedGraph(file2);
	}
	
	@Test
	public void testCreateGraph() {			
		String expectedOutput = "[(1-2): 0.0, (2-5): 0.0, (5-3): 0.0, (4-5): 0.0, (1-5): 0.0]";
		
		Assert.assertEquals(expectedOutput, g.toString());
	}

	@Test
	public void testCreateWeightedGraph() {
		String expectedOutput = "[(1-2): 0.1, (2-5): 0.2, (5-3): 5.0, (3-4): -9.5, (4-5): 2.3, (1-5): 1.0]";

		Assert.assertEquals(expectedOutput, weightedG.toString());
	}

	@Test
	public void testAdjacencyList() {
		String expectedOutput = "1 - 2 5\n2 - 1 5\n3 - 5\n4 - 5\n5 - 1 2 3 4";

		Assert.assertEquals(expectedOutput, GraphFormatter.getAdjacencyList(g));
	}

	@Test
	public void testWeightedAdjacencyList() {
		String expectedOutput = "1 - 2(0.1) 5(1)\n2 - 1(0.1) 5(0.2)\n3 - 4(-9.5) 5(5)\n4 - 3(-9.5) 5(2.3)\n5 - 1(1) 2(0.2) 3(5) 4(2.3)";

		Assert.assertEquals(expectedOutput, GraphFormatter.getAdjacencyList(weightedG));
	}

	@Test
	public void testGetVertexNumber() {
		Assert.assertEquals(5, Graph.getVertexNumber(g));
	}

	@Test
	public void testGetEdgeNumber() {
		Assert.assertEquals(5, Graph.getEdgeNumber(g));
	}
	
}
