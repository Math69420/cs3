import java.util.*;
import java.io.*;

public class Lab_10_Graph_Theory1_KEY
{
	int[][] graph3 = { { 0, 1, 1, 0 },
	                   { 1, 0, 0, 0 },
	                   { 0, 0, 0, 1 },
	                   { 0, 1, 0, 0 }};
	                   
	int[][] graph4 = { { 0, 0, 0, 1 },
	                   { 1, 0, 1, 1 },
	                   { 1, 1, 1, 0 },
	                   { 1, 1, 1, 0 }};
	                   
	int[][] graph5 = { { 0, 0, 1, 1 },
	                   { 1, 0, 1, 0 },
	                   { 1, 1, 0, 1 },
	                   { 0, 0, 1, 0 }};
	                   
	int[][] graph6 = { { 0, 1, 1, 1 },
	                   { 1, 0, 1, 0 },
	                   { 0, 0, 0, 1 },
	                   { 1, 1, 1, 0 }};
	                   	                   	                   	                                        
    public int[][] matPow(int[][] mat, int n) {
    	int[][] pow = identityMatrix(mat.length);
    	for(int i=0; i<n; ++i) {
    		pow = matrixMult(mat,pow);
    	}
    	return pow;
    }
  /*   
    public int[][] rightMatPow(int[][] mat, int n) {
    	int[][] pow = identityMatrix(mat.length);
    	for(int i=0; i<n; ++i) {
    		pow = matrixMult(pow,mat);
    	}
    	return pow;
    }
    */
    public int[][] identityMatrix(int n) {
    	int[][] identity = new int[n][n];
    	for(int i=0; i<n; ++i)
    		identity[i][i]=1;
    	return identity;
    }
                         
    public static void main(String[] args) throws IOException {
 		Lab_10_Graph_Theory1_KEY matrix = new Lab_10_Graph_Theory1_KEY();
 		matrix.output();
    }
    
    public void output() {

 		System.out.println("-------- Matrix 3 ^ 2  -----------");
		showMatrix(matPow(graph3,2));		
 		System.out.println("-------- Matrix 3 ^ 4 right multiplied -----------");
		showMatrix(matPow(graph3,4));		
		System.out.println();
 		System.out.println("-------- Matrix 4 ^ 2  -----------");
		showMatrix(matPow(graph4,2));		
 		System.out.println("-------- Matrix 4 ^ 4 right multiplied -----------");
		showMatrix(matPow(graph4,4));		
		System.out.println();
 		System.out.println("-------- Matrix 5 ^ 2  -----------");
		showMatrix(matPow(graph5,2));		
 		System.out.println("-------- Matrix 5 ^ 4 right multiplied -----------");
		showMatrix(matPow(graph5,4));		
		System.out.println();
 		System.out.println("-------- Matrix 6 ^ 2  -----------");
		showMatrix(matPow(graph6,2));		
 		System.out.println("-------- Matrix 6 ^ 3 right multiplied -----------");
		showMatrix(matPow(graph6,3));		
		System.out.println();
 	}

    public static int[][] matrixMult(int[][] a, int[][] b)
    {
        int height = a.length;
        int width = b[0].length;

 	    int[][] sol = new int[height][width];
 	    for (int row = 0; row < height; row++)
 	    {
 		    for (int col = 0; col < width; col++)
 		    {
 			    int sum = 0;
                for (int i = 0; i < a[0].length; i++)
                    sum = sum + a[row][i] * b[i][col];
 			    sol[row][col] = sum;
 		    }
 	    }
 	    return sol;
     }

    private static void showMatrix(int[][] matrix)
    {
 	    for (int y = 0; y < matrix.length; y++)
 	    {
 		    for (int x = 0; x < matrix[y].length; x++)
                System.out.printf("%4d", matrix[y][x]);
 		    System.out.println();
 	    }
    }
}