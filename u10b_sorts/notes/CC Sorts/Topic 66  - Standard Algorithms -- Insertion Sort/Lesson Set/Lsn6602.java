//
//	CS2 - Lsn6602                                © 2015 - Cypress Creek HS
//
// 	   Thread:	Algoritm Analysis - Insertion Sort
//	Criterion:	Two List Insertion Sort
//	========================================================================
//
//
//
//
/*

	public void sort()
	{
		for(int x=0; x<addList.length; x++)
		{
			// Extract Target Data
			int entry = addList[x];
			int loc   = list.length;

			// Search where it goes
			{
				boolean found = false;

				for(int k=0; !found && k<list.length; k++)
					if( list[k] > entry )
					{
						loc   = k;
						found = true;
					}
			}

			// Insert
			{
				int[] buildArray = new int[ list.length+1 ];

				System.arraycopy(list,0,buildArray,0,loc);
				buildArray[loc] = entry;
				System.arraycopy(list,loc,buildArray,loc+1,list.length-loc);

				list = buildArray;
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

public class Lsn6602{
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

	public void populate()
	{
		list 	= new int[]{1,4,9,10,12,20,22,50};		//	Must be pre-sorted
		addList = new int[]{25,75,3,14,66,8,19,2};
	}
	public void run()
	{
		out.println( this );
		sort();
		out.println( this );
	}



	public void sort()
	{
		for(int x=0; x<addList.length; x++)
		{
			// Extract Target Data
			int entry = addList[x];
			int loc   = list.length;

			// Search where it goes
			{
				boolean found = false;

				for(int k=0; !found && k<list.length; k++)
					if( list[k] > entry )
					{
						loc   = k;
						found = true;
					}
			}

			// Insert
			{
				int[] buildArray = new int[ list.length+1 ];

				System.arraycopy(list,0,buildArray,0,loc);
				buildArray[loc] = entry;
				System.arraycopy(list,loc,buildArray,loc+1,list.length-loc);

				list = buildArray;
			}
		}
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







