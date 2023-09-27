//
//	CS2 - Lsn6402                                © 2006 - Cypress Creek H.S.
//
// 	   Thread:	Algorithms -- Bubble Sorting
//	Criterion:	Iteration logic
//	========================================================================
//
//	NOTE:
//	1)	In a bubble sort, the ADJACENT items are compared all the way
//		down the list.
//
//		Before Sorting
//		==============
//
//		+----+----+----+----+----+----+----+----+
//		| 25 | 75 |  3 | 14 | 64 |  8 | 19 |  2 |
//		+----+----+----+----+----+----+----+----+
//		   0    1    2    3    4    5    6    7
//
//
//		After First Iteration
//		=====================
//
//          x x+1
//          |  : x x+1
//          |  : |  : x x+1
//          |  : |  : |  : x x+1
//          |  : |  : |  : |  : x x+1
//          |  : |  : |  : |  : |  : x x+1
//          |  : |  : |  : |  : |  : |  : x x+1
//          |  : |  : |  : |  : |  : |  : |  :
//          V  v V  v V  v V  v V  v V  v V  v
//		+----+----+----+----+----+----+----+----+
//		| 25 |  3 | 14 | 75 |  8 | 19 |  2 | 64 |
//		+----+----+----+----+----+----+----+----+
//		   0    1    2    3    4    5    6    7
//
//
//	OBSERVE:
//		-> Check the boundary conditions of the control loops.
//
//
//

package lesson;

import static java.lang.System.*;
import java.util.*;

public class Lsn6402{
	public static void main (String[] args)	{
		new Environment();
}}


class Environment
{
	private ArrayList<Integer> list;

	Environment()
	{
		populate();
		run();
	}

	public void run()
	{
		out.println();
		trace();
		out.println( );
	}


	public void sort()
	{
// 		boolean finished = false;
// 		while (    ?    )
//    	{
//  		finished = true;
//     		for (int x=0; x<    ?    ; x++)
//     		{
//
//	        }
//
//    	}
	}


	public void trace()
	{
  		boolean finished;
      	int temp;

  		finished = false;
  		while (!finished)
    	{
     		finished = true;
      		for (int x=0; x<list.size()-1; x++)
      		{
        		out.printf("%"+((x+1)*3)+"s","x");
        		out.printf("%"+((x+1-x)*3+1)+"s","x+1");
        		out.printf("%n");
        		out.printf("%"+((x+1)*3)+"s","|");
        		out.printf("%"+((x+1-x)*3)+"s","|");
        		out.printf("%n");
				String buildString = "";
				for(int k=0; k<list.size(); k++)
					buildString += String.format("%3d",list.get(k));
	        	out.print (buildString + "\n");
        		out.print ("------------------------");
        		out.print (" inside loop\n");
	        }

        	out.println("======================== OUTSIDE LOOP\n\n");
    	}
	}

	public void populate()
	{
		list = new ArrayList<Integer>();

		for(int x=0; x<8; x++)
			list.add( (int)(Math.random()*100) );
	}

	public String toString()
	{
		return list + "\n";
	}
}

