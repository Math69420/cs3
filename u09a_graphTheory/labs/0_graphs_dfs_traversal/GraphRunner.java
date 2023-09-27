//Import the Scanner, File, IOException (or FileNotFoundException) classes:

//Staticly import the members of the System class, or type System.out everywhere.

public class GraphRunner
{
   public static void main( String[] args ) throws IOException
   { 
      
      GraphDFS tester = new GraphDFS("AB AC AD BA BF CA DC DE EA EF FE GE");
      out.println(tester);
      tester.dfs("A");
          
      //Use the above to get started.  Once it works, loop through all of the 
      //graphs in each of the data files and make sure it works for all of them.
   }
}