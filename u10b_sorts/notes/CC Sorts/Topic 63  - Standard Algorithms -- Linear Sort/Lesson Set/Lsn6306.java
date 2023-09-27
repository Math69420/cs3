//
//	CS2 - Lsn6306                                         ©2015 - Cypress Creek HS
//
// 	   Thread:	Algorithms -- Linear Sorting
//	Criterion:	Apply the swap to nested loops
//	========================================================================
//
//	NOTE:
//	1)	Use the swap to alter the ArrayList.
//
//	2)	How do you cahnge the order to be descending order.
//
//
//

package lesson;

import static java.lang.System.*;
import java.util.*;

public class Lsn6306{
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
		out.println( this );
		sort();
		out.println( this );
	}

	public void sort()
	{
      	for (int x=0; x< list.size()-1 ; x++)
      	{
        	for (int y= (x+1) ; y< list.size() ; y++)
        	{
        		//                /---------------------------	Ascending order
        		//               /
        		if( list.get(x) > list.get(y) )
        		{
			  		Integer item1 = list.get(x);
			  		Integer item2 = list.get(y);

			  		list.set(x,item2);
			  		list.set(y,item1);
			  	}
        	}
        }
	}

	public void populate()
	{
		list = new ArrayList<Integer>
		(
			Arrays.asList( 25, 75, 3, 14, 84, 8, 19, 2, 33, 47 )
		);
	}

	public String toString()
	{
		return list + "\n";
	}
}

