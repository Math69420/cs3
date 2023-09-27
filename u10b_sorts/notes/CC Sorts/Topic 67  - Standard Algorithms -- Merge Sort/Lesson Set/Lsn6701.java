//
//	CS2 - Lsn6701                                © 2005 - Cypress Creek HS
//
// 	   Thread:	Algoritm Analysis - Merge Sort
//	Criterion:	Two List Merge Sort Prerequisite
//	========================================================================
//
//	Pre-Requisite: Both lists must be in order.
//
//
/*

	public void populate()
	{
		list 	= new int[]{1,4,9,10,12,20,22,50};
		addList = new int[]{2,3,8,14,19,25,75,84};
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

public class Lsn6701{
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
		list 	= new int[]{1,4,9,10,12,20,22,50};		//	Both lists must be in order.
		addList = new int[]{2,3,8,14,19,25,75,84};
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



