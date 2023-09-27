//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import java.util.LinkedList;
import java.util.Scanner;
import static java.lang.System.*;

public class HashTable
{
   private LinkedList[] table;

   //If we were using Open Addressing, we'd start with a table size 1.3 x N and find the next prime.
   public HashTable(int size)
   {
      size /= 4;
      while (!isPrime(size))
         size++;   
      table = new LinkedList[size];
   }

   public void add(Object obj)
   {
      System.out.println("add");
      
      //Calculate the index of the bucket in which obj should be stored:
      
      //If there's not already a list there, add one:
      
      //If the list at index doesn't already contain obj, add it to the list  
   
   
   }

   public String toString()
   {
      String output="HASHTABLE\n";
   
   
   
   
   
   
   
   
   
   
      return output;
   }


   /*
    * Sieve of Eratosthenes is not the best solution when only one prime number should be found. 
    * Here is the solution which is useful for that purpose. It is based on the idea that all 
    * prime numbers are in form of 6k+-1, so I'm only testing 2, 3 and numbers in form 6+-1. 
    * Of course, the loop quits when divisor breaches sqrt(a) because all such numbers have already been tested.
   */
   boolean isPrime(int number)
   {
      if (number < 2)
         return false;
      if (number == 2 || number == 3)
         return true;
   
      if (number % 2 == 0 || number % 3 == 0)
         return false;
   
      int divisor = 6;
      // divisor * divisor - 2 * divisor + 1 is the same as Math.pow(divisor - 1, 2)
      // We could also have said:  divisor <= Math.sqrt(number) + 1
      // It's much cheaper computationally to simply write the d^2 - 2d + 1 like we did.
      while (divisor * divisor - 2 * divisor + 1 <= number)
      {
      
         if (number % (divisor - 1) == 0)
            return false;
      
         if (number % (divisor + 1) == 0)
            return false;
      
         divisor += 6;
      
      }
      return true;
   }
}