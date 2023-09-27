//© A+ Computer Science
// www.apluscompsci.com

//basic map example 1

import java.util.Map;
import java.util.TreeMap;

public class BasicMapOne
{
	public static void main(String args[])
	{
		Map<Integer,String> map;
		map = new TreeMap<Integer,String>();
		map.put(1,"one");
		map.put(2,"two");
		map.put(3,"three");
		map.put(4,"four");
		map.put(5,"five");
		map.put(6,"six");
		map.put(7,"seven");

		System.out.println(map.get(1));
		System.out.println(map.get(13));
		System.out.println(map.get(7));
	}
}