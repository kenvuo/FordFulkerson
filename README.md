# FordFulkerson

A algorithm to compute maximum flow in a flow network using FordFulkerson-algorithm, with the shortest 
augmentation path using Edmonds and Karp’s version.

The program shall read its input from a designated file. The filename is given to the program as command line arguments. The input file contains: <br>
* First a line with the number of vertices _m_.<br>
* Then _m_ lines with _m_ numbers each (a matrix) defining the capacities between each pair of vertices. The number in line _i_ and column _j_ is the capacity from vertex _i_ to vertex _j_, in other words the capacity of the edge (i,j) in the graph. <br>

The vertices are numbered 0 through _m_-1, with 0 as the source and _m_-1 as the sink. Note that there may be a positive capacity both from a vertex _v_ to a vertex _u_, and from _u_ back to _v_. On the diagonal all capacities are 0. There are no edges going into the source or out of the sink (the leftmostcolumn and the last line(row)contain only zeros).

Example input <br>
5 <br>
0 5 1 0 0  <br>
0 0 1 4 0  <br>
0 2 0 0 6  <br>
0 0 1 0 1  <br>
0 0 0 0 0  <br>

Example output  <br>
4<br>
0 3 1 0 0<br> 
0 0 1 2 0 <br>
0 0 0 0 3 <br>
0 0 1 0 1 <br>
0 0 0 0 0  <br>
