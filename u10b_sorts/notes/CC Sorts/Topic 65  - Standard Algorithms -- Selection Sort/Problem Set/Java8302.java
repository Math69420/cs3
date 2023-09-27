///////////////////////////////////////////////////////////////////////////
//
//  *****   SELECTION SORT   *****
//
//  Java8302 Sort the following data set alphabetically.
//			 Populate the list from a data file.
//
//   SAMPLE DATA FILE INPUT:  Java8302a.dat
//
//            SAMPLE OUTPUT:  Original List:
//                            --------------
//                            Pittsburgh Pirates
//							  Atlanta Braves
//							  New York Mets
//							  San Francisco Giants
//							  Florida Marlins
//							  Philadelphia Phillies
//							  <etc ... National League Teams>
//
//                            Sorted List:
//                            --------------
//                            Arizona Diamondbacks
//                            Atlanta Braves
//                            Chicago Cubs
//                            Cincinnati Reds
//                            Colorado Rockies
//                            Florida Marlins
//                            Houston Astros
//							  <etc ... National League Teams>
 
//   ALSO TEST YOUR PROGRAM USING:  Java8302b.dat
//
//

package solution;

import java.util.*;
import java.io.*;

import static java.lang.System.*;

public class Java8302{
	public static void main (String args[]){
		new Environment().run();
}}


class Environment
{
	ArrayList<String> list = new ArrayList<String>();
	
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

	public Environment()
	{
		try{
			Scanner fileScan = new Scanner(new File("Java8302a.dat"));
			while(fileScan.hasNext())
			{
				list.add(fileScan.nextLine());
			}
			
		}
		catch(Exception e){}
	}
	
	public void sort()
	{
	    int index=0;
		for(int x=0;x<list.size()-1;x++)
		{
			index=x;
			for(int y=x+1;y<list.size();y++)
				if(list.get(y).compareTo(list.get(x))<0)
				{
					index=y;
				
					String l,q;
					l=list.get(x);
					q=list.get(y);
					list.set(x,q);
					list.set(y,l);
				}
		} 
		
		
	}
	
	public String toString()
	{
		String temp = "";
		for(int x=0;x<list.size();x++)
			temp+=list.get(x)+" ";
			return temp;
	}
}





