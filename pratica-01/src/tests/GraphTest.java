package tests;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import graph.*;

public class GraphTest {
	
	private String file = "src/sample_graph.txt";
	private Graph g;
	
	@Before
	public void setUp() throws IOException {	
		g = GraphCreator.createGraph(file);
	}
	
	@Test
	public void testCreateGraph() {			
		String expectedOutput = "[(1-2), (2-5), (5-3), (4-5), (1-5)]";
		
		Assert.assertEquals(expectedOutput, g.toString());
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
