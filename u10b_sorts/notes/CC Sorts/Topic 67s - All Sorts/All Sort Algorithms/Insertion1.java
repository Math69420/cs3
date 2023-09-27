
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
	int movement;
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
			int index = x-1;								
			int special = list[x];							
		
			while(index >=0 && special<list[index])			
			{                                               
				list[index+1]=list[index];					
				index--;
				
			}

			list[index+1]=special;							
		
		}
	}


	public String toString()
	{
		String special = "\n" + Arrays.toString(list) + "\n\n";
		special += "INSERTION SORT:\n";
		special += "Swaps: " + (movement/3) + "\n";
		special += "Passes: " + passes + "\n";
		special += "Comparisons: " + comparisons + "\n";
		return special;
	}
}

