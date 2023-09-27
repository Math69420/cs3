import java.util.Stack;
import java.util.Scanner;
import java.awt.Point;
import java.io.File;
import java.io.IOException;

public class AirlineGraph implements AirlineRouter
{
   private static boolean graph[][] = null;
   
   // ----- Public Interface --------------------------------------------------
   
   AirlineGraph() {
		graph = new boolean[SIZE][SIZE];
		try
    	{
	    	Scanner file = new Scanner(new File("connections.dat"));
	    	
	    	while (file.hasNextLine())
	    	{
	    		Scanner tokenizer = new Scanner(file.nextLine());
	    		//Change the delimiter
            //store the connection in the grid
			}
		}
		catch(IOException e) 
		{
			System.out.println("Error reading data file!");
			System.exit(0);
		}
	}
	
   //The findRoute method should return a string that lists the airports 
   //from the starting airport up to and including the destination airport.
   //You will use the helper methods listed at the end of the class.
   //You need implement them first.
	public String findRoute(int length, String begin, String end) {
      //Get and store the airport code for the start
      //Get and store the airport code for the destination
      //Find the path and store it
      //
      //if the stack exists
        //Add name of the starting airport to the route
        //Loop through the stack by popping each element
          //Add each airport to the end of the string
        //return the route 
  		return null;	
  	}
  	
  	public String toString() {
		String str = "     ";
		for (int i = 0; i < SIZE; i++)
			str = str + airportCode[i] + "  ";
		str = str + "\n";	
		for (int y = 0; y < SIZE; y++)
		{
			str = str + " " + airportCode[y] + "  ";
			for (int x = 0; x < SIZE; x++)
			{
				if (graph[y][x])
					str = str + "*    ";
				else
					str = str + "-    ";
			}
			str = str + "\n\n";
		}
		return str;
	}
	
	// ----- Private Helper Methods --------------------------------------------
    
    //findAirportCode returns the index of the given airport code in the list of airport 
    //codes. This index matches the row / columns index in the connections graph.
    //Return -1 if the airport code is not listed.
    private int findAirportCode(String airportCode) {
      return 0;
    }
    
    //Determines whether fin is a neighbor of start.
    private boolean adjacent(int start, int fin) {
    	return false;
    }

   //Method that creates the stack and starts the recursion:
	private Stack<Integer> findPath(int length, int start, int fin) {
		Stack<Integer> stack = new Stack<Integer>();
		return findPath(length, start, fin, stack);
	}
    
	private Stack<Integer> findPath(int length, int start, int fin, Stack stack)
    {
        //Note that we're using a stack in this method and that the findRoute method pops all of the
        //contents off the stack to generate the route. But that means it's removing the elements from the
        //stack in the reverse order from how they're stored in the stack. But that means the elements are
        //stored in the stack in reverse order (i.e. with the destination first). Why does the algorithm 
        //below do that?

        //If you're one node away from the desired distance
           //Check where the destination node is a neighbor of this node
              //Add the destination node to the stack
              //return the stack
        //Otherwise
           //Loop through column #'s in adjacency matrix
             //Check if each node is a neighbor and if it takes you to the destination node
               //Add the node to the stack
               //return the stack
        //return something to indicate no path was found. Look at the findRoute method for more clues.
    }	
}	
	