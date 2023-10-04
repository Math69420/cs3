//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;
import static java.lang.System.*;

public class ListIteratorTest
{
	private ArrayList<String> list;
	private String toRemove, replaceWith;

	public ListIteratorTest(String line, String rem, String rep)
	{
		list = new ArrayList<String>(Arrays.asList(line.split(" "))); 
		toRemove = rem; replaceWith = rep;
	}

	public void setTest(String line, String rem, String rep)
	{
		line = new ArrayList<String>(Arrays.asList(line.split(" "))); 
		toRemove = rem; replaceWith = rep;
	}

	public void replace()
	{
		ListIterator<String> it = list.listIterator(0);
		while(it.hasNext()){
			if (it.next().equals(toRemove)){
				it.remove();
				it.add(replaceWith);
			}
		}
	}

	public String toString()
	{
		return list.toString()+"\n\n";
	}
}