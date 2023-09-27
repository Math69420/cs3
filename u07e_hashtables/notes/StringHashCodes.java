//hashcode example

import static java.lang.System.*;

public class StringHashCodes
{
   public static void main ( String[] args )
   {
      String[] words = {"Computer", "Science", "computer", "science", "BFND", "bfnd", "Cy-Fair", "Bobcats", "at", "art", "an", "in", "am"};
      
      for(String word : words)
      {
         int h = word.hashCode();
         System.out.println(h + "\t" + h%19 + "\t" + (h & 0x7fffffff) % 19);      
      }  	   
   }
}