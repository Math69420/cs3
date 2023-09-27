//
//	CS2 - Lsn6301                                         ©2015 - Cypress Creek HS
//
// 	   Thread:	Algorithms -- Linear Sorting
//	Criterion:	Review - Populate an ArrayList
//	========================================================================
//
//	NOTE:
//	1)	Define an array instance variable.
//
//	2)	Populate the array at time of construction
//
//
//

package lesson;

import static java.lang.System.*;
import java.util.*;

public class Lsn6301{
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

