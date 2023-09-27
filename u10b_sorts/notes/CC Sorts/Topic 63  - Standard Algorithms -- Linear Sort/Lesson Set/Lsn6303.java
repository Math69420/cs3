//
//	CS2 - Lsn6303                                         ©2015 - Cypress Creek HS
//
// 	   Thread:	Algorithms -- Linear Sorting
//	Criterion:	Iteration logic
//	========================================================================
//
//	NOTE:
//	1)	Check the boundary conditions of the control loops.
//
//		Before Sorting
//		==============
//
//		+----+----+----+----+----+----+----+----+
//		| 25 | 75 |  3 | 14 | 84 |  8 | 19 |  2 |
//		+----+----+----+----+----+----+----+----+
//		   0    1    2    3    4    5    6    7
//
//
//		After First Iteration
//		=====================
//
//         x    y
//         |    |----+----+----+----+----+----+
//         V    V    :    :    :    :    :    V
//		+----+----+----+----+----+----+----+----+
//		|  2 | 75 | 25 | 14 | 84 |  8 | 19 |  3 |
//		+----+----+----+----+----+----+----+----+
//		   0    1    2    3    4    5    6    7
//
//
//	INQUIRY:
//	1)	Where does x always start?
//	2)	Where does y always start?
//	3)	Where does x always stop?
//	4)	Where does y always stop?
//
//      for (int x=    ?    ; x<    ?    ; x++)				<--	Outside Loop
//		{
//			for (int y=   ?    ; y<    ?    ; y++)			<--	Inside Loop
//        	{
//
//        	}
//		}
//
//

package lesson;

import static java.lang.System.*;
import java.util.*;

public class Lsn6303{
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
		trace();

		out.println( this );
	}

	public void sort()
	{
//      for (int x=    ?    ; x<    ?    ; x++)
//		{
//			for (int y=   ?    ; y<    ?    ; y++)
//        	{
//
//        	}
//		}
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
        		out.printf("%"+((x+1)*3)+"s","x");
        		out.printf("%"+((y+1-x)*3-3)+"s","y");
        		out.printf("%n");
        		out.printf("%"+((x+1)*3)+"s","|");
        		out.printf("%"+((y+1-x)*3-3)+"s","|");
        		out.printf("%n");
				String buildString = "";
				for(int z=0; z<list.size(); z++)
					buildString += String.format("%3d",list.get(z));
	        	out.print (buildString += "\n");
        		out.print ("-------------------------------");
        		out.print (" inside loop\n");
	        }

        	out.println("=============================== OUTSIDE LOOP\n\n");
        }
	}

	public String toString()
	{
		return list + "\n";
	}
}

