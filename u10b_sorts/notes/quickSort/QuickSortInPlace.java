//© A+ Computer Science
// www.apluscompsci.com

//quick sort example

import static java.lang.System.*;
import java.util.Arrays;

public class QuickSortInPlace
{
	public static void quickSort(int[] ray) {
      quickSort(ray, 0, ray.length);
	}

   public static void quickSort(int arr[], int beginIdx, int len) {
       if ( len <= 1 )
            return;

       final int endIdx = beginIdx+len-1;

       // Pivot selection
       final int pivotPos = beginIdx;  //+len/2;
       final int pivot = arr[pivotPos];
       swap(arr, pivotPos, endIdx);

       // partitioning
       int p = beginIdx;
       for(int i = beginIdx; i != endIdx; ++i) {
            if ( arr[i] <= pivot ) {
                swap(arr, i, p++);
       /* better:
        * if ( arr[i] <= pivot ) {
        *       swap(arr, i, p);
        *       p++;
        * }
        */
            out.println(Arrays.toString(arr));

            }
        }
        swap(arr, p, endIdx);
        out.println(Arrays.toString(arr)+" pivot= "+pivot);
        // recursive call
        quickSort(arr, beginIdx, p-beginIdx);
        quickSort(arr, p+1,  endIdx-beginIdx);
   }

   private static void swap(int[] arr, int i, int j) {
      int temp = arr[i];
      arr[i]=arr[j];
      arr[j]=temp;
   }
}