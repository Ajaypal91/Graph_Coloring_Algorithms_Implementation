package graph;
import java.util.ArrayList;

import graphColoringAlgorithms.GraphColorings;

public abstract class AbstractGraph implements Graph{

	ArrayList<Vertex> vertexes;
	ArrayList<Edge> edges;
	GraphColorings gc;
	int colorsCardinality;
	
	public ArrayList<Vertex> getVertices(){
		return vertexes;
	}
	
	public ArrayList<Edge> getEdges(){
		return edges;
	}
	
	
	public void printVertexAndEdge(Edge e){
		System.out.println("Vertex " + e.getStartVertex().props.get("value") +" --> " + e.getEndVertex().props.get("value"));
	}
		
	public void printAllVertexes(){
		for (Vertex v : vertexes){
			System.out.println(v.props.get("value") + "  ");
		}
	}
	
	public void printAllEdges(){
		for (Edge e : edges){
			System.out.println(e.getStartVertex().props.get("value") + " --> " + e.getEndVertex().props.get("value"));
		}
	}
	
	public void printGraphColoringTechnique(){
		this.gc.printDescription();
	}
	
	public void colorGraph() {
		this.gc.colorGraph(this);
	}
	
	public GraphColorings getGraphColoringObj(){
		return this.gc;
	}
	
	public boolean isGraphColorable(int numberOfColors){
		return this.gc.isGraphColorable(this, numberOfColors);
	}
	
	
	public void resetColors(){
		for (int i = 0; i< vertexes.size(); i++){
			vertexes.get(i).color = -1;
		}
	}
	
	public void setGraphColoringTechnique(GraphColorings GCT) {
		// TODO Auto-generated method stub
		this.gc = GCT;
	}
	
	public int getColorsCardinality(){
		return colorsCardinality;
	}
	
	public void setColorsCardinality(int i){
		colorsCardinality = i;
	}
	
	public abstract void getGraphDescription();
	
	public abstract void addNewVertex(Vertex v);
	
	public abstract void addNewEdge(Edge e1);
	
	public abstract void printGraph();
}
 