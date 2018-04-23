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
    
	private static List<String> graph = new ArrayList<String>();
	
	public static List<String> getSampleGraph() throws IOException {		
		return read(SAMPLE_GRAPH);
	}
	
    public static List<String> read(final String graphFilePath) throws IOException {
        File file = new File(graphFilePath);
        BufferedReader br = new BufferedReader(new FileReader(file));
        
        while ((fileLine = br.readLine()) != null) {
            graph.add(fileLine);
        }  
        br.close();
  
        return graph;
    }            
}