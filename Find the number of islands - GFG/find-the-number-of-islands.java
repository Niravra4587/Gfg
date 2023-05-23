//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class pair{
    int i;int j;
    pair(int i,int j){
        this.i=i;
        this.j=j;
    }
}
class Solution {
    // Function to find the number of islands.
    public void bfs(int s,int e,int v[][],char grid[][]){
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(s,e));
        int drow[]={-1,-1,-1,0,0,1,1,1};
        int dcol[]={-1,0,1,-1,1,-1,0,1};
        while(!q.isEmpty()){
            int a=q.peek().i;
            int b=q.peek().j;
            q.remove();
            for(int i=0;i<8;i++){
                int r=a+drow[i];
                int c=b+dcol[i];
                if(r>=0&&r<grid.length&&c>=0&&c<grid[0].length&&v[r][c]==0&&grid[r][c]=='1'){
                    v[r][c]=1;
                    q.add(new pair(r,c));
                }
            }
            
        }
    }
    public int numIslands(char[][] grid) {
        
        int v[][]=new int[grid.length][grid[0].length];int c=0;
        for(int i[]:v){
            Arrays.fill(i,0);
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(v[i][j]==0&&grid[i][j]=='1'){
                    c++;
                    bfs(i,j,v,grid);
                    
                }
            }
        }
        return c;
    }
}