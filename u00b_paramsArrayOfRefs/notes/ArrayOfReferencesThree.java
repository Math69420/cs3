//© A+ Computer Science
// www.apluscompsci.com

//array of references example 3

import static java.lang.System.*;
import java.util.Arrays;

public class ArrayOfReferencesThree
{
	public static void main ( String[] args )
	{
		Creature[] creatureList = new Creature[3];
		//add 3 creatures to creatureList
		
		
		
		Arrays.sort(creatureList);  		//will throw an exception until
															//creatures are added to the array		
		
		for(Creature it : creatureList)
		{
			out.println(it);
		}		
		
		creatureList[0].setSize(41);
		out.println(creatureList[0].toString());		//toString called automatically
																	//but,this makes a good demo
  }
}