//
//	CS2 - Lsn6604                                © 2015 - Cypress Creek HS
//
// 	   Thread:	Algoritm Analysis - Insertion Sort
//	Criterion:	Pivot Element in a One List Insertion Sort
//	========================================================================
//
//	Everything before the pivot element is in sorted order.
//
//
/*
                                                  +-- Pivot
	public Environment()                          |
	{                                             V
		list 	= new int[]{1,4,9,10,12,20,22,50,25,75,3,14,66,8,19,2};
		pivot	= 8;
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

public class Lsn6604{
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
//                                               +--pivot
//                           +----sorted----+    |
//                          /                \   V
		list 	= new int[]{1,4,9,10,12,20,22,50,25,75,3,14,66,8,19,2};
		pivot	= 8;
	}

	public void run()
	{
		out.println( this );
		sort();
		out.println( this );
	}


	public void sort()
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





