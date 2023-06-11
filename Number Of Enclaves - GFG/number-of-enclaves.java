//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.numberOfEnclaves(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class pair{
    int i;int j;
    pair(int i,int j){
        this.i=i;this.j=j;
    }
}
class Solution {
    void bfs(int grid[][],int i,int j,int vis[][]){
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(i,j));
        vis[i][j]=1;
        int l1[]={-1,0,1,0};
        int l2[]={0,1,0,-1};
        while(!q.isEmpty()){
            int a=q.peek().i;
            int b=q.peek().j;
            q.remove();
            for(int k=0;k<4;k++){
                int r=a+l1[k];
                int c=b+l2[k];
                if(r>=0&&r<grid.length&&c>=0&&c<grid[0].length&&vis[r][c]==0&&grid[r][c]==1){
                    vis[r][c]=1;
                    q.add(new pair(r,c));
                    
                }
            }
        }
        
    }
    int numberOfEnclaves(int[][] b) {

        
        int vis[][]=new int[b.length][b[0].length];
        for(int i[]:vis)
            Arrays.fill(i,0);
        for(int i=0;i<b[0].length;i++){
            if(vis[0][i]!=1&&b[0][i]==1){
                bfs(b,0,i,vis);
            }
            if(vis[b.length-1][i]!=1&&b[b.length-1][i]==1){
                bfs(b,b.length-1,i,vis);
            }
        }
        for(int i=0;i<b.length;i++){
            if(vis[i][0]!=1&&b[i][0]==1){
                bfs(b,i,0,vis);
            }
            if(vis[i][b[0].length-1]!=1&&b[i][b[0].length-1]==1){
                bfs(b,i,b[0].length-1,vis);
            }
        }
        int c=0;
        for(int i=0;i<b.length;i++){
            for(int j=0;j<b[0].length;j++){
                if(b[i][j]==1&&vis[i][j]==0){c++;}
                
            }
        }
        return c;
        
    }
}