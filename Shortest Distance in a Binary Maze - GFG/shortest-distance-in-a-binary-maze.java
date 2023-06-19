//{ Driver Code Starts
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
            int[] source = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                source[i] = x;
            }
            int[] dest = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                dest[i] = x;
            }
            Solution ob = new Solution();
            int ans = ob.shortestPath(grid, source, dest);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class tres{
    int dis;
    int i;int j;
    tres(int dis,int i,int j){
        this.dis=dis;
        this.i=i;
        this.j=j;
    }
}
class Solution {

    int shortestPath(int[][] grid, int[] src, int[] dest) {

        int l2[]={-1,0,1,0};
        int l1[]={0,-1,0,1};
        int dist[][]=new int[grid.length][grid[0].length];
        for(int i[]:dist){
            Arrays.fill(i,(int)(1e9));
        }
        dist[src[0]][src[1]]=0;
        PriorityQueue<tres> pq=new PriorityQueue<>((a,b)->a.dis-b.dis);
        pq.add(new tres(0,src[0],src[1]));
        while(!pq.isEmpty()){
            int d=pq.peek().dis;
            int a=pq.peek().i;
            int b=pq.peek().j;
            pq.remove();
            if(dest[0]==a&&dest[1]==b)return d;
            for(int k=0;k<4;k++){
                int r=l1[k]+a;
                int c=l2[k]+b;
                if(r>=0&&r<grid.length&&c>=0&&c<grid[0].length&&grid[r][c]==1){
                    if(d+1<dist[r][c]){
                        dist[r][c]=1+d;
                        pq.add(new tres(dist[r][c],r,c));
                    }
                }
            }
        }
        return -1;
        
    }
}
