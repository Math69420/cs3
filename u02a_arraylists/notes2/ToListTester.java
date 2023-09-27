import java.util.*;
import static java.lang.System.*;

public class ToListTester
{
	public static void main(String args[])
	{
      Integer[] ray = {1,2,3,4,5};
      //won't compile because asList creates a fixed-length list:
		//ArrayList<Integer> list = Arrays.asList(ray);
		List<Integer> list = Arrays.asList(ray);
      
      //throws UnsupportedOperationException:
      //list.add(23);


      for(Integer num : list)  
		{
		   out.println(num.intValue() + "\t" + num.doubleValue());  //.intValue() could have been dropped
		}
      out.println();    
	}
}