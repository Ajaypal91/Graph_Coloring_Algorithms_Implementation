package Main;
import graph.Graph;
import graph.GraphAdjListImpl;
import graph.GraphAdjMatrixImpl;
import graphColoringAlgorithms.GraphColoringBackTracking;
import graphColoringAlgorithms.GraphColoringGreedy;
import modules.Colors;
import modules.FileIO;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "src/Files/sample";
		//streamFileAndUpdateGraph(path);
		
		//find which graph should be implemented
		int numberOfVertices = FileIO.GraphToCreate(path);
		Graph G;
		if (numberOfVertices == 0){
			G = FileIO.readDataAndCreateGraph(path, new GraphAdjListImpl());
		}
		else {
			G = FileIO.readDataAndCreateGraph(path, new GraphAdjMatrixImpl(numberOfVertices));
		}
		
		G.printAllVertexes();
		G.printGraph();
		G.setGraphColoringTechnique(new GraphColoringBackTracking());
		G.getGraphColoringObj().toggleShuffle();
		G.colorGraph();
		Colors.printColors(G);
		
		
		G.resetColors();
		
		for (int i = 1; i< 5; i++){
			if (G.isGraphColorable(i)){
				System.out.println("The Graph was fully colorable with number of colors = " + i);
			}
			else{
				System.out.println("The Graph was not fully colorable with number of colors = " + i);
			}
			Colors.printVertexCoverage(G, i);
			G.resetColors();
		}
		
		
//		G.setGraphColoringTechnique(new GraphColoringGreedyDFS());
//		G.colorGraph();
//		Colors.printColors(G);
//		
//		G.resetColors();
//		
//		G.setGraphColoringTechnique(new GraphColoringGreedyBFS());
//		G.colorGraph();
//		Colors.printColors(G);
	}
	
	
}
