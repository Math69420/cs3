//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import static java.lang.System.*;
import java.util.Arrays;

public class Lab18c
{
   public static void main ( String[] args )
   {
      int[] nums = {99,2,8,75,10,7,9,17,5,3,4,1,11,1};
      displayResults(nums);
   	
      int[] stuff = {-3,28,18,5,3,17,29,6,5,3,4,1,11,1};
      displayResults(stuff);
   
   }
   
   public static void displayResults(int[] nums) 
   {   
      System.out.println("Original: " + Arrays.toString(nums));
      HeapSort.heapSort(nums);
      System.out.println("Sorted:   " + Arrays.toString(nums));
      System.out.println();
   }
}