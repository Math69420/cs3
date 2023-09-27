//
//	CS2 - Lsn6302                                         ©2015 - Cypress Creek HS
//
// 	   Thread:	Algorithms -- Linear Sorting
//	Criterion:	Swapping items in an ArrayList
//	========================================================================
//
//	NOTE:
//	1)	Use temporary variables to store values as they are swapped.
//
/*
	public void swap(int x, int y)
	{
  		Integer item1 = list.get(x);
  		Integer item2 = list.get(y);

  		list.set(x,item2);
  		list.set(y,item1);
	}
*/
//
//

package lesson;

import static java.lang.System.*;
import java.util.*;

public class Lsn6302{
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
		swap( 1, 6 );
		out.println( this );
	}

	public void swap(int x, int y)
	{
  		Integer item1 = list.get(x);
  		Integer item2 = list.get(y);

  		list.set(x,item2);
  		list.set(y,item1);
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

