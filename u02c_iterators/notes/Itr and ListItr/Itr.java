// The Itr class is a private Inner Class found in the AbstractList class

private class Itr implements Iterator<E> {
   /**
    * Index of element to be returned by subsequent call to next.
    */
   int cursor = 0;

   /**
    * Index of element returned by most recent call to next or
    * previous.  Reset to -1 if this element is deleted by a call
    * to remove.
    */
   int lastRet = -1;

   /**
    * The modCount value that the iterator believes that the backing
    * List should have.  If this expectation is violated, the iterator
    * has detected concurrent modification.
    */
   int expectedModCount = modCount;

   public boolean hasNext() 
   {
      return cursor != size();
   }

   public E next() 
   {
      checkForComodification();
      try 
      {
         E next = get(cursor);
         lastRet = cursor++;
         return next;
       } 
       catch (IndexOutOfBoundsException e) 
       {
         checkForComodification();
         throw new NoSuchElementException();
       }
   }

   public void remove() 
   {
      if (lastRet == -1)
         throw new IllegalStateException();
      checkForComodification();

      try 
      {
         AbstractList.this.remove(lastRet);
         if (lastRet < cursor)
            cursor--;
         lastRet = -1;
         expectedModCount = modCount;
      } 
      catch (IndexOutOfBoundsException e) 
      {
         throw new ConcurrentModificationException();
      }
   }

   final void checkForComodification() 
   {
      if (modCount != expectedModCount)
      throw new ConcurrentModificationException();
   }
    }

