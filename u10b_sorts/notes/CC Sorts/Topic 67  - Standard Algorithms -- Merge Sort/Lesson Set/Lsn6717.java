//
//	CS2 - Lsn6717                                � 2005 - Cypress Creek HS
//
// 	   Thread:	Algoritm Analysis - Merge Sort
//	Criterion:	Recursive Merge Sort
//	========================================================================
//
// 	This program demonstrates the Merge Sort program.
// 	Note that it is a combination of an "iterative" <merge>
// 	This <mergeSort> implementation suffers an execution penalty because a
//	local, temporary, array is created and destroyed many times.
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

	private void merge(int first, int mid, int last)
	{
		int[] copy = new int[ list.length ];

		int x = first;								// front of list
		int y = mid+1;								// back of list
		int z = first;								// copy

		while( x<=mid && y<=last )					// length for both lists
			if( list[x] <= list[y] )
			{
				copy[z] = list[x];
				x++;
				z++;
			}
			else
			{
				copy[z] = list[y];
				y++;
				z++;
			}

		while( x<=mid )								// front of list leftovers
		{
			copy[z] = list[x];
			x++;
			z++;
		}

		while( y<=last )							// back of list leftovers
		{
			copy[z] = list[y];
			y++;
			z++;
		}

//		list = copy;
		for (int h = first; h <= last; h++)
			list[h] = copy[h];
	}

*/
//
//

package lesson;

import static java.lang.System.*;
import java.util.*;
import java.io.*;

public class Lsn6717{
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

	private void merge(int first, int mid, int last)
	{
		int[] copy = new int[ list.length ];

		int x = first;								// front of list
		int y = mid+1;								// back of list
		int z = first;								// copy

		while( x<=mid && y<=last )					// length for both lists
			if( list[x] <= list[y] )
			{
				copy[z] = list[x];
				x++;
				z++;
			}
			else
			{
				copy[z] = list[y];
				y++;
				z++;
			}

		while( x<=mid )								// front of list leftovers
		{
			copy[z] = list[x];
			x++;
			z++;
		}

		while( y<=last )							// back of list leftovers
		{
			copy[z] = list[y];
			y++;
			z++;
		}

//		list = copy;
		for (int h = first; h <= last; h++)
			list[h] = copy[h];
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



