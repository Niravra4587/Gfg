//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class pair{
    int i;int j;
    pair(int i,int j){
        this.i=i;
        this.j=j;
    }
}
class Solution {
    public void bfs(char[][] bo,int i,int j,int vis[][]){
          
          Queue<pair> q=new LinkedList<>();
          
          q.add(new pair(i,j));
          vis[i][j]=1;
          int r[]={-1,0,1,0};
          int c[]={0,1,0,-1};
          while(!q.isEmpty()){
              int a=q.peek().i;
              int b=q.peek().j;
              q.remove();
              for(int k=0;k<4;k++){
                  int u=a+r[k];
                  int v=b+c[k];
                  if(u>=0&&u<bo.length&&v>=0&&v<bo[0].length&&bo[u][v]=='O'&&vis[u][v]!=1){
                      vis[u][v]=1;
                      q.add(new pair(u,v));
                  }
              }

          }
    }
    public char[][] fill(int n,int m,char[][] b) {
        int vis[][]=new int[b.length][b[0].length];
        for(int i=0;i<b[0].length;i++){
            if(vis[0][i]!=1&&b[0][i]=='O'){
                bfs(b,0,i,vis);
            }
            if(vis[b.length-1][i]!=1&&b[b.length-1][i]=='O'){
                bfs(b,b.length-1,i,vis);
            }
        }
        for(int i=0;i<b.length;i++){
            if(vis[i][0]!=1&&b[i][0]=='O'){
                bfs(b,i,0,vis);
            }
            if(vis[i][b[0].length-1]!=1&&b[i][b[0].length-1]=='O'){
                bfs(b,i,b[0].length-1,vis);
            }
        }
        for(int i=0;i<b.length;i++){
            for(int j=0;j<b[0].length;j++){
                if(vis[i][j]!=1&&b[i][j]=='O'){
                    b[i][j]='X';
                }
            }
        }
        return b;
    }
}