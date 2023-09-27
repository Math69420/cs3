//
//	CS2 - Lsn6206                                     © 2015 - Cypress Creek HS
//
// 	   Thread:	Standard Algorithms -- Monte Carlo Sort
//	Criterion:	Monte Carlo Sort
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

public class Lsn6206{
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
		out.println("Start: " + this );
		out.println( );

		this.sort();

		out.println( );
		out.println("Finish: " + this );
		out.println( );
	}

	public void sort()
	{
		int     count  = 0;
		boolean sorted = false;

		while(!sorted)						// while sorted is false
		{
			shuffle();						// shuffle all elements

			sorted = true;					// prove me wrong
			for(int x=0; x<list.length-1; x++)
				if(list[x]>list[x+1])		// if any element is out of order
				{
					sorted = false;			// it's not sorted yet
					count++;
					out.println("iteration " +
						        count + " : " +
						        this);
					break;					// jump out of for loop (no choice)
				}
		}
	}

	public void shuffle()
	{
		int temp;
		for(int x=0; x<list.length; x++)
		{
			int r = (int)(Math.random()*list.length);

			temp = list[r];
			list[r] = list[x];
			list[x] = temp;
		}
	}

	public void populate()
	{
		list = new int[]{ 25, 75, 10};
	//	list = new int[]{ 25, 75, 10, 2};
	//	list = new int[]{ 25, 75, 10, 2, 7};
	//	list = new int[]{ 25, 75, 10, 2, 7, 8};
	//	list = new int[]{ 25, 75, 10, 2, 7, 8, 3};
	}

	public String toString()
	{
		return  Arrays.toString(list);
	}
}
