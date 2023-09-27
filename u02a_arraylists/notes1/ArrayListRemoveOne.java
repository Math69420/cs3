//© A+ Computer Science  -  www.apluscompsci.com

//ArrayList remove() example

import java.util.ArrayList;
import static java.lang.System.*;

public class ArrayListRemoveOne
{
	public static void main(String args[])
	{
		ArrayList<String> ray;
		ray = new ArrayList<String>();

		ray.add("a");
		ray.add("b");
      out.println(ray);
 
		out.println(ray.remove(0));  //This removes whatever is at spot zero
      out.println(ray);
      
		ray.add("c");
		ray.add("d");
      out.println(ray);

		ray.remove(0);

		out.println(ray);
	}
}