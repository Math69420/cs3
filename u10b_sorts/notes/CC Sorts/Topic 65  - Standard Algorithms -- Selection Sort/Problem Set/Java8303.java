///////////////////////////////////////////////////////////////////////////
//
//  *****   SELECTION SORT   *****
//
//  Java8303 Ask the user how many real numbers they want to randomly generate.
//			 Generate the number of items and store in an array. Sort the 
//			 random data set in ascending order. Format the numbers to one 
//			 decimal place.
//
//  SAMPLE DATA KEYBOARD INPUT:  How many items? ==> 12
//
//  SAMPLE OUTPUT:
//  	Original List:
//  	-------------
//  	58.3  82.5  34.2  4.9  82.9  54.7  56.7  50.9  1.2  25.1  1.2  83.6
//  	
//  	Sorted List:
//  	-----------
//  	1.2  1.2  4.9  25.1  34.2  50.9  54.7  56.7  58.3  82.5  82.9  83.6
//                                 
//
//
//

package solution;

import java.util.*;
import java.io.*;

import static java.lang.System.*;

public class Java8303{
	public static void main (String args[]){
		new Environment().run();
}}


class Environment
{
	private double[] list;
	
	public void run()
	{
		out.println("Original List:");
		out.println("-------------");
		out.println( this );
		sort();
		out.println("Sorted List:");
		out.println("-----------");
		out.println( this );
	}

	public Environment()
	{
		Scanner scan = new Scanner(in);
		out.println("How many items? ==>");
		int size = scan.nextInt();
		list = new double[size];

		/* Generate a list of random doubles.  Hint:  nextDouble() generates a
		 * random decimal number between 0 and 1! */
		 
		 
	}
	
	public void sort()
	{
		
	}
	
	public String toString()
	{
		
	}
}








