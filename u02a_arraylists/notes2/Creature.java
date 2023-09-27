import static java.lang.System.*;

public class Creature implements Comparable<Creature>
{
	private int size;
	
	public Creature(int girth) { 
		size=girth; 
	}
	
	public void setSize(int girth)
	{
		size=girth;
	}
	
	public int getSize()
	{
		return size;
	}
	
	public boolean equals(Object obj)
	{
		Creature other = (Creature)obj;
		if(size==other.size)
			return true;
		return false;   	
	}
	
	public int compareTo(Creature other) 
	{
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