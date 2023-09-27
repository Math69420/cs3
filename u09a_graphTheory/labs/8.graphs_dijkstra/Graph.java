import java.util.*;
import java.io.*;

public class Graph {
   private int SIZE;
   private int[] cost;
   private int[] prev;
   private boolean[] done;
   private int currentNode;

   public void solve(int[][]matrix){
      int count = 1;
      this.SIZE = matrix.length;      
      //Initalize cost, previous, and visited arrays
   
   
   
      //Fill cost array with "infinity"
   
   
      /* Loop thru all nodes so that all have been visited
       * Nodes are numbered starting a zero, but will be displayed
       * such that node 0 displays as "A", node 1 as "B", etc.
       * This means your loop just iterates through 0, 1, etc.
       */
      for(  ){
        	//find the node with mininum cost and set as current node
      
      	// mark the current node as visited
      
      	//update the cheapest cost if applicable
      
         //displays arrays after each pass of the outer loop
         System.out.println("Verify: pass #"+count++);
         System.out.println(Arrays.toString(prev));
         System.out.println(Arrays.toString(visited));
         System.out.println(Arrays.toString(cost)+"\n");
      }   
      //displays the paths
      char letter = 'A';
      for(int i=1; i<SIZE;i++){
         System.out.print("Path from " + letter + " to " + (char)(i+65) + ":  ");
         if (cost[i] == Integer.MAX_VALUE)
            System.out.print(" does not exist.");
         int spot = i;
         String path = "" + (char)(i+65);
         do{
            spot = prev[spot];
            path = (char)(spot+65) + " -> " + path;
         }while(cost[spot] != 0);
         System.out.println(path);
      }
   
   
   }
   public static void main(String[] args) {
      Graph test = new Graph();
   	                                 //  A    B    C    D    E    F    G
      int[][] matrix = new int[][]{ 	{   0,   7,   0,   5,   0,   0,   0 },
         					         		{   7,   0,   8,   9,   7,   0,   0 },
         							         {   0,   8,   0,   0,   5,   0,   0 },
         							         {   5,   9,   0,   0,  15,   6,   0 },
         							         {   0,   7,   5,  15,   0,   8,   9 },
         							         {   0,   0,   0,   6,   8,   0,  11 },
         							         {   0,   0,   0,   0,   9,  11,   0 },
         						           };
                                      
          	                      		 //  A    B    C    D    E    F    G    H
      int[][] matrixTwo = new int[][]{  {   0,   6,   1,   3,   0,   0,   5,   0 },
         						          	 {   6,   0,   0,   0,   3,   0,   6,   3 },
         							          {   1,   0,   0,   1,   0,   0,   0,   0 },
         							          {   3,   0,   1,   0,   2,   8,   0,   0 },
         							          {   0,   3,   0,   2,   0,   0,   0,   4 },
         							          {   0,   0,   0,   8,   0,   0,   0,   5 },
         							          {   5,   6,   0,   0,   0,   0,   0,   0 },
         							          {   0,   3,   0,   0,   4,   5,   0,   0 },
         						            };
                                       
      System.out.println("Graph one:\n");
      test.solve(matrix);
      System.out.println("\nGraph two:\n");
      test.solve(matrixTwo);
   }
}
