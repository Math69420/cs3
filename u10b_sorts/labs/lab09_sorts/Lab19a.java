//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;

public class Lab19a
{
	public static void main( String args[] )
	{
		InsertionSort test = new InsertionSort();
		out.println("addding alice");
		test.add("alice");
		out.println("addding tommy");
		test.add("tommy");
		out.println("addding bobby");
		test.add("bobby");
		out.println("printing the list ::  "+test+"\n\n");
		out.println("removing bobby");
		test.remove("bobby");
		out.println("printing the list ::  "+test+"\n\n");
		out.println("removing alice");
		test.remove("alice");
		out.println("printing the list ::  "+test+"\n\n");
		out.println("addding fred");
		test.add("fred");
		out.println("addding xylaphone");
		test.add("xylaphone");
		out.println("printing the list ::  "+test+"\n\n");
	}
}