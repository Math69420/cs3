//
//	CS2 - Lsn8505                                © 2006 - Cypress Creek H.S.
//
// 	   Thread:	Algorithms -- Selection Sorting
//	Criterion:	Sorting integers as strings
//	========================================================================
//
//	NOTE:
//	1)	Observe what happens when integers are treated as strings.
//
//
//
//

package lesson;

import static java.lang.System.*;
import java.util.*;
import java.io.*;

public class Lsn8505{
	public static void main (String[] args)	{
		new Environment();
}}


class Environment
{
	private ArrayList<String> list;						//      ArrayList of String
														//  (datum are actually integers)
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
	       		if ( list.get(y).compareTo( list.get(index) ) < 0 )
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
			Scanner fileScan = new Scanner(new File("integer.dat"));

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

