//
//	CS2 - Lsn8606                                © 2015 - Cypress Creek HS
//
// 	   Thread:	Algoritm Analysis - Insertion Sort
//	Criterion:	One List Insertion Sort
//	========================================================================
//	Unlike with selection sort, the elements to the left of the pivot are not
//  necessarily in their final positions. Instead of placing elements into
//  their final positions, as selection sort does, insertion sort shifts one
//  element at a time into its proper position in the sorted part. No element
//  is guaranteed to be in its final position until the method finishes.
//
//
//
/*

	public void insertionSort()
	{
		for(int pivot=0; pivot<list.length; pivot++)
		{
			// Extract Target Data
			int entry 	= list[pivot];							// observe
			int loc 	= pivot;								// observe

			// Search
			{
				boolean found = false;

				for(int k=0; !found && k<pivot; k++)			// observe
					if( list[k] > entry )						//	Linear
					{											//	Search
						loc   = k;
						found = true;
					}
			}

			// Insert
			{
			    for(int i=pivot; i>loc; i--)					//	loop
			    	list[i] = list[i-1];						//	scoot
			    list[loc] = entry;								//	insert
			}
		}
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

public class Lsn6606{
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
		list 	= new int[]{50,44,92,10,17,22,20,1,25,75,3,14,86,8,19,2};
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
		for(pivot=0; pivot<list.length; pivot++)
		{
			// Extract Target Data
			int entry 	= list[pivot];							// observe
			int loc 	= pivot;								// observe

			// Search
			{
				boolean found = false;

				for(int k=0; !found && k<pivot; k++)			// observe
					if( list[k] > entry )						//	Linear
					{											//	Search
						loc   = k;
						found = true;
					}
			}

			// Insert											// WOW!!
			{													//	|
			    for(int i=pivot; i>loc; i--)					//	|
			    	list[i] = list[i-1];						//	|
			    list[loc] = entry;								//	V
			}
		}
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



