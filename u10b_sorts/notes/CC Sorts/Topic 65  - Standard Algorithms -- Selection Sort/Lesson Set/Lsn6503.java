//
//	CS2 - Lsn8503                                © 2006 - Cypress Creek H.S.
//												   2013 - edited by N. Waterman
// 	   Thread:	Algorithms -- Selection Sorting
//	Criterion:	Implement a single swap
//	========================================================================
//
//	NOTE:
//	1)	The selection sort is very efficient because it minimizes the
//		number of swaps.  It performs only one.
//
/*

	public void sort()
	{
		int index;
		for (int x=0; x<list.size()-1; x++)
		{
 			index = x;
			for (int y=x+1; y<list.size(); y++)
				if (list.get(y) < list.get(index) )
					index = y;

	        {	// SWAP
		  		Integer item1 = list.get(x);
		  		Integer item2 = list.get(index);
		  		list.set(x,item2);
		  		list.set(index,item1);
		  	}
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

public class Lsn8503{
	public static void main (String[] args)	{
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
		out.println();
		trace();
		out.println();
	}

	public void sort()
	{
		int index;
		for (int x=0; x<list.size()-1; x++)
		{
 			index = x;
			for (int y=x+1; y<list.size(); y++)
				if (list.get(y) < list.get(index) )
					index = y;

	        {	// SWAP
		  		Integer item1 = list.get(x);
		  		Integer item2 = list.get(index);
		  		list.set(x,item2);
		  		list.set(index,item1);
		  	}
		}
	}

	public void trace()
	{
		int index;
		for (int x=0; x<list.size()-1; x++)
		{
 			index = x;

			for (int y=x+1; y<list.size(); y++)
				if (list.get(y) < list.get(index) )
					index = y;

	        {	// SWAP
		  		Integer item1 = list.get(x);
		  		Integer item2 = list.get(index);
		  		list.set(x,item2);
		  		list.set(index,item1);
		  	}

    		out.printf("%"+((x+1)*3-1)+"s","x");
    		out.printf("%"+((index+1)*3-((x+1)*3-1))+"s","S");
    		out.printf("%n");
    		out.printf("%"+((x+1)*3-1)+"s","|");
    		out.printf("%"+((index+1)*3-((x+1)*3-1))+"s","|");
    		out.printf("%n");
			String buildString = "";
			for(int k=0; k<list.size(); k++)
				buildString += String.format("%3d",list.get(k));
        	out.print (buildString + "");
			out.printf("%s"," <----------------- items SWAPPED");
	   		out.print ("\n");
			out.print ("------------------------");
    		out.print (" inside loop\n");


        	out.print("======================== ");
        	out.print("OUTSIDE LOOP <---- outer PASS\n\n\n");
		}
	}

	public void populate()
	{
		list = new ArrayList<Integer>
		(
			Arrays.asList( 2, 75, 3, 14, 84, 8, 25, 19 )
		);
	}

	public String toString()
	{
		return list + "\n";
	}
}

