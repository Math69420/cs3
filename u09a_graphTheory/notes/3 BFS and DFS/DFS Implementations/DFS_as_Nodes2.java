import java.util.*;
import java.io.*;
public class DFS_as_Nodes2 {
   
   Map<Integer,Node2> nodeMap;
   
   public DFS_as_Nodes2() throws FileNotFoundException {
      nodeMap = new HashMap<Integer, Node2>();
      load();
   }
   public void load() throws FileNotFoundException {
      Scanner file = new Scanner(new File("DFS_as_Nodes.txt"));
      while(file.hasNextLine()){
         String line = file.nextLine();
         Scanner chop = new Scanner(line);
         int n = chop.nextInt();
         Node2 node = new Node2(n);
         while(chop.hasNextInt()){
            node.addNeighbor(chop.nextInt());
         }
         nodeMap.put(n,node);
      }
   }
   public List<Integer> getDFS(Integer start, Integer end){
   	List<Integer> path = new ArrayList<Integer>();  //Map<Integer,Integer> parentMap = new HashMap<Integer,Integer>(); 
   	Set<Integer> visitedSet = new HashSet<Integer>();
      Stack<Integer> stack = new Stack<Integer>();
      visitedSet.add(start);
      stack.push(start);
      path.add(start);   //parentMap.put(start,null);
      while(stack.isEmpty()==false){
         Integer curr = stack.pop();
         if(curr.equals(end))
            return path;  //traceBackPath(parentMap,end);
         for(Integer item: nodeMap.get(curr).neighbors){
            if(visitedSet.contains(item))
               continue;
            visitedSet.add(item);
            stack.add(item);
            path.add(item);  //parentMap.put(item,curr);
         }
      }
      System.out.println("no match");
      return null;
   }
   public List<Integer> traceBackPath(Map<Integer,Integer> parentMap, Integer temp){
   	System.out.println(parentMap);
      List<Integer>list = new LinkedList<Integer>();
      while(temp!=null){
         list.add(0,temp);
         temp = parentMap.get(temp);
      }
      return list;
   }
   public static void main(String[] args) throws FileNotFoundException {
      DFS_as_Nodes2 graph = new DFS_as_Nodes2();
      System.out.println(graph.getDFS(0,6));
   }
}
