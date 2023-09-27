//
//	CS2 - Lsn8708                                © 2005 - Tom Halbert
//
// 	   Thread:	Algoritm Analysis - Merge Sort
//	Criterion:	Taking care of Loft-over data items
//	========================================================================
//
//	Switched the data lists to see a problem.
//
//
/*

	public void sort()
	{
		int[] copy = new int[ list.length +  addList.length ];

		int x = 0;									// list
		int y = 0;									// addList
		int z = 0;									// copy

		while( x<list.length && y<addList.length )	// Length for both lists
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

		while( x<list.length )						// list left-overs
		{
			copy[z] = list[x];
			x++;
			z++;
		}

		while( y<addList.length )					// addList left-overs
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

public class Lsn8708{
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
		list 	= new int[]{1,4,9,10,12,20,22,50};
		addList = new int[]{2,3,8,14,19,25,75,84};
	}


	public void sort()
	{
		int[] copy = new int[ list.length +  addList.length ];

		int x = 0;									// list
		int y = 0;									// addList
		int z = 0;									// copy

		while( x<list.length && y<addList.length )	// Length for both lists
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

		while( x<list.length )						// list left-overs
		{
			copy[z] = list[x];
			x++;
			z++;
		}

		while( y<addList.length )					// addList left-overs
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



