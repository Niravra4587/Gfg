//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] S = read.readLine().split(" ");
            int N = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);
            int Grid[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String[] s = read.readLine().split(" ");
                for (int j = 0; j < M; j++) Grid[i][j] = Integer.parseInt(s[j]);
            }
            Solution ob = new Solution();
            System.out.println(ob.MinimumEffort(Grid));
        }
    }
}
// } Driver Code Ends

class tres{
    int dis;
    int i;
    int j;
    tres(int dis,int i,int j){
        this.dis=dis;
        this.i=i;
        this.j=j;
    }
}
class Solution {
    
    int MinimumEffort(int heights[][]) {
        int l1[]={0,-1,0,1};
        int l2[]={-1,0,1,0};
        Queue<tres> q=new PriorityQueue<>((a,b)->a.dis-b.dis);
        q.add(new tres(0,0,0));
        int dist[][]=new int[heights.length][heights[0].length];
    for(int i[]:dist)    
        Arrays.fill(i,(int)(1e9));
     dist[0][0]=0;
     while(!q.isEmpty()){
         int d=q.peek().dis;
         int a=q.peek().i;
         int b=q.peek().j;
         q.remove();
         if(a==heights.length-1&&b==heights[0].length-1)return d;
         for(int k=0;k<4;k++){
             int r=a+l1[k];
             int c=b+l2[k];
             if(r>=0&&r<heights.length&&c>=0&&c<heights[0].length){
                 int cos=Math.max(Math.abs(heights[r][c]-heights[a][b]),d);
                 
                 if(dist[r][c]>cos){
                     dist[r][c]=cos;
                     q.add(new tres(dist[r][c],r,c));
                 }
             }
         }
     }
     return -1;
        
    }
}