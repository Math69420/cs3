//� A+ Computer Science
// www.apluscompsci.com

//ArrayList get() example

import java.util.ArrayList;
import static java.lang.System.*;

public class ArrayListGet
{
   public static void main(String args[])
	{
		ArrayList<Integer> ray = new ArrayList<Integer>();

		ray.add(23);
		ray.add(11);
		ray.add(12);
		ray.add(65);
		out.println(ray);
        // ray.get(0) is equivalent to ray[0] for arrays
		for(int i=0; i<ray.size(); i++)
		{
		   out.println(ray.get(i));
		}
	}
}