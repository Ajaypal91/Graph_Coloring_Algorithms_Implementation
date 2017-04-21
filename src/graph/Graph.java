package graph;
import java.util.ArrayList;

import graphColoringAlgorithms.GraphColorings;

public interface Graph {
	
	public ArrayList<Vertex> getVertices();
	
	public ArrayList<Edge> getEdges();

	public void getGraphDescription();
	
	public void addNewVertex(Vertex v);
	
	public void addNewEdge(Edge e1);
	
	public void printAllVertexes();
	
	public void printAllEdges();
	
	public void printGraph();

	public ArrayList<Edge> getEdgesFromAdj(Vertex v);
	
	public void setGraphColoringTechnique(GraphColorings GCT);
	
	public void colorGraph();
	
	public void printGraphColoringTechnique();
	
	public void resetColors();

	public int getColorsCardinality();
	
	public void setColorsCardinality(int i);
	
	public boolean isGraphColorable(int numberOfColors);
	
	public GraphColorings getGraphColoringObj();
}
