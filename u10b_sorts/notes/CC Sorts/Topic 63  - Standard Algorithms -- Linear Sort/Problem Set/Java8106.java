///////////////////////////////////////////////////////////////////////////
//
//  *****   Linear SORT   *****
//
//  Java8106  Allow the user to enter a sentence.  Print the words in the 
//			  sentence in alphabetical order both forwards and backwards.
//
//   SAMPLE USER INPUT:
//			It ain't over til it's over.
//
//   SAMPLE OUTPUT:  
//			Ascending:  It ain't it's over over. til
//          Descending:  til over. over it's ain't It
//
import java.util.*;
import static java.lang.System.*;
public class Java8106{
	public static void main(String args[])
	{
		new Lolz().run();
	}
}
class Lolz{
	ArrayList <String> s = new ArrayList<String>();
	public void run()
	{
		String lol;
		Scanner scan = new Scanner(System.in);
		out.print("Enter a Sentence==>");
		lol=scan.nextLine();
		
		Scanner data = new Scanner(lol);
		while(data.hasNext())
			s.add(data.next()); 


		for(int y=0;y<s.size()-1;y++)
			for(int w=y+1;w<s.size();w++)
			   if ( s.get(y).compareTo(s.get(w)) > 0 )
            	{												
			  		String item1 = s.get(y);
			  		String item2 = s.get(w);
			  		s.set(y,item2);
			  		s.set(w,item1);
			  	}
		 out.println("Accending==>" + s);
	
		for(int y=0;y<s.size()-1;y++)
			for(int w=y+1;w<s.size();w++)
			   if ( s.get(y).compareTo(s.get(w)) < 0 )
            	{												
			  		String item1 = s.get(y);
			  		String item2 = s.get(w);
			  		s.set(y,item2);
			  		s.set(w,item1);
			  	}
		 out.println("Deccending==>" + s);
	}
}