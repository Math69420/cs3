
//  Merge 2 - Another algorithm

package lesson;

import static java.lang.System.*;
import java.util.*;
import java.io.*;

public class Merge2{
	public static void main (String[] args)	{
		new Environment();
}}


class Environment
{
	int[] list = {75, -3, 99, 25, 52, 83, 12, 7, 38};
	int comparisons;
	int movement;
	int passes;

	public Environment()
	{
		run();
	}

	public void run()
	{
//		out.println( this );
		sort();
		out.println( this );
	}


	public void sort()
	{
		int n = list.length;
		int[] temp = new int[n];
		mergeSortHelper(list, 0, n-1,temp);
	}

	public void mergeSortHelper( int[] list, int low, int high, int[] temp)
	{
	    if(low < high)
	    {	
	    	int mid = (low + high)/2;
	    	mergeSortHelper(list,low,mid,temp);
	    	mergeSortHelper(list,mid+1,high,temp);
	    	merge(list,low,mid,high,temp); 
	    }
	}

	private void merge(int[] list, int low, int mid, int high, int[]temp)
	{
	   int x = low;
	   int y = mid + 1;
	   int z = low;
	   while(x <= mid && y <= high)
	   {
	 	if(list[x] < list[y])
	   	{
	   		temp[z] = list[y];
	   		x++;
	   	}
	   	else
	   	{
	   		temp[z] = list[y];
	   		y++;
	   	}
	   	z++;
	   }
	}


	public String toString()
	{
		String temp = "\n" + Arrays.toString(list) + "\n\n";
		temp += "MERGE SORT:\n";
		temp += "Swaps: " + (movement/3) + "\n";
		temp += "Passes: " + passes + "\n";
		temp += "Comparisons: " + comparisons + "\n";
		return temp;
	}
}



