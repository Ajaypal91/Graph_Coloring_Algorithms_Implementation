package Main;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import graph.*;
import graphColoringAlgorithms.*;
import modules.Colors;

public class OnlineStart {

	public static void main(String[] args) {
		
		String path = "src/Files/sample1";
		streamFileAndUpdateGraph(path);
		
	}
	
	public static void streamFileAndUpdateGraph(String filename){
		
		
		File initialFile = new File(filename);
		long lengthBefore = 0;
		long length = 0;
		boolean proceed = true;
		Graph G = new GraphAdjListImpl();
		G.setGraphColoringTechnique(new OnlineGraphColoringFirstFit());
		//OnlineGraphColoringFirstFit ogc = new OnlineGraphColoringFirstFit();
		
		String vertexProperty = "value";
		
		while(proceed){
			
			RandomAccessFile reader = null;
			try{
				
				if((length = initialFile.length()) > lengthBefore){
					
					try{
						reader = new RandomAccessFile(initialFile, "r");
						reader.seek(lengthBefore);
						lengthBefore = length;
						int c = 0;
						int counter = 0;
						Vertex v1;
						Vertex v2;
						Edge e1;
						String v1Val = "", v2Val = ""; 
						while ( (c = reader.read()) != -1 ){
							
							if (c != 32 && c!= 10){
								if (counter == 0){
									v1Val = Character.toString((char)c);
									v1 = new Vertex();
									v1.addProp(vertexProperty, v1Val);
									G.addNewVertex(v1);
									//System.out.println(e);
								}
								if (counter == 2){
									v2Val = Character.toString((char)c);
									v2 = new Vertex();
									v2.addProp(vertexProperty, v2Val);
									G.addNewVertex(v2);
								}
								
							}
							if (c!=10)
								counter++;
							//add edge to graph and color it
							if (counter == 3){
								counter = -1;
								e1 = new Edge(G.getVertex(v1Val), G.getVertex(v2Val));
								G.addNewEdge(e1);
								G.colorGraph();
								Colors.printColors(G);
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
