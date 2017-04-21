package graphColoringAlgorithms;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

import graph.Edge;
import graph.Graph;
import graph.Vertex;
import modules.Colors;

public class GraphColoringGreedyDFS extends AbstractGraphColoring {

	public void printDescription(){
		System.out.println("This is graph coloring implementation using Greedy Algorithm using DFS from a given vertex");
		
	}
	
	public boolean isSafe(ArrayList<Edge> edges){
		
		for (Edge e: edges){
			if (e.getStartVertex().color == e.getEndVertex().color)
				return false;
		}
		return true;
	}
	
	@Override
	public void colorGraph(Graph G) {
		
		//select random vertex as starting vertex
		Vertex v = this.getRandomVertex(G);
		
		System.out.println("Starting Vertex for DFS is = " + v.props.get("value"));
		Stack<Vertex> stk = new Stack<>();
		stk.push(v);
		int n = Colors.maximumColorsAvailable();
		
		while (!stk.isEmpty()){
			
			Vertex i = stk.pop();
			
			ArrayList<Edge> edges = G.getEdgesFromAdj(i);
			
			//add adjacent non visited vertices to stack
			for (Edge e : edges){
				if (e.getEndVertex().color == -1)
					stk.push(e.getEndVertex());
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
	

	public Vertex getRandomVertex(Graph G){
		ArrayList<Vertex> vertices = G.getVertices();
		Random rn = new Random();
		//select random vertex as starting vertex
		return vertices.get(rn.nextInt(vertices.size()));
	}
	
	@Override
	public boolean isGraphColorable(Graph G, int noOfColors){
		boolean status = true;
		
		Vertex v = this.getRandomVertex(G);
		System.out.println("Checking if Graph is colorable using DFS");
		System.out.println("Starting Vertex for DFS is = " + v.props.get("value"));
		Stack<Vertex> stk = new Stack<>();
		stk.push(v);
		int n = Colors.maximumColorsAvailable();
		
		while (!stk.isEmpty()){
			
			Vertex i = stk.pop();
			
			ArrayList<Edge> edges = G.getEdgesFromAdj(i);
			
			//add adjacent non visited vertices to stack
			for (Edge e : edges){
				if (e.getEndVertex().color == -1)
					stk.push(e.getEndVertex());
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