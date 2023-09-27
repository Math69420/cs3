//
//	CS2 - Lsn6607                                © 2015 - Cypress Creek HS
//
// 	   Thread:	Algoritm Analysis - Insertion Sort
//	Criterion:	One List Insertion Sort - shorter version
//	========================================================================
//
//
//
//
/*

	public void sort()
	{
		for (int pivot = 1; pivot < list.length; pivot++)
		{
			// Extract Target Data
			int entry = list[pivot];
			int loc = pivot;

			// Linear Search COMBINED with scoot
			while (loc > 0 && entry < list[loc - 1])
			{
				list[loc] = list[loc - 1];
				loc--;
			}

			// insert
			list[loc] = entry;
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

public class Lsn6607{
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
		for (int pivot = 1; pivot < list.length; pivot++)
		{
			// Extract Target Data
			int entry = list[pivot];
			int loc = pivot;

			// Linear Search COMBINED with scoot
			while (loc > 0 && entry < list[loc - 1])
			{
				list[loc] = list[loc - 1];
				loc--;
			}

			// insert
			list[loc] = entry;
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






