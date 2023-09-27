import java.util.*;
import static java.util.Collections.*;
import static java.lang.System.*;

public class IteratingThruListNodes
{
	public static void iterateThruList1(ListNode list)
	{
		ListNode prev = list;
		ListNode node = list.getNext();
			
		while(node!=null)
		{
		     out.println("prev = "+prev.getValue()+" node = "+node.getValue());
		     node=node.getNext();
		     prev=prev.getNext();
		}
	}

	public static void iterateThruList2(ListNode list)
	{
		ListNode prev = list;
			
		while(prev!=null && prev.getNext()!=null)
		{
		     out.println("prev = "+prev.getValue()+" node = "+prev.getNext().getValue());
		     prev=prev.getNext();
		}
	}

	public static void iterateThruList3(ListNode list)
	{
	   ListNode prev = list;		
	   ListNode node = list.getNext();
	   	
		while(node!=null)
		{
		   out.println("prev = "+prev.getValue()+" node = "+node.getValue());
	      prev = node;
	      node = node.getNext();   
		}
	}			
			
	public static void iterateThruList4(ListNode list)
	{
	   ListNode node = list;
	   ListNode prev = list;
	   	
		while(node!=null)
		{
		   out.println("prev = "+prev.getValue()+" node = "+node.getValue());
	      prev = node;
	      node = node.getNext();   
		}
	}


	
	public static void main(String[] args)
	{
		ListNode theList = new ListNode("1",
				     new ListNode("3",
				     new ListNode("5",
				     new ListNode("7",
				     new ListNode("9",null)))));

		iterateThruList1(theList);
		out.println("\n");
		iterateThruList2(theList);
		out.println("\n");
		iterateThruList3(theList);
		out.println("\n");
		iterateThruList4(theList);
		out.println("\n");
	}
}