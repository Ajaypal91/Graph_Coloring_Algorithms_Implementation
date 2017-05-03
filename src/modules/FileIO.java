package modules;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

import graph.Edge;
import graph.Graph;
import graph.GraphAdjListImpl;
import graph.Vertex;

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
	
	public static Graph readDataAndCreateGraphFromEdges(String filename, Graph G){
		
		String vertexProperty = "value";
		
		ArrayList<Vertex> vList = new ArrayList<>();
		HashMap<String, Integer> vertexes = new HashMap<>();
		
		 File initialFile = new File(filename);
		 String line = "";
		 int lineNumber = -1;
		 try {
		 
			 BufferedReader reader = new BufferedReader(new FileReader(initialFile));
			 line = reader.readLine();
			 lineNumber++;
			 while (line != null){
				 
				 //add vertexes
				
				 String[] edgs = line.split(" ");
				 String v1 = edgs[0];
				 String v2 = edgs[1];
				 
				 if (!vertexes.containsKey(v1)) {
					 Vertex v = new Vertex();
					 v.addProp(vertexProperty, v1.trim());
					 vList.add(v);
					 G.addNewVertex(v);
					 vertexes.put(v1, vList.size()-1);
				 }
				 if (!vertexes.containsKey(v2)) {
					 Vertex v = new Vertex();
					 v.addProp(vertexProperty, v2.trim());
					 vList.add(v);
					 G.addNewVertex(v);
					 vertexes.put(v2, vList.size()-1);
				 }
				 
				 Edge e = new Edge();
				 
				 Vertex first = vList.get(vertexes.get(v1));
				 Vertex second = vList.get(vertexes.get(v2));
				 e.setStartVertex(first);
				 e.setEndVertex(second);
				 G.addNewEdge(e);
				 line = reader.readLine();
				 lineNumber++;
//				 System.out.println(lineNumber);
			 }
			
			 reader.close();
		 
		 }
		 catch (Exception ex){
			 System.out.println(ex.getMessage());
		 }
		 
		//return graph
		return G;
}
	
	public static Graph readSudokuAndCreateGraph(String filename, Graph G){
	
		String vertexProperty = "value";
		
		//ArrayList<Vertex> vList = new ArrayList<>();
		int[][] sudokuPuzzle = new int[9][9];
		//for the location and clues that we have in sudoku
		HashMap<Integer, Vertex> vertices = new HashMap<>();
	
		 File initialFile = new File(filename);
		 String line = "";
		 int count = 0, col = 0;
		 try {
		 
			 BufferedReader reader = new BufferedReader(new FileReader(initialFile));
			 line = reader.readLine();
			 
			 while (line != null){
			 	 while (col != 9){
					 if (line.charAt(col) == '.'){
				 		 Vertex v = new Vertex();
				 		 int c = count%9;
				 		 int r = count/9;
				 		 sudokuPuzzle[r][c] = -1;
				 	 }
				 	 else{
				 		 int c = count%9;
				 		 int r = count/9;
				 		 sudokuPuzzle[r][c] = Character.getNumericValue(line.charAt(col));
				 	 }
				 	 count++; col++;
				 }
			 	 if (col == 9)
			 		 col = 0;
			 	 line = reader.readLine();
			 }
			 
			 reader.close();
			 
//			 for (int i=0;i<9 ; i++){
//				 for (int j=0;j<9 ; j++){
//					 System.out.print(sudokuPuzzle[i][j] + " ");
//				 }
//				 System.out.println();
//			 }
			 
			 //create vertices
			 for (int i = 0; i< 9; i++){
				 int row = i*9;
				 for (int j = 0; j<9;j++){
					  Vertex v = new Vertex();
					  count = row + j;
					  v.addProp(vertexProperty, String.valueOf(count));
					  v.color = sudokuPuzzle[i][j];
					  if (sudokuPuzzle[i][j] != -1)
						  v.addProp("fixed", "1");
					  else 
						  v.addProp("fixed", "0");
					  vertices.put(count, v);
					  G.addNewVertex(v);
				 }
			 }
			 
			 //add row vice edges
			 for(int row = 0; row<9;row++){
				 for (int i = 0; i< 9; i++){
					 for (int j = i+1; j<9;j++){
						  int ind1 = row*9+i;
						  int ind2 = row*9+j;
						  Edge e = new Edge();
						  e.setStartVertex(vertices.get(ind1));
						  e.setEndVertex(vertices.get(ind2));
						  G.addNewEdge(e);
					 }
				 }
			 }
			 
			
			//add col vice edges
			 for (int i = 0; i< 9; i++){
				 for (int j = 0; j<9;j++){
					 for(col = j+1; col<9;col++){
						  int ind1 = j*9+i;
						  int ind2 = col*9+i;
						  Edge e = new Edge();
						  e.setStartVertex(vertices.get(ind1));
						  e.setEndVertex(vertices.get(ind2));
						  G.addNewEdge(e);
					 }
				 }
			 }
			 
			 
//			 //for the 3*3 box
			 for (int row = 0; row < 9; row+=3){
				 for(col = 0; col <9; col+=3){
					 
					 ArrayList<Integer> pos = new ArrayList<>();
					 int start = row*9+col;
					 pos.add((row+1)*9+col+1);
					 pos.add((row+1)*9+col+2);
					 pos.add((row+2)*9+col+1);
					 pos.add((row+2)*9+col+2);
					 
					 addEdgesToGraph(G, start, pos, vertices);
					 
					 start = row*9+col+1;
					 pos.clear();
					 pos.add((row+1)*9+col);
					 pos.add((row+1)*9+col+2);
					 pos.add((row+2)*9+col);
					 pos.add((row+2)*9+col+2);
					 
					 addEdgesToGraph(G, start, pos, vertices);
					 
					 start = row*9+col+2;
					 pos.clear();
					 pos.add((row+1)*9+col);
					 pos.add((row+1)*9+col+1);
					 pos.add((row+2)*9+col);
					 pos.add((row+2)*9+col+1);
					 
					 addEdgesToGraph(G, start, pos, vertices);
					 
					 start = (row+1)*9+col;
					 pos.clear();
					 pos.add((row+2)*9+col+1);
					 pos.add((row+2)*9+col+2);
					 
					 addEdgesToGraph(G, start, pos, vertices);
					 
					 start = (row+1)*9+col+1;
					 pos.clear();
					 pos.add((row+2)*9+col);
					 pos.add((row+2)*9+col+2);
					 
					 addEdgesToGraph(G, start, pos, vertices);
					 
					 start = (row+1)*9+col+2;
					 pos.clear();
					 pos.add((row+2)*9+col);
					 pos.add((row+2)*9+col+1);
					 
					 addEdgesToGraph(G, start, pos, vertices);
				 }
			 }
			 
			 
			 
			 
		 }
		 catch (Exception ex){
			 System.out.println(ex.getMessage());
		 }
		
		
		return G;
	}
	
	public static void addEdgesToGraph(Graph G, int startPosition, ArrayList<Integer> pos, HashMap<Integer, Vertex> vertices){
		
		for (int i: pos){
			Edge e =  new Edge();
		    e.setStartVertex(vertices.get(startPosition));
		    e.setEndVertex(vertices.get(i));
		    G.addNewEdge(e);
		}
				
	}
	
}
