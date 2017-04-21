package graphColoringAlgorithms;

import java.util.ArrayList;
import java.util.Random;

import graph.Vertex;
import modules.Colors;
import graph.Edge;
import graph.Graph;

public class RandomGraphColoring extends AbstractGraphColoring {

	boolean shuffle = false;
	
	public void toggleShuffle(){
		shuffle = !shuffle;
	}
	
	@Override
	public void colorGraph(Graph G) {

		ArrayList<Vertex> vertices;
		
		if (shuffle)
			vertices = shuffleVertices(G.getVertices());
		else 
			vertices = G.getVertices();
		
		int start = 0;
		int iterations = (vertices.size() - start)/2;
		
		//color the first vertex
		vertices.get(start).color = 0;
		start++;
		int n = vertices.size();
		
		while (start < n){
			//Assuming iterations to be half of the vertices left to co*lor
			colorBestRandomVertexAtPosition(G, vertices,start, iterations, Colors.maximumColorsAvailable());
			start++;
			iterations = (vertices.size() + 1 - start)/2;
		}
		
	}
	
	public boolean isSafe(ArrayList<Edge> edges){
		
		for (Edge e: edges){
			if (e.getStartVertex().color == e.getEndVertex().color)
				return false;
		}
		return true;
	}
	
	public void colorBestRandomVertexAtPosition(Graph G, ArrayList<Vertex> vertices,int start, int iterations, int numberOfColors){
		
		int bestIndexSoFar = start;
		int bestColorSoFar = Integer.MAX_VALUE;
		Random rn = new Random();
		int n = vertices.size();
		
		for (int i = 0; i < iterations; i++){
			
			int ind = start  + rn.nextInt(n - start);
			
			for (int c = 0; c < numberOfColors; c++){
				
				vertices.get(ind).color = c;
				
				if (isSafe(G.getEdgesFromAdj(vertices.get(ind)))){
					
					if (bestColorSoFar > c) {
						bestIndexSoFar = ind;
						bestColorSoFar = c;
					}
					break;
				}
				vertices.get(ind).color = -1; //reset color
				
			}
			
		}
		
		//set color for the best vertex found
		if (bestColorSoFar != Integer.MAX_VALUE)
			vertices.get(bestIndexSoFar).color = bestColorSoFar;
		
		//update colors cardinality of graph
		if (G.getColorsCardinality() < bestColorSoFar){
			G.setColorsCardinality(bestColorSoFar);
		}
		
		//swap the best index to start position.
		if (bestIndexSoFar != start){
			Vertex temp = vertices.get(bestIndexSoFar);
			vertices.set(bestIndexSoFar, vertices.get(start));
			vertices.set(start, temp);
		}
		
		
	}
	
	@Override
	public void printDescription() {
		// TODO Auto-generated method stub
		System.out.println("This is graph coloring implementation using Random selection of best vertices after k try");
	}

	@Override
	public boolean isGraphColorable(Graph G, int noOfColors) {
		
		ArrayList<Vertex> vertices;
		
		if (shuffle)
			vertices = shuffleVertices(G.getVertices());
		else 
			vertices = G.getVertices();
		
		int start = 0;
		int iterations = (vertices.size() - start)/2;
		
		//color the first vertex
		vertices.get(start).color = 0;
		start++;
		int n = vertices.size();
		
		while (start < n){
			//Assuming iterations to be half of the vertices left to co*lor
			colorBestRandomVertexAtPosition(G, vertices,start, iterations, noOfColors);
			start++;
			iterations = (vertices.size() + 1 - start)/2;
		}
		
		for (Vertex v: vertices){
			if (v.color == -1)
				return false;
		}
		
		return true;
	}

}
