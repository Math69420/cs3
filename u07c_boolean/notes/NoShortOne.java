//© A+ Computer Science
// www.apluscompsci.com

//no short circuit example 1

import static java.lang.System.*;

public class NoShortOne
{
   public static void main( String args[] )
   {
		int x = 9;
		int y = 10;

		if(x==10 & ++y>=11)
		   out.println("no short 1");

		out.println("y == " + y);
   }
}