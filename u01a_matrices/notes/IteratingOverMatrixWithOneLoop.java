
import java.util.Random;

public class IteratingOverMatrixWithOneLoop
{

   static int[][] x = new int[5][5];
   static Random rg = new Random();

   public static void UsingNestedLoop()
   {
      for(int i=0;i<5;i++)
      {
         for(int j =0; j<5;j++)
         {
            x[i][j] = rg.nextInt();
         }
      }
   }

   public static void UsingSingleLoop1()
   {
      for(int i = 0; i < 5 * 5; i++)
      {
         int row = i / 5;
         int column = i % 5;
         x[row][column] = rg.nextInt();
      }
   }

   public static void UsingSingleLoop2()
   {
      int i,j;
      for (i=0, j=0; i<5 && j<5; i = (i==4 ? 0 : i+1), j = (i==4 ? j+1 : j))
      {
         x[i][j] = rg.nextInt();
      }
   }

   public static void OutputArray()
   {
      for(int i=0; i<5; i++)
      {
         for(int j=0; j<5; j++)
         {
            System.out.print(x[i][j] + "\t");
         }
         System.out.println();
      }
      System.out.println();
   }

   public static void main(String[] args) {

      UsingNestedLoop();
      OutputArray();

      UsingSingleLoop1();
      OutputArray();

      UsingSingleLoop2();
      OutputArray();

   }


}