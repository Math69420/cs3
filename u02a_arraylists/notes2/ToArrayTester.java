//© A+ Computer Science
// www.apluscompsci.com

//new for loop example 1

import java.util.ArrayList;
import static java.lang.System.*;

public class ToArrayTester
{
	public static void main(String args[])
	{
		ArrayList<Integer> list;
      list = new ArrayList<Integer>();

      list.add(23);
      list.add(11);
      list.add(66);
      list.add(53);

      for(Integer num : list)  
		{
		   out.println(num.doubleValue());
		}
      out.println();  
           
      Object[] objArray = list.toArray();
      for(Object num : objArray)  
      {
         out.println( ((Integer)num).doubleValue() );
      }
      out.println(); 
         
      Integer[] intArray = list.toArray(new Integer[0]);
      for(Integer num : intArray)  
      {
         out.println(num.doubleValue());
      }          
	}
}