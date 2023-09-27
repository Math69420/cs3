//© A+ Computer Science
// www.apluscompsci.com

//base conversion example

import static java.lang.System.*;

public class JavaBase
{
	public static void main(String args[])
	{
		int base10 = Integer.parseInt("324",6);
		out.print("324 base 6 == ");
		out.println(base10 + " base10");

		out.print("124 base10 == ");
		out.println(Integer.toString(base10,16)+" base16\n\n");


      out.println("Integer.toHexString(90).toUpperCase() == " + Integer.toHexString(90).toUpperCase());
      out.println("Integer.toOctalString(90) == " + Integer.toOctalString(90));
      out.println("Integer.toBinaryString(90) == " + Integer.toBinaryString(90));
      out.println("Integer.toString(90,2) == " + Integer.toString(90,2));
      out.println();
//      out.println("Integer.toBinaryString(-10) == " + Integer.toBinaryString(-10));
//      out.println("Integer.toString(-10,2) == " + Integer.toString(-10,2));
      out.println();
	}
}