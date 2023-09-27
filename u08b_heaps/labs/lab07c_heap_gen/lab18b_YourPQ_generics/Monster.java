public class Monster implements Comparable<Monster>
{
   private int height, weight;
   
   public Monster(int height, int weight)
   {
      this.height = height;
      this.weight = weight;
   }

   @Override   
   public int compareTo(Monster other)
   {
      if (height > other.height)
         return 1;
      if (height < other.height)
         return -1;
      return weight - other.weight;
   }
   
   @Override
   public String toString()
   {
      return height+"-"+weight;
   }
}