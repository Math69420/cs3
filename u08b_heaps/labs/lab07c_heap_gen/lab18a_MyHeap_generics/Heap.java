//© A+ Computer Science	 -	 www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab	 -

import java.util.ArrayList;
import static java.lang.System.*;

public class Heap<T extends Comparable<T>>
{
	private ArrayList<T>	list;

	public Heap()
	{
		
	}

	public void	add(T	value)
	{
		//add	new value to end
		//call swapUp
	}

	public void	swapUp()
	{
		//start at end	of	list
		//calculate	location	of	parent
		//while below the	root AND	value	of	parent <	current value	(use compareTo!)
			//swap values
			//update	location	to	that of parent
			//update	location	of	parent 
	}

	public T	remove( )
	{
		//store root
		//move last	element to beginning	of	list
		//call swapDown
		//return	removed value
	}

	public void	swapDown()
	{
		//start	at	root
		//while	above	last element
			//create	variable	to	store	location	of	biggest	child
			//calculate	locations of left	&	right	children
			 
			//Case 1: You're	at	a leaf 
			//if	it's a leaf
				//end	loop (which	ends the	method since there's	nothing after the	loop)
		
			//Case 2: There's	only	a left child OR the left child is bigger
			//if	right	>=	end OR left	child	is	bigger (use	compareTo!)
				//left	child	is	bigger;
			//otherwise
				//right child is bigger
		
			//Decide	whether	you're done	or	not:
			//if	value	here < biggest	child	(use compareTo!)
				//swap	with biggest child
				//update	location
			//otherwise	
				//end	loop /	method	
	}
	
	//swap element	at	start	in	list with element	at	finish
	private void swap(int start, int	finish)
	{
	
	}
	
	public T	peek()
	{
		return null;
	}
	
	public boolean	isEmpty()
	{
		return false;
	}

	public String toString()
	{
		return list.toString();
	}
	
	public void	print() 
	{
		int size	= list.size();
		int maxDepth =	(int)	(Math.log(size) /	Math.log(2));	//	log base	2 of n
	
		StringBuilder hs = new StringBuilder();  // heap string builder
		for(int d =	maxDepth; d	>=	0;	d--) {  // number	of	layers, we build this backwards
			int layerLength =	(int)	Math.pow(2,	d);  // numbers per layer
		
			StringBuilder line =	new StringBuilder();	 // line	string builder
			for(int i =	layerLength; i	< (int) Math.pow(2, d +	1); i++)	{
				//	before spaces only on not-last layer
				if(d != maxDepth)	{
					line.append(spaces((int) Math.pow(2, maxDepth -	d)));	 
				}
				//	extra	spaces for long lines
				int loops =	maxDepth	- d;
				if(loops	>=	2)	{
					loops	-=	2;
					while(loops	>=	0)	{
						line.append(spaces((int) Math.pow(2, loops)));
						loops--;
					}
				}
			
				//	add in the number
				if(i < size) {
					line.append(String.format("%-2s", list.get(i)));  // add	leading zeros
				} else {
					line.append("__");
				}
			
				line.append( spaces((int) Math.pow(2, maxDepth - d)) );	//" ".repeat((int) Math.pow(2, maxDepth -	d)));	 // after spaces
				//	extra	spaces for long lines
				loops	= maxDepth - d;
				if(loops	>=	2)	{
					loops	-=	2;
					while(loops	>=	0)	{
						line.append(spaces((int) Math.pow(2, loops))); //line.append("	".repeat((int)	Math.pow(2,	loops)));
						loops--;
					}
				}
			}
			hs.insert(0, line.toString() + "\n");	//	prepend line
		}
		System.out.println(hs.toString());
	}

	private String	spaces(int size) {
		StringBuilder spaces	= new	StringBuilder();
		for(int n=1; n<=size; n++)
			spaces.append(" ");
		return spaces.toString();
	}
}