package graph;
import java.util.HashMap;

public class Edge {

	public HashMap<String, String> props;
	private Vertex start;
	private Vertex end;
	
	public Edge(){
		this.props = new HashMap<String,String>();
	}
	
	public Edge(Vertex s, Vertex e){
		this.start = s;
		this.end = e;
	}
	
	public void addProp(String property, String value){
		this.props.put(property, value);
	}
	
	public void setStartVertex(Vertex v){
		this.start = v;
	}
	
	public void setEndVertex(Vertex v){
		this.end = v;
	}
	
	public Vertex getStartVertex(){
		return this.start;
	}
	
	public Vertex getEndVertex(){
		return this.end;
	}
}
