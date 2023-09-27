import java.util.*;
import java.io.*;
public class BFS {

   	Map<Integer,Integer>parentMap;
   	Set<Integer>visitedSet;
   	Map<Integer,Node>nodeMap;
    public BFS() {
    	parentMap = new HashMap<Integer,Integer>();
    	visitedSet = new HashSet<Integer>();
    	nodeMap = new HashMap<Integer, Node>();
    	load();
    }
    public void load(){
		try{
			Scanner file = new Scanner(new File("graph.txt"));
			while(file.hasNextLine()){
				String line = file.nextLine();
				Scanner chop = new Scanner(line);
				int n = chop.nextInt();
				Node node = new Node(n);
				while(chop.hasNextInt()){
					node.addNeighbor(chop.nextInt());
				}
				nodeMap.put(n,node);
			}
		}catch(Exception e){
		}
    }
    public List<Integer> getBFS(Integer start, Integer end){
    	Queue<Integer>queue = new LinkedList<Integer>();
    	visitedSet.add(start);
    	queue.add(start);
    	parentMap.put(start,null);
    	while(queue.isEmpty()==false){
    		Integer curr = queue.remove();
    		if(curr.equals(end))
    			return traceBackPath(end);
    		for(Integer item: nodeMap.get(curr).neighbors){
				if(visitedSet.contains(item))
					continue;
				visitedSet.add(item);
				queue.add(item);
				parentMap.put(item,curr);
    		}
    	}
		System.out.println("no match");
		return null;
    }
    public List<Integer> traceBackPath(Integer temp){
    	List<Integer>list = new LinkedList<Integer>();
    	while(temp!=null){
    		list.add(0,temp);
    		temp = parentMap.get(temp);
    	}
    	return list;
    }
    public static void main(String[] args) {
    	BFS demo = new BFS();
    	System.out.println(demo.getBFS(0,6));
    }
}
class Node{
	Integer nodeNumber;
	ArrayList<Integer>neighbors;
	public Node(Integer i){
		nodeNumber = i;
		neighbors = new ArrayList<Integer>();
	}
	public void addNeighbor(Integer n){
		neighbors.add(n);
	}
}
class Edge{

}