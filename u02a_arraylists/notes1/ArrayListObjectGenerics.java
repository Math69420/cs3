//© A+ Computer Science
// www.apluscompsci.com

//ArrayList generics

import java.util.ArrayList;
import java.util.List;
import static java.lang.System.*;

public class ArrayListObjectGenerics
{
   public static void main(String args[])
	{
		List<String> ray;
		ray = new ArrayList<String>();
		ray.add("hello");
		ray.add("whoot");
		ray.add("contests");
		ray.add("5");
      //ray.add(5);
		out.println(ray.get(0).charAt(0));
		out.println(ray.get(2).charAt(0));
		out.println(ray + "\n");

      ArrayList<Integer> intList = new ArrayList<Integer>();    //bueno
      //ArrayList<Integer> intList = new ArrayList<>();           //good
      //ArrayList<> intList = new ArrayList<Integer>();           //doesn't compile      
      //ArrayList intList = new ArrayList<Integer>();             //mal (Compiles but allows addition of non-Integers)
      //ArrayList<Integer> intList = new ArrayList();             //no good (Compiles but allows addition of non-Integers)
      //ArrayList<Integer> intList = new ArrayList<String>();     //doesn't compile
      //ArrayList<Comparable> intList = new ArrayList<Integer>(); //Doesn't compile 
      //ArrayList<Integer> intList = new ArrayList<Number>();     //Doesn't compile  
      intList.add(new Integer(2));
		intList.add(7);
		intList.add(65);
      intList.add("no");
		out.println(intList + "\n");
      
      ArrayList<Long> bigList = new ArrayList<>();
		bigList.add(new Long(2));
		bigList.add(7L);
		bigList.add(65537765987l);
		out.println(bigList);      
	}
}