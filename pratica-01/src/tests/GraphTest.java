package tests;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import graph.*;

public class GraphTest {
	
	private String file = "src/sample_graph.txt";
	private RawGraph rawGraph;
	private Graph g;
	
	@Before
	public void setUp() throws IOException {
		rawGraph = GraphReader.read(file);	
		g = GraphCreator.createGraph(rawGraph);
	}
	
	@Test
	public void testCreateRawGraph() {
		Assert.assertEquals(5, rawGraph.getNumEdges());
		Assert.assertEquals(5, rawGraph.getVertexNumber());
	}
	
	@Test
	public void testCreateGraph() {
		g = GraphCreator.createGraph(rawGraph);
		
		Assert.assertEquals(5, g.getVertexNumber());
		Assert.assertEquals(5, g.getEdgeNumber());
				
		String expectedOutput = "[(1-2), (2-5), (5-3), (4-5), (1-5)]";
		
		Assert.assertEquals(expectedOutput, g.toString());
	}
	
}
