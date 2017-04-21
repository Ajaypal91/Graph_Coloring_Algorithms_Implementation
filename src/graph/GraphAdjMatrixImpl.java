package graph;
import java.util.ArrayList;
import java.util.Arrays;

public class GraphAdjMatrixImpl extends AbstractGraph {

	Edge[][] adjMatrix;
	
	public GraphAdjMatrixImpl(int numberOfVertices) {
		this.vertexes = new ArrayList<>();
		this.edges = new ArrayList<>();
		
		this.adjMatrix = new Edge[numberOfVertices][numberOfVertices];
		for (int i =0; i<numberOfVertices; i++)
			Arrays.fill(this.adjMatrix[i], null);
	}
	
	public void addNewVertex(Vertex v){
		vertexes.add(v);
	}
	
	//add edge to adjacency list and return 1 for success -1 for failure
	public void addNewEdge(Edge e){
		
		edges.add(e);
		String strt = e.getStartVertex().props.get("value");
		String end = e.getEndVertex().props.get("value");
		int first = -1, last = -1;
		for (int i=0; i<vertexes.size(); i++){
			if (vertexes.get(i).props.get("value") == strt){
				first = i;
			}
			if (vertexes.get(i).props.get("value") == end){
				last = i;
			}
			if (last != -1 && first != -1)
				break;
		}
		adjMatrix[first][last] = e;
		
		Edge e2 = new Edge();
		e2.setEndVertex(e.getStartVertex());
		e2.setStartVertex(e.getEndVertex());
		adjMatrix[last][first] = e2;
		
	}
	
	public void printGraph(){
		
		this.getGraphDescription();
		System.out.println("------------------------------------------");
		for (int i = 0; i<adjMatrix.length; i++){
			
			for (int j = 0; j<adjMatrix.length; j++){
				if (adjMatrix[i][j] != null){
					System.out.println(vertexes.get(i).props.get("value") + " --> " + vertexes.get(j).props.get("value"));
					System.out.println("------------------------------------------");
				}
			}
		}
	}
	
	public void getGraphDescription() {
		System.out.println("This graph is implemented using Adjaceny Matrix");
	}
	
	public ArrayList<Edge> getEdgesFromAdj(Vertex v){
		
		ArrayList<Edge> e = new ArrayList<>();
		
		for (int i =0; i < vertexes.size(); i++){
			
			if (vertexes.get(i).props.get("value") == v.props.get("value")){
				for (int j = 0; j < vertexes.size(); j++){
					if (adjMatrix[i][j] != null)
						e.add(adjMatrix[i][j]);
				}
				break;
			}
		}
		return e;
	}

	
	
}
