//© A+ Computer Science
// www.apluscompsci.com

//ListIterator example


import java.util.ArrayList;
import static java.lang.System.*;
import java.util.ListIterator;

public class ListIteratorOne
{
   public static void main(String args[])
	{
		ArrayList<String> words;
		words = new ArrayList<String>();

		words.add("at");
		words.add("is");
		words.add("of");
		words.add("us");
		System.out.println(words);
		System.out.println();

		ListIterator<String> it = words.listIterator();
		while(it.hasNext()) {
			System.out.print("nextIndex: " + it.nextIndex() + "\t" + "previousIndex: " + it.previousIndex() + "\t" + "hasNext(): " + it.hasNext());
			System.out.println("\t\t" + "set & remove would change index: " + (it.previousIndex()>-1 ? it.previousIndex() : "Can't") + "\n");
			System.out.println("next(): " + it.next() + "\n");
		}
		System.out.print("nextIndex: " + it.nextIndex() + "\t" + "previousIndex: " + it.previousIndex() + "\t" + "hasNext(): " + it.hasNext());
		System.out.println("\t\t" + "set & remove would change index: " + (it.previousIndex()>-1 ? it.previousIndex() : "Can't") + "\n");
		System.out.println("\n\n");

		System.out.println(words);
		System.out.println();
		while(it.hasPrevious()) {
			System.out.println("previous(): " + it.previous() + "\n");
			System.out.print("nextIndex: " + it.nextIndex() + "\t" + "previousIndex: " + it.previousIndex() + "\t" + "hasPrevious(): " + it.hasPrevious());
			System.out.println("\t\t" + "set & remove would change index: " + (it.nextIndex()<words.size() ? it.nextIndex() : "Can't") + "\n");
		}
//		System.out.print("nextIndex: " + it.nextIndex() + "\t" + "previousIndex: " + it.previousIndex() + "\t" + "hasPrevious(): " + it.hasPrevious() + "\n");

	}
}


/*  Output
 *
[at, is, of, us]

nextIndex: 0	previousIndex: -1	hasNext(): true		set & remove would change index: Can't

next(): at

nextIndex: 1	previousIndex: 0	hasNext(): true		set & remove would change index: 0

next(): is

nextIndex: 2	previousIndex: 1	hasNext(): true		set & remove would change index: 1

next(): of

nextIndex: 3	previousIndex: 2	hasNext(): true		set & remove would change index: 2

next(): us

nextIndex: 4	previousIndex: 3	hasNext(): false		set & remove would change index: 3




[at, is, of, us]

previous(): us

nextIndex: 3	previousIndex: 2	hasPrevious(): true		set & remove would change index: 3

previous(): of

nextIndex: 2	previousIndex: 1	hasPrevious(): true		set & remove would change index: 2

previous(): is

nextIndex: 1	previousIndex: 0	hasPrevious(): true		set & remove would change index: 1

previous(): at

nextIndex: 0	previousIndex: -1	hasPrevious(): false		set & remove would change index: 0


*/