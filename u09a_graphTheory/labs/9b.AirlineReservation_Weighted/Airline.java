import java.util.Stack;
import static java.lang.System.*;

public class Airline
{
   private AirlineGraph map = new AirlineGraph();

   public static void main(String args[]) {
      new Airline();
   }
    
   Airline() {
      System.out.println(map);        
      displayRoute("SFO","JFK",1);
      displayRoute("PHX","MIA",2);
      displayRoute("SFO","JFK",3);
      displayRoute("HNL","BOS",4);
   }  
   
   public void displayRoute(String start, String dest, int length)  {
      String route = map.findRoute(length, start, dest);
      out.print(start + "->" + dest + " (len=" + length + "): ");
      if (route == null)
         out.println("There is no direct connection!");
      else
         out.println(route); 
   }
}