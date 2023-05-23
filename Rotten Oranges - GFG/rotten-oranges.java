//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class pair{
    int i;int j;
    int val;
    pair(int i,int j,int val){
        this.i=i;
        this.j=j;
        this.val=val;
    }
}
class Solution
{
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid)
    {   int vis[][]=new int[grid.length][grid[0].length];
        Queue<pair> q=new LinkedList<>();int to=0,oc=0,ans=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    q.add(new pair(i,j,0));
                    vis[i][j]=2;
                }
                else if(grid[i][j]==1){
                    vis[i][j]=0;
                    to++;
                }
                else{
                    vis[i][j]=0;
                }
            }
        }
        int r1[]={-1,0,1,0};
        int c1[]={0,1,0,-1};
        while(!q.isEmpty()){
            int a=q.peek().i;
            int b=q.peek().j;
            int t=q.peek().val;
            ans=Math.max(ans,t);
            q.remove();
            for(int i=0;i<4;i++){
                int r=a+r1[i];
                int c=b+c1[i];
                if(r>=0&&r<grid.length&&c>=0&&c<grid[0].length&&vis[r][c]==0&&grid[r][c]==1){
                    q.add(new pair(r,c,t+1));
                    vis[r][c]=2;
                    oc++;
                }
            }
            
            
        }
        if(oc==to)return ans;
        return -1;
    }
}