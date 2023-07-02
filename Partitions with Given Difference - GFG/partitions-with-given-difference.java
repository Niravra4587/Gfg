//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int d=sc.nextInt();
            
            int []arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            
            Solution obj=new Solution();
            int res=obj.countPartitions(n, d, arr);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//Back-end complete function Template for Java

class Solution{
    int MOD=(int)(1e9)+7;
    public int f(int i,int target,int dp[][],int nums[]){
        if(i==0){
            if(nums[0]==0&&target==0)return 2;
            if(nums[0]==target||target==0)return 1;
            else return 0;
        }
        if(dp[i][target]!=-1)return dp[i][target];
        int np=f(i-1,target,dp,nums)%MOD;
        int p=0;
        if(nums[i]<=target){
            p=f(i-1,target-nums[i],dp,nums)%MOD;
            
        }
        return dp[i][target]=(p+np)%MOD;
    }

    public int countPartitions(int n, int d, int arr[]){
        // Code here
        int s=0;
        for(int i:arr){
            s+=i;
        }
        s-=d;
        if(s%2!=0||s<0)return 0;
        int dp[][]=new int[n][s/2+1];
        for(int i[]:dp){
            Arrays.fill(i,-1);
        }
        return f(n-1,s/2,dp,arr);
        
    }
}