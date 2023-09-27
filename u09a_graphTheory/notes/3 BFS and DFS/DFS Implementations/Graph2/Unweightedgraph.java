import java.util.*;

public class Unweightedgraph <V> extends Abstractgraph<V>{
	public Unweightedgraph(int[][] edges,V[] vertices){
		super(edges,vertices);
	}
	public Unweightedgraph(List<Edge>edges,List<V> vertices){
		super(edges,vertices);
	}
	public Unweightedgraph(List<Edge>edges,int numberOfVertices){
		super(edges,numberOfVertices);
	}
	public Unweightedgraph(int[][] edges,int numberOfVertices){
		super(edges,numberOfVertices);
	}
}