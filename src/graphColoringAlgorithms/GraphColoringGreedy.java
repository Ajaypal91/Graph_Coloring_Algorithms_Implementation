package graphColoringAlgorithms;
import java.util.ArrayList;

import graph.Edge;
import graph.Graph;
import graph.Vertex;
import modules.Colors;


public class GraphColoringGreedy extends AbstractGraphColoring {
	
	boolean shuffle = false;

	public void printDescription(){
		System.out.println("This is graph coloring implementation using Greedy Algorithm with random vertexes");
		
	}
	
	public boolean isSafe(ArrayList<Edge> edges){
		
		for (Edge e: edges){
			if (e.getStartVertex().color == e.getEndVertex().color)
				return false;
		}
		return true;
	}
	
	
	public void toggleShuffle(){
		shuffle = !shuffle;
	}
	
	@Override
	public void colorGraph(Graph G) {
		
		int n = Colors.maximumColorsAvailable();
		
		ArrayList<Vertex> vertices;
		if (this.shuffle)
			vertices = this.shuffleVertices(G.getVertices());
		else 
			vertices = G.getVertices();
		
		boolean status = false;
		
		for (Vertex v: vertices){
			
			ArrayList<Edge> edges = G.getEdgesFromAdj(v);
			status = false;
			
			for (int i = 0; i < n; i++){
				
				v.color = i;
				//update colors cardinality of graph
				if (G.getColorsCardinality() < i){
					G.setColorsCardinality(i);
				}
				
				if (this.isSafe(edges)){
					status = true;
					break;	
				}
				
			}
			
			//if could not find any color
			if(!status){
				v.color = -1; 
			}
		}
		
	}
	
	@Override
	public boolean isGraphColorable(Graph G, int noOfColors){
		boolean status = true;
		
		ArrayList<Vertex> vertices = G.getVertices();
		
		for (Vertex v: vertices){
			
			ArrayList<Edge> edges = G.getEdgesFromAdj(v);
			
			for (int i = 0; i < noOfColors; i++){
				
				v.color = i;
				
				//update colors cardinality of graph
				if (G.getColorsCardinality() < i){
					G.setColorsCardinality(i);
				}
				
				if (this.isSafe(edges)){
					break;	
				}
				
				//if we ran out of colors
				if (i == noOfColors-1){
					status = false;
					v.color = -1; //reset color 
				}
					
				
			}
			
		}
		
		return status;
	}
	
	public void colorNewVertex(Graph G, Vertex v, Edge e){
		
	}

}
