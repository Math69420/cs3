//© A+ Computer Science
// www.apluscompsci.com

//ArrayList Objects example

import java.util.ArrayList;
import java.util.List;
import static java.lang.System.*;

public class ArrayListObjects
{
   public static void main(String args[])
   {
      List ray = new ArrayList();
      ray.add("hello");
      ray.add("whoot");
      ray.add("contests");
      ray.add("5");   //Get rid of the quotes and see what happens.
      out.println(ray);
      //out.println(ray.get(0).charAt(0));
      //out.println( (String)ray.get(0).charAt(0));
      out.println(((String)ray.get(0)).charAt(0));
      out.println(((String)ray.get(2)).charAt(0));
      out.println(((String)ray.get(3)).charAt(0));
   }
}