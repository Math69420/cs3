import java.util.*;

class Node{
   final Integer number;
   ArrayList<Node> neighbors;
   
   public Node(Integer i){
      number = i;
      neighbors = new ArrayList<Node>();
   }
   
   public void addNeighbor(Integer n){
      neighbors.add(new Node(n));
   }

   public void addNeighbor(Node node){
      neighbors.add(node);
   }   
   
   public boolean equals(Object obj) {
   	if( ! (obj instanceof Node) )
   		return false;
   	Node other = (Node)obj;
   	return number.equals(other.number);
   }
 
   public String toString() {
   	return ""+number;
   }
   
   public static Node getNode(ArrayList<Node> nodes, Integer value) {
   	for(Node node : nodes)
   		if(node.number.equals(value))
   			return node;
      return null;
   }   
}