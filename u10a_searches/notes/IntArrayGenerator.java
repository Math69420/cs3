
import static java.lang.System.*;
import java.util.*;

public class IntArrayGenerator {
	

    
    public static int[] generateNewArray(int size) {
    	int[] ray = new int[size];
		Set<Integer> values = new HashSet<Integer>();
		Random rand = new Random(size*100);
		while(values.size()<size){
			values.add(rand.nextInt());
		}
		Iterator<Integer> iterator = values.iterator();
		int i=0;
		while(iterator.hasNext()){
			ray[i++]=iterator.next();
		} 
		return ray;   	
    }

    public static void main(String[] args) {

		//out.println(Arrays.toString(ray));
			

    }
    
    
}
