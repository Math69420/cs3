//© A+ Computer Science
// www.apluscompsci.com

//selection sort tester

import static java.lang.System.*;
import java.util.Arrays;

public class QuickSortTester
{
   public static void main( String args[] )
   {
//		int[] array = {39,6,11,23,18,3,20,5,57,15};
      int[] array = {3,15,61,11,7,9,2};

		out.println("before quick sort");
		out.println(Arrays.toString(array));

      QuickSort.quickSort(array);

		out.println("\n\nafter quick sort");
		out.println(Arrays.toString(array));
	}
}