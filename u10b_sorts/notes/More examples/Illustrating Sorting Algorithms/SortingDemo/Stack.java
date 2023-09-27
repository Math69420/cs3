// Stack.java
// Implements a standard stack.
// Note that you must check on your own if the stack is empty before trying to
// pop an element.
public class Stack
{
   public Node top, bottom;
   public int numOfNodes;

   public Stack()
   {
      top = null;
      bottom = null;
      numOfNodes = 0;
   }

   public boolean isEmpty()
   {
      return (top == null);
   }

   public void push(String s)
   {
      Node p = new Node(s);
      p.next = top;
      if (top != null)
        top.prev = p;
      top = p;
      if (numOfNodes == 0)
        bottom = p;
      numOfNodes += 1;
   }

   public String pop()
   {
      Node p = top;
      String s = p.data;
      top = top.next;
      if (top != null)
        top.prev = null;
      else
        bottom = null;
      p = null;
      numOfNodes -= 1;
      return s;
   }

   public String peek()
   {
      return top.data;
   }

   public void show()
   {
      Node p = top;
      while (p != null)
      {
         System.out.println(p.data);
         p = p.next;
      }
      System.out.println("");
   }

   public void erase()
   {
      top = null;
      numOfNodes = 0;
   }

}
