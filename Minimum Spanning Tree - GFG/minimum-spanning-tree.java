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
class pair{
    int i;
    int val;
    pair(int i,int val){
        this.i=i;
        this.val=val;
    }
}
class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    List<List<pair>> ls=new ArrayList<>();
	    for(int i=0;i<V;i++){
	        ls.add(new ArrayList<>());
	    }
	    for(int i=0;i<edges.length;i++){
	        ls.get(edges[i][0]).add(new pair(edges[i][1],edges[i][2]));
	        ls.get(edges[i][1]).add(new pair(edges[i][0],edges[i][2]));
	    }
	    Queue<pair> q=new PriorityQueue<>((a,b)->a.val-b.val);int s=0;
	    q.add(new pair(0,0));
	    int vis[]=new int[V];
	    Arrays.fill(vis,0);
	    while(!q.isEmpty()){
	        int node=q.peek().i;
	        int wt=q.peek().val;
	        q.remove();
	        if(vis[node]==1)continue;
	        vis[node]=1;
	        s+=wt;
	        for(int j=0;j<ls.get(node).size();j++){
	            if(vis[ls.get(node).get(j).i]!=1){
	                q.add(new pair(ls.get(node).get(j).i,ls.get(node).get(j).val));
	            }
	        }
	        
	    }
	    return s;
	}
}