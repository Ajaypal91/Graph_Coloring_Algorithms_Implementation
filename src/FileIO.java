import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Objects;

public class FileIO {

	//return numberofVertices for adjacency Matrix and 0 for adjList graph implementation
	public static int GraphToCreate(String filename){
		
		int numberOfvertexes = 0, numberOfEdges = 0;
		
		File initialFile = new File(filename);
		String line = "";
		int lineNumber = -1;
		
		try {
			 
			 BufferedReader reader = new BufferedReader(new FileReader(initialFile));
			 line = reader.readLine();
			 lineNumber++;
			 while (line != null){
				 
				 //add vertexes
				 if (lineNumber == 0) { //first line 
					numberOfvertexes = Integer.parseInt(line);
					for (int i = 0; i < numberOfvertexes; i++){
						line = reader.readLine();
						lineNumber++;
					}
				 }
				 //add edges
				 else{
					 numberOfEdges++;
					 line = reader.readLine();
					 lineNumber++;
				 }
				 
			 }
			 reader.close();
		 
		 }
		 catch (Exception ex){
			 System.out.println(ex.getMessage());
		 }
		
		//check if it a complete graph or almost a complete graph. The graph with adj matrix is preferred
		int threashold = 1;
		if (2*numberOfEdges > (numberOfvertexes*(numberOfvertexes-1) - threashold))
			return numberOfvertexes;
		else
			return 0;
		
	}
	
	public static Graph readDataAndCreateGraph(String filename, Graph G){
			
			String vertexProperty = "value";
			
			ArrayList<Vertex> vList = new ArrayList<>();
			
			 File initialFile = new File(filename);
			 String line = "";
			 int lineNumber = -1;
			 try {
			 
				 BufferedReader reader = new BufferedReader(new FileReader(initialFile));
				 line = reader.readLine();
				 lineNumber++;
				 while (line != null){
					 
					 //add vertexes
					 if (lineNumber == 0) { //first line 
						int vertexes = Integer.parseInt(line);
						while (vertexes > 0){
							line = reader.readLine();
							lineNumber++;
							Vertex v = new Vertex();
							v.addProp(vertexProperty, line.trim());
							vList.add(v);
							G.addNewVertex(v);
							vertexes--;
						}
						line = reader.readLine();
						lineNumber++;
					 }
					 //add edges
					 else{
						 String[] edgs = line.split(" ");
						 String v1 = edgs[0];
						 String v2 = edgs[1];
						 Edge e = new Edge();
						 
						 for (int i = 0; i < vList.size(); i++){
							 if (Objects.equals(vList.get(i).props.get(vertexProperty),v1)){
								 e.setStartVertex(vList.get(i));
							 }
							 if (Objects.equals(vList.get(i).props.get(vertexProperty),v2)){
								 e.setEndVertex(vList.get(i));
							 }	
						 }
						 G.addNewEdge(e);
						 line = reader.readLine();
						 lineNumber++;
					 }
					 
				 }
				 reader.close();
			 
			 }
			 catch (Exception ex){
				 System.out.println(ex.getMessage());
			 }
			 
			//return graph
			return G;
	}
	
	public static void streamFileAndUpdateGraph(String filename){
		
		
		File initialFile = new File(filename);
		long lengthBefore = 0;
		long length = 0;
		boolean proceed = true;
		while(proceed){
			
		RandomAccessFile reader = null;
		try{
			
			if((length = initialFile.length()) > lengthBefore){
				
				try{
					reader = new RandomAccessFile(initialFile, "r");
					reader.seek(lengthBefore);
					lengthBefore = length;
					int c = 0;
					while ( (c = reader.read()) != -1 ){
						if (c != 10){
							char p = (char)c;
							System.out.println(p+ " ");
						}
					}
					
				}
				catch(Exception e){
					
				}
				Thread.sleep(2000);
			}
			
			
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		try{
			if (reader != null){
				reader.close();
			}
		}
		catch(IOException exi){
			
		}
		}
	}
	
}
