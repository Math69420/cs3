import java.util.*;

class Node2{
   final Integer number;
   ArrayList<Integer> neighbors;
   
   public Node2(Integer i){
      number = i;
      neighbors = new ArrayList<Integer>();
   }
   
   public void addNeighbor(Integer n){
      neighbors.add(n);
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
}