
//exception example 6

import static java.lang.System.*;
import java.util.*;

public class Exception7seven
{
	public static void main(String args[])
	{
      try{
         //Object x = new String("This won't work because a Scanner "+
         //                      "is not a type of String!");
         int answer=0;
   		Scanner kb = null;
         //kb = (Scanner)x;
   		kb = new Scanner(in);
   		out.print("Enter an integer :: ");
   		//kb.close();
   		int num=kb.nextInt();
			//if(num==0)
		   //		throw new Exception("num==0");
		   //	else
		   	   answer=32/num;
         out.println("the answer is "+answer);              
		}
		catch(NullPointerException e){
         out.println(e);
      }
		catch(ClassCastException e){
		   out.println(e);
		}
      catch(InputMismatchException e){
         out.println(e);
      }     
      catch(NoSuchElementException e){
         out.println(e);
      }              
      catch(IllegalStateException e){
         out.println(e);
      }
      catch(ArithmeticException e){
         out.println(e);
      }
		catch(Exception e){
		   out.println(e);
		}
		finally{
		   out.println("You messed up!");
		}

      out.println("\n. . . and then we move on . . .");
	}
}
