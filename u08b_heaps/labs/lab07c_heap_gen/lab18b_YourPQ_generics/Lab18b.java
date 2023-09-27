import java.util.Queue;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Lab18b
{
   public static void main ( String[] args )
   {
      YourPQ<Monster> test = new YourPQ<>();
     
      test.add(new Monster(1,5));
      test.add(new Monster(1,3));  
      test.add(new Monster(10,55));
      test.add(new Monster(12,45));
      test.add(new Monster(111,123));
      test.add(new Monster(5,9));
      System.out.println("PQ: " + test);
      System.out.println("natural order of contents: " + test.getNaturalOrder());      
      System.out.println("getMin() - " + test.getMin());
      System.out.println("removeMin() - " + test.removeMin()+"\n");		
      System.out.println("PQ: " + test);
      System.out.println("natural order of contents: " + test.getNaturalOrder());		
      System.out.println("getMin() - " + test.getMin());
      System.out.println("removeMin() - " + test.removeMin()+"\n");			
      System.out.println("PQ: " + test);
      System.out.println("natural order of contents: " + test.getNaturalOrder());	
      System.out.println("\n");
      
      YourPQ<Integer> test2 = new YourPQ<>();
     
      test2.add(3);
      test2.add(9);  
      test2.add(1);
      test2.add(6);
      test2.add(7);
      test2.add(1);
      System.out.println("PQ: " + test2);
      System.out.println("natural order of contents: " + test2.getNaturalOrder());      
      System.out.println("getMin() - " + test2.getMin());
      System.out.println("removeMin() - " + test2.removeMin()+"\n");		
      System.out.println("PQ: " + test2);
      System.out.println("natural order of contents: " + test2.getNaturalOrder());		
      System.out.println("getMin() - " + test2.getMin());
      System.out.println("removeMin() - " + test2.removeMin()+"\n");			
      System.out.println("PQ: " + test2);
      System.out.println("natural order of contents: " + test2.getNaturalOrder());      	
   }
}