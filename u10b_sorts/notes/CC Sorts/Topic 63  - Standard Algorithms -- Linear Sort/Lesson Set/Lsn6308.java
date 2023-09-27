//
//	CS2 - Lsn6308                                         ©2015 - Cypress Creek HS
//
// 	   Thread:	Algorithms -- Linear Sorting
//	Criterion:	Working with arrays
//	========================================================================
//
//	NOTE:
//	1)	Review - Array populated from data file input
//
//	2) 	Working with arrays
/*

	public void sort()
	{
      	for (int x=0; x< list.length-1 ; x++)
        	for (int y= (x+1) ; y< list.length ; y++)
        		if( list[x] > list[y] )
        		{

              		int temp = list[x];
              		list[x]  = list[y];
              		list[y]  = temp;

			  	}
	}

*/
//
//

package lesson;

import static java.lang.System.*;
import java.util.*;
import java.io.*;


public class Lsn6308{
	public static void main (String[] args){
		new Environment();
}}


class Environment
{
	private int[] list;

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

	public void sort()
	{
      	for (int x=0; x < list.length-1 ; x++)
        	for (int y=(x+1); y < list.length; y++)
        		if( list[x] > list[y] )
        		{
              		int temp = list[x];
              		list[x]  = list[y];
              		list[y]  = temp;
			  	}
	}

	public void populate()
	{
		try
		{
			Scanner fileScan = new Scanner( new File( "Lsn6308a.dat" ));

			ArrayList<Integer> tempList= new ArrayList<Integer>();
			while( fileScan.hasNext() )
				tempList.add( fileScan.nextInt() );

			list = new int[ tempList.size() ];

			for(int x=0; x< list.length; x++)
				list[x] = tempList.get(x);
		}
		catch(Exception e)
		{}
	}

	public String toString()
	{
		return Arrays.toString(list) + "\n";
	}
}

















