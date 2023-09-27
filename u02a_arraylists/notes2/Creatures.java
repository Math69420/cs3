import static java.lang.System.*;
import java.util.ArrayList;
import java.util.Collections;

public class Creatures
{
	private ArrayList<Creature> creatureList;

	public Creatures()
	{
		creatureList = new ArrayList<Creature>();
	}

	public void add(int creatureSize)
	{
		creatureList.add( new Creature(creatureSize));
	}
	
	public void removeAllOfSize(int size)
	{
		int i=0;
		while(i<creatureList.size()) {
			if(creatureList.get(i).getSize()==size)
				creatureList.remove(i);
		   else i++;
		}
	}

	public String toString()
	{
		return "" + creatureList;
	}
}