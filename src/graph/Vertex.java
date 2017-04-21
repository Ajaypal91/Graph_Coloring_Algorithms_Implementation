package graph;
import java.util.HashMap;

public class Vertex {
	
	public HashMap<String, String> props;
	public int color;
	
	public Vertex(){
		this.props = new HashMap<String, String>();
		this.color = -1;
	}
	
	public void addProp(String property, String value){
		this.props.put(property, value);
	}

}
