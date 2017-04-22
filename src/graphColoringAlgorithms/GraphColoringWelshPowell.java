package graphColoringAlgorithms;
import java.util.ArrayList;
import java.util.Collections;

import graph.Edge;
import graph.Graph;
import graph.Vertex;
import modules.Colors;

public class GraphColoringWelshPowell extends AbstractGraphColoring
{
	boolean shuffle = false;

	public void printDescription(){
		System.out.println("This is graph coloring implementation using Welsh Powell algorithm");
		
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
	
	public ArrayList<Vertex> getVerticesAccToDegrees(Graph G){

		ArrayList<Vertex> vertices;
		vertices = G.getVertices();
		
		int noofVertices =  vertices.size();
		int d[]=new int[noofVertices];
		ArrayList<Edge> edges2;
		for(int i=0;i<noofVertices;i++)
		{
			edges2 = G.getEdgesFromAdj(vertices.get(i));
			d[i]=edges2.size();
						
		}
		int temp=0;
		
		for(int i=0;i<noofVertices;i++)
		{
			for(int j=1;j<noofVertices-i;j++)
			{
				if(d[j-1]<d[j])
				{
					temp = d[j-1];
					d[j-1] = d[j];
					d[j]=temp;
					Collections.swap(vertices, j-1, j);
				
				}
			}
		}
		return vertices;
	}
	
	@Override
	public void colorGraph(Graph G) {
		
		ArrayList<Vertex> vertices = getVerticesAccToDegrees(G);
		int n = Colors.maximumColorsAvailable();
		
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
		
		ArrayList<Vertex> vertices = getVerticesAccToDegrees(G);
		
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
	
}
