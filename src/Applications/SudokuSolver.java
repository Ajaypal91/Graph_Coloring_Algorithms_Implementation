package Applications;

import graph.Graph;
import graph.GraphAdjListImpl;
import graphColoringAlgorithms.GraphColoringBackTracking;
import graphColoringAlgorithms.GraphColoringBackTrackingForSudoku;
import modules.Colors;
import modules.FileIO;

public class SudokuSolver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "src/Files/Sudoku2	";
		Graph G = FileIO.readSudokuAndCreateGraph(path, new GraphAdjListImpl());
		G.setGraphColoringTechnique(new GraphColoringBackTrackingForSudoku());
		G.colorGraph();
		Colors.printSudoku(G);
	}
	
}
