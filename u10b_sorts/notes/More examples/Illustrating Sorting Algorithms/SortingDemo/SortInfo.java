// SortInfo.java
public class SortInfo
{
   public String array, comparisons, exchanges;

   public SortInfo()
   {
      array = comparisons = exchanges = null;
   }

   public void setData(int[] A, int compCt, int exchangeCt)
   {
      array = "";
      for(int i = 0; i < A.length; i++)
        array += Integer.toString(A[i]) + " ";
      array = array.trim();
      comparisons = Integer.toString(compCt);
      exchanges = Integer.toString(exchangeCt);
   }

   public void setData(String arrayStr, int compCt, int exchangeCt)
   {
      array = arrayStr;
      comparisons = Integer.toString(compCt);
      exchanges = Integer.toString(exchangeCt);
   }

   public static void main(String[] args){}

}
