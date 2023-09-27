//
//	CS2 - Lsn6406                                © 2006 - Cypress Creek H.S.
//
// 	   Thread:	Algorithms -- Bubble Sorting
//	Criterion:	Ascending vs Descending
//	========================================================================
//
//	NOTE:
//	1)	Change direction of sort
//		- descending to ascending
//
//	2)	What effect does increasing the amount of data have on the sort?
//
//
//

package lesson;

import static java.lang.System.*;
import java.util.*;

public class Lsn6406{
	public static void main (String[] args)	{
		new Environment();
}}


class Environment
{
	private ArrayList<Integer> list;
	private int size;

	Environment()
	{
		size = 10;										// What happens if you
		populate();										// sort 10000 items?
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
 		boolean finished = false;
  		int backEnd  = list.size()-1;
 		while ( !finished )
    	{
	  		finished = true;
     		for (int x=0; x<  backEnd  ; x++)
     		{
	       		if ( list.get(x) < list.get(x+1) )		// Change direction
          		{
			  		Integer item1 = list.get(x);
			  		Integer item2 = list.get(x+1);
			  		list.set(x,item2);
			  		list.set(x+1,item1);
            		finished  = false;
          		}
	        }
			backEnd--;
	   	}
	}


	public void populate()
	{
		list = new ArrayList<Integer>();

		for(int x=0; x<size; x++)
			list.add( (int)(Math.random()*100) );
	}

	public String toString()
	{
		return list + "\n";
	}
}

