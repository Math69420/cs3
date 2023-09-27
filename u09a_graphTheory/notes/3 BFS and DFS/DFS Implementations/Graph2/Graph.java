import java.util.ArrayList;
import java.util.List;

//import com.sun.corba.se.impl.orbutil.graph.Graph;

public interface Graph<V> {
	public int getSize();
	public java.util.List<V> getVertices();
	public V getVertex(int index);
	public int getIndex(V v);
	public List<Integer> getNeighbors(int index);
	public int getDegree(int v);
	public int[][] getAdjacencyMatrix();
	public void printAdjacencyMatrix();
	public void printEdges();
	public Abstractgraph<V>.Tree dfs(int v);
	public Abstractgraph<V>.Tree bfs(int v);
	public Abstractgraph<V>.Tree sdfs(int v);
	public List<List<Integer>> getConnectedComponents();
	public void printlist();
	public void printpath(int u ,int v);
	public List<Integer> getPath(int u,int v);
	public boolean isCyclic();
	//public List<Integer> getACycle();
	//public void printcycle();
	//public boolean isBipartite();
	//public List<List<Integer>> getBipartite();
	//public List<Integer> getHamiltonianCycle();
}