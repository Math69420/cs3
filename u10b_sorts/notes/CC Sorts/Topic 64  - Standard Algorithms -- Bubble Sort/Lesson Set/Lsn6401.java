//
//	CS2 - Lsn6401                                © 2006 - Cypress Creek H.S.
//
// 	   Thread:	Algorithms -- Bubble Sorting
//	Criterion:	Utility library sort
//	========================================================================
//
//	NOTE:
//	1)	The collections class has a sort, but how does it work?
//
//	2)	The library Math.random() is used to creat a random double
//		in the range from 0 to .9999999.
//
//	3)	To create a random number you multiply the random() method
//		by the range and add the lowest acceptable number.
//
//			(int)    (random() * range  +  low)
//
//	4)	The range is the number of possible values.
//
//			range =   hi - low + 1
//
//
//
//

package lesson;

import static java.lang.System.*;
import java.util.*;

public class Lsn6401{
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
		out.println( this );
		sort();
		out.println( this );
	}

	public void sort()
	{
		Collections.sort( list );
	}

	public void populate()
	{
		list = new ArrayList<Integer>();

		for(int x=0; x<15; x++)
			list.add( (int)(Math.random()*101 + 150) );  // [0...100] + 150 =
	}													 // [150...250]

	public String toString()
	{
		return list + "\n";
	}
}

