package graphColoringAlgorithms;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import graph.Edge;
import graph.Graph;
import graph.Vertex;
import modules.Colors;


public class GraphColoringGreedyBFS extends AbstractGraphColoring {

	public void printDescription(){
		System.out.println("This is graph coloring implementation using Greedy Algorithm using BFS from a given vertex");
		
	}
	
	public boolean isSafe(ArrayList<Edge> edges){
		
		for (Edge e: edges){
			if (e.getStartVertex().color == e.getEndVertex().color)
				return false;
		}
		return true;
	}
	
	public Vertex getRandomVertex(Graph G){
		ArrayList<Vertex> vertices = G.getVertices();
		Random rn = new Random();
		//select random vertex as starting vertex
		return vertices.get(rn.nextInt(vertices.size()));
	}
	
	
	@Override
	public void colorGraph(Graph G) {
		
		Vertex v = this.getRandomVertex(G);
		
		System.out.println("Starting Vertex for BFS is = " + v.props.get("value"));
		Queue<Vertex> queue = new LinkedList<>();
		queue.add(v);
		int n = Colors.maximumColorsAvailable();
		
		while (!queue.isEmpty()){
			
			Vertex i = queue.poll();
			
			ArrayList<Edge> edges = G.getEdgesFromAdj(i);
			
			//add adjacent non visited vertices to stack
			for (Edge e : edges){
				if (e.getEndVertex().color == -1)
					queue.add(e.getEndVertex());
			}
			
			//find color for this vertex i
			for (int j =0; j < n; j++){
				
				i.color = j;
				
				//update colors cardinality of graph
				if (G.getColorsCardinality() < j){
					G.setColorsCardinality(j);
				}
				
				if (this.isSafe(edges)){
					break;
				}
				
			}
			
		}
	}
	
	
	@Override
	public boolean isGraphColorable(Graph G, int noOfColors){
		boolean status = true;
		
		Vertex v = this.getRandomVertex(G);
		System.out.println("Checking if Graph is colorable using BFS");
		System.out.println("Starting Vertex for BFS is = " + v.props.get("value"));
		Queue<Vertex> queue = new LinkedList<>();
		queue.add(v);
		
		while (!queue.isEmpty()){
			
			Vertex i = queue.poll();
			
			ArrayList<Edge> edges = G.getEdgesFromAdj(i);
			
			//add adjacent non visited vertices to queue
			for (Edge e : edges){
				if (e.getEndVertex().color == -1)
					queue.add(e.getEndVertex());
			}
			
			//find color for this vertex i
			for (int j =0; j < noOfColors; j++){
				
				i.color = j;
				
				//update colors cardinality of graph
				if (G.getColorsCardinality() < j){
					G.setColorsCardinality(j);
				}
				
				if (this.isSafe(edges)){
					break;
				}
				
				//if we ran out of colors
				if (j == noOfColors-1){
					status = false;
					v.color = -1; //reset color 
				}
				
			}
			
		}
		
		return status;
	}

}