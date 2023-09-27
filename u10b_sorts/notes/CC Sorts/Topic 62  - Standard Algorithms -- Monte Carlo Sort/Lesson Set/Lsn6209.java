//
//	CS2 - Lsn6208                                     © 2015 - Cypress Creek HS
//
// 	   Thread:	Standard Algorithms -- Monte Carlo Sort
//	Criterion:	Comparing Strings - compareTo() method
//	========================================================================
//
// 	NOTE:
// 	1)	Because a String is an object (NOT a primitive), you must use a
//		String method to compare two strings against each other.
//
//	2)	Comparing two strings will find out if one String comes before the
//		other alphabetically.
//
//  INQUIRY
//	->	How does Java know if one string comes before the other
//		alphabetically?
//
//	________________________________________________________________________
//		"GRAPE".compareTo("APPLE")
//
//                  GRAPE
//         +6 char  |
//		+>>>>>>>>>>>+
//      V           V
//		A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
//      A
//      |
//      APPLE
//                                  			->  GRAPE is +6 from APPLE
//	________________________________________________________________________
//		"APPLE".compareTo("GRAPE")
//
//      APPLE
//      |  -6 char
//		+<<<<<<<<<<<+
//      V           V
//		A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
//                  A
//                  |
//                  GRAPE
//                                  			-> 	APPLE is -6 from GRAPE
//	________________________________________________________________________
//		"APPLE".compareTo("APE")
//
//                                  APPLE (examine 3rd character)
//                     +11 char       |
//		        +>>>>>>>>>>>>>>>>>>>>>+
//              V                     V
//		A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
//              A
//              |
//            APE (examine 3rd character)
//                                  			-> 	APPLE is +11 from APE
//	________________________________________________________________________
//
//
//


package lesson;

import static java.lang.System.*;
import java.util.*;

public class Lsn6209{
	public static void main (String[] args){
		new DataBase();
}}


class DataBase
{
	String word1;
	String word2;
	String word3;
	String word4;
	String word5;

	DataBase()
	{
		populate();
		run();
	}

	public void run()
	{
		out.println("GRAPE.compareTo(APPLE)        ==> " + "GRAPE".compareTo("APPLE"));
		out.println("APPLE.compareTo(GRAPE)        ==> " +   word2.compareTo(word3)  );
		out.println("APE.compareTo(APPLE)          ==> " +   word1.compareTo(word2)  );
		out.println("APPLE.compareTo(APE)          ==> " +   word2.compareTo(word1)  );
		out.println("APE.compareTo(APE)            ==> " +   word1.compareTo(word1)  );
		out.println("ape.compareTo(APE)            ==> " +   word4.compareTo(word1)  );
		out.println("ape.compareToIgnoreCase(APE)  ==> " +   word4.compareToIgnoreCase(word1));
		out.println();
		out.println();
		out.println("BANANA.compareTo(APPLE) < 0   ==> " + (word5.compareTo(word2) < 0  ));
		out.println("APPLE.compareTo(BANANA) < 0   ==> " + (word2.compareTo(word5) < 0  ));
		out.println("APE.compareTo(APPLE)    < 0   ==> " + (word1.compareTo(word2) < 0  ));
		out.println("APPLE.compareTo(APE)    < 0   ==> " + (word2.compareTo(word1) < 0  ));
		out.println("APE.compareTo(APE)     == 0   ==> " + (word1.compareTo(word1) == 0 ));
		out.println();
	}

	public void populate()
	{
		word1 = "APE";
		word2 = "APPLE";
		word3 = "GRAPE";
		word4 = "ape";
		word5 = "BANANA";
	}
}














