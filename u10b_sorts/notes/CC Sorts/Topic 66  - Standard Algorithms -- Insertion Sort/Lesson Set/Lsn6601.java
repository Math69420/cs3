//
//	CS2 - Lsn6601                                © 2015 - Cypress Creek HS
//
// 	   Thread:	Algoritm Analysis - Insertion Sort
//	Criterion:	Two List Insertion Sort Prerequisite
//	========================================================================
//
//
//
//
/*

	public Environment()
	{
		list 	= new int[]{1,4,9,10,12,20,22,50};		//	Must be pre-sorted
		addList = new int[]{25,75,3,14,66,8,19,2};
	}

	public void sort()
	{
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

public class Lsn6601{
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



