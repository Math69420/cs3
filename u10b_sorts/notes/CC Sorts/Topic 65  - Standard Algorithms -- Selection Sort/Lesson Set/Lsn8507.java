//
//	CS2 - Lsn8507                                � 2006 - Cypress Creek H.S.
//
// 	   Thread:	Algorithms -- Selection Sorting
//	Criterion:	BEST Case efficiency
//	========================================================================
//
//	Note:
//	1)	What if array is almost in order?
//
//
//		+----+----+----+----+----+----+----+----+
//		|  4 |  2 |  5 |  8 |  9 | 12 | 27 | 21 |
//		+----+----+----+----+----+----+----+----+
//		   0    1    2    3    4    5    6    7
//
//
//	2)	Order of Magnitude Analysis - BEST Case
//
//         2
//		  n
/*

		for (int x=0; x<list.size()-1; x++)
		{
			for (int y=x+1; y<list.size(); y++)

			...
		}

*/
//
//
//

package lesson;

import static java.lang.System.*;
import java.util.*;

public class Lsn8507{
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

    		out.printf("%"+((x+1)*3-1)+"s","x");
    		out.printf("%"+((index+1)*3-((x+1)*3-1))+"s","S");
    		out.printf("%n");
    		out.printf("%"+((x+1)*3-1)+"s","|");
    		out.printf("%"+((index+1)*3-((x+1)*3-1))+"s","|");
    		out.printf("%n");
			String buildString = "";
			for(int k=0; k<list.size(); k++)
				buildString += String.format("%3d",list.get(k));
        	out.print (buildString);
			out.printf("%s"," <----------------- items SWAPPED");
	   		out.print ("\n");
			out.print ("------------------------");
    		out.print (" inside loop\n");

	        {	// SWAP
		  		Integer item1 = list.get(x);
		  		Integer item2 = list.get(index);
		  		list.set(x,item2);
		  		list.set(index,item1);
		  	}

        	out.print("======================== ");
        	out.print("OUTSIDE LOOP <---- outer PASS\n\n\n");
		}
	}

	public void populate()
	{
		list = new ArrayList<Integer>
		(
			Arrays.asList( 4, 2, 5, 8, 9, 12, 27, 21 )
		);
	}

	public String toString()
	{
		return list + "\n";
	}
}

