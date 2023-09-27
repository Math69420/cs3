import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class DFS_Using_Adjacency_Array
{
    static String[] nodes = {"A","B","C","D","E","F","G","H","I","J","K","L","M"};  
                         
    static int[][] graph6 = { { 0, 1, 0, 1, 0 },
                              { 1, 0, 0, 1, 1 },
                              { 0, 1, 0, 0, 0 },
                              { 1, 0, 1, 0, 0 },
                              { 1, 0, 0, 1, 0 }};

    static int[][] graphW = { { 0, 1, 1, 0, 1, 0, 0 },
                              { 1, 0, 0, 1, 0, 1, 0 },
                              { 1, 0, 0, 0, 0, 0, 1 },
                              { 0, 1, 0, 0, 0, 0, 0 },
                              { 1, 0, 0, 0, 0, 1, 0 },
                              { 0, 1, 0, 0, 1, 0, 0 },
                              { 0, 0, 1, 0, 0, 0, 0 }};                       
                       
     static boolean[][] graph6b = makeBoolean(graph6);
     static boolean[][] graphWb = makeBoolean(graphW);
     
     public static void main(String[] args) throws IOException {
        showMatrix(graphW);  
        out.println();   
        System.out.println(dfs(graphWb,"A"));
    }

    public static String dfs(boolean[][] graph, String begin) {
        int start = findCode(nodes,begin);
        boolean[] visited = new boolean[graph.length];
        PriorityQueue<Integer> path = dfs(graph, start, visited, new PriorityQueue<Integer>());
        
        String nodesList = "";
        while(!path.isEmpty())
            nodesList += nodes[path.remove()] + " ";
        return nodesList;
    }
             
    private static PriorityQueue<Integer> dfs(boolean[][] graph, int start, boolean[] visited, PriorityQueue<Integer> found) {
        visited[start] = true;
        found.add(start);	
        for(int i=0; i<graph.length; ++i)
        {
            if(graph[start][i] && !visited[i]) {
                return dfs(graph, i, visited, found);
            }   
        }
        return found;
    }
    
    /*
    //Non-recursive forward version     
    public static String dfs(boolean[][] graph, String start){
        boolean[] visited = new boolean[graph.length];
        String nodesList = "";
        Stack<Integer> stack = new Stack<Integer>();
        int current = findCode(nodes,start);
        nodesList += nodes[current] + " ";
        int possibleEdge = 0;
        visited[current] = true;  //You have visited the starting node
        stack.push(current);
        while (!stack.isEmpty()) {
            while (possibleEdge < graph.length) {
                //System.out.println(airportCode[current]+"-"+airportCode[possibleEdge]);
                if (graph[current][possibleEdge] && !visited[possibleEdge]){
                    stack.push(current);      //Save state
                    current = possibleEdge;   //Continue with the child node
                    visited[current] = true; 
                    possibleEdge = -1;        //So that it will be incremented to 0
                    nodesList += nodes[current] + " ";
                }
                possibleEdge++;
            }
            possibleEdge = current;           //Continue to next row of "parent node"
            current = stack.pop();            //Get parent node back
        } 
        return nodesList;
    }  */
        

 /*
    //Non-recursive backward
    public static String dfs(boolean[][] graph, String start){
        boolean[] visited = new boolean[graph.length];
        String nodesList = "";
        Stack<Integer> stack = new Stack<Integer>();
        int current = findCode(nodes,start);
        stack.push(current);
        while (!stack.isEmpty()) {
            current = stack.pop();            //Get parent node back
            if(!visited[current]) {
               visited[current] = true; 
               nodesList += nodes[current] + " ";            	
               for(int possibleEdge=0; possibleEdge<graph.length; possibleEdge++) {
                  if (graph[current][possibleEdge]){
                     stack.push(possibleEdge);      //Save state
                  }
               }   
            }
        } 
        return nodesList;
    }   
       */            

                         

    
    private static int findCode(String[] nodes, String code) {
        for (int i = 0; i < nodes.length; i++)
            if (nodes[i].equalsIgnoreCase(code))
                return i;
        return -1;
    }
    
    private static boolean[][] makeBoolean(int[][] intAdjMat) {
        boolean[][] bool = new boolean[intAdjMat.length][intAdjMat.length];
        for(int row=0; row<intAdjMat.length; ++row)
            for(int col=0; col<intAdjMat.length; ++col)
                bool[row][col] = ( intAdjMat[row][col]==1 ? true : false);
        return bool;
    }

    private static void showMatrix(int[][] matrix)
    {
    	  System.out.print("  ");
    	  for(int x=0; x<matrix.length; x++)
    	  	   System.out.printf("%4s", nodes[x]);
    	  System.out.println();
        for (int y = 0; y < matrix.length; y++)
        {
        	   System.out.print(nodes[y]+":");
            for (int x = 0; x < matrix[y].length; x++)
                System.out.printf("%4d", matrix[y][x]);
            System.out.println();
        }
    }
    
}