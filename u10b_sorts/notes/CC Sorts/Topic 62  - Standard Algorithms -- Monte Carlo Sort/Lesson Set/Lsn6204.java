//
//	CS2 - Lsn6204                                     © 2015 - Cypress Creek HS
//
// 	   Thread:	Standard Algorithms -- Monte Carlo Sort
//	Criterion:	Efficient variable swap
//	========================================================================
//
//	NOTE:
//	1)
//
//
//

package lesson;

import static java.lang.System.*;

public class Lsn6204{
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
		String temp;

		temp    = animal1;				//	copy first element into temp
		animal1 = animal2;				//	copy second element into first
		animal2 = temp;					//	place stored first element into second
	}

	public String toString()
	{
		String buildString = "";
			buildString += " First animal = " + animal1 + "\n";
			buildString += "Second animal = " + animal2 + "\n\n";
		return buildString;
	}
}

