//
//	CS2 - Lsn6305                                         ©2015 - Cypress Creek HS
//
// 	   Thread:	Algorithms -- Linear Sorting
//	Criterion:	Conditional Test
//	========================================================================
//
//	NOTE:
//	1)	What items need to be tested?
//
//		After Third Iteration
//		=====================
//
//                   x    y
//                   |    |----+----+----+----+
//                   V    V    :    :    :    V
//		+----+----+----+----+----+----+----+----+
//		|  2 |  3 |  8 | 75 | 84 | 25 | 19 | 14 |
//		+----+----+----+----+----+----+----+----+
//		   0    1    2    3    4    5    6    7
//
//
//	2)	->	if( list.get(x) > list.get(y) )
//
//
//

package lesson;

import static java.lang.System.*;
import java.util.*;

public class Lsn6305{
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

        		if( list.get(x) > list.get(y) )
        			out.println(list.get(x) + " needs to swap with " + list.get(y));

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

