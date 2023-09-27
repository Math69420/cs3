//
//	CS2 - Lsn6716                                © 2005 - Cypress Creek HS
//
// 	   Thread:	Algoritm Analysis - Merge Sort
//	Criterion:	Recursive Merge Sort
//	========================================================================
//
//                                                                   length
//               0   1   2   3   4   5   6   7   8   9   10  11  12 = (13)
//	           +---+---+---+---+---+---+---+---+---+---+---+---+---+
//	           |  8|  2|  5| 13|  4| 19| 12|  6|  3| 11| 10|  7|  9|
//	           +---+---+---+---+---+---+---+---+---+---+---+---+---+
//	        +---+---+---+---+---+---+---+    +---+---+---+---+---+---+
//	        |  8|  2|  5| 13|  4| 19| 12|    |  6|  3| 11| 10|  7|  9|
//	        +---+---+---+---+---+---+---+    +---+---+---+---+---+---+
//	    +---+---+---+---+ +---+---+---+        +---+---+---+ +---+---+---+
//	    |  8|  2|  5| 13| |  4| 19| 12|        |  6|  3| 11| | 10|  7|  9|
//	    +---+---+---+---+ +---+---+---+        +---+---+---+ +---+---+---+
//  +---+---+ +---+---+    +---+---+ +---+  +---+---+ +---+   +---+---+ +---+
//  |  8|  2| |  5| 13|    |  4| 19| | 12|  |  6|  3| | 11|   | 10|  7| |  9|
//  +---+---+ +---+---+    +---+---+ +---+  +---+---+ +---+   +---+---+ +---+
// +---++---+ +---++---+  +---++---+ +---+  +---++---+ +---+  +---++---+ +---+
// |  8||  2| |  5|| 13|  |  4|| 19| | 12|  |  6||  3| | 11|  | 10||  7| |  9|
// +---++---+ +---++---+  +---++---+ +---+  +---++---+ +---+  +---++---+ +---+
//
//							      NOW  MERGE
//
//  +---+---+ +---+---+    +---+---+ +---+  +---+---+ +---+   +---+---+ +---+
//  |  2|  8| |  5| 13|    |  4| 19| | 12|  |  3|  6| | 11|   |  7| 10| |  9|
//  +---+---+ +---+---+    +---+---+ +---+  +---+---+ +---+   +---+---+ +---+
//	    +---+---+---+---+ +---+---+---+        +---+---+---+ +---+---+---+
//	    |  2|  5|  8| 13| |  4| 12| 19|        |  3|  6| 11| |  7|  9| 10|
//	    +---+---+---+---+ +---+---+---+        +---+---+---+ +---+---+---+
//	        +---+---+---+---+---+---+---+    +---+---+---+---+---+---+
//	        |  2|  4|  5|  8| 12| 13| 19|    |  3|  6|  7|  9| 10| 11|
//	        +---+---+---+---+---+---+---+    +---+---+---+---+---+---+
//	           +---+---+---+---+---+---+---+---+---+---+---+---+---+
//	           |  2|  3|  4|  5|  6|  7|  8|  9| 10| 11| 12| 13| 19|
//	           +---+---+---+---+---+---+---+---+---+---+---+---+---+
//
//
//
/*

	public void sort()
	{
		sort(0, list.length-1);
	}

	private void sort(int first, int last)
	{
		if(first < last)
		{
			int mid = (first+last)/2;

			sort  (first, mid);
			sort  (mid+1,last);
			merge (first,mid,last);
		}
	}

	private void merge(int first, int pivot, int last)
	{
	}

*/
//
//

package lesson;

import static java.lang.System.*;
import java.util.*;
import java.io.*;

public class Lsn6716{
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

	public void run()
	{
		out.println( this );
		sort();
		out.println( this );
	}

	public void populate()
	{
		//                                         /------	pivot
		//                                        /
		list 	= new int[]{50,44,92,10,17,22,20,1,25,75,3,14,84,8,19,2};
		pivot	= list.length/2;
	}


	public void sort()
	{
		sort(0, list.length-1);
	}

	private void sort(int first, int last)
	{
		if(first < last)
		{
			int mid = (first+last)/2;

			sort  (first, mid);
			sort  (mid+1,last);
			merge (first,mid,last);
		}
	}

	private void merge(int first, int pivot, int last)
	{
	}


	public String toString()
	{
		String build = "";

		build += String.format("%"+(4*(pivot+1))+"s-- Pivot\n","+");
		build += String.format("%"+(4*(pivot+1))+"s\n","|");
		build += String.format("%"+(4*(pivot+1))+"s\n","V");
		for(int x=0; x<list.length; x++)
			build += String.format("%4d",list[x]);

		return build + "\n\n";
	}
}



