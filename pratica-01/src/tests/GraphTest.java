package tests;

import java.io.IOException;
import java.util.List;

import org.junit.*;

import graph.*;

public class GraphTest {
	
	private List<String> graph;
	private Graph g;
	
	@Before
	public void setUp() throws IOException {
		String file = "src/sample_graph.txt";
		graph = GraphReader.read(file);
		
		g = Graph.createGraph(graph);
	}

	@Test
	public void testCreateGraph() {
		Assert.assertEquals(5, g.getVertexNumber());
		Assert.assertEquals(5, g.getEdgeNumber());
				
		String expectedOutput = "[(1-2), (2-5), (5-3), (4-5), (1-5)]";
		
		Assert.assertEquals(expectedOutput, g.toString());
	}
}
