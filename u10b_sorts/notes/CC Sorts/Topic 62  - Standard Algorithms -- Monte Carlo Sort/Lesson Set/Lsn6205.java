//
//	CS2 - Lsn6205                                     © 2015 - Cypress Creek HS
//
// 	   Thread:	Standard Algorithms -- Monte Carlo Sort
//	Criterion:	Random shuffle
//	========================================================================
//
//	NOTE:
//	1)
//
//
//

package lesson;

import static java.lang.System.*;
import java.util.*;

public class Lsn6205{
	public static void main (String[] args){
		new DataBase();
}}


class DataBase
{
	private int[] list;

	DataBase()
	{
		populate();
		run();
	}

	public void run()
	{
		for(int x=0;x<100;x++)
		{
			out.println( this );
			shuffle();
		}
		
	}

	public void shuffle()
	{
		int temp;

		for(int x=0; x<list.length; x++)	// go through each element
		{
			int r = (int)(Math.random()*list.length);  // pick a random index

			temp = list[r];			// every element swaps at least once
			list[r] = list[x];		// with location of random index
			list[x] = temp;
		}
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

