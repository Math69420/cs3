//
//	CS2 - Lsn6403                                © 2006 - Cypress Creek H.S.
//
// 	   Thread:	Algorithms -- Bubble Sorting
//	Criterion:	Boundary conditions
//	========================================================================
//
//	NOTE:
//	1)	The outside loop terminates when the list is in order.
//		This is a type od short circuting.
//
//	2)	The inside loop terminates one before the end of the list.
//
//		After Second Iteration
//		======================
//
//          x x+1
//          |  : x x+1
//          |  : |  : x x+1
//          |  : |  : |  : x x+1
//          |  : |  : |  : |  : x x+1
//          |  : |  : |  : |  : |  : x x+1
//          |  : |  : |  : |  : |  : |  :
//          V  v V  v V  v V  v V  v V  v
//		+----+----+----+----+----+----+----+----+
//		|  3 | 14 | 25 |  8 | 19 |  2 | 75 | 64 |
//		+----+----+----+----+----+----+----+----+
//		   0    1    2    3    4    5    6    7
//
//
//	INQUIRY:
//	1)	Where does x always start?
//	2)	Where does x+1 always start?
//	3)	Where does x always stop?
//	4)	Where does x+1 always stop?
//
//
//
//

package lesson;

import static java.lang.System.*;
import java.util.*;

public class Lsn6403{
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
 		boolean finished = false;
 		while ( !finished )
    	{
	  		finished = true;
     		for (int x=0; x<list.size()-1; x++)
     		{

	        }

	   	}
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
	        	out.print (buildString);
            	out.print ("\n");
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
			Arrays.asList( 25, 75, 3, 14, 64, 8, 19, 2 )
		);
	}

	public String toString()
	{
		return list + "\n";
	}
}

