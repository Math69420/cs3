//
//	CS2 - Lsn6307                                         ©2015 - Cypress Creek HS
//
// 	   Thread:	Algorithms -- Linear Sorting
//	Criterion:	Last look at trace
//	========================================================================
//
//	NOTE:
//	1)	Observe the swaps and passes.
//
//	2) 	Working with ArrayLists
/*

	public void sort()
	{
      	for (int x=0; x< list.size()-1 ; x++)
        	for (int y= (x+1) ; y< list.size() ; y++)
        		if( list.get(x) > list.get(y) )
        		{
			  		Integer item1 = list.get(x);
			  		Integer item2 = list.get(y);

			  		list.set(x,item2);
			  		list.set(y,item1);
			  	}
	}

*/
//
//
//

package lesson;

import static java.lang.System.*;
import java.util.*;

public class Lsn6307{
	public static void main (String[] args){
		new Environment();
}}


class Environment
{
	private ArrayList<Integer> list;

	public Environment()
	{
		populate();
		run();
	}

	public void run()
	{
		out.println( );
		trace();
		out.println( );
	}

	public void sort()
	{
      	for (int x=0; x< list.size()-1 ; x++)
        	for (int y= (x+1) ; y< list.size() ; y++)
        		if( list.get(x) > list.get(y) )
        		{
			  		Integer item1 = list.get(x);
			  		Integer item2 = list.get(y);

			  		list.set(x,item2);
			  		list.set(y,item1);
			  	}
	}

	public void populate()
	{
		list = new ArrayList<Integer>
		(
			Arrays.asList( 25, 75, 3, 14, 84, 8, 19, 2, 33, 47 )
		);
	}

	public void trace()
	{
      	for (int x=0; x< list.size()-1 ; x++)
      	{
        	for (int y= (x+1) ; y< list.size() ; y++)
        	{
        		boolean swapped = false;
        		if( list.get(x) > list.get(y) )
        		{
			  		Integer item1 = list.get(x);
			  		Integer item2 = list.get(y);

			  		list.set(x,item2);
			  		list.set(y,item1);

			  		swapped = true;
			  	}

        		out.printf("%"+((x+1)*3)+"s","x");
        		out.printf("%"+((y+1-x)*3-3)+"s","y");
        		out.printf("%n");
        		out.printf("%"+((x+1)*3)+"s","|");
        		out.printf("%"+((y+1-x)*3-3)+"s","|");
        		out.printf("%n");
				String buildString = "";
				for(int z=0; z<list.size(); z++)
					buildString += String.format("%3d",list.get(z));
	        	out.print (buildString);

				if(swapped)
					out.printf("%s"," <----------------- items SWAPPED");

	        	out.print ("\n");
        		out.print ("------------------------");
        		out.print (" inside loop\n");
	        }

        	out.println("======================== OUTSIDE LOOP\n\n");
        }
	}

	public String toString()
	{
		return list + "\n";
	}
}

