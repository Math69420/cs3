
// Insertion Sort 2 - Using linear search

package lesson;

import static java.lang.System.*;
import java.util.*;
import java.io.*;

public class Insertion2{
	public static void main (String[] args)	{
		new Environment();
}}


class Environment
{
	int[] list = {75, -3, 99, 25, 52, 83, 12, 7, 38};
	int scoots;
	int passes;
	int comparisons;

	public Environment()
	{
		run();
	}
	
	public void run()
	{
		out.println( Arrays.toString(list) );
		sort();
		out.println( this );
	}


	public void sort()
	{
		for(int x=0; x<list.length; x++)
		{
			int index 	= x;								 
			int temp 	= list[x];							 
			passes++;
			boolean found = false;
			for(int y=0; (!found && y<x); y++)			// observe
				if( list[y] > temp )					//	Linear
				{										//	Search
					index   = y;
					found = true;
				}
														// SCOOT!!											//	 |
		    for(int i=x; i>index; i--)					//	 |
		    {
		    	scoots++;
		    	list[i] = list[i-1];					//	 v
			}
		    list[index] = temp;							// insert item
			}
		
	}

	public String toString()
	{
		String temp = "\n" + Arrays.toString(list) + "\n\n";
		temp += "INSERTION SORT:\n";
		temp += "Scoots: " + scoots + "\n";
		temp += "Passes: " + passes + "\n";
		temp += "Comparisons: " + comparisons + "\n";
		return temp;
	}
}



