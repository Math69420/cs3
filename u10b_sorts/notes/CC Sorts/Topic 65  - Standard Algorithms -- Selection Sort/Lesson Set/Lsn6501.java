//
//	CS2 - Lsn8501                                © 2006 - Cypress Creek H.S.
//
// 	   Thread:	Algorithms -- Selection Sorting
//	Criterion:	Iteration logic
//	========================================================================
//
//	NOTE:
//	1)	The iteration of the selection sort is identical to the iteration
//		logic of the linear sort.
//
//
//		The First Iteration
//		=====================
//
//         x    y
//         |    +----+----+----+----+----+----+
//         V    :    :    :    :    :    :    :
//		+----+----+----+----+----+----+----+----+
//		|  2 | 75 |  3 | 14 | 84 |  8 | 25 | 19 |
//		+----+----+----+----+----+----+----+----+
//		   0    1    2    3    4    5    6    7
//
//
//	OBSERVE:
//		-> Check the boundary conditions of the control loops.
//
//
//
//

package lesson;

import static java.lang.System.*;
import java.util.*;

public class Lsn8501{
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
//		int index;
//		for (int x=0; x<   ?   ; x++)
//		{
// 			index = x;
//			for (int y=   ?   ; y<   ?   ; y++)
//			{
//			}
//
//		}
	}


	public void trace()
	{
		int index;
		int temp;

		for (int x=0; x<list.size()-1; x++)
		{
 			index = x;

			for (int y=x+1; y<list.size(); y++)
			{
        		out.printf("%"+((x+1)*3)+"s","x");
        		out.printf("%"+((y+1-x)*3-3)+"s","y");
        		out.printf("%n");
        		out.printf("%"+((x+1)*3)+"s","|");
        		out.printf("%"+((y+1-x)*3-3)+"s","|");
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

