//
//	CS2 - Lsn6405                                © 2006 - Cypress Creek H.S.
//
// 	   Thread:	Algorithms -- Bubble Sorting
//	Criterion:	Improving efficiency - Trailing tail
//	========================================================================
//
//	NOTE:
//	1)	In a bubble sort, if a swap is made we reset the finished flag
//		to false.  This esures there will be at least one more pass.
//
//		fourth Third Iteration
//		=====================
//
//          x x+1
//          |  : x x+1
//          |  : |  : x x+1
//          |  : |  : |  : x x+1
//          |  : |  : |  : |  :
//          V  v V  v V  v V  v
//		+----+----+----+----+----+----+----+----+
//		|  3 |  8 | 14 |  2 | 19 | 25 | 75 | 64 |
//		+----+----+----+----+----+----+----+----+
//		   0    1    2    3    4    5    6    7
//
//
//	2)	The swap is between
//
//			list.get(x)   <-->   list.get(x+1)
//
//
//

package lesson;

import static java.lang.System.*;
import java.util.*;

public class Lsn6405{
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
  		int backEnd  = list.size()-1;
 		while ( !finished )
    	{
	  		finished = true;
     		for (int x=0; x<  backEnd  ; x++)
     		{
	       		if ( list.get(x) > list.get(x+1) )
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


	public void trace()
	{
  		boolean finished;
      	int temp;

  		finished = false;
  		int backEnd  = list.size()-1;
  		while (!finished)
    	{
     		finished = true;
      		for (int x=0; x<backEnd; x++)
      		{
          		boolean swapped = false;
	       		if ( list.get(x) > list.get(x+1) )
          		{
			  		Integer item1 = list.get(x);
			  		Integer item2 = list.get(x+1);
			  		list.set(x,item2);
			  		list.set(x+1,item1);
            		finished  = false;
              		swapped = true;
          		}
				if(swapped)
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
						out.printf("%s"," <----------------- items SWAPPED");
	            	out.print ("\n");
	        		out.print ("------------------------");
	        		out.print (" inside loop\n");
				}
	        }

        	out.println("======================== OUTSIDE LOOP\n\n");
 			backEnd--;
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

