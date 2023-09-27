public class Test {
	public static void main(String[] args){
		String[] vertices = {"Seattle","San Francisco","Los Angeles","Denver","Kansas City",
				"Chicago","Boston","New York","Atlanta","Miami","Dallas","Houston"};
		int[][] edges = {
				{0,1},{0,3},{0,5},
				{1,0},{1,2},{1,3},
				{2,1},{2,3},{2,4},{2,10},
				{3,0},{3,1},{3,2},{3,4},{3,5},
				{4,2},{4,3},{4,5},{4,7},{4,8},{4,10},
				{5,0},{5,3},{5,4},{5,6},{5,7},
				{6,5},{6,7},
				{7,4},{7,5},{7,6},{7,8},
				{8,4},{8,7},{8,9},{8,10},{8,11},
				{9,8},{9,11},
				{10,2},{10,4},{10,8},{10,11},
				{11,8},{11,9},{11,10}
		};
		Graph<String> graph1 = new Unweightedgraph<String>(edges, vertices);
		System.out.println("The index of Miami is "+graph1.getIndex("Miami"));
		printgraph(graph1);	
		System.out.println("\n");
	
		String[] names ={"Peter","Jane","Mark","Cindy","Wendy"};
		int [][]edgelist = {
				{0,2},{0,3},
				{1,2},
				{2,1},{2,4},
				{3,0},{3,4},
				{4,2},{4,3}
		};
		Graph<String> graph2 = new Unweightedgraph<String>(edgelist, names);
		System.out.println("The index of Cindy is "+graph2.getIndex("Cindy"));
		printgraph(graph2);
	}
    public static void printgraph(Graph a){
	    System.out.println("The number of vertices in graph1: "+a.getSize());
		System.out.println("The vertex with index 1 is "+a.getVertex(1));
		System.out.println("The edges for graph1: ");
		a.printEdges();
		System.out.println("Adjacency matrix for this graph: ");
		a.printAdjacencyMatrix();
		a.dfs(2).printPath(1);
		a.dfs(3).printTree();
		a.bfs(0).printPath(4);
		a.bfs(0).printTree();
		a.sdfs(0).printPath(4);
		a.sdfs(0).printTree();
		a.printlist();
		a.printpath(0, 3);
		System.out.println(a.isCyclic());
    	//a.printcycle();
	}
}