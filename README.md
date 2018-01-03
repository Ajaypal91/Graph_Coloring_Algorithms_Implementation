# Graph_Coloring_Algorithms_Implementation
This project includes the implementation of various graph coloring Algorithms.

<h1> Graph Coloring: </h1>

<h2>Introduction</h2>
In graph theory, graph coloring is a special case of graph labeling; it is an assignment of labels traditionally called "colors" to elements of a graph subject to certain constraints. 
In its simplest form, it is a way of coloring the vertices of a graph such that no two adjacent vertices share the same color; this is called a vertex coloring. 
Similarly, an edge coloring assigns a color to each edge so that no two adjacent edges share the same color, and a face coloring of a planar graph assigns a color to each face or region so that no two faces that share a boundary have the same color.</br>

In graph theory, graph coloring is an assignment of labels traditionally called "colors" to elements of a graph subject to certain constraints. In its simplest form, it is a way of coloring the vertices of a graph such that no two adjacent vertices share the same color; this is called a vertex coloring. Similarly, an edge coloring assigns a color to each edge so that no two adjacent edges share the same color, and a face coloring of a planar graph assigns a color to each face or region so that no two faces that share a
boundary have the same color.</br>
In this project, we tackle the problem of vertex coloring using a variety of algorithms on a set of randomly generated graphs. We solve the minimization problem (find the minimum number of colors
that can be used to color a graph) and the maximization problem (find the maximum percentage of the graph that can be colored given x colors). We also create a Sudoku solver application that uses graph
coloring to solve it. We also compare these different algorithms on a huge real world dataset to compare time and color efficiency.</br>

<h2>Applications</h2>
Some of the applications of Graph coloring may include: 
1) Interval Schedulings 
2) Register allocation: In compiler optimization, register allocation is the process of assigning a large number of target program variables onto a small number of CPU registers. This problem is also a graph coloring problem.
3) Sudoku solver: Sudoku is also a variation of Graph coloring problem where every cell represents a vertex. There is an edge between two vertices if they are in same row or same column or same block. (This application is available under Applications Package).
4) Bipartite Graphs: We can check if a graph is Bipartite or not by coloring the graph using two colors. If a given graph is 2-colorable, then it is Bipartite, otherwise not. See this for more details.
5) Map Coloring: Geographical maps of countries or states where no two adjacent cities cannot be assigned same color. Four colors are sufficient to color any map 

<h2> Problems tackled </h2>
The problem of minimization and maximization of colors, both are tackled using the algorithms defined below

