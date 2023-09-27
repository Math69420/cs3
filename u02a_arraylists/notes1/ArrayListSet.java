//© A+ Computer Science
// www.apluscompsci.com

//ArrayList set() example

import java.util.ArrayList;
import static java.lang.System.*;

public class ArrayListSet
{
   public static void main(String args[])
	{
		ArrayList<Integer> ray;
		ray = new ArrayList<Integer>();

		ray.add(23);
        out.println(ray);
        ray.add(11);
        out.println(ray);
        ray.set(0,66);
        out.println(ray);
		ray.add(53);
        out.println(ray);
        ray.set(1,93);
        out.println(ray);
		ray.add(1,22);

		out.println(ray);
		//ray.set(4,77);
		//out.println(ray);
	}
}