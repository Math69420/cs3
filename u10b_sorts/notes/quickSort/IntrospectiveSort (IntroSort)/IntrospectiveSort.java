import static java.lang.System.*;
import java.util.Arrays;

public class IntrospectiveSort
{
   public static void introSort(int[] ray) {
      int maxDepth = (int)(Math.floor(Math.log(ray.length)) * 2);
      introSort(ray, 0, ray.length, maxDepth);
   }
      	
   public static void introSort(int arr[], int start, int end, int maxDepth) {
      int n = arr.length;
      if (n <= 1)
         return;  // base case
      else if (maxDepth == 0)
         HeapSort.heapSort(arr);
      else {
         int p = partition(arr, start, end-1);  // assume this function does pivot selection
         introSort(arr,   0,   p, maxDepth - 1);
         introSort(arr, p+1, n, maxDepth - 1);      	
      }

   }

	private static int partition(int[] array, int start, int end)   {
	   int bot = start, top = end, pivot = array[start];        
	   while (top > bot) {                    
	      while (array[bot] <= pivot && bot<=end && top > bot)     
	         bot++;           
	      while (array[top] > pivot && top >= start && top >= bot) 
	         top--;                                             
	      if (top > bot)                                          
	         swap(array, bot, top);                                
	   }
	   swap(array, start, top);        
	   return top;	
	}   
	   
	private static void swap(int array[], int index1, int index2)    {
	   int temp = array[index1];           
	   array[index1] = array[index2];      
	   array[index2] = temp;               
	}
	
   public static void main( String args[] )
   {
//		int[] array = {39,6,11,23,18,3,20,5,57,15};
      int[] array = {2,3,11,7,9,15,11,23,43,54,48,61,100};

		out.println("before introspective sort");
		out.println(Arrays.toString(array));

        introSort(array);

		out.println("\n\nafter introspective sort");
		out.println(Arrays.toString(array));
	} 
}