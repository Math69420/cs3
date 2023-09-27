import static java.lang.System.*;
import java.util.Queue;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class PQAdd
{
	public static void main( String args[] )
	{
		PriorityQueue<Integer> pQueue;
		pQueue = new PriorityQueue<Integer>();
		pQueue.add(11);
		pQueue.add(10);
		pQueue.add(7);
		out.println(pQueue);
		out.println(pQueue.poll());
		out.println(pQueue.poll());
		out.println(pQueue.poll());
		out.println(pQueue.poll());
 }
}