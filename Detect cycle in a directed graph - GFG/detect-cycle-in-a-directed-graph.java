//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean dfs(int i,ArrayList<ArrayList<Integer>> adj,int vis[],int pvis[]){
        vis[i]=1;
        pvis[i]=1;
        for(int j=0;j<adj.get(i).size();j++){
            if(vis[adj.get(i).get(j)]!=1){
                
                if(dfs(adj.get(i).get(j),adj,vis,pvis))return true;
            }
            else if(pvis[adj.get(i).get(j)]==1)return true;
        }
        pvis[i]=0;
        return false;
        
    }
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int vis[]=new int[V];
        int pvis[]=new int[V];
        Arrays.fill(vis,-1);
        Arrays.fill(pvis,-1);
        for(int i=0;i<V;i++){
            if(vis[i]!=1){
                if(dfs(i,adj,vis,pvis)){
                    return true;
                }
            }
        }
        return false;
    }
}