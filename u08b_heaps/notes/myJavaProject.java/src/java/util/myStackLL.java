package java.util;

public class myStackLL<E> 
{
   LinkedList<E> list;

   public StackLL() {
      list = new LinkedList<E>();
   }
   
   public E push(E item) {
      list.push(item);
      return item;
   }
   
   public synchronized E pop() {
      return list.pop();
   }

   public synchronized E peek() {
      return list.peek();
   }

   public boolean empty() {
      return list.isEmpty();
   }

   public synchronized int search(Object o) {
      int i = list.lastIndexOf(o);
   
      if (i >= 0) {
         return list.size() - i;
      }
      return -1;
   }
}
