//
//	CS2 - Lsn6210                                     © 2015 - Cypress Creek HS
//
// 	   Thread:	Standard Algorithms -- Monte Carlo Sort
//	Criterion:	Problem Sorting Strings Fixed
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

public class Lsn6210{
	public static void main (String[] args){
		new DataBase();
}}


class DataBase
{
	private String[] list;

	DataBase()
	{
		populate();
		run();
	}

	public void run()
	{
		out.println( this );
		this.sort();
		out.println( this );
		out.println( );
	}

	public void sort()
	{
		boolean sorted = false;
		int count=0;
		while(!sorted)
		{
			shuffle();

			sorted = true;
			for(int x=0; x<list.length-1; x++)			//	 /
				if( list[x].compareTo(list[x+1]) > 0 )	//	<-----	Problem Fixed
				{										//	 \
					sorted = false;
					count++;
					break;
				}

		}out.println("Number of iterations: " + String.format("%,d",count));
	}

	public void shuffle()
	{
		String temp;
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
		list = new String[]{ "red", "sat", "can", "bat", "zit", "bob", "doe", "mad", "cut", "zap" };
	}

	public String toString()
	{
		return  Arrays.toString(list) + "\n";
	}
}
