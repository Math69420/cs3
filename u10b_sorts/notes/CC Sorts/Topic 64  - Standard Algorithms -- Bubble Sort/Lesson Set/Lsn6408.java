//
//	CS2 - Lsn6408                                © 2006 - Cypress Creek H.S.
//
// 	   Thread:	Algorithms -- Bubble Sorting
//	Criterion:	String comparison - String1.compareTo(String2)
//	========================================================================
//
//	NOTE:
//	1)	Observe the test in the sort used to sort strings.
//
//	2)	The Test -> if positive a swap is needed.
//
//			list.get(x).compareTo( list.get(y) ) > 0
//
//
//

package lesson;

import static java.lang.System.*;
import java.util.*;
import java.io.*;

public class Lsn6408{
	public static void main (String[] args)	{
		new Environment();
}}


class Environment
{
	private ArrayList<String> list;

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
 		boolean finished = false;
  		int backEnd  = list.size()-1;
 		while ( !finished )
    	{
	  		finished = true;
     		for (int x=0; x<  backEnd  ; x++)
     		{
	       		if ( list.get(x).compareTo( list.get(x+1) ) > 0 )	// Correct
          		{
			  		String item1 = list.get(x);
			  		String item2 = list.get(x+1);
			  		list.set(x,item2);
			  		list.set(x+1,item1);
            		finished  = false;
          		}
	        }
			backEnd--;
	   	}
	}


	public void populate()
	{
		try
		{
			Scanner fileScan = new Scanner(new File("Heros.dat"));

			list = new ArrayList<String>();
			while (fileScan.hasNext())
				list.add( fileScan.nextLine() );
		}
		catch(Exception e)
		{}
	}

	public String toString()
	{
		return list + "\n";
	}
}

