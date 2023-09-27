import java.util.Stack;
import java.util.Scanner;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

public class AirlineGraph implements AirlineRouter
{
   private static int graph[][] = null;
   
   // ----- Public Interface --------------------------------------------------
   
   AirlineGraph() {
      graph = new int[SIZE][SIZE];
      try
      {
         Scanner reader = new Scanner(new File("connections.dat"));
         //This is different from the previous lab.
         //The delimiter is set to be a comma or the end of a line
         //The vertical bar means OR just like with booleans.
         reader.useDelimiter(",|\r\n");
         while (reader.hasNextInt())
         { 
            graph[reader.nextInt()][reader.nextInt()] = reader.nextInt();
         }
      }
      catch(IOException e) 
      {
         System.out.println("Error reading data file!");
         System.exit(0);
      }
   }

   public String findRoute(int length, String begin, String end) {
      DecimalFormat df = new DecimalFormat("$,###.00");
      int start = findAirportCode(begin);
      int fin = findAirportCode(end);
      Stack<Integer> stack = findPath(length, start, fin);
      int cost = findCostOfRoute(start, stack);
      if (cost > 0)
      {
         String route = city[start];
         while (!stack.empty())
            route = route + "-> " + city[stack.pop()] + " ";
         route += "\tTotal cost: " + df.format(cost);
         return route;
      }
      return null; 
   }
   
   public int findCostOfRoute(int start, Stack<Integer> path) {
      //In the case that there is no path
         //return the correct cost

      //Create a clone of the stack
      int totalCost = 0; //Create the answer variable and store the first cost.
      //Loop through the stack. Be careful about stopping correctly!
         //Get the from node using pop or peek (choose wisely)
         //Get the to node using pop or peek (choose wisely)
         //Get the cost for that connection from the matrix
         //Add that cost to the total
      return totalCost;
   }

   public String toString() {
      String str = "      ";
      for (int i = 0; i < SIZE; i++)
         str = str + airportCodes[i] + "  ";
      str = str + "\n"; 
      for (int y = 0; y < SIZE; y++)
      {
         str = str + airportCodes[y] + "  ";
         for (int x = 0; x < SIZE; x++)
         {
            if (graph[y][x] > 0)
               str += String.format("%4d " , graph[y][x]);
            else
               str = str + "  -  ";
         }
         str = str + "\n";
      }
      return str;
   }
   
   // ----- Private Helper Methods --------------------------------------------
    
   //Implement this just as in the previous lab.
   private int findAirportCode(String airportCode) {
      return 0;
   }

   //Determines whether fin is a neighbor of start.
   //Hint: What number is stored for non-neighbors?
   private boolean adjacent(int start, int fin) {
      return false;
   }

   //Method that creates the stack and starts the recursion:
   private Stack findPath(int length, int start, int fin)
   {
      Stack<Integer> stack = new Stack<Integer>();
      return findPath(length, start, fin, stack);
   }

   //Implement this just as in the previous lab.
   private Stack findPath(int length, int start, int fin, Stack stack)    {      
      
      return null;
   }
}
