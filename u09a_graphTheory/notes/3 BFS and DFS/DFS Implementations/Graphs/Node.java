package graphs;
import graphs.State;

public class Node {

    private Node[] child;
    private int childCount;
    private String vertex;
    private State state;

    public Node(String vertex)
    {
        this.vertex = vertex;
    }

    public Node(String vertex, int childlen)
    {
        this.vertex = vertex;
        childCount = 0;
        child = new Node[childlen];
    }

    public void addChildNode(Node adj)
    {
        adj.state = State.Unvisited;
        if(childCount < 30)
        {
            this.child[childCount] = adj;
            childCount++;
        }
    }
    
    public void setState(State state) { this.state=state; }

    public Node[] getChild()  { return child; }
    public String getVertex() { return vertex; }
    public State  getState()  { return state; }

}