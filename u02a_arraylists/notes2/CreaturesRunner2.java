import static java.lang.System.*;
import java.util.ArrayList;
import java.util.Collections;

public class CreaturesRunner2
{
	public static void main ( String[] args )
	{
		Creatures bunch = new Creatures();
		bunch.add(3);
		bunch.add(5);
		bunch.add(6);
		bunch.add(3);
		bunch.add(5);		
		System.out.println(bunch);
		bunch.removeAllOfSize(5);
		System.out.println(bunch);				
  }
}