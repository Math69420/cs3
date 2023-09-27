//
//	CS2 - Lsn6605                                © 2015 - Cypress Creek HS
//
// 	   Thread:	Algoritm Analysis - Insertion Sort
//	Criterion:	Pivot starting location
//	========================================================================
//
//	Assume there is nothing sorted.  Start pivot at first element.
//
//
/*
                            +-- Pivot
	public void populate()  |
	{                       V
		list 	= new int[]{50,44,92,10,17,22,20,1,25,75,3,14,66,8,19,2};
		pivot	= 0;
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

public class Lsn6605{
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




