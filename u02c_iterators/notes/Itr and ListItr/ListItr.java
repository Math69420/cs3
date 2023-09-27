// The ListItr class is a subclass of the Itr class and is also a private
// Inner Class found in the AbstractList class

private class ListItr extends Itr implements ListIterator<E> 
{
   ListItr(int index) 
   {
      cursor = index;
   }

   public boolean hasPrevious() 
   {
      return cursor != 0;
   }

   public E previous() 
   {
      checkForComodification();
      try 
      {
         int i = cursor - 1;
         E previous = get(i);
         lastRet = cursor = i;
         return previous;
      } 
      catch (IndexOutOfBoundsException e) 
      {
         checkForComodification();
         throw new NoSuchElementException();
      }
   }

   public int nextIndex() 
   {
      return cursor;
   }

   public int previousIndex() 
   {
      return cursor-1;
   }

   public void set(E e) 
   {
      if (lastRet == -1)
         throw new IllegalStateException();
      checkForComodification();

      try 
      {
         AbstractList.this.set(lastRet, e);
         expectedModCount = modCount;
      } 
      catch (IndexOutOfBoundsException ex) 
      {
         throw new ConcurrentModificationException();
      }
   }
   
   public void add(E e) 
   {
      checkForComodification();

      try 
      {
         AbstractList.this.add(cursor++, e);
         lastRet = -1;
         expectedModCount = modCount;
      } 
      catch (IndexOutOfBoundsException ex) 
      {
         throw new ConcurrentModificationException();
      }
   }
}