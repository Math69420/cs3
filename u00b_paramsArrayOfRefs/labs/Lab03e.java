//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Scanner;
import java.util.Arrays;
import static java.lang.System.*;

public class Lab03e
{
	public static void main( String args[] )
	{
		Scanner keyboard = new Scanner(in);

		out.print("How many arrays do you wish to enter? :: ");
		int rowCount = keyboard.nextInt();

		TwoDRay test = new TwoDRay(rowCount);

		for(int i = 0; i < rowCount; i++)
		{
			out.print("What is the size of array " + i + " : ");
			int size = keyboard.nextInt();

			int[] ray = new int[size];
			out.println();
			for (int j = 0; j<ray.length; j++)
			{
				out.print("Enter the value for spot " + j + " :: ");
				ray[j] = keyboard.nextInt();
			}

			out.println("\nTwoDRay before copying ray to row "+i);
			out.println(test);		//call TwoDRay toString()
			

			test.setRow(i,ray);
			

			out.println("\nTwoDRay before sorting row "+i);
											//call TwoDRay toString()


			test.sortRow(i);

			out.println("\nTwoDRay after sorting row "+i);
											//call TwoDRay toString()
		}
	}
}