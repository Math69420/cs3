import java.util.*;
import java.io.*;
public class DFS {

   	Map<Integer,Integer>parentMap;
   	Set<Integer>visitedSet;
   	Map<Integer,Node>nodeMap;
    public DFS() {
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
    public List<Integer> getDFS(Integer start, Integer end){
    	Stack<Integer>stack = new Stack<Integer>();
    	visitedSet.add(start);
    	stack.push(start);
    	parentMap.put(start,null);
    	while(stack.isEmpty()==false){
    		Integer curr = stack.pop();
    		if(curr.equals(end))
    			return traceBackPath(end);
    		for(Integer item: nodeMap.get(curr).neighbors){
				if(visitedSet.contains(item))
					continue;
				visitedSet.add(item);
				stack.add(item);
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
    	DFS demo = new DFS();
    	System.out.println(demo.getDFS(0,6));
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