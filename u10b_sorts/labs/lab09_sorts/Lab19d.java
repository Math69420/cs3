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

public class Lab19d
{
	public static void main (String args[])
	{
		ArrayList<Integer> test = new ArrayList<Integer>();
		test.add(103);
		test.add(17);
		test.add(38);
		test.add(20);

		out.println("Original List -  " + test + "\n\n");

		RadixSort sort = new RadixSort();

		sort.radixSort(test);
		out.println("Sorted List -  " + test + "\n\n");

		//build a new list to sort
		test = new ArrayList<Integer>();
		test.add(655);
		test.add(21);
		test.add(22);
		test.add(48);
		test.add(262);
		test.add(6412);
		test.add(11);
		test.add(33);
		test.add(10);

      sort = new RadixSort();

		out.println("\n\nOriginal List -  " + test + "\n\n");
		sort.radixSort(test);
		out.println("Sorted List -  " + test + "\n\n");
	}
}