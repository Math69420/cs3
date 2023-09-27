import java.util.*;
import static java.lang.System.*;

public class GraphDFS
{
   //Create an instance variable of your choice.
   //The two top candidates are:
   //  A map of strings to strings
   //  A map of strings to lists
   //  An array of strings
   //  An array of lists

   //The constructor should take a String of one-directional connections
   //as an input and add each connection to the graph.
   public GraphDFS(String line)
   {
   
   }

   ////////////////////////////////////////////////////
   // The signature of the public method called      //
   // by the main method should be:  dfs(String)     //
   // You're going to make both a recursive and      //
   // an iterative version. Just change the name of  //
   // the one you don't want to run to dfs1 or dfs2. //
   ////////////////////////////////////////////////////
    
   /* Two options for keeping track of which nodes have been visited:
    * If using an array or list to store the graph, you can use a 
    * list or array of booleans that's the same size.  You'll set the
    * corresponding spot in the boolean array to true when it's visited.
    
    * If using a map to store the graph, just make an empty set to 
    * store the visited list.  You can add a node to the set AND check
    * where that node had previously been visited by putting the 
    * call to the add method as the IF's condition.
    */   
     
   //public method called to start the recursive version: 
   public void dfs(String start)
   {
      //Bail if the starting key isn't even in the graph
   
   
   }
      
   //The recursive helper method:
   private void dfs(String start, Set<String> visited)
   { 
      //label v as discovered
      
      //for all neighbors of v
      //  if neighbor is not labeled as discovered then
      //    recursively call DFS on the neighbor
   } 
   
   //public method called to run the iterative version: 
   public void dfs(String start)
   {
    	//let SOS be a stack of stacks (it's really just a LinkedList)
     	//SOS.addFront(v)
     	//while SOS is not empty do
      //  v = SOS.removeFront()
      //    if v is not labeled as discovered then
      //      label v as discovered
      //      add to list of v's neighbors to the front of SOS, maintaining their order
   }    
   
   @Override
   public String toString()
   {
      return null;
   }
}