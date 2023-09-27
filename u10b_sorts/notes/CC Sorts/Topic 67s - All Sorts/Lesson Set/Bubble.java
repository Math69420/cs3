
//  Bubble Sort

package lesson;

import static java.lang.System.*;
import java.util.*;

public class Bubble{
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
		int y=list.length-1;
      	boolean sorted = false;
      	while(!sorted)
      	{
      		passes++;
      		sorted = true;
      		for(int x=0;x<y;x++)
      		{
      			comparisons++;
      			if(list[x]>list[x+1])
      			{
      				swaps++;
      				sorted = false;
      				int temp = list[x];
      				list[x]=list[x+1];
      				list[x+1] = temp;
      			}

      		}
      		y--;
      	}

	}


public String toString()
	{
		String temp = "\n" + Arrays.toString(list) + "\n\n";
		temp += "BUBBLE SORT:\n";
		temp += "Swaps: " + swaps + "\n";
		temp += "Passes: " + passes + "\n";
		temp += "Comparisons: " + comparisons + "\n";
		return temp;
	}
}

