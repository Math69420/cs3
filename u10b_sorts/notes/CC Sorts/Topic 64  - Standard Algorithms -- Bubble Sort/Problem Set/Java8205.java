///////////////////////////////////////////////////////////////////////////
//
//  *****   BUBBLE SORT   *****
//
//  Java8205  Sort the following data set in ascending order.
//			  The data is stored horizontally in the data file.
//            Also calculate the efficiency of the sort.
//
//   SAMPLE DATA FILE INPUT:  Java8205a.dat
//
//            SAMPLE OUTPUT:  Original List:
//							  -------------
//							  37 924 -5 76 451 -62 51
//							  
//							  Sorted List:
//							  -----------
//							  -62 -5 37 51 76 451 924
//							  
//                            Efficiency:
//                            -----------
//                            18
//
//   ALSO TEST YOUR PROGRAM USING:  Java8205b.dat
//
//

import static java.lang.System.*;
import java.io.*;
import java.util.*;
public class Java8205{
	public static void main(String args[]){
		new Classs();
	}
}
class Classs{
	ArrayList<Integer> list = new ArrayList<Integer>();
	int effi = 0;
	public Classs()
	{
		try{
			Scanner fileScan = new Scanner(new File("Java8205a.dat"));
			while(fileScan.hasNext()){
				list.add(fileScan.nextInt());
			}
		}
		
		catch(Exception e){}
		out.println("Before:"+this);

		 		boolean finished = false;
  		int bEnd  = list.size()-1;
 		while ( !finished )
    	{
	  		finished = true;
     		for (int x=0; x<  bEnd  ; x++)
     		{
     			effi++;
	       		if ( list.get(x) > list.get(x+1) )
          		{
			  		Integer d1 = list.get(x);
			  		Integer d2 = list.get(x+1);
			  		list.set(x,d2);
			  		list.set(x+1,d1);
            		finished  = false;
          		}
          		
	        }
			bEnd--;
	   	}
	   	out.println("After:"+this);
	   	out.println("Efficency:"+effi);
	}
	public String toString()
	{
		String temp="";
		for(int x=0;x<list.size();x++)
		{
			temp+=list.get(x)+" ";
		}
		return temp;
		
	}
}