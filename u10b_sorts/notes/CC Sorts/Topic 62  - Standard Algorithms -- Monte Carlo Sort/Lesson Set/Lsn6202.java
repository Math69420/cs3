//
//	CS2 - Lsn6202                                     © 2015 - Cypress Creek HS
//
// 	   Thread:	Standard Algorithms -- Monte Carlo Sort
//	Criterion:	Problematic swap
//	========================================================================
//
//	NOTE:
//	1)	This program demonstrates the incorrect swapping technique of
//		two variable.
//
//
//

package lesson;

import static java.lang.System.*;

public class Lsn6202{
	public static void main (String[] args){
		new Animals();
}}


class Animals
{
	private String animal1 = "Tiger";
	private String animal2 = "Giraffe";

	Animals()
	{
		run();
	}

	public void run()
	{
		out.println( this );
		this.swap();
		out.println( this );
	}

	public void swap()
	{
		animal1 = animal2;
		animal2 = animal1;
	}

	public String toString()
	{
		String buildString = "";
			buildString += " First animal = " + animal1 + "\n";
			buildString += "Second animal = " + animal2 + "\n\n";
		return buildString;
	}
}

