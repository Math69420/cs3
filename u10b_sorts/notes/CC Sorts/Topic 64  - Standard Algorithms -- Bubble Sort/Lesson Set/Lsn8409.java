//
//	CS2 - Lsn8409                                © 2006 - Cypress Creek H.S.
//
// 	   Thread:	Algorithms -- Bubble Sorting
//	Criterion:	Order of Magnitude Analysis - Best case efficiency
//	========================================================================
//
//	Note:
//	1)	Already in order
/*

 		boolean finished = false;
 		while ( !finished )
    	{
	  		finished = true;
     		for (int x=0; x<  backEnd  ; x++)
     		{
     			...
	        }
	   	}

*/
//
//		+----+----+----+----+----+----+----+----+
//		|  4 |  2 |  5 |  8 |  9 | 12 | 27 | 21 |
//		+----+----+----+----+----+----+----+----+
//		   0    1    2    3    4    5    6    7
//
//
//	WOW!!!!!
//
//	2)	Order of Magnitude Analysis - BEST Case
//
//		  n
//
//

package lesson;

import static java.lang.System.*;
import java.util.*;

public class Lsn8409{
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
			Arrays.asList( 25, 75, 3, 14, 84, 8, 19, 2 )
		);
	}

	public String toString()
	{
		return list + "\n";
	}
}

