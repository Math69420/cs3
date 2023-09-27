//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class Lab01f
{
	public static void main( String args[] )
	{
		Rational test = new Rational();
		out.println("test = " + test);

		Rational newOne = new Rational(3,4);
		out.println("newOne = "+newOne);

		out.println("test.equals(newOne) = "+test.equals(newOne));

		//uncomment after you write clone()
		/*newOne = (Rational)test.clone();
		out.println("\n\nnewOne after test.clone() = "+newOne);

		Rational rOne = new Rational(1,2);
		Rational rTwo = new Rational(2,3);

		out.println("\n\nrOne = "+rOne);
		out.println("rTwo = "+rTwo);

		out.println("rOne.compareTo(rTwo) = "+rOne.compareTo(rTwo));

		out.println("rTwo.compareTo(rOne) = "+rTwo.compareTo(rOne));

		rOne.add(rTwo);
		out.println("\n\nrOne.add(rTwo) = "+ rOne);

		rOne = new Rational(1,2);
		rTwo = new Rational(1,3);
		rOne.add(rTwo);
		out.println("\n\n1/2.add(1/3) = "+ rOne);
		*/
	}
}