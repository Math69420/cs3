//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Collections;
import static java.lang.System.*;

public class RadixSort
{
	private static final int radix=10;

	private int biggestNum(ArrayList<Integer> list)
	{
		return 0;
	}

	private int numDigits(int num)
	{
		String s = "";
		return 0;
	}

	public void radixSort(ArrayList<Integer> list)
	{
		Queue[] queueArray = new LinkedList[radix];
		//make all spotsin queueArray refer to a Queue


		//find the largest number in list
		//find how many digits are in the largest number in list
		int max=numDigits(biggestNum(list));

		//loop to run for the max # of digits in the largest number

			//put numbers in queues

			//put stuff from queues back into list
	}
}