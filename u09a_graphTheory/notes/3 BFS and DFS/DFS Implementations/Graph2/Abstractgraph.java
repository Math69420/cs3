import java.util.*;

public abstract class Abstractgraph<V> implements Graph<V> {
	protected List<V> vertices;
	protected List<List<Integer>> neighbors;
	
	protected Abstractgraph(int[][] edges,V[] vertices){
		this.vertices = new ArrayList<V>();
		for(int i = 0;i<vertices.length;i++)
			this.vertices.add(vertices[i]);
		createAdjacencyLists(edges,vertices.length);
	}
	protected Abstractgraph(List<Edge> edges,List<V> vertices){
		this.vertices = vertices;
		createAdjacencyLists(edges,vertices.size());
	}
    protected Abstractgraph(List<Edge> edges,int numberOfVertices){
    	vertices = new ArrayList<V>();
    	for(int i = 0;i<numberOfVertices;i++){
    		vertices.add((V)(new Integer(i)));
    	}
    	createAdjacencyLists(edges,numberOfVertices);
    }
    protected Abstractgraph(int[][] edges,int numberOfVertices){
    	vertices = new ArrayList<V>();
    	for(int i = 0;i<numberOfVertices;i++){
    		vertices.add((V)(new Integer(i)));
    	}
    	createAdjacencyLists(edges,numberOfVertices);
    }
    private void createAdjacencyLists(int[][] edges,int numberOfVertices){
    	neighbors = new ArrayList<List<Integer>>();
    	for(int i = 0;i<numberOfVertices;i++){
    		neighbors.add(new ArrayList<Integer>());
    	}
    	for(int i = 0;i<edges.length;i++){
    		int u = edges[i][0];
    		int v = edges[i][1];
    		neighbors.get(u).add(v);
    	}
    }
    private void createAdjacencyLists(List<Edge> edges,int numberOfVertices){
    	neighbors = new ArrayList<List<Integer>>();
    	for(int i = 0;i<numberOfVertices;i++){
    		neighbors.add(new ArrayList<Integer>());
    	}
    	for(Edge edge:edges){
    		neighbors.get(edge.u).add(edge.v);
    	}
    }
    public int getSize(){
    	return vertices.size();
    }
    public List<V> getVertices(){
    	return vertices;
    }
    public V getVertex(int index){
    	return vertices.get(index);
    }
    public int getIndex(V v){
    	return vertices.indexOf(v);
    }
    public List<Integer> getNeighbors(int index){
    	return neighbors.get(index);
    }
    public int getDegree(int v){
    	return neighbors.get(v).size();
    }
    public int[][] getAdjacencyMatrix(){
    	int[][] adjacencyMatrix = new int[getSize()][getSize()];
    	for(int i = 0;i<neighbors.size();i++){
    		for(int j = 0;j<neighbors.get(i).size();j++){
    			int v = neighbors.get(i).get(j);
    			adjacencyMatrix[i][v]= 1; 
    		}
    	}
    	return adjacencyMatrix;
    }
    public void printAdjacencyMatrix(){
    	int[][] adjacencyMatrix = getAdjacencyMatrix();
    	for(int i = 0;i<adjacencyMatrix.length;i++){
    		for(int j = 0;j<adjacencyMatrix[0].length;j++){
    			System.out.print(adjacencyMatrix[i][j]+" ");
    		}
    		System.out.println();
    	}
    }
    public void printEdges(){
    	for(int u = 0;u<neighbors.size();u++){
    		System.out.print("Vertex "+u+": ");
    		for(int j = 0;j<neighbors.get(u).size();j++){
    			System.out.print("("+u+","+neighbors.get(u).get(j)+")");
    		}
    		System.out.println();
    	}
    }
    public static class Edge{
    	public int u;
    	public int v;
    	public Edge(int u,int v){
    		this.u = u;
    		this.v = v;
    	}
    }
    public Tree dfs(int v){
    	List<Integer> searchOrders = new ArrayList<Integer>();
    	int []parent = new int[vertices.size()];
    	for(int i = 0;i<parent.length;i++){
    		parent[i]= -1; 
    	}
    	boolean[] isVisited = new boolean[vertices.size()];
    	dfs(v,parent,searchOrders,isVisited);
    	return new Tree(v,parent,searchOrders);
    }
    private void dfs(int v,int[] parent,List<Integer> searchOrders,boolean[] isVisited){
    	searchOrders.add(v);
    	isVisited[v] = true;
    	for(int i:neighbors.get(v)){
    		if(!isVisited[i]){
    			parent[i]= v;
    			dfs(i,parent,searchOrders,isVisited);
    		}
    	}
    }
    public Tree bfs(int v){
    	List<Integer> searchOrders = new ArrayList<Integer>(); 
    	int[] parent = new int[vertices.size()];
    	for(int i = 0;i<parent.length;i++){
    		parent[i]= -1; 
    	}
    	LinkedList<Integer> queue = new LinkedList<Integer>();
    	boolean[] isVisited = new boolean[vertices.size()];
    	queue.offer(v);
    	isVisited[v]= true;
    	while(!queue.isEmpty()){
    		int u = queue.poll();
    		searchOrders.add(u);
    		for(int w:neighbors.get(u)){
    			if(!isVisited[w]){
    				queue.offer(w);
    				parent[w]= u;
    				isVisited[w] = true;
    			}
    		}
    	}
    	return new Tree(v,parent,searchOrders);
    }
    public Tree sdfs(int v){
    	LinkedList<Integer> stack = new LinkedList<Integer>();  
    	List<Integer> searchorder = new ArrayList<Integer>();
    	stack.add(v);
    	boolean[] isvisited = new boolean[vertices.size()];
    	for(int i = 0;i<vertices.size();i++){
    		isvisited[i] = false; 
    	}
    	int[] parent = new int[vertices.size()];
    	for(int i = 0;i<parent.length;i++){
    		parent[i] = -1; 
    	}
    	isvisited[v] = true;
    	searchorder.add(v);
    	while(!stack.isEmpty()){
    		int u = stack.removeFirst();
    		for(int w:neighbors.get(u)){
    			if(!isvisited[w]){
    				searchorder.add(w);
    				stack.addFirst(w);
    				parent[w] = u;
    				isvisited[w] = true;
    				break;
    			}  		
    		}
    	}
    	return new Tree(v,parent,searchorder);	
    }
    public class Tree{
    	private int root;
    	private int[] parent;
    	private List<Integer> searchOrders;
    	public Tree(int root,int[] parent,List<Integer> searchOrders){
    		this.root = root;
    		this.parent = parent;
    		this.searchOrders = searchOrders;
    	}
    	public Tree(int root,int[] parent){
    		this.root = root;
    		this.parent = parent;
    	}
    	public int getRoot(){
    		return root;
    	}
    	public int getParent(int v){
    		return parent[v];
    	}
    	public List<Integer> getSearchOrders(){
    		return searchOrders;
    	}
    	public int getNumberOfVerticesFound(){
    		return searchOrders.size();
    	}
    	public List<V> getPath(int index){
    		ArrayList<V> path = new ArrayList<V>();
    		do{
    			path.add(vertices.get(index));
    			index = parent[index];
    		}
    		while(index!=-1);
    		return path;
    	}
    	public void printPath(int index){
    		List<V> path = getPath(index);
    		System.out.print("A path from "+vertices.get(root)+" to "+vertices.get(index)+": ");
    		for(int i = path.size()-1;i>=0;i--){
    			System.out.print(path.get(i)+" ");
    		}
    	}
    	public void printTree(){
    		System.out.println("Root is: "+vertices.get(root));
    		System.out.print("Edges: ");
    		for(int i = 0;i<parent.length;i++){
    			if(parent[i]!=-1){
    				System.out.print("("+vertices.get(parent[i])+","+vertices.get(i)+")");
    			}
    		}
    		System.out.println();
    	}
    }
    public List<List<Integer>> getConnectedComponents(){
    	List<List<Integer>> list= new ArrayList<List<Integer>>();
    	for(int i = 0;i<vertices.size();i++){
    	    if(dfs(i).searchOrders.size()==vertices.size()){
    			list.add(dfs(i).searchOrders);
    			break;
    		}
    		else{
    			boolean co = true;
    			for(int j = 0;j<i;j++){
    				if(dfs(j).searchOrders.indexOf(i)!=-1){
    					co = false;
    					break;
    				}
    			}
    			if(co==true)
    				list.add(dfs(i).searchOrders);
    		}
    	}
    	return list;
    }
    public void printlist(){
    	List<List<Integer>> list = getConnectedComponents();
    	for(int i = 0;i<list.size();i++){
    		for(int j = 0;j<list.get(i).size();j++){
    			System.out.print((list.get(i)).get(j)+"  ");
    		}
    		System.out.println();
    	}
    }
    public List<Integer> getPath(int u,int v){
        int a = bfs(v).getPath(u).size();
        if(a==1)
        	return null;
        else{
    	    return (List<Integer>) bfs(v).getPath(u);
        }
    }
    public void printpath(int u,int v){
    	if(getPath(u,v)==null)
    		System.out.println("No path");
    	else{
    	    for(int i = 0;i<getPath(u,v).size();i++){
    		    System.out.print((bfs(v).getPath(u)).get(i)+" ");
    	    }
    	    System.out.println();
    	}
    }
    public boolean isCyclic(){
    	LinkedList<Integer> stack = new LinkedList<Integer>();  
    	stack.add(0);
    	int[] isvisited = new int[vertices.size()];
    	for(int i = 0;i<vertices.size();i++){
    		isvisited[i] = 0; 
    	}
    	int[] parent = new int[vertices.size()];
    	for(int i = 0;i<parent.length;i++){
    		parent[i] = -1; 
    	}
    	isvisited[0] = 1;
    	while(!stack.isEmpty()){
    		int u = stack.removeFirst();
    		for(int w:neighbors.get(u)){
    			if(isvisited[w]==0){
    				stack.addFirst(w);
    				parent[w] = u;
    				isvisited[w] = 1;
    				break;
    			}
    			else if(isvisited[w]==1)
    				return true;
    		}
    	}
    	return false;
    }
    /*public List<Integer> getACycle(){
    	if(isCyclic()==true){
    		LinkedList<Integer> stack = new LinkedList<Integer>();  
        	stack.add(0);
        	int[] isvisited = new int[vertices.size()];
        	for(int i = 0;i<vertices.size();i++){
        		isvisited[i] = 0; 
        	}
        	isvisited[0] = 1;
            int []m = new int[vertices.size()];
            for(int i = 0;i<vertices.size();i++){
        	    m[i] = getDegree(i); 
            }
    	    LinkedList<Integer> cycle = new LinkedList<Integer>();
    	    if(m[0]>1)
    	    	cycle.add(0);
    	    for(int i = 0;i<vertices.size();i++){
    	    	while(!stack.isEmpty()){
    	    		int u = stack.removeFirst();
    	    		for(int w:neighbors.get(u)){
    	    			if(isvisited[w]==0){
    	    				stack.addFirst(w);
    		                if(m[w]>1)
    			                cycle.add(w);
    		                isvisited[w] = 1; 
    	    			}
    	    			else if(isvisited[w]==1){
    	    				continue;
    	    			}
    	    		}
    	    	}
    	    }
    	    return cycle;
    	    }
    	else {
			return null;
		}
    }
    public void printcycle(){
    	if(isCyclic()==true){
    	System.out.println();
    	for(int i = 0;i<getACycle().size();i++){
    		System.out.print(getACycle().get(i)+" ");
    	}
    	System.out.println();
    	}
    }
    public boolean isBipartite(){
    	return true;
    }
    public List<List<Integer>> getBipartite(){
    	return null;
    }
    public static graph maxInducedSubgraph(graph edeg,int k){
    	return null;
    }
    public List<Integer> getHamiltonianCycle(){
    	return null;
    }*/
}