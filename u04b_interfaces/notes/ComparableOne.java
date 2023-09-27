//© A+ Computer Science
// www.apluscompsci.com

//comparable example one

import static java.lang.System.*;

public class ComparableOne
{
	public static void main ( String[] args )
	{
		out.println("CompareTo() returns 0 for ==");
		out.println("CompareTo() returns <0 for <");
		out.println("CompareTo() returns >0 for >\n");

		Comparable x = 54;
		Comparable y = 67;
		out.print("54.compareTo(67) == ");
		out.println(x.compareTo(y));
		
		Comparable a = 9.21;
		Comparable b = 8.54;
		out.print("9.21.compareTo(8.54) == ");
		out.println(a.compareTo(b));		
  }
}