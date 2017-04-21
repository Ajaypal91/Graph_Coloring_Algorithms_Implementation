package graphColoringAlgorithms;
import modules.Colors;

import java.util.ArrayList;

import graph.Edge;
import graph.Graph;
import graph.Vertex;

public class GraphColoringBackTracking extends AbstractGraphColoring {

	boolean shuffle = false;
	
	@Override
	public void colorGraph(Graph G) {
		// TODO Auto-generated method stub
		int colorsAvailable = Colors.maximumColorsAvailable();
		
		if(isGraphColorable(G, colorsAvailable)){
			System.out.println("With the available colors the graph was colorable");
		}
		else{
			System.out.println("With the available colors the graph was not colorable");
		}
		
	}

	@Override
	public void printDescription() {
		// TODO Auto-generated method stub
		System.out.println("This is graph coloring implementation using Back Tracking");
	}
	
	public boolean isSafe(ArrayList<Edge> edges){
		
		for (Edge e: edges){
			if (e.getStartVertex().color == e.getEndVertex().color)
				return false;
		}
		return true;
	}
	
	public boolean colorGraphUsingBackTrack(Graph G, ArrayList<Vertex> vertices, int index, int numberOfColors){
		
		//if all vertices are covered
		if (index == vertices.size())
			return true;
		
		for (int i = 0; i < numberOfColors; i++){
			
			//color vertex
			vertices.get(index).color = i;
			
			//check if it safe
			if (this.isSafe(G.getEdgesFromAdj(vertices.get(index)))){
				//color next vertex
				if (colorGraphUsingBackTrack(G, vertices, index+1, numberOfColors))
					return true;
				//if next vertex was not colorable. reset the color and try next one
				vertices.get(index).color = -1; //reset color
			}
		}
		
		return false;
	}
	
	public void toggleShuffle(){
		shuffle = !shuffle;
	}

	@Override
	public boolean isGraphColorable(Graph G, int noOfColors) {
		// TODO Auto-generated method stub
		ArrayList<Vertex> vertices;
		
		if (this.shuffle)
			vertices = this.shuffleVertices(G.getVertices());
		else 
			vertices = G.getVertices();
		
		return this.colorGraphUsingBackTrack(G, vertices, 0, noOfColors);
		
	}

}
