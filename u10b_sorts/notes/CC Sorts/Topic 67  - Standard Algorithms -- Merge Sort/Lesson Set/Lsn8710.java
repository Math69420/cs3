//
//	CS2 - Lsn8710                                � 2005 - Tom Halbert
//
// 	   Thread:	Algoritm Analysis - Merge Sort
//	Criterion:	Tracking Indices for One List Merge Sort
//	========================================================================
//
// This program demonstrates how to merge two sorted halves
// of one array into one totally sorted array.
//
//
/*

	private void merge(int first, int pivot, int last)
	{
		int[] copy = new int[ list.length ];

		int x = first;								// front of list
		int y = pivot+1;							// back of list
		int z = first;								// copy

		list = copy;
	}

*/
//
//

package lesson;

import static java.lang.System.*;
import java.util.*;
import java.io.*;

public class Lsn8710{
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
		//                                       /--------	pivot
		//                                      /
		list 	= new int[]{1,4,9,10,12,20,22,50,2,3,8,14,19,25,75,84};
		pivot	= 7;
	}


	public void sort()
	{
		//      /-----------------------------------------	first
		//     /  /---------------------------------------	pivot
		//    /  /    /-----------------------------------	last
		merge(0, 7, list.length-1);
	}

	private void merge(int first, int pivot, int last)
	{
		int[] copy = new int[ list.length ];

		int x = first;								// front of list
		int y = pivot+1;							// back of list
		int z = first;								// copy

		list = copy;
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


