import org.jgrapht.*;
import org.jgrapht.graph.*;

public class GraphCreator
{
   public static void main(String[] args)
   {
      Graph<Integer,DefaultEdge> g = new SimpleGraph<>(DefaultEdge.class);
      for(int x=0; x<10; x++)
         g.addVertex(x);
      for(int x=1; x<10; x++)
         g.addEdge(0,x);      
      for(int x=1; x<10; x++)
         g.addEdge(x,0);
      for(int x=1; x<10; x++)
         g.addEdge(0,x);      
      for(int x=1; x<10; x++)
         g.addEdge(x,0);
   }
}