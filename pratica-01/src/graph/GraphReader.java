package graph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GraphReader {
    private final static String SAMPLE_GRAPH = "src/sample_graph.txt";
    private final static String SAMPLE_WEIGHTED_GRAPH = "src/sample_weighted_graph.txt";

    private static String fileLine = "";
    	
	public static RawGraph getSampleGraph() {		
		return read(SAMPLE_GRAPH);
	}

	public static RawGraph getSampleWeightedGraph() {
		return read(SAMPLE_WEIGHTED_GRAPH);
	}

    public static RawGraph read(final String graphFilePath) {
        File file = new File(graphFilePath);
        BufferedReader br;
        List<String> graph = new ArrayList<String>();
		try {
            br = new BufferedReader(new FileReader(file));
            while ((fileLine = br.readLine()) != null) {
                graph.add(fileLine);
            }  
            br.close();
		} catch (IOException e) {
			e.printStackTrace();
        }     
                
        return new RawGraph(graph); 
    }
}