import java.util.*;
import static java.lang.System.*;

public class DFS_Using_Adjacency_List {
   
    //public dfs that takes the graph and start as inputs
    public static void dfs(ArrayList<ArrayList<Integer>> adjLists, int s){
        int n = adjLists.size();
        boolean[] visited = new boolean[n];
        dfs_rec(adjLists, visited, s);
    } 
      
    // recursive dfs which also takes the visited array
    private static void dfs_rec(ArrayList<ArrayList<Integer>> adjLists, boolean[] visited, int v){
        visited[v] = true;
        System.out.print(v + " ");
        for(int w : adjLists.get(v)){
            if(!visited[w]){
                dfs_rec(adjLists, visited, w);
            }
        }
    }
     
    // Use a stack for the iterative DFS version
    public static void dfs_iterative(ArrayList<ArrayList<Integer>> adj, int s){
        boolean[] visited = new boolean[adj.size()];
        Stack<Integer> st = new Stack<Integer>();
        st.push(s);
        while(!st.isEmpty()){
            int v = st.pop();
            if(!visited[v]){
                visited[v] = true;
                System.out.print(v + " ");
                // auxiliary stack to visit neighbors in the order they appear
                // in the adjacency list
                // alternatively: iterate through ArrayList in reverse order
                // but this is only to get the same output as the recursive dfs
                // otherwise, this would not be necessary
                Stack<Integer> auxStack = new Stack<Integer>();
                for(int w : adj.get(v)){
                    if(!visited[w]){
                        auxStack.push(w);
                    }
                }
                while(!auxStack.isEmpty()){
                    st.push(auxStack.pop());
                }
            }
        }
        System.out.println();
    }     
     
    public static String[][] adjacencyMatrix(ArrayList<ArrayList<Integer>> adjLists) {
      String[][] adjMat = new String[adjLists.size()][adjLists.size()];
      for(int r=0; r<adjLists.size(); ++r) 
         for(int c=0; c<adjLists.size(); ++c) 
            adjMat[r][c] = "-";

      for(int r=0; r<adjLists.size(); ++r) {
         ArrayList<Integer> row = adjLists.get(r);
         Iterator<Integer> iter = row.iterator();
         while(iter.hasNext()) {
            Integer entry = iter.next();            
                  adjMat[r][entry] = "*";
            }
         }
      return adjMat;            
    }
    
    public static void outputMatrix(String[][] matrix) {
      out.print("\t");
      for(int r=0; r<matrix.length; ++r)
         out.print(r+"\t");
      out.println("\n");
      int rowNum=0;    
      for(String[] row : matrix)
      {
         out.print(rowNum++ + ":\t");           
         for(String entry : row) {       
            out.print(entry+"\t");
         }
         out.println();
      }
    }
    
    public static void outputLists(ArrayList<ArrayList<Integer>> adjLists) {
      int rowNum=0;
      for(ArrayList<Integer> row : adjLists)
      {
         out.print(rowNum++ + ":  ");
         for(Integer entry : row) {
            out.print(entry+"\t");
         }
         out.println();
      }      
    }
     
    // ----------------------------------------------------------------------
    // Testing our implementation
    public static void main(String[] args) {
         
        // Create adjacency list representation
        ArrayList<ArrayList<Integer>> adjLists = new ArrayList<ArrayList<Integer>>();
        final int n = 7;
         
        // Add an empty adjacency list for each vertex
        for(int v=0; v<n; v++){
            adjLists.add(new ArrayList<Integer>());
        }
         
        // insert neighbors of vertex 0 into adjacency list for vertex 0
        adjLists.get(0).add(1);
        adjLists.get(0).add(2);
        adjLists.get(0).add(3);
         
        // insert neighbors of vertex 1 into adjacency list for vertex 1
        adjLists.get(1).add(5);
        adjLists.get(1).add(6);
         
        // insert neighbors of vertex 2 into adjacency list for vertex 2
        adjLists.get(2).add(4);
     
        // insert neighbors of vertex 3 into adjacency list for vertex 3
        adjLists.get(3).add(2);
        adjLists.get(3).add(4);
 
        // insert neighbors of vertex 4 into adjacency list for vertex 4
        adjLists.get(4).add(1);
 
        // insert neighbors of vertex 5 into adjacency list for vertex 5
        // -> nothing to do since vertex 5 has no neighbors
         
        // insert neighbors of vertex 6 into adjacency list for vertex 5
        adjLists.get(6).add(4);
         
        outputLists(adjLists);
        out.println();

        outputMatrix(adjacencyMatrix(adjLists));
        out.println();
        // Print vertices in the order in which they are visited by dfs()
        out.println("DFS traversal using recurvise method:");
        dfs(adjLists, 0);
        out.println();
        out.println("DFS traversal using iterative method:");
        dfs_iterative(adjLists, 0);
    }
 
}