
//  Selection Sort

package lesson;

import static java.lang.System.*;
import java.util.*;

public class Selection{
	public static void main (String[] args){
		new Environment();
}}


class Environment
{
	int[] list = {75, -3, 99, 25, 52, 83, 12, 7, 38};
	int swaps;
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
      	int index;
		for (int x=0; x<list.length-1; x++)
		{
			index = x;
			for (int y=x+1; y<list.length; y++)
			{
			
				if (list[y] < list[index])
					index = y;
			}	
			int temp = list[x];
	  		list[x] = list[index];
	  		list[index]=temp;	
		}
	}


	public String toString()
	{
		String temp = "\n" + Arrays.toString(list) + "\n\n";
		temp += "SELECTION SORT:\n";
		temp += "Swaps: " + swaps + "\n";
		temp += "Passes: " + passes + "\n";
		temp += "Comparisons: " + comparisons + "\n";
		return temp;
	}
}

