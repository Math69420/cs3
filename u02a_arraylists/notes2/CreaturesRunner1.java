import static java.lang.System.*;
import java.util.ArrayList;
import java.util.Collections;

public class CreaturesRunner1
{
   public static void main ( String[] args )
   {
      ArrayList<Creature> creatureList = new ArrayList<Creature>();     // What's missing?
      creatureList.add(new Creature(22));
      creatureList.add(new Creature(11));
      //add 3 more creatures to creatureList
      creatureList.add(new Creature(5));      
      creatureList.add(new Creature(233));             
      
      
      Collections.sort(creatureList);        //will throw an exception until
                                             //creatures are added to the arrayList    
      
      for(Creature it : creatureList)
      {
         out.println(it);
      }     
      out.println();
      
      creatureList.get(0).setSize(41);
      out.println(creatureList.get(0).toString());    //toString called automatically,
      out.println();                                  //but,this makes a good demo
            
         
      out.println(creatureList);                      // [41, 11, 22, 233]                                        
      Creature dude = new Creature(41);
      out.println(creatureList.indexOf(dude));     
      out.println(creatureList.contains(dude));       
      out.println(creatureList.isEmpty());               
   }
}