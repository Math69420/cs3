//© A+ Computer Science
// www.apluscompsci.com

//ArrayList remove() example

import java.util.ArrayList;
import static java.lang.System.*;

public class ArrayListRemoveTwo
{
   public static void main(String args[])
   {
      ArrayList<String> ray;
      ray = new ArrayList<String>();

      ray.add("a");  
      ray.add("b");
      ray.add("a");
      out.println(ray.remove("a"));  //This removes an "a", if there is one.
      out.println(ray);
      
      ray.add("c");
      ray.add("d");
      out.println(ray.remove("d"));
      out.println(ray.remove("z"));  // So what is the return type of the remove method?

      out.println(ray);
   }
}