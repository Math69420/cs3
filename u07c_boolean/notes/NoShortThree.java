//© A+ Computer Science
// www.apluscompsci.com

//no short circuit example 3

import static java.lang.System.*;

public class NoShortThree
{
   public static void main( String args[] )
   {
		int x = 9;
		int y = 10;

		if(y>10 | x == 10 & ++y>=11)
		      out.println("no short 3");
		out.println("y == " + y);
   }
}