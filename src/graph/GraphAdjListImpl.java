package graph;
import java.util.ArrayList;
import java.util.LinkedList;

class Tuple{
	Vertex v;
	LinkedList<Edge> list;
	
	public Tuple(Vertex v){
		this.v = v;
		this.list = new LinkedList<>();
	}
}

public class GraphAdjListImpl extends AbstractGraph{

	
	ArrayList<Tuple> adjList;
	
	public GraphAdjListImpl() {
		this.vertexes = new ArrayList<>();
		this.edges = new ArrayList<>();
		this.adjList = new ArrayList<Tuple>();
	}
	
	public void addNewVertex(Vertex v){
		adjList.add(new Tuple(v));
		vertexes.add(v);
	}
	
	//add edge to adjacency list and return 1 for success -1 for failure
	public void addNewEdge(Edge e){
		
		Edge e2 = new Edge();
		e2.setEndVertex(e.getStartVertex());
		e2.setStartVertex(e.getEndVertex());
		edges.add(e);
		edges.add(e2);
		
		for (Tuple t : adjList){
			Vertex i = t.v;
			if (i.props.get("value") == e.getStartVertex().props.get("value")){
				t.list.offer(e);
				break;
			}
		}
		
		for (Tuple t : adjList){
			Vertex i = t.v;
			if (i.props.get("value") == e2.getStartVertex().props.get("value")){
				t.list.offer(e2);
				break;
			}
		}
		
	}
	
	public void printGraph(){
		
		this.getGraphDescription();
		System.out.println("------------------------------------------");
		for (Tuple t : adjList){
			for (int j = 0; j < t.list.size() ; j++){
				this.printVertexAndEdge(t.list.get(j));
				System.out.println("------------------------------------------");
			}
			
		}
		
	}
	
	@Override
	public void getGraphDescription() {
		// TODO Auto-generated method stub
		System.out.println("This graph is implemented using Adjaceny List");
	}

	public ArrayList<Edge> getEdgesFromAdj(Vertex v){
		
		for (Tuple t : adjList){
			Vertex i = t.v;
			if (v.props.get("value") == i.props.get("value")){
				return new ArrayList<Edge>(t.list);
			}
		}
		return null;
	}

}
