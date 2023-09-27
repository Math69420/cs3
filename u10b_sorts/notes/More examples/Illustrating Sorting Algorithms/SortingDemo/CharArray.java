// CharArray.java
// Provides methods for manipulating an array of characters.
import java.util.*;

public class CharArray
{
   public static final int MAXLENGTH = 512;
   public char[] chars = new char[MAXLENGTH];
   public int length;

   public CharArray(String string)
   {
      // sets length to the length of the incoming string
      // sets each character in the string to the corresponding location in the
      // array and pads the remaining slots in the array with spaces
      length = string.length();
      for(int i = 0; i < length; i++)
        chars[i] = string.charAt(i);
      for(int i = length; i < MAXLENGTH; i++)
        chars[i] = ' ';
   }

   public CharArray(CharArray ch)
   {
      // works the same as the above constructor but has a CharArray as its
      // parameter
      length = ch.length;
      for(int i = 0; i < length; i++)
        chars[i] = ch.chars[i];
      for(int i = length; i < MAXLENGTH; i++)
        chars[i] = ' ';
   }

   public boolean isExistence()
   {
      // returns true if the user did not input a line of spaces (i.e. something exists)
      // returns false otherwise
      int i = 0;
      boolean done = false;
      while ((i < length) && (!done))
        if (chars[i] != ' ')
          done = true;
        else
          i += 1;
      return done;
   }

   public int pos(char ch)
   {
      // sequential search for a character starting at the beginning of the array
      boolean done = false;
      int i = 0;
      int pos = -1;
      while (!(done) && (i < length))
        if (chars[i] == ch)
        {
           pos = i;
           done = true;
        }
        else
           i += 1;
      return pos;
   }

   public int pos(char ch, int i)
   {
      // sequential search for a character starting at position i
      boolean done = false;
      int pos = -1;
      while (!(done) && (i < length))
        if (chars[i] == ch)
        {
           pos = i;
           done = true;
        }
        else
           i += 1;
      return pos;
   }

   public int pos(char[] ch)
   {
      // finds the position of an array within the array of characters
      boolean done = false;
      boolean found = false;
      int i = 0;
      int pos = -1;
      int j = 0;          
      while ((!(done)) && (j < ch.length))
      {
         if (chars[i] == ch[j])
         {
            if (j == 0)
              pos = i;
            j += 1;
         }
         else
         {
            if (j != 0)
              i -= 1;
            j = 0;
         }
         i += 1;
         if (j == ch.length)
           found = true;
         if (i == length)
           done = true;
      }
      if (found)
        return pos;
      else
        return -1;
   }

   public int posFromEnd(char ch, int pos)
   {
      // finds the position of a character starting at the end of the array
      boolean done = false;
      while (!(done) && (pos > -1))
        if (chars[pos] == ch)
          done = true;
        else
          pos -= 1;
      if (done)
        return pos;
      else
        return -1;
   }

   public void addOn(char ch)
   {
      // inserts a character at the end of the array
      chars[length] = ch;
      length += 1;
   }

   public void insert(char ch, int pos)
   {
      // inserts a character at position pos
      for(int i = length - 1; i >= pos; i--)
        chars[i + 1] = chars[i];
      chars[pos] = ch;
      length += 1;
   }

   public void delete(int pos, int howMany)
   {
      // deletes howMany characters starting at position pos
      if (pos + 1 != length)
      {
         for(int i = pos; i < length; i++)
           chars[i] = chars[i + howMany];
      }
      length -= howMany;
   }

   public int[] getArray(int MAXLENGTH) throws ArrayException
   {
      // returns an array of integers parsed from the CharArray and
      // throws an ArrayException if an error occurs
      int[] A = new int[MAXLENGTH];
      boolean done = false;
      int i = 0;
      while (chars[0] == ' ')
         delete(0, 1);
      while (chars[length - 1] == ' ')
         delete(length - 1, 1);
      addOn(' ');
      while (i < length)
      {
         char ch = chars[i];
         if (!((ch >= '0') && (ch <= '9')) && (ch != '-') && (ch != ' '))
           throw new ArrayException("Cannot sort array: error in input.");
         else
           i += 1;
      }
      int lastP = 0, arrayPos = 0;
      while (!done)
      {
         int p = pos(' ', lastP);
         if (p > 0)
         {
            String temp = new String(chars, lastP, p - lastP);
            if (arrayPos < MAXLENGTH)
               try
               {
                  A[arrayPos] = Integer.parseInt(temp);
                  lastP = p + 1;
                  while ((lastP < length) && (chars[lastP] == ' '))
                    delete(lastP, 1);
                  arrayPos += 1;
               }
               catch (NumberFormatException nfe)
               {
                  throw new ArrayException("Cannot sort array: error in input.");
               }
            else
               throw new ArrayException("Array exceeds maximum of " + MAXLENGTH + " integers.");
         }
         else
           done = true;
      }
      int[] B = new int[arrayPos];
      for(int j = 0; j < arrayPos; j++)
        B[j] = A[j];
      return B;
   }

   public int[] getBoundlessArray() throws ArrayException
   {
      // returns an array of integers parsed from the CharArray and
      // throws an ArrayException if an error occurs
      Vector Avec = new Vector();
      boolean done = false;
      int i = 0;
      while (chars[0] == ' ')
         delete(0, 1);
      while (chars[length - 1] == ' ')
         delete(length - 1, 1);
      addOn(' ');
      while (i < length)
      {
         char ch = chars[i];
         if (!((ch >= '0') && (ch <= '9')) && (ch != '-') && (ch != ' '))
           throw new ArrayException("Cannot sort array: error in input.");
         else
           i += 1;
      }
      int lastP = 0;
      while (!done)
      {
         int p = pos(' ', lastP);
         if (p > 0)
         {
            String temp = new String(chars, lastP, p - lastP);
            try
            {
               Avec.addElement(new Integer(Integer.parseInt(temp)));
               lastP = p + 1;
               while ((lastP < length) && (chars[lastP] == ' '))
                 delete(lastP, 1);
            }
            catch (NumberFormatException nfe)
            {
               throw new ArrayException("Cannot sort array: error in input.");
            }
         }
         else
           done = true;
      }
      int[] B = new int[Avec.size()];
      for(int j = 0; j < Avec.size(); j++)
      {
         String numStr = Avec.elementAt(j).toString();
         B[j] = Integer.parseInt(numStr);
      }
      return B;
   }

}
