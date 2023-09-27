package java.util;

public interface Queue<E> extends Collection<E> {
    
   boolean add(E e);

   boolean offer(E e);

   E remove();

   E poll();

   E element();

   E peek();
}


//This is how you'd make a queue:
//
//  Queue q = new LinkedList();