//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class disjoint{
    List<Integer> parent=new ArrayList<>();
    List<Integer> size=new ArrayList<>();
    public disjoint(int n){
        for(int i=0;i<=n;i++){
            parent.add(i);
            size.add(1);
        }
    }
    public int findparent(int node){
        if(node==parent.get(node))return node;
        parent.set(node,findparent(parent.get(node)));
        return parent.get(node);
    }
    public void dis(int src,int dest){
        int u=findparent(src);
        int v=findparent(dest);
        if(u==v)return;
        if(size.get(u)<size.get(v)){
            parent.set(u,v);
            size.set(v,size.get(u)+size.get(v));
        }
        else{
            parent.set(v,u);
            size.set(u,size.get(u)+size.get(v));
        }
    }
}
class Solution {
    
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        disjoint ds=new disjoint(V);
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                if(adj.get(i).get(j)==1){
                    ds.dis(i,j);
                }
            }
        }
        
        int c=0;
        for(int i=0;i<V;i++){
            if(ds.findparent(i)==i){
                c++;
            }
        }
        return c;
    }
};