//© A+ Computer Science
// www.apluscompsci.com

//no short circuit example 2

import static java.lang.System.*;

public class NoShortTwo
{
   public static void main( String args[] )
   {
		int x = 9;
		int y = 10;

		if(y>5 | x==10 & ++y>=11)
		     out.println("no short 2");
		out.println("y == " + y);
   }
}