///////////////////////////////////////////////////////////////////////////
//
//  *****   SELECTION SORT   *****
//
//  Java8304 The ShowMeTheMoney Credit Card Company has gathered some
//           of their outstanding accounts with the remaining balances due,
//           but the clerk who input the data entered them in a random
//           order.  The accounting department would like to know who owes
//           the most money.  Please sort the data in the file by the highest
//           balance due down to the lowest balance due so the company can 
//			 begin gathering their outstanding amounts in order of priority.
//
//           Time to test your knowledge of OOP.  Much of the program has been
//			 done for you.  Your job is to fill in the missing code in the 
//			 program.  This is an example of sorting OBJECTS, so multi-class
//			 design must be implemented.
//
//   SAMPLE DATA FILE INPUT:  Java8304a.dat
//							  1/95
//							  1768
//							  524.60
//							  2/92
//							  1435
//							  100.00
//							  1/91
//							  2341
//							  234.78
//							  3/94
//							  3417
//							  50.67
//
//            SAMPLE OUTPUT: 
//							Original List:
//							-------------
//							Date   Account Number  Balance Due
//							1/95      1768         $  524.60
//							2/92      1435         $  100.00
//							1/91      2341         $  234.78
//							3/94      3417         $   50.67
//							
//							Sorted List:
//							-----------
//							Date   Account Number  Balance Due
//							1/95      1768         $  524.60
//							1/91      2341         $  234.78
//							2/92      1435         $  100.00
//							3/94      3417         $   50.67
//
//
//   ALSO TEST YOUR PROGRAM USING:  Java8304b.dat
//
//

package solution;

import java.util.*;
import java.io.*;
import static java.lang.System.*;
import static java.lang.String.*;

public class Java8304{
	public static void main (String args[]){
		new Environment().run();
}}


class Environment
{
	private /* What's the data type? */ [] list;
	
	public void run()
	{
		out.println("Original List:");
		out.println("-------------");
		out.println( this );
		sort();
		out.println("Sorted List:");
		out.println("-----------");
		out.println( this );
	}

	public Environment()throws IOException
	{
		String fileName = "Java8304a.dat";
		Scanner sizeScan = new Scanner(new File(fileName));
		int size=0;
		while(sizeScan.hasNext())
		{
			// how much to scan before you count it?
			
			size++;
		}
		
		list = new /* What's the data type? */ [size];
		
		Scanner fileScan = new Scanner(new File(fileName));
		for(int x=0;x<list.length;x++)
		{
			/* scan in the date, account number, and balance from the
			   data file.  Do you need a garbage scan somewhere */
			
			
			
						
			list[x] = new /* ????????????? */
		}
			
	}
	
	public void sort()
	{
		int index;
		/* What's the data type? */ temp;
		
		for(int x=0;x<list.length-1;x++)
		{
			index=x;
			for(int y=x+1;y<list.length;y++)
				if(/* ????????????? */  )
					index=y;
			temp=list[index];
			list[index]=list[x];
			list[x]=temp;
		}
	}
	
	public String toString()
	{
		String buildString = "Date   Account Number  Balance Due\n";
		
		for(int x=0; x<list.length; x++)
			buildString += list[x] + "\n";
				
		return buildString + "\n";
	}
}

class Billing
{
	public String date;
	private int accountNum;
	private double balance;
	
	Billing(/* ????????????? */)
	{
		/* ????????????? */
	}
	
	double getBalance()
	{
		/* ????????????? */
	}
	public String toString()
	{
		String all = "";
		
		all += format("%4s",date);
		all += format("%10d",accountNum);
		all += format("%10s", "$");
		all += format("%8.2f",balance);
		return all;
		
	}
	
}




