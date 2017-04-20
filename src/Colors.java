import java.util.ArrayList;

public class Colors {

	private static String[] colors = {"Red", "Green", "Blue", "Yellow","White","Black","Grey","Orange","Pink","Voilet" ,"Purple",
									"Brown", "Magenta","Gold", "Cyan", "Lavender","Maroon","Indigo","Silver","Sky Blue","Teal","Lime",
									"Salmon","Tan","Blue-Green","Orchid","Goldenrod","Azure","Plum","Crimson","Steel Blue","Slate-Grey"};
	
	public static String getColor(int index){
		return colors[index%colors.length];
	}
	
	public static void printColors(Graph G){
		
		System.out.println("<-------------------->");
		
		G.printGraphColoringTechnique();
		
		ArrayList<Vertex> vertices = G.getVertices();
		
		for (Vertex v: vertices){
			
			if (  v.color < vertices.size() && v.color >=0 ){
				System.out.println("Vertex: " + v.props.get("value") + " has color = " + colors[v.color]);
			}
			else {
				System.out.println("Vertex: " + v.props.get("value") + " has color no color defined");
			}
			
		}
		
		System.out.println("<-------------------->");
		
	}
	
	public static void printVertexCoverage(Graph G, int i){
		 
		 int numberOfVerticesColored = 0;
		 
		 ArrayList<Vertex> vertices = G.getVertices();
		 
		 for (Vertex v : vertices){
			 if (v.color >= 0)
				 numberOfVerticesColored++;
		 }
		
		 System.out.println("The percentage of vertex colored with " + i + " colors = " + ((float)(numberOfVerticesColored)/((float)G.getVertices().size()))*100 + "%") ;
		 System.out.println("<-------------------->");
	}
	
	public static int maximumColorsAvailable(){
		return colors.length;
	}
	
}
