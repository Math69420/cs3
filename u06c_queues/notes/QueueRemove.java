//� A+ Computer Science
// www.apluscompsci.com

//queue remove example

import static java.lang.System.*;
import java.util.Queue;
import java.util.LinkedList;

public class QueueRemove
{
	public static void main( String args[] )
	{
		Queue<Integer> queue;
		queue = new LinkedList<Integer>();
		queue.add(11);
		queue.add(10);
		queue.add(7);
		out.println(queue.remove());
		out.println(queue);
	}
}