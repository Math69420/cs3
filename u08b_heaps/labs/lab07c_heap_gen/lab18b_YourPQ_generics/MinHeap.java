import java.util.ArrayList;
import static java.lang.System.*;

public class MinHeap<T extends Comparable<T>>
{
   private ArrayList<T> list;

   //Initialization block.  Put the list initialization here
   //so it happens in every constructor.
   {
      list = new ArrayList<T>();
   }
   
   //Simply needs to create the ArrayList, 
   //but that's already done by the initialization block.
   public MinHeap()
   {
   }
   
   @SuppressWarnings("unchecked")
   //Copy constructor that fills this heap's list
   //with the the contents of original in the same order.
   //Hint:  Use the ArrayList copy constructor.
   public MinHeap(MinHeap original)
   {
      list = new ArrayList<T>(original.list);
   }

   //Should return a COPY of this heap's list.
   public ArrayList<T> getList()
   {
      return new ArrayList<T>(list);
   }

   public void add(T value)
   {
      list.add(value);
      swapUp(list.size()-1);
   }

   public void swapUp(int bot)
   {
      while(bot>0)
      {
         int parent = (bot-1)/2;
         int cmp = list.get(parent).compareTo(list.get(bot));
         if(cmp > 0)
         {
            swap(parent, bot);
            bot=parent;
         }
         else{
            break;
         }
      }
   }

   public T remove( )
   {
      T ret = list.get(0);
      list.set(0,list.get(list.size()-1));
      list.remove(list.size()-1);
      swapDown(list.size());
      return ret;
   }

   public void swapDown(int top)
   {
      int root=0;
      while(root < top)
      {
         int min=0;
         int left = root * 2 + 1;
         int right = root * 2 + 2;
      
         if(left < top )
         {
            if(right < top )
            {
               if (list.get(left).compareTo(list.get(right))>=0)
               {
                  min = right;
               }
               else
               {
                  min = left;
               }
            }
            else
               min = left;
         }
         else 
            break;
      
         if (list.get(root).compareTo(list.get(min))>0)
         {
            swap(root, min);
            root=min;
         }
         else 
            break;
      }
   }
	
   private void swap(int start, int finish)
   {
      T temp = list.get(start);
      list.set(start,list.get(finish));
      list.set(finish,temp);		
   }
	
   public T peek()
   {
      return list.get(0);
   }
	
   public boolean isEmpty()
   {
      return list.size()==0;
   }

   public void print()
   {
      out.println("\n\nPRINTING THE HEAP!\n\n");
      int x=0;
      for(int i=1; i<list.size();i*=2)
      {
         for(int s=1;s<list.size()-i;s++)
         {
            out.print(" ");
         }
         for(int j=0;j<=i-1&&x<list.size(); j++)
         {
            out.print(list.get(x++)+"  ");
         }
         out.println();
         if(x==list.size()-1)
         {
            out.print(list.get(x++)+"  ");
         }
      }
      out.println();
   }

   public String toString()
   {
      return list.toString();
   }
}