///////////////////////////////////////////////////////////////////////////
//
//  *****   SELECTION SORT   *****
//
//  Java8301 Create a number object that stores an array of 20 integer values.
//			 Randomly create 20 integers in the range of 0 to 99.
//			 Assign the 20 integers to the array.  Sort the numbers using
//			 the selection sort.  Sort the numbers in descending order
//
// SAMPLE RANDOM DATA SET: 7 6 12 3 9 25 34 11 8 1 26 70 58 31 83 41 68 52 5 76
//
//          SAMPLE OUTPUT: Original List:
//                         --------------
//                         7 6 12 3 9 25 34 11 8 1 26 70 58 31 83 41 68 52 5 76
//
//                         Sorted List:
//                         --------------
//                         83 76 70 68 58 52 41 34 31 26 25 12 11 9 8 7 6 5 3 1
//
//

package solution;

import java.util.Random;
import static java.lang.System.*;

public class Java8301{
	public static void main (String args[]){
		new Environment().run();
}}


class Environment
{
	private int [] list;
	
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
		list = new int[20];
		
		//randomly generate a list of 20 integers from 0...99
	}	
	
	public void sort()
	{
		// code for selection sort
		
	}
	
	public String toString()
	{
		String buildString = "";
		
		for(int x=0; x<list.length; x++)
			buildString += String.format("%d ",list[x]);
				
		return buildString + "\n";
	}
}



