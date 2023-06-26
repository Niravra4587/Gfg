//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
//User function Template for Java
class disjoint{
    List<Integer> par=new ArrayList<>();
    List<Integer> size=new ArrayList<>();
    public disjoint(int n){
        for(int i=0;i<=n;i++){
            par.add(i);
            size.add(1);
        }
    }
    public int findparent(int node){
        if(par.get(node)==node)return node;
        par.set(node,findparent(par.get(node)));
        return par.get(node);
    }
    public void union(int u,int v){
        int pu=findparent(u);
        int pv=findparent(v);
        if(pu==pv)return;
        if(size.get(pu)<size.get(pv)){
            par.set(pu,pv);
            size.set(pv,size.get(pv)+size.get(pu));
        }
        else{
             par.set(pv,pu);
            size.set(pu,size.get(pv)+size.get(pu));
        }
    }
}
class Solution {
    
    public List<Integer> numOfIslands(int rows, int cols, int[][] op) {
        //Your code here
        disjoint ds=new disjoint(rows*cols);
        int vis[][]=new int[rows][cols];
        int c=0;
        for(int i[]:vis)
            Arrays.fill(i,0);
        List<Integer> ls=new ArrayList<>();
        for(int i=0;i<op.length;i++){
            if(vis[op[i][0]][op[i][1]]!=0){
                ls.add(c);
            }
            else{
                c++;
                vis[op[i][0]][op[i][1]]=1;
                int dx[]={-1,0,1,0};
                int dy[]={0,1,0,-1};
                for(int k=0;k<4;k++){
                    int a=dx[k]+op[i][0];
                    int b=dy[k]+op[i][1];
                    if(a>=0&&a<rows&&b>=0&&b<cols){
                    if(vis[a][b]==1){
                        if(ds.findparent(op[i][0]*cols+op[i][1])!=ds.findparent(a*cols+b)){
                            c--;
                            ds.union(op[i][0]*cols+op[i][1],a*cols+b);
                            
                        }
                    } 
                    }
                }
                ls.add(c);
            }
        }
        return ls;
    }
    
}

//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int  k= sc.nextInt();
            int[][] a = new int[k][2];
            for(int i=0;i<k;i++){
            
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
            }
            
            Solution obj = new Solution();
            List<Integer> ans = obj.numOfIslands(n,m,a);
           
            for(int i:ans){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends