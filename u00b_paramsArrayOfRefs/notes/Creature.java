//© A+ Computer Science
// www.apluscompsci.com

//array of references example 3

import static java.lang.System.*;

public class Creature implements Comparable
{
	private int size;
	
	public Creature(int girth) { 
		size=girth; 
	}
	
	public void setSize(int girth)
	{
		size=girth;
	}
	
	public boolean equals(Object obj)
	{
		Creature other = (Creature)obj;
		if(size==other.size)
			return true;
		return false;   	
	}
	
	public int compareTo(Object obj) 
	{
		Creature other = (Creature)obj;
		if(size>other.size)
			return 1;
		else if(size<other.size) 
			return -1;
		return 0; 
	}
	
	public String toString() { 
		return "" + size; 
	}
}