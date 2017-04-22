package graphColoringAlgorithms;

import java.util.ArrayList;

import graph.Edge;
import graph.Graph;
import graph.Vertex;
import modules.Colors;

public class OnlineGraphColoringFirstFit extends AbstractGraphColoring{

	public boolean isSafe(ArrayList<Edge> edges){
		
		for (Edge e: edges){
			if (e.getStartVertex().color == e.getEndVertex().color)
				return false;
		}
		return true;
	}
	
	@Override
	public void colorGraph(Graph G) {
		
		//get the second last added edge to the graph. // because two edges are added for undirected edge in graph
		Edge e = G.getEdges().get(G.getEdges().size()-2);
		
		Vertex start = e.getStartVertex();
		Vertex end = e.getEndVertex();
		ArrayList<Edge> edgesStart = G.getEdgesFromAdj(start);
		ArrayList<Edge> edgesEnd = G.getEdgesFromAdj(end);
		
		//does adding new edge created conflict in present colors
		if (!isSafe(edgesStart) || start.color == -1){
			for (int c = 0; c < Colors.maximumColorsAvailable(); c++){
				start.color = c;
				
				if (isSafe(edgesStart)){
					break;
				}
				
			}
		}
		
		//does adding new edge created conflict in present colors
		if (!isSafe(edgesEnd) || end.color == -1){
			for (int c = 0; c < Colors.maximumColorsAvailable(); c++){
				end.color = c;
				
				if (isSafe(edgesEnd)){
					break;
				}
				
			}
		}
		
		
	}

	public void printDescription() {
		System.out.println("This is online graph coloring implementation using first fit algorithm");
	}


	@Override
	public boolean isGraphColorable(Graph G, int noOfColors) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
