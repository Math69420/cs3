//
//	CS2 - Lsn6614                                © 2015 - Cypress Creek HS
//
// 	   Thread:	Algoritm Analysis - Insertion Sort
//	Criterion:	Order of Magnitude Analysis - WORST Case
//	========================================================================
//
//                                     2
//		Using Sequential Search  ->   n
//
//
//		Using Binary Search      ->   n log n
//

package lesson;

import static java.lang.System.*;
import java.util.*;
import java.io.*;

public class Lsn6612{
	public static void main (String[] args)	{
		new Environment();
}}


class Environment
{
	private int[] list;
	private int pivot;

	public Environment()
	{
		populate();
		run();
	}

	public void populate()
	{
		list 	= new int[]{50,44,92,10,17,22,20,1,25,75,3,14,66,8,19,2};
		pivot	= 7;
	}

	public void run()
	{
		out.println( this );
		sort();
		out.println( this );
	}


	public void sort()
	{
		for(int pivot=0; pivot<list.length; pivot++)
			insertEntry(list[pivot], pivot, binarySearch(list[pivot], pivot));
	}

	private int binarySearch (int target, int pivot)
	{
  		int lo  = 0;
  		int mid = pivot;
  		int hi  = pivot;
  		while (lo <= hi)
  		{
    		mid = (lo+hi) / 2;
    		if (target > list[mid]) 			lo = mid+1;
    			else if (target < list[mid])	hi = mid-1;
      				else	        			break;
      		mid = lo;
		}
 		return mid;
	}

	private void insertEntry(int key, int pivot, int loc)
	{
	    for(int i=pivot; i>loc; i--)
	    	list[i] = list[i-1];
	    list[loc] = key;
	}


	public String toString()
	{
		String build = "";

		for(int x=0; x<list.length; x++)
			build += String.format("%4d",list[x]);

		return build + "\n\n";
	}
}






