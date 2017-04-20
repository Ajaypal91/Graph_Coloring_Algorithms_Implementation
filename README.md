# Graph_Coloring_Algorithms_Implementation
This project includes the implementation of various graph coloring Algorithms.

<h2> Graph Coloring: </h1>
In graph theory, graph coloring is a special case of graph labeling; it is an assignment of labels traditionally called "colors" to elements of a graph subject to certain constraints. 
In its simplest form, it is a way of coloring the vertices of a graph such that no two adjacent vertices share the same color; this is called a vertex coloring. 
Similarly, an edge coloring assigns a color to each edge so that no two adjacent edges share the same color, and a face coloring of a planar graph assigns a color to each face or region so that no two faces that share a boundary have the same color.

In this project the problem of vertex coloring is being tackled. 

Some of the applications of Graph coloring may include: 
1) Interval Schedulings 
2) Register allocation: In compiler optimization, register allocation is the process of assigning a large number of target program variables onto a small number of CPU registers. This problem is also a graph coloring problem.
3) Sudoku solver: Sudoku is also a variation of Graph coloring problem where every cell represents a vertex. There is an edge between two vertices if they are in same row or same column or same block.
4) Bipartite Graphs: We can check if a graph is Bipartite or not by coloring the graph using two colors. If a given graph is 2-colorable, then it is Bipartite, otherwise not. See this for more details.
5) Map Coloring: Geographical maps of countries or states where no two adjacent cities cannot be assigned same color. Four colors are sufficient to color any map 

<h3> Problems tackled </h3>
The problem of minimization and maximization of colors, both are tackled using the algorithms defined below

<h3> Algorithms used </h3>
The following Algorithms are used in the implementation: </br>
1) Greedy Algorithm with and without randomness</br>
2) Wigderson's Algorithm using BFS and DFS</br>
More algorithms on implementation will be updated

<h3> How to work around </h3>
After compiling all the files,
Run the start.java file.
For creating a graph. Update the sample.txt or any other file (in this case update the filename in start.java)
The file should contains the following information (please not the vertex coloring problem tackled here is for directed graphs)
Number of vertices in graph
vertices (with newline)
edges betweeen the vertices with spaces (with newline)

For example: </br>
3</br>
a</br>
b</br>
c</br>
a b</br>
b c</br>


There are various sources available online which may help. If I can help you in any way, please reach out at erajaypal91@gmail.com
