package java.util;
public class StackD<E> 
{
   Vector<E> v;

   public StackD() {
      v = new Vector<E>();
   }
   
   public E push(E item) {
      v.addElement(item);
      return item;
   }
   
   public synchronized E pop() {
      E	obj;
      int	len = v.size();
   
      obj = peek();
      v.removeElementAt(len - 1);
   
      return obj;
   }

   public synchronized E peek() {
      int	len = v.size();
   
      if (len == 0)
         throw new EmptyStackException();
      return v.elementAt(len - 1);
   }

   public boolean empty() {
      return v.isEmpty();
   }

   public synchronized int search(Object o) {
      int i = v.lastIndexOf(o);
   
      if (i >= 0) {
         return v.size() - i;
      }
      return -1;
   }
}
