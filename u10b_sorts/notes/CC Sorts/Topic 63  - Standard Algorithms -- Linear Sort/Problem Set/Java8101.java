///////////////////////////////////////////////////////////////////////////
//
//  *****   Linear SORT   *****
//
// Java8101  Sort the following data set in descending order
//			 Assign the data at time of construction.
//
//
//            SAMPLE OUTPUT:  Original List:
//                            --------------
//                            7 6 12 3 9 25 34 11 8
//
//                            Sorted List:
//                            --------------
//                            34 25 12 11 9 8 7 6 3
//
//
//

import static java.lang.System.*;

public class Java8101{
	public static void main (String[] args){
		new Problem01().run();
}}


class Problem01
{
	private int[] s;
	
	public void run()
	{
		out.println("Original List:");
		out.println("-------------");
		out.println( this);
		
		sort();
		
		out.println("Sorted List:");
		out.println("-----------");
		out.println( this );
	}

	public Problem01()
	{
		 s = new int[]{2,3,4,5,6,7,8};	
	}	
	
	public void sort()
	{
        for(int y=0;y<s.length-1;y++)
			for(int w=y+1;w<s.length;w++)
			   if ( s[y]<(s[w]) )
            	{												
			  		int item1 = s[y];
			  		int item2 = s[w];
			  		s[y]=item2;
			  		s[w]=item1;
			  	}
		 out.println("Deccending==>" + this);
	}
	
	public String toString()
	{
		String buildString = "";
		
		for(int x=0; x<s.length; x++)
			buildString += String.format("%3d",s[x]);
				
		return buildString + "\n";
	}
}





