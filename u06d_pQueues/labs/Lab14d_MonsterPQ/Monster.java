import java.awt.Color;
import static java.lang.System.*;

public class Monster implements Comparable<Monster>
{
	private int weight;
	private int height;
	private int age;

	public Monster()
	{
	   setMonster(0, 0, 0);
	}

	public Monster(int ht)
	{
	   setMonster(ht, 0, 0);
	}

	public Monster(int ht, int wt)
	{
	   setMonster(ht, wt, 0);
	}

	public Monster(int ht, int wt, int age)
	{
	   setMonster(ht, wt, age);
	}

	public void setMonster(int ht, int wt, int age)
	{
	   setHeight(ht);
	   setWeight(wt);
	   setAge(age);
	}

	public void setHeight( int ht)
	{
		height = ht;
	}

	public void setWeight(int wt)
	{
		weight = wt;
	}

	public void setAge( int ag)
	{
		age = ag;
	}

	public int getHeight()
	{
	   return height;
	}

	public int getWeight()
	{
	   return weight;
	}

	public int getAge()
	{
	   return age;
	}

   public Object clone()
   {
      return new Monster(height,weight,age);
   }

   public boolean equals( Object o )
   {
      Monster other = (Monster)o;
      return height==other.height && weight==other.weight && age==other.age;
   }

   public int compareTo( Monster other)
   {
      if(height!=other.height)
         return height - other.height;
      else if(weight != other.weight)
         return weight - other.weight;
      else return age - other.age;
   }

	public String toString( )
	{
		return getHeight() + " " + getWeight() + " " + getAge();
	}
}