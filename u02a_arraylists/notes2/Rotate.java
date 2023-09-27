import static java.lang.System.*;
import java.util.ArrayList;
import java.util.Collections;

public class Rotate
{
   public static void main(String args[])
   {
      ArrayList<Integer> ray = new ArrayList<Integer>();

      ray.add(23);
      ray.add(11);
      ray.add(53);
      ray.add(6);
      ray.add(82);

      out.println("Original:  "+ray);
      Collections.reverse(ray);
      out.println("Reversed:  "+ray);
      Collections.reverse(ray);
      out.println("Reversed back:  \n"+ray);           
      
      out.println("\nrotate right 2");
      Collections.rotate(ray,2);
      out.println(ray);

      out.println("\nrotate right 1 more");
      Collections.rotate(ray,1);
      out.println(ray);
      
      out.println("\nrotate 1 back");
      Collections.rotate(ray,-1);
      out.println(ray);  
         
      out.println("\nrotate the middle three numbers right one");
      Collections.rotate(ray.subList(1,4),1);
      out.println(ray); 

      out.println("Clearing part of a list:");
      ray.subList(0,2).clear();
      out.println(ray); 
                                      
   }
}