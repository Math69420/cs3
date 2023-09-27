//© A+ Computer Science
// www.apluscompsci.com

//Matrix instantiation example

import static java.lang.System.*;

public class MatrixTwo
{
	public static void main(String args[])
	{
		//java allows the [][] to be placed by the type or by the name
		//int[][] mat or int mat[][]
		
		int mat[][] = {{5,7,9,2},
							{5,3,4,6},
							{7,0,8,9}};

		out.println(mat[2][1]);
		out.println(mat[1][2]);
		out.println(mat.length);
		out.println(mat[0].length);
	}
}