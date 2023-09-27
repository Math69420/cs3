import java.util.*;
import org.magicwerk.brownies.collections.GapList;

public class GapListTester {
    
    public static void main(String[] args) {
    	
       // GapList replaces all ArrayList, LinkedList, ArrayDequeue
       List list = GapList.create("a", "b");
       System.out.println(list);
    }
}