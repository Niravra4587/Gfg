//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


// User function Template for Java
class Edges{
    int src,dest,wt;
    Edges(int src,int dest,int wt){
        this.src=src;
        this.dest=dest;
        this.wt=wt;
    }
}
class disjointset{
    List<Integer> parent=new ArrayList<>();
    List<Integer> size=new ArrayList<>();
    public disjointset(int n){
        for(int i=0;i<n;i++){
            parent.add(i);
            size.add(1);
        }
    }
    public int findparent(int node){
        if(parent.get(node)==node)return node;
        parent.set(node,findparent(parent.get(node)));
        return parent.get(node);
    }
    public void disjointbysize(int src,int dest){
        int u=findparent(src);
        int v=findparent(dest);
        if(u==v)return;
        if(size.get(u)<size.get(v)){
            parent.set(u,v);
            size.set(size.get(u),size.get(u)+size.get(v));
        }
        else{
            parent.set(v,u);
            size.set(size.get(v),size.get(u)+size.get(v));
        }
    }
}
class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    Queue<Edges> pq=new PriorityQueue<>((a,b)->a.wt-b.wt);
	    for(int i=0;i<edges.length;i++){
	        pq.add(new Edges(edges[i][0],edges[i][1],edges[i][2]));
	    }
	    int sum=0;
	    disjointset ds=new disjointset(V);
	    while(!pq.isEmpty()){
	        int s=pq.peek().src;
	        int d=pq.peek().dest;
	        int w=pq.peek().wt;
	        pq.remove();
	        
	        if(ds.findparent(s)!=ds.findparent(d)){
	            ds.disjointbysize(s,d);
	            sum+=w;
	        }
	        
	    }
	    return sum;
	}
}