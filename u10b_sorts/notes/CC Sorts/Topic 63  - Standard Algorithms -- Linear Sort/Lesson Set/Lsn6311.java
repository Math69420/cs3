//
//	CS2 - Lsn6311                                         ©2015 - Cypress Creek HS
//
// 	   Thread:	Algorithms -- Linear Sorting
//	Criterion:	Order of Magnitude Analysis - WORST Case
//	========================================================================
//
//	Note:
//	1)	Complete Reverse Order
//
//         2
//		  n
/*

War
Texas Hold'em
Spoons
Solitare
Spades
Rummy
Hearts
Gin
Bridge
Blackjack

*/
//
//
//

package lesson;

import static java.lang.System.*;
import java.util.*;
import java.io.*;

public class Lsn6311{
	public static void main (String[] args){
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
		out.println("Original List:");
		out.println("-------------");
		out.println( this );
			sort();
		out.println("Sorted List:");
		out.println("-----------");
		out.println( this );
	}

	public void sort()
	{
      	for (int x=0; x< list.size()-1 ; x++)
        	for (int y= (x+1) ; y< list.size() ; y++)
          		if ( list.get(x).compareTo(list.get(y)) > 0 )	// Test to sort
            	{												//   Strings.
			  		String item1 = list.get(x);
			  		String item2 = list.get(y);
			  		list.set(x,item2);
			  		list.set(y,item1);
			  	}
	}

	public void populate()
	{
		try
		{
			Scanner fileScan = new Scanner( new File( "Lsn6309a.dat" ));

			list = new ArrayList<String>();
			while( fileScan.hasNext() )
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

		return buildString += "\n";
	}
}




