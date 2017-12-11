import java.io.*;
import java.util.*;


class FordFulkerson {
	Scanner in;
	File file;
	int network[][];
	int flow[][];
	int vertices;
	int parent[];
	int results;

	FordFulkerson(String file) {
		try {in = new Scanner(new File(file));}
		catch (FileNotFoundException e) {}
		vertices = in.nextInt();
		//visited = new boolean[vertices];
		network = new int[vertices][vertices];
		flow = new int[vertices][vertices];
		for(int i = 0; i<vertices; i++) {
			for (int j = 0; j<vertices ; j++) {
				network[i][j] = in.nextInt();
				System.out.print(network[i][j] + " ");
			}
			System.out.println();
		}
		results = edmondKarp();
		System.out.println("Max flow: " + results);
		printWrite();
	}

	void printWrite() {
		try {
			PrintWriter out = new PrintWriter(new File("out.txt"));
			out.println(results);
			for(int i = 0; i<vertices; i++) {
				for (int j = 0; j<vertices; j++) {
					if(flow[i][j] < 0) {
						out.print("0 ");
						System.out.print("0 ");
					} else {	
					out.print(flow[i][j] + " ");
					System.out.print(flow[i][j] + " ");	
					}
				}
				out.println();
				System.out.println();
			}
			out.close();
		} catch (FileNotFoundException e) {}
	}

	int edmondKarp() {
		while(true) {
			parent = new int[vertices];
			//Set all edges to unvisited, which would be -1. Also works as parent table
			for (int i = 0; i<vertices; i++) {
				parent[i] = -1;
			}
			parent[0] = 0;
			//Cap of path to node
			int cap[] = new int[vertices];
			cap[0] = Integer.MAX_VALUE;
			//BFS
			Queue<Integer> queue = new LinkedList<Integer>();
			//Add start location, which in this assignment should always be 0
			queue.offer(0);

			while(!queue.isEmpty()) {
				int i = queue.poll(); //Grab header
				for (int j = 0; j<vertices; j++ ) {
					//If j is not visited and capacity has space
					if(parent[j] == -1 && network[i][j] - flow[i][j] > 0) {
						//Set to visited
						parent[j] = i;
						cap[j] = Math.min(cap[i], network[i][j] - flow[i][j]);
						//If not last, add next edge
						if(j != (vertices - 1)) {
							queue.offer(j);
						} else {
							//Else backtrack and write flow
							while(parent[j] != j) {
								i = parent[j];
								flow[i][j] += cap[vertices - 1];
								flow[j][i] -= cap[vertices - 1];
								j = i;
							}
							break;
						}

					}
				}

			}
			if(parent[vertices - 1] == -1) {
				int sum = 0;
				for (int x : flow[0])
					sum += x;
				return sum;
			}
		}
	}
}



class FordAlgorithm {
	public static void main(String [] args) {
		if(args.length != 1) {
			System.out.println("Try; java FordAlgorithm [FILE] ");
		} else {
			new FordFulkerson(args[0]);
		}

	}
}
