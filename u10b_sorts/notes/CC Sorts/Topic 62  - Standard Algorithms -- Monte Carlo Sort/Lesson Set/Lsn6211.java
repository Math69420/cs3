//
//	CS2 - Lsn6211                                     © 2015 - Cypress Creek HS
//
// 	   Thread:	Standard Algorithms -- Monte Carlo Sort
//	Criterion:	Monte Carlo Sort efficiency
//	========================================================================
//
//	Note:
//	1)	In all cases
//
//         n
//		  2
//
//

package lesson;

import static java.lang.System.*;
import java.util.*;
import java.text.DecimalFormat;

public class Lsn6211{
	public static void main (String[] args){
		new DataBase();
}}


class DataBase
{
	private int[] list;
	private int count;

	DataBase()
	{
		populate();
		run();
	}

	public void run()
	{
		out.println( "Using Monte Carlo sort." );
		out.println( this );

		TimeTest time = new TimeTest();
		{
			time.startClock();						//	Start time
			this.sort();							//	Array Sort
			time.stopClock();						//	Stop time
		}

		out.println( this );
		out.println();
		out.println( "Execution time: " + time );
		out.println();
	}

	public void populate()
	{
		list = new int[]{ 25, 75 };
//		list = new int[]{ 25, 75, 3 };
//		list = new int[]{ 25, 75, 3, 14 };
//		list = new int[]{ 25, 75, 3, 14, 84, 8, 19 };
//		list = new int[]{ 25, 75, 3, 14, 84, 8, 19, 2, 33, 47 };
//		list = new int[]{ 25, 75, 3, 14, 84, 8, 19, 2, 33, 47, 16, 67, 42, 9, 62, 31, 23, 77, 81, 59 };
	}

	public void sort()
	{
		boolean sorted = false;

		while(!sorted)
		{
			shuffle();
			count++;

			sorted = true;
			for(int x=0; x<list.length-1; x++)
				if(list[x]>list[x+1])
				{
					sorted = false;
					break;
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

	public String toString()
	{
		return  Arrays.toString(list) + "\n" +
				"The sort shuffled " + String.format("%,d",count) + " times.\n";
	}
}











class TimeTest
{

	private long startTicks;	// tick count at the start of the test
	private long endTicks;		// tick count at the end of the test
	private long millis;		// elapsed number of ticks
	private long hours;			// elapsed hours
	private long minutes;		// elapsed minutes
	private long seconds;		// elapsed seconds
	private long fractions;		// elapsed fractions of a second

	public TimeTest()
	{
		startTicks = 0;
		endTicks = 0;
		millis = 0;
		hours = 0;
		minutes = 0;
		seconds = 0;
		fractions = 0;
	}

	public void startClock()
	{
		startTicks = System.currentTimeMillis();
	}


	public void stopClock()
	{
		endTicks = System.currentTimeMillis();
		computeTime();
	}


	private void computeTime()
	{
		millis = endTicks - startTicks;
		hours = millis / 3600000;
		long leftOver = millis % 3600000;
		minutes = leftOver / 60000;
		leftOver = leftOver % 60000;
		seconds = leftOver / 1000;
		fractions = leftOver % 1000;
	}

	public String toString()
	{
		DecimalFormat twos = new DecimalFormat("00");
		DecimalFormat threes = new DecimalFormat("000");
		String temp = twos.format(hours) + ":";
		temp = temp + twos.format(minutes) + ":";
		temp = temp + twos.format(seconds) + ".";
		temp = temp + threes.format(fractions);
		return temp;
	}

}