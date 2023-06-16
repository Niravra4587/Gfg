//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends

class pair{
    int k;int wt;
    pair(int k,int wt){
        this.k=k;
        this.wt=wt;
    }
}
//User function Template for Java
class Solution {
    Stack<Integer> st=new Stack<>();
    public void dfs(int i,List<List<pair>> ls,int vis[]){
        vis[i]=1;
        for(int j=0;j<ls.get(i).size();j++){
            if(vis[ls.get(i).get(j).k]!=1){
                dfs(ls.get(i).get(j).k,ls,vis);
            }
        }
        st.push(i);
        
    }
	public int[] shortestPath(int N,int M, int[][] edges) {
		//Code here
            List<List<pair>> ls=new ArrayList<>();
            for(int i=0;i<N;i++){
                ls.add(new ArrayList<>());
            }
            for(int i=0;i<edges.length;i++){
                ls.get(edges[i][0]).add(new pair(edges[i][1],edges[i][2]));
                
            }
            int vis[]=new int[N];
            int dis[]=new int[N];
            Arrays.fill(dis,(int)(1e9));
            for(int i=0;i<N;i++){
                if(vis[i]!=1){
                    dfs(i,ls,vis);
                }
            }
            dis[0]=0;
            while(!st.isEmpty()){
                int val=st.pop();
                int dist=dis[val];
                for(int i=0;i<ls.get(val).size();i++){
                    dis[ls.get(val).get(i).k]=Math.min(dis[ls.get(val).get(i).k],dist+ls.get(val).get(i).wt);
                }
            }
            for (int i = 0; i < N; i++) {
      if (dis[i] == 1e9) dis[i] = -1;
    }
            return dis;
	}
}