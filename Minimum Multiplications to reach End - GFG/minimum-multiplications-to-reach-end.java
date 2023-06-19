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
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class pair{
    int val;
    int step;
    pair(int val,int step){
        this.val=val;
        this.step=step;
    }
}
class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {

        // Your code here
        int dis[]=new int[100000];
        Arrays.fill(dis,(int)(1e9));
        Queue<pair> pq=new LinkedList<>();
        pq.add(new pair(start,0));
        while(!pq.isEmpty()){
            int node=pq.peek().val;
            int dist=pq.peek().step;
            pq.remove();
            
            for(int i=0;i<arr.length;i++){
                int val=(arr[i]*node)%((int)Math.pow(10,5));
                if(dist+1<dis[val]){
                    dis[val]=1+dist;
                     if(val==end)return dist+1;
                    pq.add(new pair(val,1+dist));
                }
            }
            
        }
        return dis[end]==(int)(1e9)?-1:dis[end];
    }
}
