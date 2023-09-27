import static java.lang.System.*;
import java.util.*;

public class RadixSort
{
	static String convertToBinary ( int n ) 
	{ 		
	   if ( n == 0 ) 
	      return "0"; 
       String bits = "" ; 
	   do 
	   { 
	       bits = ( char ) ( n % 2 + '0' ) + bits ; 
	       n /= 2 ; 
	   }while ( n > 0 ) ; 
	   return bits; 
	} 	
		
	public static int[] radixSort(int[] old) {
	    // Loop for every bit in the integers
	    for (int shift = Integer.SIZE - 1; shift > -1; shift--) {
	        // The array to put the partially sorted array into
	        int[] tmp = new int[old.length];
	        // The number of 0s
	        int j = 0;
	 
	        // Move the 0s to the new array, and the 1s to the old one
	        for (int i = 0; i < old.length; i++) {
	            // If there is a 1 in the bit we are testing, the number will be negative
	            boolean move = old[i] << shift >= 0;
	 
	            // If this is the last bit, negative numbers are actually lower
	            if (shift == 0 ? !move : move) {
	                tmp[j] = old[i];
	                j++;
	            } else {
	                // It's a 1, so stick it in the old array for now
	                old[i - j] = old[i];
	            }
	        }
	 
	        // Copy over the 1s from the old array
	        for (int i = j; i < tmp.length; i++) {
	            tmp[i] = old[i - j];
	        }
	 
	        // And now the tmp array gets switched for another round of sorting
	        old = tmp;
	        for(int num : old)
	        	out.print(convertToBinary(num)+", ");
	        out.println();	            

	    }

	    return old;
	}	

   public static void main( String args[] )
   {
        int i;
        int[] array1 = new int[8];
        //System.out.print("original: ");
        for(i=0;i<array1.length;i++){
            array1[i] = (int)(Math.random() * 1024);
            //System.out.print(array1[i] + " ");
        }
		out.println("array1 before selection sort");
		out.println(Arrays.toString(array1));

		array1 = radixSort(array1);

		out.println("\n\narray1 after selection sort");
		out.println(Arrays.toString(array1));
		out.println("\n\n");		
/*		
		Integer[] array2 = {39,6,11,23,18,3,20,5,57,15};

		out.println("array2 before selection sort");
		out.println(Arrays.toString(array2));

		SelectionSortObjects.selectionSort(array2);

		out.println("\n\narray2 after selection sort");
		out.println(Arrays.toString(array2));
		out.println("\n\n");
		
		String[] array3 = {"art","zen","plus","Carl","Antler","question"};

		out.println("array3 before selection sort");
		out.println(Arrays.toString(array3));

		SelectionSortObjects.selectionSort(array3);

		out.println("\n\narray3 after selection sort");
		out.println(Arrays.toString(array3));
		out.println("\n\n");						*/
	}
}
	