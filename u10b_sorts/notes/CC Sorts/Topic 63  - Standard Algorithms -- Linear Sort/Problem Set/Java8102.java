///////////////////////////////////////////////////////////////////////////
//
//  *****   Linear SORT   *****
//
//  Java8102  Goofy Bob is upset and "out of sorts" because he can't put
//			  a list of real numbers in ascending order.  Help Bob with
//			  his sorting issues.
//
//   SAMPLE DATA FILE INPUT:  Java8102a.dat
//
//            SAMPLE OUTPUT:  Original List:
//                            --------------
//                            1.98  1.44  2.26  1.76  2.21  3.77  3.65
//
//                            Sorted List:
//                            ------------
//                            1.44  1.76  1.98  2.21  2.26  3.65  3.77
//
//   ALSO TEST YOUR PROGRAM USING:  Java8102b.dat
//
//

import static java.lang.System.*;
import java.io.*;
import java.util.*;

public class Java8102{
	public static void main (String[] args){
		new Problem02().run();
}}


class Problem02
{
	private int[] list;

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

	public Problem02()
	{	int size=0;
		String fileName = "Java8102a.dat";
		try{Scanner sizeScan = new Scanner(new File(fileName));
	
		
	
		while(sizeScan.hasNext())
		{
			size++;
		}
		
		double[]list = new double[size];
		
	
		for(int x=0;x<list.length;x++)
			list[x] = sizeScan.nextInt();	}catch(Exception e){}
	}	
	
	public void sort()
	{
      	int temp;
      	int temp2;

      	for (int x=0; x<list.length-1; x++)
        	for (int y=x+1; y<list.length; y++)
          		if (list[x] > list[y])
            	{
              		temp    = list[x];
              		temp2 = list[y];
              		list[y] = temp;
              		list[x] = temp2;
            	}		
	}
	
	public String toString()
	{
		String buildString="";
		
		for(int x=0; x<list.length; x++)
			buildString += String.format("%7.2f",list[x]);
				
		return buildString + "\n";
	}
}





