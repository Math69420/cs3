//
//
// MonteCarlo Sort
//

package lesson;

import static java.lang.System.*;
import java.util.*;

public class MonteCarlo{
	public static void main (String[] args){
		new DataBase();
}}


class DataBase
{
	private int[] list;
	int swaps;
	int passes;
	int comparisons;

	DataBase()
	{
		populate();
		run();
	}

	public void run()
	{
		out.println( this );
		out.println( );

		this.sort();

		out.println( );
		out.println( this );
		out.println( );
	}

	public void sort()
	{
		int     count  = 0;
		boolean sorted = false;

		while(!sorted)
		{
			shuffle();

			sorted = true;
			for(int x=0; x<list.length-1; x++)
				if(list[x]>list[x+1])
				{
					sorted = false;
					count++;
					out.println(this);
					out.println(count);
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
			swaps++;
			temp = list[r];
			list[r] = list[x];
			list[x] = temp;
		}
	}

	public void populate()
	{
	//	list = new int[]{ 75,-3,99,25,52,83,12,7,38};				// not possible!

	}

	public String toString()
	{
		return  Arrays.toString(list);
	}
}
