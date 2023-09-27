//© A+ Computer Science
// www.apluscompsci.com

//Iterator next example


import java.util.ArrayList;
import java.util.Iterator;

public class IteratorStop
{
   public static void main(String args[])
   {
      ArrayList<String> words;
      words = new ArrayList<String>();
   
      words.add("at");
      words.add("is");
      words.add("of");
   
      Iterator<String> it = words.iterator();
      System.out.println(it.next());
      words.remove(1);
      it = words.iterator();
      System.out.println(it.next());
      System.out.println();
      
      Iterator<String> it2 = words.iterator();
      while(it2.hasNext())
         System.out.println(it2.next());
      words.add("fry");
      it2 = words.iterator();
      System.out.println(it2.next());
   
   }
}