//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class Rational implements Comparable<Rational>
{
	private int numerator;
	private int denominator;

	public Rational()
	{
	}

	public Rational(int num, int den)
	{
	}

	public void setNumerator(int num)
	{
	}

	public void setDenominator(int den)
	{
	}

	public void add( Rational  other)
	{
	}
	
	public Object clone( )
	{
		return new Object();
	}

	public boolean equals( Object other)
	{
		Rational rhs = (Rational)other;
		return false;
	}

	public int compareTo( Rational other)
	{
		//How do you compare fractions?
		//convert the fraction to a decimal
		//compare the decimal values
		return 0;
	}

	public int getNumerator()
	{
		return 0;
	}

	public int getDenominator()
	{
		return 0;
	}

	public String toString()
	{
	   return getNumerator() + "/" + getDenominator();
	}

	private void reduce()
	{
	}

	private int gcd(int one, int two)
	{
	   return 0;
	}
}