//© A+ Computer Science
// www.apluscompsci.com

//abstract example one

import static java.lang.System.*;
import java.util.Scanner;

abstract class Monster
{
   private String myName;

   public Monster()
   {
      myName="";
   }

   public Monster(String name)
   {
   	myName=name;
   }

   public String getName()
   {
   	return myName;
   }

   public abstract void talk( );

   public String toString() {
      return myName + "\n";
   }
}

class Vampire extends Monster
{
  public Vampire( String name )
  {
     super(name);
  }

  public void talk()
  {
     out.println("Vampire " + getName() + " say \"I want to drink your blood!\"");
  }
}


//add in another Monster class





public class MonsterOne
{
  public static void main ( String[] args )
  {
    String name;
    Scanner kb = new Scanner(in);

    System.out.print("Your name ::  ");
    name = kb.nextLine();

    Vampire vampire = new Vampire(name);
    out.println("Vampire's name :: " + vampire);
    vampire.talk();
  }
}