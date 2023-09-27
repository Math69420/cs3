//
//	CS2 - Lsn6201                                     © 2015 - Cypress Creek HS
//
// 	   Thread:	Standard Algorithms -- Monte Carlo Sort
//	Criterion:	Review - Populate an Array
//	========================================================================
//
//	NOTE:
//	1)	Define an array instance variable.
//
//	2)	Populate the array at time of construction
//
//	3)	Use Arrays utility method to display array.
//
//

package lesson;

import static java.lang.System.*;
import java.util.*;

public class Lsn6201{
	public static void main (String[] args){
		new DataBase();
}}


class DataBase
{
	private int[] list;

	public DataBase()
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
		list = new int[]{ 25, 75, 3, 14, 84, 8, 19, 2, 33, 47 };
	}

	public String toString()
	{
		return  Arrays.toString(list) + "\n";
	}
}

