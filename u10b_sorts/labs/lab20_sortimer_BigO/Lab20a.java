//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;
import static java.lang.System.*;

public class Lab20a
{
	private Comparable[] list;
	private Sorts sortTester;

	public Lab20a()
	{
		sortTester = new Sorts();
	}

	public void writeRandomFile() throws IOException
	{
		out.println("writing #s to file\n\n");

		//Use PrintWriter to write 10,000 random #s to file lab20.dat
		//Use Math.random()




	}


	public void loadFromFile(  ) throws IOException
	{
		out.println("\n\nloading #s from file");

		Scanner file = new Scanner( new File("lab20.dat"));




	}

	public void testSorts() throws IOException
	{
		loadFromFile();
		sortTester.linearSearch(list, 75000);
		out.println("Seconds taken to find 1: "+sortTester.getElapsed());

















	}

   public static void main( String args[] ) throws IOException
   {
       Lab20a prog = new Lab20a();
       prog.writeRandomFile();
       prog.testSorts();
	}
}