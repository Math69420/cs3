///////////////////////////////////////////////////////////////////////////
//
//  *****   BUBBLE SORT   *****
//
//  Java8201 Create a number object that stores an array of 6 double values.
//			 Assign the 6 double values to the array at time of construction.
//			 Sort the values in descending order using the bubble sort.  Format
//			 the list to 2 decimal places.
//
//   SAMPLE DATA SET:  84.054  2.347  57.86  7.1  15.299  57.99
//
//            SAMPLE OUTPUT:  Original List:
//							  -------------
//							  84.05   2.35  57.86   7.10  15.30  57.99
//							  
//							  Sorted List:
//							  -----------
//							   2.35   7.10  15.30  57.86  57.99  84.05
//
//
//

// imports go here

public class Java8201{
	public static void main (String args[]){
		new Solution().run();
}}


class Solution
{
	private double [] list;
	
	public void run()
	{
		out.println("Original List:");
		out.println("-------------");
		// call toString() method here (original list)
		
		// call sort method here
		
		out.println("Sorted List:");
		out.println("-----------");
		// call toString() method here (sorted list)
	}

	public Solution()
	{
		// populate array at time of construction	
	}	
	
	public void sort()
	{
		// sort data using bubble sort algorithm
	}
	
	public String toString()
	{
		String buildString = "";
		
		for(int x=0; x<list.length; x++)
			buildString += // format to 2 decimal places
				
		return buildString + "\n";
	}
}



