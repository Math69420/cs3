
//  Insertion Sort 1 - typical algorithm

package lesson;

import static java.lang.System.*;
import java.util.*;

public class Insertion1{
	public static void main (String[] args){
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
      	for(int x=1; x<list.length; x++)
		{
			passes++;
			int index = x-1;								// the one already sorted
			int temp = list[x];								// the one to get in relative order
			
			while(index >=0 && temp<list[index])			// while the index is still positive
			{                                               // AND the spotlight item is less than
				list[index+1]=list[index];					// SCOOT the offending item to the right
				index--;
				scoots++;
				comparisons++;
			}

			list[index+1]=temp;								// place the correct item into its correct slot
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

