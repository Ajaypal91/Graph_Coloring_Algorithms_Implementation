import java.util.HashMap;

public class Vertex {
	
	HashMap<String, String> props;
	int color;
	
	public Vertex(){
		this.props = new HashMap<String, String>();
		this.color = -1;
	}
	
	public void addProp(String property, String value){
		this.props.put(property, value);
	}

}
