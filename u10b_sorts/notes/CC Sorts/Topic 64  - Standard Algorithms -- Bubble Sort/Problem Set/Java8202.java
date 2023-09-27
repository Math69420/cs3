///////////////////////////////////////////////////////////////////////////
//
//  *****   BUBBLE SORT   *****
//
//  Java8202 Create a number object that stores an array of 10 integer values.
//			 Randomly create 10 integers in the range of 150 to 250.
//			 Assign the 10 integers to the array.  Sort the numbers using
//			 the bubble sort.  Sort the numbers in ascending order
//
//   SAMPLE RANDOM DATA SET:  180 248 220 282 194 163 202 151 199 216
//
//            SAMPLE OUTPUT:  Original List:
//                            --------------
//                            180 248 220 282 194 163 202 151 199 216
//
//                            Sorted List:
//                            ------------
//                            151 163 180 194 199 202 216 220 282 248
//
//
// ****************************************************************************
// *        NOTE:  BECAUSE THE LIST IS RANDOMLY GENERATED, YOU WILL NOT       *
// *        GENERATE THE SAME NUMBERS AS THE SAMPLE!                          *
// **************************************************************************** 

// imports
import java.util.*;
import static java.lang.System.*;
public class Java8202{
	public static void main (String args[]){
		new Solution().run();
}}


class Solution
{
	private int [] list = new int[10];

	public void run()
	{
		out.println("Original List:");
		out.println("-------------");
		out.println(this);
		
		sort();
		
		out.println("Sorted List:");
		out.println("-----------");
		out.println(this);
	}

	public Solution()
	{
		for(int x=1;x<11;x++)
		{
			list[x-1]=  new Random().nextInt(x*111);
		}
	}	
	
	public void sort()
	{
		boolean sorted =false;
		while(!sorted)
		{
			sorted=true;
			for(int x=0;x<list.length-1;x++)
			{
				if(list[x]>list[x+1])
				{
				  sorted=false;
				  int temp = list[x];
				  list[x] = list[x+1];
				  list[x+1]=temp;
				  	
				}
				
			}
		}
	}
	
	public String toString()
	{
		String temp ="";
		for(int x=0;x<list.length;x++)
			temp+=list[x] + " ";
		return temp;
	}
}