<h2> Algorithms used </h2>
The following Algorithms are used in the implementation: </br>
1) Greedy Algorithm with and without randomness</br>
2) Wigderson's Algorithm using BFS and DFS with and without randomness</br>
3) BackTracking with and without randomness</br>
4) Randomized Graph Coloring</br>
5) WelsPowel Algorithm </br>
6) Online Graph Coloring - First Fit (This is a modified version of actual graph coloring, in which vertexes occurs dynamically. Here the edges are occuring dynamically.</br>
More algorithms on implementation will be updated

<h2>Random Graph Generator</h2>
In this program, we generate a random graph and write the vertices and the edges to a file. The algorithm for it is as follows:-</br>
1. Get the number of edges for the graph from the user.</br>
2. Calculate the minimum and maximum number of vertices that can be created from the edges.</br>
3. Choose 2 random vertices from a range of values from (minVertices, maxVertices) and if an edge does not exist, create it.</br>
4. Continue till the desired number of edges have been created.</br>
5. Write the vertices and edges to the file.</br>
Thus, we managed to get a random graph in an output file. We can test out our algorithms on it now giving this file as input.</br>

<h2> Algorithms in detail</h2>
<h3>Random Graph Coloring Alogorithm</h3>

In random graph coloring algorithm, the vertices are chosen at random to color over ‘n’ iterations and are given a safe minimum temporary color and the vertex that could be colored with the
minimum color is then colored after n iterations. In this algorithm, the value of ‘n’ is proportional to the size of the vertices that has not been colored yet [2]. The pseudocode of this algorithm is as follow:

![alt text](/src/Daigram/1.png)


<h3>Backtracking Alogorithm</h3>

In backtracking graph coloring algorithm, we iterate over all the vertices in an order, then for each vertex v in V, we assign minimum available color for it, if we can assign the color, then we color the
next vertex in the same way, if we ran out of colors then we give the previous vertex a different color so that we can color the new vertex. A recursive algorithm is given below:

![alt text](/src/Daigram/2.png)

<h3>Greedy Alogorithm</h3>

The greedy algorithm considers the vertices one by one and uses the first available color. It doesn’t guarantee to use minimum colors, but it guarantees an upper bound on the number of colors. The basic algorithm never uses more than d+1 colors where d is the maximum degree of a vertex in the given graph [2]. The following is the basic idea of it:-

![alt text](/src/Daigram/3.png)


<h3>Greedy Alogorithm with BFS and DFS</h3>

It is like the Greedy algorithm but a subtle difference is that it uses BFS or DFS to traverse and color the other vertices starting from a given vertex. Thus, the ordering of the vertices which is the most important part of the graph coloring problem is decided through BFS or DFS. 

<h3>Welsh Powell Alogorithm</h3>

Welsh-Powell Algorithm provides a greedy algorithm that runs on a static graph. It orders the coloring of the vertices based on the decreasing order of their degree. This is an iterative greedy algorithm:
Step 1: All vertices are sorted per the decreasing value of their degree in a list V.
Step 2: Colors are ordered in a list C.
Step 3: The first non-colored vertex v in V is colored with the first available color in C. available means a color that was not previously used by the algorithm.
Step 4: The remaining part of the ordered list V is traversed and the same color is allocated to every vertex for which no adjacent vertex has the same color.
Step 5: Steps 3 and 4 are applied iteratively until all the vertices have been colored.

<h3>Online Graph Coloring Algorithm</h3>
This first fit is a greedy approach in choosing the best color for a vertex that appears dynamically along its edges for a given graph. So, whenever a new vertex appears along with its edges, the new vertex is given a new color with first fit (i.e. the best possible minimum color), without altering the colors already defined for the previous vertices of the graph G. Sample output of the program is shown below. On the top, we have the vertexes with their edges as they appear, and on the bottom we have the colors that are given to these vertexes using the first fit algorithm:

![alt text](/src/Daigram/4.png)

<h1>Observations</h1>

<h2>Running Algorithms on Random Graph</h2>
To gain a better understanding of how these algorithms run, we ran all of them on a Random Graph Generator of 5000 edges. The results are plotted below:-

![alt text](/src/Daigram/5.png)

![alt text](/src/Daigram/6.png)

The exception was the backtracking one which, even after taking 4 hours, was not able to completely cover the graph.

<h2>Real World Facebook Graph</h2>

For testing out the various algorithms we implemented in our project, we chose a Facebook network graph containing anonymized social circles of Facebook. It is an undirected graph having 4,039 nodes and 88,234 edges. The following table summarizes the results:-

![alt text](/src/Daigram/9.png)

It is evident from the above graph that Welsh Powell Algorithm performed the best, both in time taken and the number of colors used. The greedy algorithm were similar in terms of color usage, but Greedy and Greedy DFS took less than a minute to color the graph whereas the Greedy BFS took around 20 minutes for the same. The reason for this can be the structure of the graph having less number of levels but more number of adjacent vertices.</br>
The backtracking algorithm took 88 colors to color the graph whereas Random coloring algorithm took 86 colors. These were the worst performing with each taking a couple of hours to color the graph.

<h1>The Sudoku Solver</h1>
In this project, we created a Sudoku solver application using graph coloring. Each vertex in Sudoku is given a color from 1 to 9. A modified Backtracking algorithm in which a color, once assigned in the input, is unchanged till the end is used.
A sample Sudoku problem is given below on the left and its solution using graph coloring is shown on the right side below.

![alt text](/src/Daigram/8.png)


<h1> Design Pattern Used </h1>
This project is a good example and implementation of Strategy Design Pattern, in which all the underlying changing behavious of graph coloring algorithms are encapsulated and are used accordingly via interfaces. </br></br>

![Alt text](/src/Daigram/design.png?raw=true "Design")


<h2> How to work around </h2>
<h3> Running Offline Graph Coloring Algorithms: </h3>
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
<h3> Running Online Graph Coloring Algorithm: </h3>
To run the first fit algorithm, run the OnlineStart.java file and add edges in the sample1.txt file, save them.
As the vertices are added the graph will be colored on the fly with first fit algorithm. 

<h3> Running Sudoku Application: </h3>
Open SudokuSolver.java in Applications package. 
Input your sudoku in any file in the Files folder and give the same file path to the sudokusolver.
For the sudoku puzzle, in place of an unknown value input "."

</br></br>
There are various sources available online which may help. If I can help you in any way, please reach out at erajaypal91@gmail.com



