import java.util.ArrayList;

public interface GraphColorings {

	public void colorGraph(Graph G);
	
	public void printDescription();
	
	public boolean isGraphColorable(Graph G, int noOfColors);
	
	public ArrayList<Vertex> shuffleVertices(ArrayList<Vertex> vertices);
	
	public void toggleShuffle();
}
