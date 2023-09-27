import static java.lang.System.*;

public class BitwiseComplement
{
	public static void main(String args[])
	{
		int[] nums = {8,12,-5}; 
		for(int num : nums)  {
			//String bc =
			out.printf("~%s == %s%n",Integer.toBinaryString(num),Integer.toBinaryString(~num));
			out.printf("~%d == %d%n",num,~num);
			out.println();
		}
	}
}