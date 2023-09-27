package java.util;

public interface StackInterface<E> 
{
   public E push(E item); 
      
   public synchronized E pop();

   public synchronized E peek(); 
   
   public boolean isEmpty();

   public static int search(Object o) {
      int i = list.lastIndexOf(o);
   
      if (i >= 0) {
         return list.size() - i;
      }
      return -1;
   }
}
