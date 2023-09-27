//© A+ Computer Science
// www.apluscompsci.com

//list iterator add example 2


import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class AddThree
{
   public static void main(String args[])
	{
		ArrayList<String> words;
		words = new ArrayList<String>();

		words.add("is");
		words.add("us");

		ListIterator<String> it = words.listIterator();
      System.out.println(words);

		it.add("5");
		it.add("4");
		it.add("3");
		it.add("2");

		System.out.println(words);
	}
}