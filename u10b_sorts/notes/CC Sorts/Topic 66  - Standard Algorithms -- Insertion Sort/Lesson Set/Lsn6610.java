//
//	CS2 - Lsn6610                                © 2015 - Cypress Creek HS
//
// 	   Thread:	Algoritm Analysis - Insertion Sort
//	Criterion:	Consolidation
//	========================================================================
//
//
//			int entry 	= list[pivot];						1) Extract
//                        \         /						   Target Data
//                          \     /
//                            \ /
//                             |
//                   +---------+---------+
//                   |                   |
//			         |                   V
//			int loc  |	= binarySearch(entry, pivot);		2) Search
//			         |     \                       /
//                   |       \                   /
//                   |         \               /
//                   |           \           /
//                   |             \       /
//                   +----+          \   /
//                        |            |
//                        V            V
//			insertEntry(entry, pivot, loc);					3) Insert
//
//
//
/*

	public void sort()
	{
		for(int pivot=0; pivot<list.length; pivot++)
			insertEntry(list[pivot], pivot, binarySearch(list[pivot], pivot));
			//          |\_________/        \_____________________________/|
			//          |     |                            |               |
			//          |     +-- Extract Target Data      +-- Search      |
			//           \________________________________________________/
			//                                  |
			//                                  +-- Insert
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

*/
//
//
//
//

package lesson;

import static java.lang.System.*;
import java.util.*;
import java.io.*;

public class Lsn6610{
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
		pivot	= 0;
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






