//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class Lab09b
{
	public static void main(String args[])
	{
		AtCounter a = new AtCounter();
		a.countAts(0,0);
		out.println(a);
		a = new AtCounter();
		a.countAts(2,5);
		out.println(a);
		a = new AtCounter();
		a.countAts(5,0);
		out.println(a);
		a = new AtCounter();
		a.countAts(9,9);
		out.println(a);
		a = new AtCounter();
		a.countAts(3,9);
		out.println(a);	
	}
}