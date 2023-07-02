//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static boolean f(int i,int target,int dp[][],int arr[]){
        if(target==0)return true;
        if(i==0)return arr[0]==target;
        if(dp[i][target]!=-1)return dp[i][target]==0?false:true;
        boolean np=f(i-1,target,dp,arr);
        boolean p=false;
        if(arr[i]<=target){
            p=f(i-1,target-arr[i],dp,arr);
        }
        dp[i][target]=(p||np==true)?1:0;
        return p||np;
    }
    static int equalPartition(int N, int arr[])
    {
        int s=0;
        for(int i:arr){
            s+=i;
        }
        if(s%2!=0)return 0;
        int dp[][]=new int[N][(s/2)+1];
        for(int i[]:dp){
            
            Arrays.fill(i,-1);
        }
        return f(N-1,s/2,dp,arr)==true?1:0;
        
    }
}