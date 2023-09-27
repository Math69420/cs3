package graphs;

 import java.io.BufferedReader;
 import java.io.IOException;
 import java.io.InputStreamReader;
 import java.io.PrintWriter;
 import static java.lang.System.out;
 import java.util.ArrayList;
 import java.util.Iterator;
 import java.util.LinkedList;
 import java.util.Queue;
 import java.util.StringTokenizer;


 public class BFS_Using_Adjacency_List_Recursive {
	
	static ArrayList<ArrayList<Integer>> a;
	static boolean visited[];
	static Queue q=new LinkedList<Integer>();
	
	public static void main(String args[]) throws IOException
	{
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    PrintWriter w = new PrintWriter(System.out);
	    out.println("Enter the vertice and edge");
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    int vertice,edge;
	
	    vertice=ip(st.nextToken());
	    edge=ip(st.nextToken());
	    a=new ArrayList<ArrayList<Integer>>(vertice);
	    for(int i=0;i<vertice;i++)
	    {
	        a.add(new ArrayList<Integer>());
	    }
	    out.println("Enter all the points X Y");
	    int n=vertice;
	    while(n-->0)
	    {
	        st=new StringTokenizer(br.readLine());
	        graph(ip(st.nextToken()),ip(st.nextToken()));
	
	    }
	    visited=new boolean[vertice];
	    out.println("Enter any vertice number");
	    bfs(ip(br.readLine()));
	
	   // w.println(a);
	    w.close();
	}
	
	public static void graph(int p1,int p2)
	{
	    a.get(p1).add(p2);
	    a.get(p2).add(p1);
	}
	
	public static void bfs(int vertice)
	{
	    if(!visited[vertice])
	    {
	        visited[vertice]=true;
	        q.add(vertice);
	    }
	    Iterator it=a.get(vertice).iterator();
	
	    while(it.hasNext())
	    {
	        int currver=(int)it.next();
	      // System.out.println(visited[currver]+" :"+currver);
	
	        if(!visited[currver])
	        {
	            q.add(currver);
	            visited[currver]=true;
	        }
	    }
	//   System.out.println(q); 
	    System.out.println(q.poll());
	    if(!q.isEmpty())
	    {
	        bfs((int)q.peek());
	    }
	}
	   public static int ip(String s){
	    return Integer.parseInt(s);
	}
}