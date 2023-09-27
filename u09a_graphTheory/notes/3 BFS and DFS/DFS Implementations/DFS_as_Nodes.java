import java.util.*;
import java.io.*;
public class DFS_as_Nodes {
   
   ArrayList<Node> nodes;
   
   public DFS_as_Nodes() throws FileNotFoundException {
      nodes = new ArrayList<Node>();
      load();
   }
   public void load() throws FileNotFoundException {
      Scanner file = new Scanner(new File("DFS_as_Nodes.txt"));
      while(file.hasNextLine()){
         String line = file.nextLine();
         Scanner chop = new Scanner(line);
         int n = chop.nextInt();
         Node node = new Node(n);
         while(chop.hasNextInt()){
            node.addNeighbor(chop.nextInt());
         }
         nodes.add(node);
      }
   }
   /*
   public List<Integer> getDFS(Integer start) {
   	Set<Integer> visitedSet = new HashSet<Integer>();
   	List<Integer> path = new LinkedList<Integer>();
   	return getDFS(path,visitedSet,start);

   }
   
   public List<Integer> getDFS(List<Integer> path, Set<Integer> visited, Integer start)
   {
   	Node startNode = getNode(start));)
      visited.add(start);
      path.add(start);
      for(Integer neighbor : startNode.neighbors)
      {
      	if(visited.contains(neighbor))
      		continue;
      	getDFS(path, visited, neighbor);
      	
      }	
   }*/
   

   
   public List<Node> getDFS(Integer start, Integer end){
   	Node startNode = Node.getNode(nodes,start);
   	Node endNode = Node.getNode(nodes,end);
   	Map<Node,Node> parentMap = new HashMap<Node,Node>(); 
   	Set<Node> visitedSet = new HashSet<Node>();
      Stack<Node> stack = new Stack<Node>();
      visitedSet.add(startNode);
      stack.push(startNode);
      parentMap.put(startNode,null);
      while(stack.isEmpty()==false){
         Node curr = stack.pop();
         if(curr.equals(end))
            return traceBackPath(parentMap,endNode);
         for(Node neighbor : nodes.get(curr.number).neighbors){
            if(visitedSet.contains(neighbor))
               continue;
            visitedSet.add(neighbor);
            stack.add(neighbor);
            parentMap.put(neighbor,curr);
         }
      }
      System.out.println("no match");
      return null;
   }
   public List<Node> traceBackPath(Map<Node,Node> parentMap, Node temp){
      List<Node> list = new LinkedList<Node>();
      while(temp!=null){
         list.add(0,temp);
         temp = parentMap.get(temp);
      }
      return list;
   }
   public static void main(String[] args) throws FileNotFoundException {
      DFS_as_Nodes graph = new DFS_as_Nodes();
      System.out.println(graph.getDFS(0,6));
   }
}
