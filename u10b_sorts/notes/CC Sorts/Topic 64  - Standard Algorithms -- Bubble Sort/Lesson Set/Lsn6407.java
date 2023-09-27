//
//	CS2 - Lsn6407                                © 2006 - Cypress Creek H.S.
//
// 	   Thread:	Algorithms -- Bubble Sorting
//	Criterion:	Reference variable relational comparison
//	========================================================================
//
//	NOTE:
//	1)	Objects, like Strings are stored in reference variables.
//
//	2)	Reference variables cannot use the primative relational operators.
//
//
//

package lesson;

import static java.lang.System.*;
import java.util.*;

public class Lsn6407{
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
	       		if ( list.get(x) > list.get(x+1) )			// Problem
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
		list = new ArrayList<String>
		(
			Arrays.asList
			(
				"perl",
				"C++",
				"VBScript",
				"java",
				"ada",
				"BASIC",
				"Fortran",
				"COBOL"
			)
		);
	}

	public String toString()
	{
		return list + "\n";
	}
}

