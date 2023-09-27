//
//	CS2 - Lsn6713                                © 2005 - Cypress Creek HS
//
// 	   Thread:	Algoritm Analysis - Merge Sort
//	Criterion:	Importance of the pivot element
//	========================================================================
//
//
//
//
//
/*

	//                            /-------------------	pivot
	//                           /
	list 	= new int[]{1,4,12,22,2,3,8,9,10,14,19,20,25,50,75,84};


	public void sort()
	{
		//      /-----------------------------------------	first
		//     /  /---------------------------------------	pivot
		//    /  /    /-----------------------------------	last
		merge(0, 3, list.length-1);
	}

*/
//
//

package lesson;

import static java.lang.System.*;
import java.util.*;
import java.io.*;

public class Lsn6713{
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
		//                            /-------------------	pivot
		//                           /
		list 	= new int[]{1,4,12,22,2,3,8,9,10,14,19,20,25,50,75,84};
		pivot	= 3;
	}


	public void sort()
	{
		//      /-----------------------------------------	first
		//     /  /---------------------------------------	pivot
		//    /  /    /-----------------------------------	last
		merge(0, 3, list.length-1);
	}

	private void merge(int first, int pivot, int last)
	{
		int[] copy = new int[ list.length ];

		int x = first;								// front of list
		int y = pivot+1;							// back of list
		int z = first;								// copy

		while( x<=pivot && y<=last )				// length for both lists
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

		while( x<=pivot )							// front of list leftovers
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



