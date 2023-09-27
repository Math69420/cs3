//
//	CS2 - Lsn6706                                © 2005 - Cypress Creek HS
//
// 	   Thread:	Algoritm Analysis - Merge Sort
//	Criterion:	ArrayIndexOutOfBoundsException
//	========================================================================
//
//	Switched the data lists to see a problem.
//
//
/*
		list    = new int[]{2,3,8,14,19,25,75,84};
		addList = new int[]{1,4,9,10,12,20,22,50};


	public void sort()
	{
		int[] copy = new int[ list.length +  addList.length ];

		int x = 0;									// list
		int y = 0;									// addList
		int z = 0;									// copy

		while( x<list.length )
			if( list[x] <= addList[y] )
			{
				copy[z] = list[x];
				x++;
				z++;
			}
			else
			{
				copy[z] = addList[y];
				y++;
				z++;
			}

		list = copy;
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

public class Lsn6706{
	public static void main (String[] args)	{
		new Environment();
}}


class Environment
{
	private int[] list;
	private int[] addList;

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
		list    = new int[]{2,3,8,14,19,25,75,84};
		addList = new int[]{1,4,9,10,12,20,22,50};
	}


	public void sort()
	{
		int[] copy = new int[ list.length +  addList.length ];

		int x = 0;									// list
		int y = 0;									// addList
		int z = 0;									// copy

		while( x<list.length )
			if( list[x] <= addList[y] )
			{
				copy[z] = list[x];
				x++;
				z++;
			}
			else
			{
				copy[z] = addList[y];
				y++;
				z++;
			}

		list = copy;
	}


	public String toString()
	{
		String build = "";

		for(int x=0; x<list.length; x++)
			build += String.format("%4d",list[x]);
		build += "\n";
		for(int x=0; x<addList.length; x++)
			build += String.format("%4d",addList[x]);

		return build + "\n";
	}
}



