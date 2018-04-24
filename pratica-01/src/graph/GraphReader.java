package graph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GraphReader {
    private final static String SAMPLE_GRAPH = "src/sample_graph.txt";
    
    private static String fileLine = "";
    	
	public static RawGraph getSampleGraph() throws IOException {		
		return read(SAMPLE_GRAPH);
	}
	    
    public static RawGraph read(final String graphFilePath) throws IOException {
        File file = new File(graphFilePath);
        BufferedReader br = new BufferedReader(new FileReader(file));
        
        List<String> graph = new ArrayList<String>();
        while ((fileLine = br.readLine()) != null) {
            graph.add(fileLine);
        }  
        br.close();
        
        return new RawGraph(graph);  

    }      
}