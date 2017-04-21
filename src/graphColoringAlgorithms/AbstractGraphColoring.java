package graphColoringAlgorithms;
import java.util.ArrayList;
import java.util.Random;

import graph.Graph;
import graph.Vertex;

public abstract class AbstractGraphColoring implements GraphColorings{

	boolean shuffle = false;
	
	public void toggleShuffle(){
		shuffle = !shuffle;
	}
	
	public ArrayList<Vertex> shuffleVertices(ArrayList<Vertex> vertices){
		int n = vertices.size();
		Random rn = new Random();
		while(n > 1){
			Vertex x = vertices.get(n-1);
			int ind = rn.nextInt(n-1);
			vertices.set(n-1, vertices.get(ind));
			vertices.set(ind, x);
			n--;
		}
		return vertices;
	}
	
	@Override
	public abstract void colorGraph(Graph G);

	@Override
	public abstract void printDescription(); 

	@Override
	public abstract boolean isGraphColorable(Graph G, int noOfColors);

}
