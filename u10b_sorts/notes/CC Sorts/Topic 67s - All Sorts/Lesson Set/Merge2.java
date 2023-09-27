
//  Merge 2 - Another algorithm

package lesson;

import static java.lang.System.*;
import java.util.*;
import java.io.*;

public class Merge2{
	public static void main (String[] args)	{
		new Environment();
}}


class Environment
{
	int[] list = {75, -3, 99, 25, 52, 83, 12, 7, 38};

	public Environment()
	{
		run();
	}

	public void run()
	{
		out.println( this );
		sort();
		out.println( this );
	}


	public void sort()
	{
		mysterySort(list, 0, list.length);
	}

	public void mysterySort( int[] list, int front, int back)
	{
	   int mid = (front+back)/2;
	   if( mid==front) return;

	   mysterySort(list, front, mid);
	   mysterySort(list, mid, back);
	   help(list, front, back);
	}

	private void help(int[] list, int front, int back)
	{
	   int[] temp = new int[back-front];
	   int i = front, j = (front+back)/2, k =0;
	   int mid =j;
	   while( i<mid && j<back)
	   {
	     if(list[i]< list [j])
	        temp[k++]= list[i++];
	     else
	        temp[k++]= list[j++];
	   }

	   while(i<mid)
	      temp[k++]= list[i++];
	   while(j<back)
	      temp[k++]= list[j++];
	   for(i = 0; i<back-front; ++i)
	      list[front+i]=temp[i];
	}


	public String toString()
	{
		String build = "";

		for(int x=0; x<list.length; x++)
			build += String.format("%4d",list[x]);

		return build + "\n\n";
	}
}



