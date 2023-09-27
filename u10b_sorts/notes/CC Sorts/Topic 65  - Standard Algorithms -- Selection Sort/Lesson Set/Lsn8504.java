//
//	CS2 - Lsn8504                                © 2006 - Cypress Creek H.S.
//												   2013 - edited by N Waterman
// 	   Thread:	Algorithms -- Selection Sorting
//	Criterion:	String comparison - String1.compareTo(String2)
//	========================================================================
//
//	NOTE:
//	1)	Observe the test in the sort used to sort strings.
//
//	2)	The Test -> might be a bit confusing, but if you want ASCENDING,
//      a negative number means list.get(y) is alphabetically BEFORE
//      (SMALLER THAN) list.get(index).
//
//				if ( list.get(y).compareTo( list.get(index) ) < 0 )
//					   "apple"				  "banana"
//
//              example:  in this case, "apple" is smaller than "banana",
//              and you need the index of the apple (which is y).
//
//


package lesson;

import static java.lang.System.*;
import java.util.*;
import java.io.*;

public class Lsn8504{
	public static void main (String[] args)	{
		new Environment();
}}


class Environment
{
	private ArrayList<String> list;

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
		int index;
		for (int x=0; x<list.size()-1; x++)
		{
 			index = x;
			for (int y=x+1; y<list.size(); y++)
	       		if ( list.get(y).compareTo( list.get(index) ) < 0 )		// see explanation above
					index = y;

	  		String item1 = list.get(x);
	  		String item2 = list.get(index);
	  		list.set(x,item2);
	  		list.set(index,item1);
		}
	}

	public void populate()
	{
		try
		{
			Scanner fileScan = new Scanner(new File("string.dat"));

			list = new ArrayList<String>();
			while (fileScan.hasNext())
				list.add( fileScan.nextLine() );
		}
		catch(Exception e)
		{}
	}

	public String toString()
	{
		String buildString = "";

		for(int x=0; x<list.size(); x++)
			buildString += list.get(x) + "\n";

		return buildString + "\n";
	}
}

