//
//	CS2 - Lsn6203                                     © 2015 - Cypress Creek HS
//
// 	   Thread:	Standard Algorithms -- Monte Carlo Sort
//	Criterion:	Two variable swap
//	========================================================================
//
//	NOTE:
//	1)	This program demonstrates the correct swapping technique of two
//		variable values by using an extra, temporary variable.
//
//
//

package lesson;

import static java.lang.System.*;

public class Lsn6203{
	public static void main (String[] args){
		new AnimalSwap();
}}


class AnimalSwap
{
	private String animal1 = "Tiger";
	private String animal2 = "Giraffe";

	AnimalSwap()
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
		String temp1 = animal1;				// data type must match array type
		String temp2 = animal2;				// data type must match array type

		animal1 = temp2;
		animal2 = temp1;
	}

	public String toString()
	{
		String buildString = "";
			buildString += " First animal = " + animal1 + "\n";
			buildString += "Second animal = " + animal2 + "\n\n";
		return buildString;
	}
}

