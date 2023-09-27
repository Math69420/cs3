// Node.java
public class Node
{
   public Node next, prev;
   public String data;

   public Node()
   {
      prev = null;
      next = null;
   }

   public Node(String s)
   {
      data = s;
      prev = null;
      next = null;
   }

}
