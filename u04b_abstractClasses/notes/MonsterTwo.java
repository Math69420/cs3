//© A+ Computer Science
// www.apluscompsci.com

//abstract example two

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

   public String toString()
   {
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
     out.println("Vampire " + getName() + " say \"I want to drink your blood!\"\n\n");
  }
}

class Witch extends Monster
{
  public Witch( String name )
  {
    super(name);
  }

  public void talk()
  {
     out.println("Witch " + getName() + " say \"I like to fly on broom!\"\n\n");
  }
}

class Ghost extends Monster
{
  public Ghost( String name )
  {
    super(name);
  }

  public void talk()
  {
     out.println("Ghost " + getName() + " say \"Where did I go?\"\n\n");
  }

  public String toString()
  {
    return super.toString() + "\n";
  }
}

public class MonsterTwo
{
  public static void main ( String[] args )
  {
    String name;
    Scanner kb = new Scanner(in);

    Monster m;

    System.out.print("Your name ::  ");
    name = kb.nextLine();

    m = new Vampire(name);
    out.println("Vampire's name :: " + m);
    m.talk();

    System.out.print("Your name ::  ");
    name = kb.nextLine();

    m = new Witch(name);
    out.println("Witch's name :: " + m);
    m.talk();

    System.out.print("Your name ::  ");
    name = kb.nextLine();

    m = new Ghost(name);
    out.println("Ghost's name :: " + m);
    m.talk();
  }
}