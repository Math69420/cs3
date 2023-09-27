//
//	CS2 - Lsn6208                                     © 2015 - Cypress Creek HS
//
// 	   Thread:	Standard Algorithms -- Monte Carlo Sort
//	Criterion:	Comparing Strings Error - relational operators
//	========================================================================
//
// 	NOTE:
// 	1)	Comparing strings does NOT work with the < Relational Operator.
//
//		Why?
//
//

package lesson;

import static java.lang.System.*;
import java.util.*;

public class Lsn6208{
	public static void main (String[] args){
		new Lesson();
}}


class Lesson
{
	String word1;
	String word2;
	char let1;
	char let2;
	int num1;
	int num2;

	Lesson()
	{
		populate();
		run();
	}

	public void run()
	{
		out.println(let1 +"<"+let2 +" => " +  ( let1 < let2 )); // not an error

		out.println(num1 +"<"+num2 +" => " +  ( num1 < num2 )); // not an error

		out.println(word1+"<"+word2+" => " +  ( word1<word2 )); // error...WHY?
		out.println( );
	}

	public void populate()
	{
		word1 = "ape";
		word2 = "apple";
		let1 = 'a';
		let2 = 'b';
		num1 = 25;
		num2 = 30;
	}
}














