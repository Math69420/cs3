//© A+ Computer Science
// www.apluscompsci.com

//abstract example three

import static java.lang.System.*;
import java.util.Scanner;
import java.util.Random;

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
}


public class MonsterThree
{
	private Monster[] monsters;

	public MonsterThree()
	{
		monsters = new Monster[0];
	}

	public void loadMonsters( )
	{
		System.out.print("loadMonsters\n\n");
		Scanner keyboard = new Scanner(in);

		System.out.print("How many monsters are in the pack? :: ");
		int size = keyboard.nextInt();
		keyboard.nextLine();
		monsters = new Monster[size];

		for(int j=0; j<monsters.length; j++)
		{
			out.print("Enter Monster " + j + " Name :: ");
         int r = (int)(Math.random()*3);
			if(r==0)
				monsters[j] = new Vampire(keyboard.nextLine());
			else if( r==1 )
				monsters[j] = new Witch(keyboard.nextLine());
			else
				monsters[j] = new Ghost(keyboard.nextLine());
		}
		out.print("\n\n");
	}

	public void monstersTalk( )
	{
		out.print("monstersTalk Method\n\n");
		for(int j=0; j<monsters.length; j++)
			monsters[j].talk();
	}

	public String toString( )
	{
		String output="";
		for(int j=0; j < monsters.length; j++)
			output+=monsters[j].toString();
		return output;
	}

	public static void main ( String[] args )
	{
		MonsterThree pack = new MonsterThree();
		pack.loadMonsters();
		pack.monstersTalk();
		out.println(pack);
	}
}