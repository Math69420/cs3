import java.util.*;
import static java.lang.System.*;

public class Lab15b
{
   public static void main ( String[] args )
   {
      //ListNode z = null;
      
      ListNode z = new ListNode("go",
                   new ListNode("on",
                   new ListNode("at",
                   new ListNode("34",
                   new ListNode("2.1",
                   new ListNode("-a-2-1",
                   new ListNode("up",                  
                   new ListNode("over",null))))))));
                  
      out.println("Lab15b Test Code\n\n");   
      
      out.print("                Original list values:  "); 
      ListFunHouse.print(z);
      out.println();
      
      out.println("                                       num nodes = " + ListFunHouse.nodeCount(z));

      out.print("             After calling nodeCount:  "); 
      ListFunHouse.print(z);
      out.println();    

      ListFunHouse.doubleFirst(z);     
      out.print("           After calling doubleFirst:  ");                   
      ListFunHouse.print(z);
      out.println(); 

      ListFunHouse.doubleLast(z);      
      out.print("            After calling doubleLast:  ");                   
      ListFunHouse.print(z);
      out.println();          

      ListFunHouse.skipEveryOther(z);     
      out.print("        After calling skipEveryOther:  ");                   
      ListFunHouse.print(z);
      out.println();       
      
      ListFunHouse.removeEveryXthNode(z,2);     
      out.print(" After calling removeEveryXthNode(2):  ");             
      ListFunHouse.print(z);
      out.println();       
      
      
      ListFunHouse.setEveryXthNode(z,2,"one");     
      out.print("After calling setEveryXthNode(2,one):  ");                            
      ListFunHouse.print(z);
      out.println();          
   }
}